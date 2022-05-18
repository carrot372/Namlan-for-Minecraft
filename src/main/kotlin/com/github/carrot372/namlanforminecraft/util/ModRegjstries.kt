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

package com.github.carrot372.namlanforminecraft.util

import com.github.carrot372.namlanforminecraft.command.StartCommand
import com.github.carrot372.namlanforminecraft.item.custom.DevTool
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class ModRegistries() {
    companion object {
        fun registerModStuff() {
            registerCommands()
            registerItems()
        }

        private fun registerCommands() {
            CommandRegistrationCallback.EVENT.register(StartCommand::register)
        }

        private fun registerItems() {
            Registry.register(Registry.ITEM, Identifier("namlanforminecraft","devtool"), DevTool.DEVTOOL)
        }
    }
}

