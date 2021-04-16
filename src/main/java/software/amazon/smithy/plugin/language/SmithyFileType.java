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

package software.amazon.smithy.plugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SmithyFileType extends LanguageFileType {

    public static final SmithyFileType INSTANCE = new SmithyFileType();

    private SmithyFileType() {
        super(SmithyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Smithy File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Smithy language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "smithy";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SmithyIcons.FILE;
    }
}
