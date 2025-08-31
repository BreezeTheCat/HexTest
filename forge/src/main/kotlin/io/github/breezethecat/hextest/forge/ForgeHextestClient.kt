package io.github.breezethecat.hextest.forge

import io.github.breezethecat.hextest.HextestClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeHextestClient {
    fun init(event: FMLClientSetupEvent) {
        HextestClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> HextestClient.getConfigScreen(parent) }
        }
    }
}
