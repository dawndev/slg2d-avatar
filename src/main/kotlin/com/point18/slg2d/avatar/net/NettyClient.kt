package com.point18.slg2d.avatar.net

import com.point18.slg2d.avatar.constg.Parameter
import com.point18.slg2d.avatar.net.handler.ClientHandlerInitializer
import com.point18.slg2d.avatar.net.handler.RobotClientHandler
import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy


@Component
class NettyClient {

    private val logger: Logger = LoggerFactory.getLogger(NettyClient::class.java)

    private val group: EventLoopGroup = NioEventLoopGroup()
    private val bootstrap: Bootstrap = Bootstrap()

    /**
     * netty引导
     */
    @PostConstruct
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
        }.run {
            logger.info("初始化Netty客户端完毕")
        }
    }

    @PreDestroy
    fun stop() {
        val nettyFuture = group.shutdownGracefully()
        nettyFuture.await()
    }

    fun connect(clientId: Int, serverHost: String?, serverPort: Int?) {
        if (serverHost == null || serverPort == null) {
            throw IllegalArgumentException("NettyClient::connect参数发生异常,serverHost:$serverHost, serverPort:$serverPort")
        }

        // 连接到服务器
        val future = this.bootstrap.connect(serverHost, serverPort).sync()

        // 获取 Channel，并设置附加信息
        val channel = future.channel()
        channel.attr(RobotClientHandler.CLIENT_ID).set(clientId.toString())

        // 等待连接关闭
        channel.closeFuture().sync()
    }
}