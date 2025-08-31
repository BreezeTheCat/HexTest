package io.github.breezethecat.hextest.forge

import dev.architectury.platform.forge.EventBuses
import io.github.breezethecat.hextest.Hextest
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hextest.MODID)
class HextestForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hextest.MODID, this)
            addListener(ForgeHextestClient::init)
            addListener(::gatherData)
        }
        Hextest.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
