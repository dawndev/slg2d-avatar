package com.point18.slg2d.avatar.net.handler

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class RobotTopMsgCryptoEncoder : MessageToMessageEncoder<ByteBuf>() {

    override fun encode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {

        val channel = ctx.channel()  // 从上下文获取channel
        val attr = channel.attr(RobotClientHandler.sessionKey)  // 从channel获取想要的attr - sessionKey
        val robot = attr.get()        // attr 是一个ActorRef

        val aesKey = robot.aesKey

        val length = msg.readableBytes()

        val array = ByteArray(length)
        msg.readBytes(array)

        val cryptoBytes = encrypt(array, aesKey)

        out.add(Unpooled.wrappedBuffer(cryptoBytes))
    }

    @Throws(Throwable::class)
    fun encrypt(content: ByteArray, password: String): ByteArray {
        val key = SecretKeySpec(password.toByteArray(), "AES")
        val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key) // 初始化
        return cipher.doFinal(content)
    }
}