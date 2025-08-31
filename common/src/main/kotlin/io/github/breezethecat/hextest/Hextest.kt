package io.github.breezethecat.hextest

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.breezethecat.hextest.config.HextestConfig
import io.github.breezethecat.hextest.networking.HextestNetworking
import io.github.breezethecat.hextest.registry.HextestActions

object Hextest {
    const val MODID = "hextest"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HextestConfig.init()
        initRegistries(
            HextestActions,
        )
        HextestNetworking.init()
    }
}
