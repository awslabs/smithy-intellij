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
package software.amazon.smithy.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static software.amazon.smithy.plugin.language.psi.SmithyTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SmithyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return idl(b, l + 1);
  }

  /* ********************************************************** */
  // namespace POUND IDENTIFIER
  public static boolean absolute_root_shape_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_root_shape_id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespace(b, l + 1);
    r = r && consumeTokens(b, 0, POUND, IDENTIFIER);
    exit_section_(b, m, ABSOLUTE_ROOT_SHAPE_ID, r);
    return r;
  }

  /* ********************************************************** */
  // APPLY ws shape_id ws trait ws
  public static boolean apply_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apply_statement")) return false;
    if (!nextTokenIs(b, APPLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, APPLY);
    r = r && ws(b, l + 1);
    r = r && shape_id(b, l + 1);
    r = r && ws(b, l + 1);
    r = r && trait(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, m, APPLY_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT | DOC_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", DOC_COMMENT, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = consumeToken(b, DOC_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ws COMPLEX_TYPE_NAME ws IDENTIFIER ws shape_members
  public static boolean complex_shape_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complex_shape_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPLEX_SHAPE_STATEMENT, "<complex shape statement>");
    r = ws(b, l + 1);
    r = r && consumeToken(b, COMPLEX_TYPE_NAME);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ws(b, l + 1);
    r = r && shape_members(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ws version_section ws metadata_section shape_section
  static boolean idl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idl")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws(b, l + 1);
    r = r && version_section(b, l + 1);
    r = r && ws(b, l + 1);
    r = r && metadata_section(b, l + 1);
    r = r && shape_section(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (metadata_statement)*
  public static boolean metadata_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_section")) return false;
    Marker m = enter_section_(b, l, _NONE_, METADATA_SECTION, "<metadata section>");
    while (true) {
      int c = current_position_(b);
      if (!metadata_section_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "metadata_section", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // (metadata_statement)
  private static boolean metadata_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_section_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = metadata_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // METADATA ws IDENTIFIER ws EQ ws node_value ws
  public static boolean metadata_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_statement")) return false;
    if (!nextTokenIs(b, METADATA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, METADATA);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && ws(b, l + 1);
    r = r && node_value(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, m, METADATA_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ("." IDENTIFIER)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && namespace_1(b, l + 1);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  // ("." IDENTIFIER)*
  private static boolean namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_1", c)) break;
    }
    return true;
  }

  // "." IDENTIFIER
  private static boolean namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ws NAMESPACE_KEYWORD ws namespace ws
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_STATEMENT, "<namespace statement>");
    r = ws(b, l + 1);
    r = r && consumeToken(b, NAMESPACE_KEYWORD);
    r = r && ws(b, l + 1);
    r = r && namespace(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACK ws (node_value ws)* RBRACK
  public static boolean node_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_array")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && ws(b, l + 1);
    r = r && node_array_2(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, NODE_ARRAY, r);
    return r;
  }

  // (node_value ws)*
  private static boolean node_array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_array_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_array_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_array_2", c)) break;
    }
    return true;
  }

  // node_value ws
  private static boolean node_array_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_array_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_value(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE ws (node_object_kvp ws)* RBRACE
  public static boolean node_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && ws(b, l + 1);
    r = r && node_object_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, NODE_OBJECT, r);
    return r;
  }

  // (node_object_kvp ws)*
  private static boolean node_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_object_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_object_2", c)) break;
    }
    return true;
  }

  // node_object_kvp ws
  private static boolean node_object_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_object_kvp(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTED_TEXT | IDENTIFIER
  public static boolean node_object_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object_key")) return false;
    if (!nextTokenIs(b, "<node object key>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_OBJECT_KEY, "<node object key>");
    r = consumeToken(b, QUOTED_TEXT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ws COLON ws node_value
  public static boolean node_object_kvp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object_kvp")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ws(b, l + 1);
    r = r && node_value(b, l + 1);
    exit_section_(b, m, NODE_OBJECT_KVP, r);
    return r;
  }

  /* ********************************************************** */
  // ws NODE_OBJECT_TYPE_NAME ws IDENTIFIER ws node_object
  public static boolean node_object_shape_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_object_shape_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_OBJECT_SHAPE_STATEMENT, "<node object shape statement>");
    r = ws(b, l + 1);
    r = r && consumeToken(b, NODE_OBJECT_TYPE_NAME);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ws(b, l + 1);
    r = r && node_object(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // shape_id | TEXT_BLOCK | QUOTED_TEXT
  public static boolean node_string_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_string_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_STRING_VALUE, "<node string value>");
    r = shape_id(b, l + 1);
    if (!r) r = consumeToken(b, TEXT_BLOCK);
    if (!r) r = consumeToken(b, QUOTED_TEXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // node_array | node_object | number | NODE_CONSTANTS | node_string_value
  public static boolean node_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_VALUE, "<node value>");
    r = node_array(b, l + 1);
    if (!r) r = node_object(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, NODE_CONSTANTS);
    if (!r) r = node_string_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [MINUS] INT [FRAC] [EXP]
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    if (!nextTokenIs(b, "<number>", INT, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_0(b, l + 1);
    r = r && consumeToken(b, INT);
    r = r && number_2(b, l + 1);
    r = r && number_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [MINUS]
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  // [FRAC]
  private static boolean number_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_2")) return false;
    consumeToken(b, FRAC);
    return true;
  }

  // [EXP]
  private static boolean number_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_3")) return false;
    consumeToken(b, EXP);
    return true;
  }

  /* ********************************************************** */
  // absolute_root_shape_id | IDENTIFIER
  public static boolean root_shape_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_shape_id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_root_shape_id(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ROOT_SHAPE_ID, r);
    return r;
  }

  /* ********************************************************** */
  // simple_shape_statement
  //     | complex_shape_statement
  //     | node_object_shape_statement
  public static boolean shape_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHAPE_BODY, "<shape body>");
    r = simple_shape_statement(b, l + 1);
    if (!r) r = complex_shape_statement(b, l + 1);
    if (!r) r = node_object_shape_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // root_shape_id [SHAPE_ID_MEMBER]
  public static boolean shape_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_shape_id(b, l + 1);
    r = r && shape_id_1(b, l + 1);
    exit_section_(b, m, SHAPE_ID, r);
    return r;
  }

  // [SHAPE_ID_MEMBER]
  private static boolean shape_id_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_id_1")) return false;
    consumeToken(b, SHAPE_ID_MEMBER);
    return true;
  }

  /* ********************************************************** */
  // trait_statements IDENTIFIER ws COLON ws shape_id
  public static boolean shape_member_kvp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_member_kvp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHAPE_MEMBER_KVP, "<shape member kvp>");
    r = trait_statements(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ws(b, l + 1);
    r = r && shape_id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE ws (shape_member_kvp)* ws RBRACE
  public static boolean shape_members(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_members")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && ws(b, l + 1);
    r = r && shape_members_2(b, l + 1);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SHAPE_MEMBERS, r);
    return r;
  }

  // (shape_member_kvp)*
  private static boolean shape_members_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_members_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shape_members_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shape_members_2", c)) break;
    }
    return true;
  }

  // (shape_member_kvp)
  private static boolean shape_members_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_members_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shape_member_kvp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_statement* use_section shape_statements
  public static boolean shape_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHAPE_SECTION, "<shape section>");
    r = shape_section_0(b, l + 1);
    r = r && use_section(b, l + 1);
    r = r && shape_statements(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // namespace_statement*
  private static boolean shape_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shape_section_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // trait_statements shape_body
  public static boolean shape_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHAPE_STATEMENT, "<shape statement>");
    r = trait_statements(b, l + 1);
    r = r && shape_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (shape_statement | apply_statement)*
  public static boolean shape_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_statements")) return false;
    Marker m = enter_section_(b, l, _NONE_, SHAPE_STATEMENTS, "<shape statements>");
    while (true) {
      int c = current_position_(b);
      if (!shape_statements_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shape_statements", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // shape_statement | apply_statement
  private static boolean shape_statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shape_statements_0")) return false;
    boolean r;
    r = shape_statement(b, l + 1);
    if (!r) r = apply_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ws SIMPLE_TYPE_NAME ws IDENTIFIER
  public static boolean simple_shape_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_shape_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_SHAPE_STATEMENT, "<simple shape statement>");
    r = ws(b, l + 1);
    r = r && consumeToken(b, SIMPLE_TYPE_NAME);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRAIT_ID [trait_body]
  public static boolean trait(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait")) return false;
    if (!nextTokenIs(b, TRAIT_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRAIT_ID);
    r = r && trait_1(b, l + 1);
    exit_section_(b, m, TRAIT, r);
    return r;
  }

  // [trait_body]
  private static boolean trait_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_1")) return false;
    trait_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LPAREN ws trait_body_value ws RPAREN
  public static boolean trait_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_body")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ws(b, l + 1);
    r = r && trait_body_value(b, l + 1);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TRAIT_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // trait_structure | node_value
  public static boolean trait_body_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_body_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_BODY_VALUE, "<trait body value>");
    r = trait_structure(b, l + 1);
    if (!r) r = node_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ws trait)* ws
  public static boolean trait_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_STATEMENTS, "<trait statements>");
    r = trait_statements_0(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ws trait)*
  private static boolean trait_statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statements_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!trait_statements_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "trait_statements_0", c)) break;
    }
    return true;
  }

  // ws trait
  private static boolean trait_statements_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statements_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws(b, l + 1);
    r = r && trait(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // trait_structure_kvp (ws trait_structure_kvp)*
  public static boolean trait_structure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_structure")) return false;
    if (!nextTokenIs(b, "<trait structure>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_STRUCTURE, "<trait structure>");
    r = trait_structure_kvp(b, l + 1);
    r = r && trait_structure_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ws trait_structure_kvp)*
  private static boolean trait_structure_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_structure_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!trait_structure_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "trait_structure_1", c)) break;
    }
    return true;
  }

  // ws trait_structure_kvp
  private static boolean trait_structure_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_structure_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws(b, l + 1);
    r = r && trait_structure_kvp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // node_object_key ws COLON ws node_value
  public static boolean trait_structure_kvp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_structure_kvp")) return false;
    if (!nextTokenIs(b, "<trait structure kvp>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_STRUCTURE_KVP, "<trait structure kvp>");
    r = node_object_key(b, l + 1);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ws(b, l + 1);
    r = r && node_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (use_statement)*
  public static boolean use_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_section")) return false;
    Marker m = enter_section_(b, l, _NONE_, USE_SECTION, "<use section>");
    while (true) {
      int c = current_position_(b);
      if (!use_section_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "use_section", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // (use_statement)
  private static boolean use_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_section_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = use_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ws USE_KEYWORD ws absolute_root_shape_id ws
  public static boolean use_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_STATEMENT, "<use statement>");
    r = ws(b, l + 1);
    r = r && consumeToken(b, USE_KEYWORD);
    r = r && ws(b, l + 1);
    r = r && absolute_root_shape_id(b, l + 1);
    r = r && ws(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VERSION COLON ws QUOTED_TEXT
  public static boolean version_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_section")) return false;
    if (!nextTokenIs(b, VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VERSION, COLON);
    r = r && ws(b, l + 1);
    r = r && consumeToken(b, QUOTED_TEXT);
    exit_section_(b, m, VERSION_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // (SPACE | NEWLINE | comment | COMMA)*
  public static boolean ws(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws")) return false;
    Marker m = enter_section_(b, l, _NONE_, WS, "<ws>");
    while (true) {
      int c = current_position_(b);
      if (!ws_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ws", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // SPACE | NEWLINE | comment | COMMA
  private static boolean ws_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws_0")) return false;
    boolean r;
    r = consumeToken(b, SPACE);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = comment(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

}
