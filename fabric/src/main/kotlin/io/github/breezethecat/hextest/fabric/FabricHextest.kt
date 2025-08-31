package io.github.breezethecat.hextest.fabric

import io.github.breezethecat.hextest.Hextest
import net.fabricmc.api.ModInitializer

object FabricHextest : ModInitializer {
    override fun onInitialize() {
        Hextest.init()
    }
}
