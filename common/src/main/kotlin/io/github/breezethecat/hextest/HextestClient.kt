package io.github.breezethecat.hextest

import io.github.breezethecat.hextest.config.HextestConfig
import io.github.breezethecat.hextest.config.HextestConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HextestClient {
    fun init() {
        HextestConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
