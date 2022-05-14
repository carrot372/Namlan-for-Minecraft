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

package com.github.carrot372.namlanforminecraft

import com.github.carrot372.namlanforminecraft.item.DevTool
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.util.function.Supplier

var MOD_ID = "namlanforminecraft"
@Suppress("unused")
fun init() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    println("Hello Fabric world!")

    Registry.register(Registry.ITEM, Identifier("namlanforminecraft","devtool"),DevTool.DEVTOOL)
}

object NamlanGroup {
    var NAMLANGROUP: ItemGroup = FabricItemGroupBuilder.build(Identifier(MOD_ID,"namlan"), Supplier { ItemStack(DevTool.DEVTOOL) })
}



