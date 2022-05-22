/*
 * Copyright (c) 2022. carrot
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.carrot372.namlan

enum class TokenKind {
    //SPECIAL
    EOF,//End Of File
    ILLEGAL,//Error

    //Normal
    IDENTIFIER,//User's Original Name
    NUMBER,// 0-9

    //Delimiter
    LPAREN,// (
    RPAREN,// )
    LBRACE,// {
    RBRACE,// }
    COMMA,// ,
    SEMICOLON,// ;

    //Operation
    ASSIGN,// =
    BANG,// !

    //Math
    PLUS,// +
    MINUS,// -
    MULTI,// *
    DIVI,// /
    LESS, // <
    GREAT, // >
    LESSEQUAL,// <=
    GREATEQUAL,// >=
    EQUAL, // ==
    NOTEQUAL,// !=

    //KeyWords
    FUNCTION,// Function
    RETURN,// Return
    IF,// If
    ELSE,// Else
    WHILE,// While
    For,// For
    WHEN,// When
    THEN,// Then

    //Boolean
    TRUE,// True
    FALSE,// Talse

    //model
    INT,// Numbers
    STRING,// String
}

open class Token (
    private val kind : TokenKind,
    private val literal : String
){
    override fun toString() : String {
        return "Kind : $kind : Literal: $literal"
    }
}

class IllegalToken(value: String): Token(TokenKind.ILLEGAL, value)
class EOFToken : Token(TokenKind.EOF, "")

class IdentifierToken(value: String): Token(TokenKind.IDENTIFIER, value)
class NumberToken(value: String): Token(TokenKind.NUMBER, value)
class StringToken(value: String): Token(TokenKind.STRING, value)

class PlusToken : Token(TokenKind.PLUS, "+")
class MinusToken : Token(TokenKind.MINUS, "-")
class MultiToken : Token(TokenKind.MULTI, "*")
class DiviToken : Token(TokenKind.DIVI, "/")
class BangToken : Token(TokenKind.BANG, "!")
class LessToken : Token(TokenKind.LESS, "<")
class GreatToken : Token(TokenKind.GREAT, ">")
class EqualToken : Token(TokenKind.EQUAL, "==")
class NotEqualToken : Token(TokenKind.NOTEQUAL, "!=")
class LessEqualToken : Token(TokenKind.LESSEQUAL, "<=")
class GreatEqualToken : Token(TokenKind.GREATEQUAL, ">=")
class AssignToken : Token(TokenKind.ASSIGN, "=")

class CommaToken : Token(TokenKind.COMMA, ",")
class LParenToken : Token(TokenKind.LPAREN, "(")
class RParenToken : Token(TokenKind.RPAREN, ")")
class LBraceToken : Token(TokenKind.LBRACE, "{")
class RBraceToken : Token(TokenKind.RBRACE, "}")
class SemiColonToken : Token(TokenKind.SEMICOLON, ";")



class FunctionToken : Token(TokenKind.FUNCTION, "Function")
class ReturnToken : Token(TokenKind.RETURN, "Return")
class IfToken : Token(TokenKind.IF, "If")
class ElseToken : Token(TokenKind.ELSE, "Else")
class WhenToken: Token(TokenKind.WHEN, "When")
class ThenToken: Token(TokenKind.THEN, "Then")
class TrueToken : Token(TokenKind.TRUE, "True")
class FalseToken : Token(TokenKind.FALSE, "False")
class WhileToken : Token(TokenKind.WHILE, "While")
class ForToken : Token(TokenKind.For, "For")

