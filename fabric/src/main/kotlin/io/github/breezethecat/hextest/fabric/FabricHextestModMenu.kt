package io.github.breezethecat.hextest.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.breezethecat.hextest.HextestClient

object FabricHextestModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HextestClient::getConfigScreen)
}
