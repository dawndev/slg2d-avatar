package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.constg.Parameter
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LengthFieldPrepender

class ClientHandlerInitializer : ChannelInitializer<SocketChannel>() {

    override fun initChannel(ch: SocketChannel) {
        // 解码处理
        ch.pipeline().addLast(
            "frameDecoder", LengthFieldBasedFrameDecoder(
                Parameter.MAX_FRAME_BYTES_LENGTH, 0, 4, -4, 4, true
            )
        )

        ch.pipeline().addLast("crcDecoder", RobotTopMsgCrcDecoder())
        ch.pipeline().addLast("protobufDecoder", RobotTopMsgProtobufDecoder())

        // 编码处理
        ch.pipeline().addLast("frameEncoder", LengthFieldPrepender(4, true))
        ch.pipeline().addLast("crcEncoder", RobotTopMsgCrcEncoder())
        ch.pipeline().addLast("cryptoEncoder", RobotTopMsgCryptoEncoder())
        ch.pipeline().addLast("protobufEncoder", RobotTopMsgProtobufEncoder())

        ch.pipeline().addLast(RobotClientHandler())
    }
}