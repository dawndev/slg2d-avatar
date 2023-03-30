package com.point18.slg2d.avatar.net

import com.point18.slg2d.avatar.constg.Parameter
import com.point18.slg2d.avatar.net.handler.ClientHandlerInitializer
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy


@Component
class NettyClient {

    private val logger: Logger = LoggerFactory.getLogger(NettyClient::class.java)

    private val group: EventLoopGroup = NioEventLoopGroup()
    private val bootstrap: Bootstrap = Bootstrap()


    //@PostConstruct
    fun startup() {
        with(this.bootstrap) {
            group(group)

            // 指定所使用的NIO传输channel
            channel(NioSocketChannel::class.java)

            // 要求低延迟，禁用nagle算法
            option(ChannelOption.TCP_NODELAY, true)

            // 连接超时
            option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)

            // sendBuff大小
            option(ChannelOption.SO_SNDBUF, Parameter.MAX_FRAME_BYTES_LENGTH)

            // receiveBuff大小
            option(ChannelOption.SO_RCVBUF, Parameter.MAX_FRAME_BYTES_LENGTH)

            // 可以重复使用本地地址和端口
            option(ChannelOption.SO_REUSEADDR, true)

            handler(ClientHandlerInitializer())
        }
    }

    @PreDestroy
    fun stop() {
        // pass
    }
}