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

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import software.amazon.smithy.plugin.language.psi.SmithyTypes;

public class SmithySyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SMITHY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey METADATA_SECTION =
            createTextAttributesKey("SMITHY_METADATA_SECTION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey METADATA_STATEMENT =
            createTextAttributesKey("SMITHY_METADATA_STATEMENT", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NODE_ARRAY =
            createTextAttributesKey("SMITHY_NODE_ARRAY", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey NODE_OBJECT =
            createTextAttributesKey("SMITHY_NODE_OBJECT", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey NODE_OBJECT_KVP =
            createTextAttributesKey("SMITHY_NODE_OBJECT_KVP", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey NODE_STRING_VALUE =
            createTextAttributesKey("SMITHY_NODE_STRING_VALUE", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey NODE_VALUE =
            createTextAttributesKey("SMITHY_NODE_VALUE", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("SMITHY_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey VERSION_SECTION =
            createTextAttributesKey("SMITHY_VERSION_SECTION", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey WS =
            createTextAttributesKey("SMITHY_WS", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey COLON =
            createTextAttributesKey("SMITHY_COLON", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey DOC_COMMENT =
            createTextAttributesKey("SMITHY_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey DQUOTE =
            createTextAttributesKey("SMITHY_DQUOTE", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey EQ =
            createTextAttributesKey("SMITHY_EQ", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey COMMA =
            createTextAttributesKey("SMITHY_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey ESCAPE =
            createTextAttributesKey("SMITHY_ESCAPE", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey SHAPE_ID_MEMBER =
            createTextAttributesKey("SMITHY_SHAPE_ID_MEMBER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("SMITHY_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey INT =
            createTextAttributesKey("SMITHY_INT", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey FRAC =
            createTextAttributesKey("SMITHY_FRAC", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey EXP =
            createTextAttributesKey("SMITHY_EXP", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SIMPLE_TYPE_NAME =
            createTextAttributesKey("SMITHY_SIMPLE_TYPE_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMPLEX_TYPE_NAME =
            createTextAttributesKey("SMITHY_COMPLEX_TYPE_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NODE_OBJECT_TYPE_NAME =
            createTextAttributesKey("SMITHY_NODE_OBJECT_TYPE_NAME", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LBRACE =
            createTextAttributesKey("SMITHY_LBRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey RBRACE =
            createTextAttributesKey("SMITHY_RBRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey LBRACK =
            createTextAttributesKey("SMITHY_LBRACK", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey RBRACK =
            createTextAttributesKey("SMITHY_RBRACK", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey LPAREN =
            createTextAttributesKey("SMITHY_LPAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey RPAREN =
            createTextAttributesKey("SMITHY_RBRACK", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("SMITHY_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey METADATA =
            createTextAttributesKey("SMITHY_METADATA", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey MINUS =
            createTextAttributesKey("SMITHY_MINUS", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey NEWLINE =
            createTextAttributesKey("SMITHY_NEWLINE", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey NODE_CONSTANTS =
            createTextAttributesKey("SMITHY_NODE_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey PLUS =
            createTextAttributesKey("SMITHY_PLUS", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey TRAIT_ID =
            createTextAttributesKey("SMITHY_TRAIT_ID", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey QUOTED_TEXT =
            createTextAttributesKey("SMITHY_QUOTED_TEXT", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey TEXT_BLOCK =
            createTextAttributesKey("SMITHY_TEXT_BLOCK", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey SPACE =
            createTextAttributesKey("SMITHY_SPACE", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey VERSION =
            createTextAttributesKey("SMITHY_VERSION", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey APPLY =
            createTextAttributesKey("SMITHY_APPLY", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey NAMESPACE_KEYWORD =
            createTextAttributesKey("SMITHY_NAMESPACE_KEYWORD", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey USE_KEYWORD =
            createTextAttributesKey("SMITHY_USE_KEYWORD", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SMITHY_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] METADATA_SECTION_KEYS = new TextAttributesKey[]{METADATA_SECTION};
    private static final TextAttributesKey[] METADATA_STATEMENT_KEYS = new TextAttributesKey[]{METADATA_STATEMENT};
    private static final TextAttributesKey[] NODE_ARRAY_KEYS = new TextAttributesKey[]{NODE_ARRAY};
    private static final TextAttributesKey[] NODE_OBJECT_KEYS = new TextAttributesKey[]{NODE_OBJECT};
    private static final TextAttributesKey[] NODE_OBJECT_KVP_KEYS = new TextAttributesKey[]{NODE_OBJECT_KVP};
    private static final TextAttributesKey[] NODE_STRING_VALUE_KEYS = new TextAttributesKey[]{NODE_STRING_VALUE};
    private static final TextAttributesKey[] NODE_VALUE_KEYS = new TextAttributesKey[]{NODE_VALUE};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] VERSION_SECTION_KEYS = new TextAttributesKey[]{VERSION_SECTION};
    private static final TextAttributesKey[] WS_KEYS = new TextAttributesKey[]{WS};
    private static final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[]{COLON};
    private static final TextAttributesKey[] DOC_COMMENT_KEYS = new TextAttributesKey[]{DOC_COMMENT};
    private static final TextAttributesKey[] DQUOTE_KEYS = new TextAttributesKey[]{DQUOTE};
    private static final TextAttributesKey[] EQ_KEYS = new TextAttributesKey[]{EQ};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] ESCAPE_KEYS = new TextAttributesKey[]{ESCAPE};
    private static final TextAttributesKey[] SHAPE_ID_MEMBER_KEYS = new TextAttributesKey[]{SHAPE_ID_MEMBER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] INT_KEYS = new TextAttributesKey[]{INT};
    private static final TextAttributesKey[] FRAC_KEYS = new TextAttributesKey[]{FRAC};
    private static final TextAttributesKey[] EXP_KEYS = new TextAttributesKey[]{EXP};
    private static final TextAttributesKey[] SIMPLE_TYPE_NAME_KEYS = new TextAttributesKey[]{SIMPLE_TYPE_NAME};
    private static final TextAttributesKey[] COMPLEX_TYPE_NAME_KEYS = new TextAttributesKey[]{COMPLEX_TYPE_NAME};
    private static final TextAttributesKey[] NODE_OBJECT_TYPE_NAME_KEYS
            = new TextAttributesKey[]{NODE_OBJECT_TYPE_NAME};
    private static final TextAttributesKey[] LBRACE_KEYS = new TextAttributesKey[]{LBRACE};
    private static final TextAttributesKey[] RBRACE_KEYS = new TextAttributesKey[]{RBRACE};
    private static final TextAttributesKey[] LBRACK_KEYS = new TextAttributesKey[]{LBRACK};
    private static final TextAttributesKey[] RBRACK_KEYS = new TextAttributesKey[]{RBRACK};
    private static final TextAttributesKey[] LPAREN_KEYS = new TextAttributesKey[]{LPAREN};
    private static final TextAttributesKey[] RPAREN_KEYS = new TextAttributesKey[]{RPAREN};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] METADATA_KEYS = new TextAttributesKey[]{METADATA};
    private static final TextAttributesKey[] MINUS_KEYS = new TextAttributesKey[]{MINUS};
    private static final TextAttributesKey[] NEWLINE_KEYS = new TextAttributesKey[]{NEWLINE};
    private static final TextAttributesKey[] NODE_CONSTANTS_KEYS = new TextAttributesKey[]{NODE_CONSTANTS};
    private static final TextAttributesKey[] PLUS_KEYS = new TextAttributesKey[]{PLUS};
    private static final TextAttributesKey[] TRAIT_ID_KEYS = new TextAttributesKey[]{TRAIT_ID};
    private static final TextAttributesKey[] QUOTED_TEXT_KEYS = new TextAttributesKey[]{QUOTED_TEXT};
    private static final TextAttributesKey[] TEXT_BLOCK_KEYS = new TextAttributesKey[]{TEXT_BLOCK};
    private static final TextAttributesKey[] SPACE_KEYS = new TextAttributesKey[]{SPACE};
    private static final TextAttributesKey[] VERSION_KEYS = new TextAttributesKey[]{VERSION};
    private static final TextAttributesKey[] APPLY_KEYS = new TextAttributesKey[]{APPLY};
    private static final TextAttributesKey[] NAMESPACE_KEYWORD_KEYS = new TextAttributesKey[]{NAMESPACE_KEYWORD};
    private static final TextAttributesKey[] USE_KEYWORD_KEYS = new TextAttributesKey[]{USE_KEYWORD};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SmithyLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SmithyTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(SmithyTypes.METADATA_SECTION)) {
            return METADATA_SECTION_KEYS;
        } else if (tokenType.equals(SmithyTypes.METADATA_STATEMENT)) {
            return METADATA_STATEMENT_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_ARRAY)) {
            return NODE_ARRAY_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_OBJECT)) {
            return NODE_OBJECT_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_OBJECT_KVP)) {
            return NODE_OBJECT_KVP_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_STRING_VALUE)) {
            return NODE_STRING_VALUE_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_VALUE)) {
            return NODE_VALUE_KEYS;
        } else if (tokenType.equals(SmithyTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(SmithyTypes.VERSION_SECTION)) {
            return VERSION_SECTION_KEYS;
        } else if (tokenType.equals(SmithyTypes.WS)) {
            return WS_KEYS;
        } else if (tokenType.equals(SmithyTypes.COLON)) {
            return COLON_KEYS;
        } else if (tokenType.equals(SmithyTypes.DOC_COMMENT)) {
            return DOC_COMMENT_KEYS;
        } else if (tokenType.equals(SmithyTypes.DQUOTE)) {
            return DQUOTE_KEYS;
        } else if (tokenType.equals(SmithyTypes.EQ)) {
            return EQ_KEYS;
        } else if (tokenType.equals(SmithyTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(SmithyTypes.ESCAPE)) {
            return ESCAPE_KEYS;
        } else if (tokenType.equals(SmithyTypes.SHAPE_ID_MEMBER)) {
            return SHAPE_ID_MEMBER_KEYS;
        } else if (tokenType.equals(SmithyTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(SmithyTypes.INT)) {
            return INT_KEYS;
        } else if (tokenType.equals(SmithyTypes.FRAC)) {
            return FRAC_KEYS;
        } else if (tokenType.equals(SmithyTypes.EXP)) {
            return EXP_KEYS;
        } else if (tokenType.equals(SmithyTypes.SIMPLE_TYPE_NAME)) {
            return SIMPLE_TYPE_NAME_KEYS;
        } else if (tokenType.equals(SmithyTypes.COMPLEX_TYPE_NAME)) {
            return COMPLEX_TYPE_NAME_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_OBJECT_TYPE_NAME)) {
            return NODE_OBJECT_TYPE_NAME_KEYS;
        } else if (tokenType.equals(SmithyTypes.LBRACE)) {
            return LBRACE_KEYS;
        } else if (tokenType.equals(SmithyTypes.RBRACE)) {
            return RBRACE_KEYS;
        } else if (tokenType.equals(SmithyTypes.LBRACK)) {
            return LBRACK_KEYS;
        } else if (tokenType.equals(SmithyTypes.RBRACK)) {
            return RBRACK_KEYS;
        } else if (tokenType.equals(SmithyTypes.LPAREN)) {
            return LPAREN_KEYS;
        } else if (tokenType.equals(SmithyTypes.RPAREN)) {
            return RPAREN_KEYS;
        } else if (tokenType.equals(SmithyTypes.SPACE)) {
            return SPACE_KEYS;
        } else if (tokenType.equals(SmithyTypes.LINE_COMMENT)) {
            return LINE_COMMENT_KEYS;
        } else if (tokenType.equals(SmithyTypes.METADATA)) {
            return METADATA_KEYS;
        } else if (tokenType.equals(SmithyTypes.MINUS)) {
            return MINUS_KEYS;
        } else if (tokenType.equals(SmithyTypes.NEWLINE)) {
            return NEWLINE_KEYS;
        } else if (tokenType.equals(SmithyTypes.NODE_CONSTANTS)) {
            return NODE_CONSTANTS_KEYS;
        } else if (tokenType.equals(SmithyTypes.PLUS)) {
            return PLUS_KEYS;
        } else if (tokenType.equals(SmithyTypes.TRAIT_ID)) {
            return TRAIT_ID_KEYS;
        } else if (tokenType.equals(SmithyTypes.QUOTED_TEXT)) {
            return QUOTED_TEXT_KEYS;
        } else if (tokenType.equals(SmithyTypes.TEXT_BLOCK)) {
            return TEXT_BLOCK_KEYS;
        } else if (tokenType.equals(SmithyTypes.VERSION)) {
            return VERSION_KEYS;
        } else if (tokenType.equals(SmithyTypes.APPLY)) {
            return APPLY_KEYS;
        } else if (tokenType.equals(SmithyTypes.NAMESPACE_KEYWORD)) {
            return NAMESPACE_KEYWORD_KEYS;
        } else if (tokenType.equals(SmithyTypes.USE_KEYWORD)) {
            return USE_KEYWORD_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
