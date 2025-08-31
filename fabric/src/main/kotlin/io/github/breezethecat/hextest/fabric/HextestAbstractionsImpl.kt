@file:JvmName("HextestAbstractionsImpl")

package io.github.breezethecat.hextest.fabric

import io.github.breezethecat.hextest.registry.HextestRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HextestRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
