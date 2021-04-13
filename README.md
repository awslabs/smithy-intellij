## Smithy IntelliJ

<!-- Plugin description -->
**Smithy IntelliJ** provides IDE integration for the [Smithy IDL](https://awslabs.github.io/smithy/) within
IntelliJ IDEA.  It utilizes [smithy-language-server](https://github.com/awslabs/smithy-language-server) for its
[Language Server Protocol](https://microsoft.github.io/language-server-protocol/) implementation.
<!-- Plugin description end -->

## Managing Smithy model dependencies while using the plugin
When using the Smithy Intellij Plugin, dependencies used by the model within the workspace must be specified, so that
the plugin can inject them when launching the Smithy Language Server. Dependencies must be specified in the workspace
at `/build/smithy-dependencies.json` or `.smithy.json`, listing all the required artifacts along with their source
repositories:
```json
{
  "artifacts": [
    "software.amazon.smithy:smithy-aws-traits:1.7.0",
    "software.amazon.smithy:smithy-aws-iam-traits:1.7.0",
    "com.example.my-traits:0.0.1"
  ],
  "repositories": [
    "file:/Users/me/.m2/repository/",
    "https://repo.maven.apache.org/maven2/"
  ]
}
```

## Running this plugin for development
Clone the [smithy-language-server](https://github.com/awslabs/smithy-language-server) repository to a separate directory:
`git clone git@github.com:awslabs/smithy-language-server.git ~/smithy-language-server`

Change to that directory, and build and publish the locally:
`cd ~/smithy-language-server && ./gradlew build publishToMavenLocal`

From this plugin directory, use `ideRun` task to start a sandboxed instance of IntelliJ with the plugin loaded:
`./gradlew runIde`

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

