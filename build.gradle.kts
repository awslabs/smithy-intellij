/*
 * Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.grammarkit.tasks.GenerateLexer
import org.jetbrains.grammarkit.tasks.GenerateParser

fun properties(key: String) = project.findProperty(key).toString()

plugins {
    // Java support
    id("java")
    // gradle-intellij-plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
    id("org.jetbrains.intellij") version "1.4.0"
    // gradle-changelog-plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
    id("org.jetbrains.changelog") version "1.3.1"
    id("checkstyle")
    id("com.github.spotbugs") version "5.0.6"
    id("org.jetbrains.grammarkit") version "2021.1.2"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

// Configure project's dependencies
repositories {
    mavenCentral()
}
dependencies {
    implementation("com.github.ballerina-platform:lsp4intellij:0.94.2")
    implementation("software.amazon.smithy:smithy-model:[1.0, 2.0[")
}

// Configure gradle-intellij-plugin plugin.
// Read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
}

sourceSets["main"].java.srcDirs("src/main/gen")

/*
 * CheckStyle
 * ====================================================
 *
 * Apply CheckStyle to source files but not tests.
 */

tasks["checkstyleTest"].enabled = false
tasks.checkstyleMain {
    source = fileTree("src/main/java")
}

/*
 * Spotbugs
 * ====================================================
 *
 * Run spotbugs against source files and configure suppressions.
 */

// We don't need to lint tests.
tasks["spotbugsTest"].enabled = false
tasks.spotbugsMain {
    excludeFilter.set(project.file("config/spotbugs/filter.xml"))
}

/*
 * Grammar-Kit
 * ====================================================
 *
 * Apply Grammar-Kit plugin and configure tasks for generating Lexer and Parser classes.
 */
apply(plugin = "org.jetbrains.grammarkit")

grammarKit {
    jflexRelease = "1.7.0-1"
}

val generateSmithyLexer = task<GenerateLexer>("generateSmithyLexer") {
    source = "src/main/java/software/amazon/smithy/plugin/language/Smithy.flex"
    targetDir = "src/main/gen/software/amazon/smithy/plugin/language"
    targetClass = "SmithyLexer"
    purgeOldFiles = true
}

val generateSmithyParser = task<GenerateParser>("generateSmithyParser") {
    source = "src/main/java/software/amazon/smithy/plugin/language/Smithy.bnf"
    targetRoot = "src/main/gen"
    pathToParser = "/software/amazon/smithy/plugin/parser/SmithyParser.java"
    pathToPsiRoot = "/software/amazon/smithy/plugin/language/psi"
    purgeOldFiles = true
}

tasks {
    // Set the JVM compatibility versions
    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
        }
    }

    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(
                projectDir.resolve("README.md").readText().lines().run {
                    val start = "<!-- Plugin description -->"
                    val end = "<!-- Plugin description end -->"

                    if (!containsAll(listOf(start, end))) {
                        throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                    }
                    subList(indexOf(start) + 1, indexOf(end))
                }.joinToString("\n").run { markdownToHTML(this) }
        )

        // Get the latest available change notes from the changelog file
        changeNotes.set(provider {
            changelog.run {
                getOrNull(properties("pluginVersion")) ?: getLatest()
            }.toHTML()
        })
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("PUBLISH_TOKEN"))
        // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels.set(listOf(properties("pluginVersion").split('-').getOrElse(1) { "default" }.split('.').first()))
    }
}
