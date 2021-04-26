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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return idl(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // namespace POUND IDENTIFIER
  public static boolean absolute_root_shape_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "absolute_root_shape_id")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = namespace(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, POUND, IDENTIFIER);
    exit_section_(builder_, marker_, ABSOLUTE_ROOT_SHAPE_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // APPLY ws shape_id ws trait ws
  public static boolean apply_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "apply_statement")) return false;
    if (!nextTokenIs(builder_, APPLY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, APPLY);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && shape_id(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && trait(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, marker_, APPLY_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // LINE_COMMENT | DOC_COMMENT
  public static boolean comment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comment")) return false;
    if (!nextTokenIs(builder_, "<comment>", DOC_COMMENT, LINE_COMMENT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COMMENT, "<comment>");
    result_ = consumeToken(builder_, LINE_COMMENT);
    if (!result_) result_ = consumeToken(builder_, DOC_COMMENT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ws COMPLEX_TYPE_NAME ws IDENTIFIER ws shape_members
  public static boolean complex_shape_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "complex_shape_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COMPLEX_SHAPE_STATEMENT, "<complex shape statement>");
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMPLEX_TYPE_NAME);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && shape_members(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ws version_section ws metadata_section shape_section
  static boolean idl(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "idl")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && version_section(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && metadata_section(builder_, level_ + 1);
    result_ = result_ && shape_section(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (metadata_statement)*
  public static boolean metadata_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "metadata_section")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METADATA_SECTION, "<metadata section>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!metadata_section_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "metadata_section", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // (metadata_statement)
  private static boolean metadata_section_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "metadata_section_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = metadata_statement(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // METADATA ws IDENTIFIER ws EQ ws node_value ws
  public static boolean metadata_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "metadata_statement")) return false;
    if (!nextTokenIs(builder_, METADATA)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, METADATA);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_value(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, marker_, METADATA_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER ("." IDENTIFIER)*
  public static boolean namespace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "namespace")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && namespace_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, NAMESPACE, result_);
    return result_;
  }

  // ("." IDENTIFIER)*
  private static boolean namespace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "namespace_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!namespace_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "namespace_1", pos_)) break;
    }
    return true;
  }

  // "." IDENTIFIER
  private static boolean namespace_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "namespace_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ".");
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ws NAMESPACE_KEYWORD ws namespace ws
  public static boolean namespace_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "namespace_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NAMESPACE_STATEMENT, "<namespace statement>");
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NAMESPACE_KEYWORD);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && namespace(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACK ws (node_value ws)* RBRACK
  public static boolean node_array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_array")) return false;
    if (!nextTokenIs(builder_, LBRACK)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACK);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_array_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACK);
    exit_section_(builder_, marker_, NODE_ARRAY, result_);
    return result_;
  }

  // (node_value ws)*
  private static boolean node_array_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_array_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!node_array_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "node_array_2", pos_)) break;
    }
    return true;
  }

  // node_value ws
  private static boolean node_array_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_array_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = node_value(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE ws (node_object_kvp ws)* RBRACE
  public static boolean node_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_object_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, NODE_OBJECT, result_);
    return result_;
  }

  // (node_object_kvp ws)*
  private static boolean node_object_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!node_object_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "node_object_2", pos_)) break;
    }
    return true;
  }

  // node_object_kvp ws
  private static boolean node_object_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = node_object_kvp(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // QUOTED_TEXT | IDENTIFIER
  public static boolean node_object_key(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object_key")) return false;
    if (!nextTokenIs(builder_, "<node object key>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NODE_OBJECT_KEY, "<node object key>");
    result_ = consumeToken(builder_, QUOTED_TEXT);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER ws COLON ws node_value
  public static boolean node_object_kvp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object_kvp")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, NODE_OBJECT_KVP, result_);
    return result_;
  }

  /* ********************************************************** */
  // ws NODE_OBJECT_TYPE_NAME ws IDENTIFIER ws node_object
  public static boolean node_object_shape_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_object_shape_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NODE_OBJECT_SHAPE_STATEMENT, "<node object shape statement>");
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NODE_OBJECT_TYPE_NAME);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_object(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // shape_id | TEXT_BLOCK | QUOTED_TEXT
  public static boolean node_string_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_string_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NODE_STRING_VALUE, "<node string value>");
    result_ = shape_id(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TEXT_BLOCK);
    if (!result_) result_ = consumeToken(builder_, QUOTED_TEXT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // node_array | node_object | number | NODE_CONSTANTS | node_string_value
  public static boolean node_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "node_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NODE_VALUE, "<node value>");
    result_ = node_array(builder_, level_ + 1);
    if (!result_) result_ = node_object(builder_, level_ + 1);
    if (!result_) result_ = number(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NODE_CONSTANTS);
    if (!result_) result_ = node_string_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // [MINUS] INT [FRAC] [EXP]
  public static boolean number(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number")) return false;
    if (!nextTokenIs(builder_, "<number>", INT, MINUS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUMBER, "<number>");
    result_ = number_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, INT);
    result_ = result_ && number_2(builder_, level_ + 1);
    result_ = result_ && number_3(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // [MINUS]
  private static boolean number_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_0")) return false;
    consumeToken(builder_, MINUS);
    return true;
  }

  // [FRAC]
  private static boolean number_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_2")) return false;
    consumeToken(builder_, FRAC);
    return true;
  }

  // [EXP]
  private static boolean number_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_3")) return false;
    consumeToken(builder_, EXP);
    return true;
  }

  /* ********************************************************** */
  // absolute_root_shape_id | IDENTIFIER
  public static boolean root_shape_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root_shape_id")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = absolute_root_shape_id(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, ROOT_SHAPE_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // simple_shape_statement
  //     | complex_shape_statement
  //     | node_object_shape_statement
  public static boolean shape_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_body")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SHAPE_BODY, "<shape body>");
    result_ = simple_shape_statement(builder_, level_ + 1);
    if (!result_) result_ = complex_shape_statement(builder_, level_ + 1);
    if (!result_) result_ = node_object_shape_statement(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // root_shape_id [SHAPE_ID_MEMBER]
  public static boolean shape_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_id")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = root_shape_id(builder_, level_ + 1);
    result_ = result_ && shape_id_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, SHAPE_ID, result_);
    return result_;
  }

  // [SHAPE_ID_MEMBER]
  private static boolean shape_id_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_id_1")) return false;
    consumeToken(builder_, SHAPE_ID_MEMBER);
    return true;
  }

  /* ********************************************************** */
  // trait_statements IDENTIFIER ws COLON ws shape_id
  public static boolean shape_member_kvp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_member_kvp")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SHAPE_MEMBER_KVP, "<shape member kvp>");
    result_ = trait_statements(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && shape_id(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE ws (shape_member_kvp)* ws RBRACE
  public static boolean shape_members(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_members")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LBRACE);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && shape_members_2(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, SHAPE_MEMBERS, result_);
    return result_;
  }

  // (shape_member_kvp)*
  private static boolean shape_members_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_members_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!shape_members_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "shape_members_2", pos_)) break;
    }
    return true;
  }

  // (shape_member_kvp)
  private static boolean shape_members_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_members_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = shape_member_kvp(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // namespace_statement* use_section shape_statements
  public static boolean shape_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_section")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SHAPE_SECTION, "<shape section>");
    result_ = shape_section_0(builder_, level_ + 1);
    result_ = result_ && use_section(builder_, level_ + 1);
    result_ = result_ && shape_statements(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // namespace_statement*
  private static boolean shape_section_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_section_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!namespace_statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "shape_section_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // trait_statements shape_body
  public static boolean shape_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SHAPE_STATEMENT, "<shape statement>");
    result_ = trait_statements(builder_, level_ + 1);
    result_ = result_ && shape_body(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (shape_statement | apply_statement)*
  public static boolean shape_statements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_statements")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SHAPE_STATEMENTS, "<shape statements>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!shape_statements_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "shape_statements", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // shape_statement | apply_statement
  private static boolean shape_statements_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shape_statements_0")) return false;
    boolean result_;
    result_ = shape_statement(builder_, level_ + 1);
    if (!result_) result_ = apply_statement(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // ws SIMPLE_TYPE_NAME ws IDENTIFIER
  public static boolean simple_shape_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simple_shape_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SIMPLE_SHAPE_STATEMENT, "<simple shape statement>");
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SIMPLE_TYPE_NAME);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TRAIT_ID [trait_body]
  public static boolean trait(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait")) return false;
    if (!nextTokenIs(builder_, TRAIT_ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TRAIT_ID);
    result_ = result_ && trait_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, TRAIT, result_);
    return result_;
  }

  // [trait_body]
  private static boolean trait_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_1")) return false;
    trait_body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // LPAREN ws trait_body_value ws RPAREN
  public static boolean trait_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_body")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && trait_body_value(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, TRAIT_BODY, result_);
    return result_;
  }

  /* ********************************************************** */
  // trait_structure | node_value
  public static boolean trait_body_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_body_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TRAIT_BODY_VALUE, "<trait body value>");
    result_ = trait_structure(builder_, level_ + 1);
    if (!result_) result_ = node_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (ws trait)* ws
  public static boolean trait_statements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_statements")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TRAIT_STATEMENTS, "<trait statements>");
    result_ = trait_statements_0(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (ws trait)*
  private static boolean trait_statements_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_statements_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!trait_statements_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "trait_statements_0", pos_)) break;
    }
    return true;
  }

  // ws trait
  private static boolean trait_statements_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_statements_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && trait(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // trait_structure_kvp (ws trait_structure_kvp)*
  public static boolean trait_structure(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_structure")) return false;
    if (!nextTokenIs(builder_, "<trait structure>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TRAIT_STRUCTURE, "<trait structure>");
    result_ = trait_structure_kvp(builder_, level_ + 1);
    result_ = result_ && trait_structure_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (ws trait_structure_kvp)*
  private static boolean trait_structure_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_structure_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!trait_structure_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "trait_structure_1", pos_)) break;
    }
    return true;
  }

  // ws trait_structure_kvp
  private static boolean trait_structure_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_structure_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && trait_structure_kvp(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // node_object_key ws COLON ws node_value
  public static boolean trait_structure_kvp(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "trait_structure_kvp")) return false;
    if (!nextTokenIs(builder_, "<trait structure kvp>", IDENTIFIER, QUOTED_TEXT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TRAIT_STRUCTURE_KVP, "<trait structure kvp>");
    result_ = node_object_key(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && node_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (use_statement)*
  public static boolean use_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "use_section")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, USE_SECTION, "<use section>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!use_section_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "use_section", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // (use_statement)
  private static boolean use_section_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "use_section_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = use_statement(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ws USE_KEYWORD ws absolute_root_shape_id ws
  public static boolean use_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "use_statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, USE_STATEMENT, "<use statement>");
    result_ = ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, USE_KEYWORD);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && absolute_root_shape_id(builder_, level_ + 1);
    result_ = result_ && ws(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // VERSION COLON ws QUOTED_TEXT
  public static boolean version_section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "version_section")) return false;
    if (!nextTokenIs(builder_, VERSION)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, VERSION, COLON);
    result_ = result_ && ws(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, QUOTED_TEXT);
    exit_section_(builder_, marker_, VERSION_SECTION, result_);
    return result_;
  }

  /* ********************************************************** */
  // (SPACE | NEWLINE | comment | COMMA)*
  public static boolean ws(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ws")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, WS, "<ws>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!ws_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ws", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // SPACE | NEWLINE | comment | COMMA
  private static boolean ws_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ws_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SPACE);
    if (!result_) result_ = consumeToken(builder_, NEWLINE);
    if (!result_) result_ = comment(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMA);
    return result_;
  }

}
