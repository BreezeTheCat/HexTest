package io.github.breezethecat.hextest.networking

import dev.architectury.networking.NetworkChannel
import io.github.breezethecat.hextest.Hextest
import io.github.breezethecat.hextest.networking.msg.HextestMessageCompanion

object HextestNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hextest.id("networking_channel"))

    fun init() {
        for (subclass in HextestMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
