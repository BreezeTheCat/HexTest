package io.github.breezethecat.hextest.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.breezethecat.hextest.Hextest
import io.github.breezethecat.hextest.networking.HextestNetworking
import io.github.breezethecat.hextest.networking.handler.applyOnClient
import io.github.breezethecat.hextest.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HextestMessage

sealed interface HextestMessageC2S : HextestMessage {
    fun sendToServer() {
        HextestNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HextestMessageS2C : HextestMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HextestNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HextestNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HextestMessageCompanion<T : HextestMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hextest.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HextestMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hextest.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hextest.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HextestMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hextest.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
