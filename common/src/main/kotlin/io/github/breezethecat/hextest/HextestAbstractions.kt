@file:JvmName("HextestAbstractions")

package io.github.breezethecat.hextest

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.breezethecat.hextest.registry.HextestRegistrar

fun initRegistries(vararg registries: HextestRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HextestRegistrar<T>) {
    throw AssertionError()
}
