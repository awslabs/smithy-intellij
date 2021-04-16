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
package software.amazon.smithy.plugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import software.amazon.smithy.plugin.language.psi.impl.*;

public interface SmithyTypes {

  IElementType ABSOLUTE_ROOT_SHAPE_ID = new SmithyElementType("ABSOLUTE_ROOT_SHAPE_ID");
  IElementType APPLY_STATEMENT = new SmithyElementType("APPLY_STATEMENT");
  IElementType COMMENT = new SmithyElementType("COMMENT");
  IElementType COMPLEX_SHAPE_STATEMENT = new SmithyElementType("COMPLEX_SHAPE_STATEMENT");
  IElementType METADATA_SECTION = new SmithyElementType("METADATA_SECTION");
  IElementType METADATA_STATEMENT = new SmithyElementType("METADATA_STATEMENT");
  IElementType NAMESPACE = new SmithyElementType("NAMESPACE");
  IElementType NAMESPACE_STATEMENT = new SmithyElementType("NAMESPACE_STATEMENT");
  IElementType NODE_ARRAY = new SmithyElementType("NODE_ARRAY");
  IElementType NODE_OBJECT = new SmithyElementType("NODE_OBJECT");
  IElementType NODE_OBJECT_KEY = new SmithyElementType("NODE_OBJECT_KEY");
  IElementType NODE_OBJECT_KVP = new SmithyElementType("NODE_OBJECT_KVP");
  IElementType NODE_OBJECT_SHAPE_STATEMENT = new SmithyElementType("NODE_OBJECT_SHAPE_STATEMENT");
  IElementType NODE_STRING_VALUE = new SmithyElementType("NODE_STRING_VALUE");
  IElementType NODE_VALUE = new SmithyElementType("NODE_VALUE");
  IElementType NUMBER = new SmithyElementType("NUMBER");
  IElementType ROOT_SHAPE_ID = new SmithyElementType("ROOT_SHAPE_ID");
  IElementType SHAPE_BODY = new SmithyElementType("SHAPE_BODY");
  IElementType SHAPE_ID = new SmithyElementType("SHAPE_ID");
  IElementType SHAPE_MEMBERS = new SmithyElementType("SHAPE_MEMBERS");
  IElementType SHAPE_MEMBER_KVP = new SmithyElementType("SHAPE_MEMBER_KVP");
  IElementType SHAPE_SECTION = new SmithyElementType("SHAPE_SECTION");
  IElementType SHAPE_STATEMENT = new SmithyElementType("SHAPE_STATEMENT");
  IElementType SHAPE_STATEMENTS = new SmithyElementType("SHAPE_STATEMENTS");
  IElementType SIMPLE_SHAPE_STATEMENT = new SmithyElementType("SIMPLE_SHAPE_STATEMENT");
  IElementType TRAIT = new SmithyElementType("TRAIT");
  IElementType TRAIT_BODY = new SmithyElementType("TRAIT_BODY");
  IElementType TRAIT_BODY_VALUE = new SmithyElementType("TRAIT_BODY_VALUE");
  IElementType TRAIT_STATEMENTS = new SmithyElementType("TRAIT_STATEMENTS");
  IElementType TRAIT_STRUCTURE = new SmithyElementType("TRAIT_STRUCTURE");
  IElementType TRAIT_STRUCTURE_KVP = new SmithyElementType("TRAIT_STRUCTURE_KVP");
  IElementType USE_SECTION = new SmithyElementType("USE_SECTION");
  IElementType USE_STATEMENT = new SmithyElementType("USE_STATEMENT");
  IElementType VERSION_SECTION = new SmithyElementType("VERSION_SECTION");
  IElementType WS = new SmithyElementType("WS");

