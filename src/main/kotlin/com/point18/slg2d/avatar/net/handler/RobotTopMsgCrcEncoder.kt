package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.util.utilCrc
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.wrappedBuffer
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder


class RobotTopMsgCrcEncoder : MessageToMessageEncoder<ByteBuf>() {

    override fun encode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
        val length = msg.readableBytes()

        val array = ByteArray(length)
        msg.readBytes(array, 0, length)

        val genCode = utilCrc.crc16(array).toInt()

        val codeBytes = ByteArray(2)
        codeBytes[1] = (genCode and 0xff).toByte()
        codeBytes[0] = (genCode shr 8 and 0xff).toByte()

        out.add(wrappedBuffer(array, codeBytes))
    }
}