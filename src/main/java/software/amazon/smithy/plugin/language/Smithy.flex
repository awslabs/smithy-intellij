package software.amazon.smithy.plugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static software.amazon.smithy.plugin.language.psi.SmithyTypes.*;

%%

%{
  public SmithyLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class SmithyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

DOC_COMMENT="///"[^\r\n]*
LINE_COMMENT="//"[^\r\n]*
SPACE=[ \t\n\x0B\f\r]+
NEWLINE=\r?\n
QUOTED_TEXT=\"([^\\\"]|\\.)*\"
NODE_CONSTANTS=(TRUE|FALSE|NULL)
TRAIT_ID=@(((_|[:letter:])(_|[:letter:]|[:digit:])*(.(_|[:letter:])(_|[:letter:]|[:digit:])*)*)#)*(_|[:letter:])(_|[:letter:]|[:digit:])*
INT=0|[1-9][0-9]*
FRAC=\.[0-9]*
EXP=[eE]([-a+])?[0-9]+
SIMPLE_TYPE_NAME=(blob|boolean|document|string|byte|short|integer|long|float|double|bigInteger|bigDecimal|timestamp)
COMPLEX_TYPE_NAME=(list|set|map|structure|union)
NODE_OBJECT_TYPE_NAME=(service|resource|operation)
SHAPE_ID_MEMBER=\$(_|[:letter:])(_|[:letter:]|[:digit:])*
IDENTIFIER=(_|[:letter:])(_|[:letter:]|[:digit:])*
TEXT_BLOCK=\"\"\"(\r?\n[ !#-\[\]-}]*)*\"\"\"

%%
<YYINITIAL> {
  {WHITE_SPACE}                { return WHITE_SPACE; }

  "$version"                   { return VERSION; }
  "apply"                      { return APPLY; }
  "metadata"                   { return METADATA; }
  "namespace"                  { return NAMESPACE_KEYWORD; }
  "use"                        { return USE_KEYWORD; }
  "\""                         { return DQUOTE; }
  "\\"                         { return ESCAPE; }
  ":"                          { return COLON; }
  "="                          { return EQ; }
  ","                          { return COMMA; }
  "{"                          { return LBRACE; }
  "}"                          { return RBRACE; }
  "["                          { return LBRACK; }
  "]"                          { return RBRACK; }
  "("                          { return LPAREN; }
  ")"                          { return RPAREN; }
  "#"                          { return POUND; }
  "-"                          { return MINUS; }
  "+"                          { return PLUS; }

  {DOC_COMMENT}                { return DOC_COMMENT; }
  {LINE_COMMENT}               { return LINE_COMMENT; }
  {SPACE}                      { return SPACE; }
  {NEWLINE}                    { return NEWLINE; }
  {QUOTED_TEXT}                { return QUOTED_TEXT; }
  {NODE_CONSTANTS}             { return NODE_CONSTANTS; }
  {TRAIT_ID}                   { return TRAIT_ID; }
  {INT}                        { return INT; }
  {FRAC}                       { return FRAC; }
  {EXP}                        { return EXP; }
  {SIMPLE_TYPE_NAME}           { return SIMPLE_TYPE_NAME; }
  {COMPLEX_TYPE_NAME}          { return COMPLEX_TYPE_NAME; }
  {NODE_OBJECT_TYPE_NAME}      { return NODE_OBJECT_TYPE_NAME; }
  {SHAPE_ID_MEMBER}            { return SHAPE_ID_MEMBER; }
  {IDENTIFIER}                 { return IDENTIFIER; }
  {TEXT_BLOCK}                 { return TEXT_BLOCK; }

}

[^] { return BAD_CHARACTER; }
