package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.util.utilCrc
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder


class RobotTopMsgCrcDecoder : MessageToMessageDecoder<ByteBuf>() {

    @Throws(Exception::class)
    override fun decode(ctx: ChannelHandlerContext, inMsg: ByteBuf, out: MutableList<Any>) {
        val length = inMsg.readableBytes()

        if (length < 2) {
            return
        }

        val beginIndex = inMsg.readerIndex()

        val array = ByteArray(length - 2)
        inMsg.readBytes(array, 0, length - 2)

        val crcCode = inMsg.readShort()

        if (utilCrc.crc16Verify(array, crcCode.toUShort())) {
            out.add(inMsg.retainedSlice(beginIndex, length - 2))
        }
    }
}