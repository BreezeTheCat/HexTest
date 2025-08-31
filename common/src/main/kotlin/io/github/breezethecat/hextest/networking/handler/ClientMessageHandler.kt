package io.github.breezethecat.hextest.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.breezethecat.hextest.config.HextestConfig
import io.github.breezethecat.hextest.networking.msg.*

fun HextestMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HextestConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
