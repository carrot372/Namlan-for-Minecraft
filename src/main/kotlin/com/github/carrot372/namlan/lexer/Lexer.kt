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

package com.github.carrot372.namlan.lexer

import com.github.carrot372.namlan.*

object Lexer {
    fun lexing(text: String) {
        val tokenizer = Tokenizer(text)
        do {
            val token = tokenizer.nextToken()
            println(token)
        } while (token !is EOFToken)
    }


}

private operator fun Regex.contains(char: Char?): Boolean {
    return if (char == null) {
        false
    } else {
        matches(char.toString())
    }
}

class Tokenizer(private val input: String) {
    private fun isWhiteSpace(char: Char?): Boolean {
        return if(char == null) false else Regex("\\s").matches(char.toString())
    }

    private val ch: Char?
        get() = input.getOrNull(p)

    private var p: Int = 0

    private var position: Int = 0

    private fun incP(): Int {
        if (p < input.length) {
            p++
        }
        return p
    }

    private fun isEnd(): Boolean {
        return p == input.length
    }

    private fun ensureSetPosition(token: Token): Token {
        position = p
        return token
    }


    fun nextToken(): Token {
        if (isEnd()) return EOFToken()
        while (isWhiteSpace(ch)) {
            incP()
            position = p
        }
        val startPosition = position
        return when (ch) {
            // math
            '+' -> {
                incP()
                ensureSetPosition(PlusToken())
            }
            '-' -> {
                incP()
                ensureSetPosition(MinusToken())
            }
            '*' -> {
                incP()
                ensureSetPosition(MultiToken())
            }
            '/' -> {
                incP()
                ensureSetPosition(DiviToken())
            }
            '<' -> {
                incP()
                return when (ch) {
                    '=' -> {
                        incP()
                        position += p
                        LessEqualToken()
                    }
                    else -> {
                        position += p
                        LessToken()
                    }
                }
            }
            '>' -> {
                incP()
                return when (ch) {
                    '=' -> {
                        p++
                        GreatEqualToken()
                    }
                    else -> {
                        GreatToken()
                    }
                }
            }
            '=' -> {
                incP()
                when (ch) {
                    '=' -> {
                        incP()
                        position += p
                        return EqualToken()
                    }
                    else -> {
                        position += p
                        return AssignToken()
                    }
                }
            }
            '!' -> {
                incP()
                return when (ch) {
                    '=' -> {
                        incP()
                        position += p
                        NotEqualToken()
                    }
                    else -> {
                        position += p
                        BangToken()
                    }
                }
            }
            ',' -> {
                incP()
                position = p
                CommaToken()
            }
            '(' -> {
                incP()
                position = p
                LParenToken()
            }
            ')' -> {
                incP()
                position = p
                RParenToken()
            }
            '{' -> {
                incP()
                position = p
                LBraceToken()
            }
            '}' -> {
                incP()
                position = p
                RBraceToken()
            }
            ';' -> {
                incP()
                position = p
                SemiColonToken()
            }
            in Regex("[1-9]") -> {
                incP()
                while (ch in Regex("\\d")) {
                    incP()
                }
                ensureSetPosition(NumberToken(input.slice(startPosition until p)))
            }
            else -> return when {
                    isEnd() -> {
                        EOFToken()
                    }
                    ch in Regex("[a-zA-Z_]") -> {
                        while (ch in Regex("[a-zA-Z_]")) {
                            incP()
                        }
                        when (val text = input.slice(startPosition until p)) {
                            "Function" -> ensureSetPosition(FunctionToken())
                            "return" -> ensureSetPosition(ReturnToken())
                            "True" -> ensureSetPosition(TrueToken())
                            "False" -> ensureSetPosition(FalseToken())
                            "If" -> ensureSetPosition(IfToken())
                            "Else" -> ensureSetPosition(ElseToken())
                            "While" -> ensureSetPosition(WhileToken())
                            "For" -> ensureSetPosition(ForToken())
                            "When" -> ensureSetPosition(WhenToken())
                            "Then" -> ensureSetPosition(ThenToken())
                            else -> ensureSetPosition(IdentifierToken(text))
                        }
                    }
                    else -> {
                        incP()
                        ensureSetPosition(IllegalToken(input.slice(startPosition until p)))
                    }
                }
        }
    }

}