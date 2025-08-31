package io.github.breezethecat.hextest.fabric

import io.github.breezethecat.hextest.HextestClient
import net.fabricmc.api.ClientModInitializer

object FabricHextestClient : ClientModInitializer {
    override fun onInitializeClient() {
        HextestClient.init()
    }
}
