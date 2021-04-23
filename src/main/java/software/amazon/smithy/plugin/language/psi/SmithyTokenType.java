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

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.language.SmithyLanguage;

public class SmithyTokenType extends IElementType {
    public SmithyTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SmithyLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SmithyTokenType." + super.toString();
    }
}
