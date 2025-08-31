package io.github.breezethecat.hextest.networking.msg

import io.github.breezethecat.hextest.config.HextestConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: HextestConfig.ServerConfig) : HextestMessageS2C {
    companion object : HextestMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = HextestConfig.ServerConfig.decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
