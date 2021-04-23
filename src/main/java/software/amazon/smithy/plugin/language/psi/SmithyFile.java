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

package software.amazon.smithy.plugin.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.language.SmithyFileType;
import software.amazon.smithy.plugin.language.SmithyLanguage;

public class SmithyFile extends PsiFileBase {
    public SmithyFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SmithyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SmithyFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Smithy File";
    }
}
