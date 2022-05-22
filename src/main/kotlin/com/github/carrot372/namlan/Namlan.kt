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

import com.github.carrot372.namlan.lexer.Lexer
import java.io.File

fun main() {
    /*
    do {
        val text = readln()
        Lexer.lexing(text)
    } while (text != "exit")
    */
    val file = File(readln())
    val text = file.readText()
    Lexer.lexing(text)

    println("Namlan was Exit.")
}