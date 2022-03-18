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

// This is a generated file.
package software.amazon.smithy.plugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static software.amazon.smithy.plugin.language.psi.SmithyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import software.amazon.smithy.plugin.language.psi.*;

public class SmithyShapeBodyImpl extends ASTWrapperPsiElement implements SmithyShapeBody {

  public SmithyShapeBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmithyVisitor visitor) {
    visitor.visitShapeBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmithyVisitor) accept((SmithyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmithyComplexShapeStatement getComplexShapeStatement() {
    return findChildByClass(SmithyComplexShapeStatement.class);
  }

  @Override
  @Nullable
  public SmithyNodeObjectShapeStatement getNodeObjectShapeStatement() {
    return findChildByClass(SmithyNodeObjectShapeStatement.class);
  }

  @Override
  @Nullable
  public SmithySimpleShapeStatement getSimpleShapeStatement() {
    return findChildByClass(SmithySimpleShapeStatement.class);
  }

}
