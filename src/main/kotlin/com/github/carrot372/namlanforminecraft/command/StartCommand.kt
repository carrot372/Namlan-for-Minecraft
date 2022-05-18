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

package com.github.carrot372.namlanforminecraft.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

object StartCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicaded:Boolean) {
        dispatcher.register(CommandManager.literal("nl")
            .then(CommandManager.literal("start").executes(this::run)))
    }

    private fun run(context: CommandContext<ServerCommandSource>): Int {
        println("called start command")

        return 0
    }

}