//package com.point18.slg2d.avatar.net
//
//import akka.actor.ActorRef
//import com.point18.slg2d.avatar.constg.AvatarId
//import com.point18.slg2d.avatar.constg.Parameter
//import com.point18.slg2d.avatar.net.handler.*
//import com.point18.slg2d.avatar.pojo.ConnectedEvent
//import com.point18.slg2d.avatar.pojo.Disconnected
//import io.netty.bootstrap.Bootstrap
//import io.netty.channel.Channel
//import io.netty.channel.ChannelInitializer
//import io.netty.channel.EventLoopGroup
//import io.netty.channel.nio.NioEventLoopGroup
//import io.netty.channel.socket.SocketChannel
//import io.netty.channel.socket.nio.NioSocketChannel
//import io.netty.handler.codec.LengthFieldBasedFrameDecoder
//import io.netty.handler.codec.LengthFieldPrepender
//import org.slf4j.LoggerFactory
//import org.springframework.stereotype.Component
//import java.util.concurrent.ConcurrentHashMap
//import javax.annotation.PostConstruct
//
//@Component
//class NettyResources {
//
//    private val sharedEventLoop: EventLoopGroup = NioEventLoopGroup() // 共享线程池（[[1]](#__1) [[2]](#__2)）
//    private val sharedBootstrap: Bootstrap = Bootstrap()
//    private val logger = LoggerFactory.getLogger(this::class.java)
//
//    // 客户端状态管理Map
//    val clientRegistry = ConcurrentHashMap<AvatarId, ActorRef>()
//
//    @PostConstruct
//    fun startup() {
//        with(this.sharedBootstrap) {
//            group(sharedEventLoop)
//            channel(NioSocketChannel::class.java)
//        }
//    }
//
//    fun handler(actorRef: ActorRef) {
//        this.sharedBootstrap.handler(
//            object : ChannelInitializer<SocketChannel>() {
//                override fun initChannel(ch: SocketChannel) {
//                    ch.pipeline().addLast(
//                        "frameDecoder", LengthFieldBasedFrameDecoder(
//                            Parameter.MAX_FRAME_BYTES_LENGTH, 0, 4, -4, 4, true
//                        )
//                    )
//
//                    ch.pipeline().addLast("crcDecoder", RobotTopMsgCrcDecoder())
//                    ch.pipeline().addLast("protobufDecoder", RobotTopMsgProtobufDecoder())
//
//                    // 编码处理
//                    ch.pipeline().addLast("frameEncoder", LengthFieldPrepender(4, true))
//                    ch.pipeline().addLast("crcEncoder", RobotTopMsgCrcEncoder())
//                    ch.pipeline().addLast("cryptoEncoder", RobotTopMsgCryptoEncoder())
//                    ch.pipeline().addLast("protobufEncoder", RobotTopMsgProtobufEncoder())
//
//                    ch.pipeline().addLast(RobotClientHandler(actorRef))
//                }
//            }
//        )
//    }
//
//    fun connect(clientId: AvatarId, self: ActorRef, host: String?, port: Int?): Channel {
//        require(host != null)
//        require(port != null)
//        val future = this.sharedBootstrap.connect(host, port)
//        val channel = future.channel()
//
//        // 注册连接关闭的回调
//        future.addListener { f ->
//            if (f.isSuccess) {
//                // 连接成功关闭
//                // 这里可以进行连接关闭后的处理逻辑
//                clientRegistry[clientId] = self
//
//                self.tell(ConnectedEvent(channel), ActorRef.noSender())
//
//            } else {
//                // 连接关闭异常
//                val cause = f.cause()
//                // 这里可以处理连接关闭异常
//                self.tell(Disconnected, ActorRef.noSender())
//                logger.info("")
//            }
//        }
//        return channel
//    }
//}
