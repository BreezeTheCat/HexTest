@file:JvmName("HextestAbstractionsImpl")

package io.github.breezethecat.hextest.forge

import io.github.breezethecat.hextest.registry.HextestRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HextestRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