  IElementType APPLY = new SmithyTokenType("apply");
  IElementType COLON = new SmithyTokenType(":");
  IElementType COMMA = new SmithyTokenType(",");
  IElementType COMPLEX_TYPE_NAME = new SmithyTokenType("COMPLEX_TYPE_NAME");
  IElementType DOC_COMMENT = new SmithyTokenType("DOC_COMMENT");
  IElementType DQUOTE = new SmithyTokenType("\"");
  IElementType EQ = new SmithyTokenType("=");
  IElementType ESCAPE = new SmithyTokenType("\\");
  IElementType EXP = new SmithyTokenType("EXP");
  IElementType FRAC = new SmithyTokenType("FRAC");
  IElementType IDENTIFIER = new SmithyTokenType("IDENTIFIER");
  IElementType INT = new SmithyTokenType("INT");
  IElementType LBRACE = new SmithyTokenType("{");
  IElementType LBRACK = new SmithyTokenType("[");
  IElementType LINE_COMMENT = new SmithyTokenType("LINE_COMMENT");
  IElementType LPAREN = new SmithyTokenType("(");
  IElementType METADATA = new SmithyTokenType("metadata");
  IElementType MINUS = new SmithyTokenType("-");
  IElementType NAMESPACE_KEYWORD = new SmithyTokenType("namespace");
  IElementType NEWLINE = new SmithyTokenType("NEWLINE");
  IElementType NODE_CONSTANTS = new SmithyTokenType("NODE_CONSTANTS");
  IElementType NODE_OBJECT_TYPE_NAME = new SmithyTokenType("NODE_OBJECT_TYPE_NAME");
  IElementType PLUS = new SmithyTokenType("+");
  IElementType POUND = new SmithyTokenType("#");
  IElementType QUOTED_TEXT = new SmithyTokenType("QUOTED_TEXT");
  IElementType RBRACE = new SmithyTokenType("}");
  IElementType RBRACK = new SmithyTokenType("]");
  IElementType RPAREN = new SmithyTokenType(")");
  IElementType SHAPE_ID_MEMBER = new SmithyTokenType("SHAPE_ID_MEMBER");
  IElementType SIMPLE_TYPE_NAME = new SmithyTokenType("SIMPLE_TYPE_NAME");
  IElementType SPACE = new SmithyTokenType("SPACE");
  IElementType TEXT_BLOCK = new SmithyTokenType("TEXT_BLOCK");
  IElementType TRAIT_ID = new SmithyTokenType("TRAIT_ID");
  IElementType USE_KEYWORD = new SmithyTokenType("use");
  IElementType VERSION = new SmithyTokenType("$version");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ABSOLUTE_ROOT_SHAPE_ID) {
        return new SmithyAbsoluteRootShapeIdImpl(node);
      }
      else if (type == APPLY_STATEMENT) {
        return new SmithyApplyStatementImpl(node);
      }
      else if (type == COMMENT) {
        return new SmithyCommentImpl(node);
      }
      else if (type == COMPLEX_SHAPE_STATEMENT) {
        return new SmithyComplexShapeStatementImpl(node);
      }
      else if (type == METADATA_SECTION) {
        return new SmithyMetadataSectionImpl(node);
      }
      else if (type == METADATA_STATEMENT) {
        return new SmithyMetadataStatementImpl(node);
      }
      else if (type == NAMESPACE) {
        return new SmithyNamespaceImpl(node);
      }
      else if (type == NAMESPACE_STATEMENT) {
        return new SmithyNamespaceStatementImpl(node);
      }
      else if (type == NODE_ARRAY) {
        return new SmithyNodeArrayImpl(node);
      }
      else if (type == NODE_OBJECT) {
        return new SmithyNodeObjectImpl(node);
      }
      else if (type == NODE_OBJECT_KEY) {
        return new SmithyNodeObjectKeyImpl(node);
      }
      else if (type == NODE_OBJECT_KVP) {
        return new SmithyNodeObjectKvpImpl(node);
      }
      else if (type == NODE_OBJECT_SHAPE_STATEMENT) {
        return new SmithyNodeObjectShapeStatementImpl(node);
      }
      else if (type == NODE_STRING_VALUE) {
        return new SmithyNodeStringValueImpl(node);
      }
      else if (type == NODE_VALUE) {
        return new SmithyNodeValueImpl(node);
      }
      else if (type == NUMBER) {
        return new SmithyNumberImpl(node);
      }
      else if (type == ROOT_SHAPE_ID) {
        return new SmithyRootShapeIdImpl(node);
      }
      else if (type == SHAPE_BODY) {
        return new SmithyShapeBodyImpl(node);
      }
      else if (type == SHAPE_ID) {
        return new SmithyShapeIdImpl(node);
      }
      else if (type == SHAPE_MEMBERS) {
        return new SmithyShapeMembersImpl(node);
      }
      else if (type == SHAPE_MEMBER_KVP) {
        return new SmithyShapeMemberKvpImpl(node);
      }
      else if (type == SHAPE_SECTION) {
        return new SmithyShapeSectionImpl(node);
      }
      else if (type == SHAPE_STATEMENT) {
        return new SmithyShapeStatementImpl(node);
      }
      else if (type == SHAPE_STATEMENTS) {
        return new SmithyShapeStatementsImpl(node);
      }
      else if (type == SIMPLE_SHAPE_STATEMENT) {
        return new SmithySimpleShapeStatementImpl(node);
      }
      else if (type == TRAIT) {
        return new SmithyTraitImpl(node);
      }
      else if (type == TRAIT_BODY) {
        return new SmithyTraitBodyImpl(node);
      }
      else if (type == TRAIT_BODY_VALUE) {
        return new SmithyTraitBodyValueImpl(node);
      }
      else if (type == TRAIT_STATEMENTS) {
        return new SmithyTraitStatementsImpl(node);
      }
      else if (type == TRAIT_STRUCTURE) {
        return new SmithyTraitStructureImpl(node);
      }
      else if (type == TRAIT_STRUCTURE_KVP) {
        return new SmithyTraitStructureKvpImpl(node);
      }
      else if (type == USE_SECTION) {
        return new SmithyUseSectionImpl(node);
      }
      else if (type == USE_STATEMENT) {
        return new SmithyUseStatementImpl(node);
      }
      else if (type == VERSION_SECTION) {
        return new SmithyVersionSectionImpl(node);
      }
      else if (type == WS) {
        return new SmithyWsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
