package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.actor.ConnectedEvent
import com.point18.slg2d.avatar.event.AvatarRegisterHandler
import com.point18.slg2d.avatar.exception.ChannelAttrException
import com.point18.slg2d.common.netmsg.C2SMsg
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.util.AttributeKey
import com.point18.slg2d.avatar.pojo.AvatarDefinition
import com.point18.slg2d.avatar.util.ApplicationContextProvider
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.util.Optional
import java.util.concurrent.TimeUnit


@ChannelHandler.Sharable
class RobotClientHandler : SimpleChannelInboundHandler<C2SMsg>() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun channelActive(ctx: ChannelHandlerContext) {
        val clientId = Optional.ofNullable(ctx.channel().attr(CLIENT_ID).get()).orElseThrow {
            ChannelAttrException()
        }
        val robotNo = clientId.toIntOrNull()
            ?: throw IllegalArgumentException("RobotClientHandler::channelActive取不到参数")

        // 给指定actor发送通知
        logger.info("客户端收到channel激活通知，通知actor:${robotNo}")
        ApplicationContextProvider.getBean(AvatarRegisterHandler::class.java)?.let {
            val rt = it.tellActor2(robotNo, ConnectedEvent)
            logger.info("客户端收到channel激活通知，结果:$rt")
        }
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: C2SMsg) {
        val clientId = ctx.channel().attr(CLIENT_ID).get()
    }

    @Deprecated("Deprecated in Java")
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        logger.error("RobotClientHandler::exceptionCaught 捕获到了异常, {}", cause::class.java)
        if (cause is ChannelAttrException) {
            Optional.ofNullable(ctx.channel().attr(CLIENT_ID).get()).ifPresentOrElse({clientId2 ->
                println("尝试重新获取:${clientId2}")
            }) {
                logger.info("注册一个定时任务")
                ctx.channel().eventLoop().schedule({
                    // 获取 Channel，并设置附加信息
                    val attr = ctx.channel().attr(CLIENT_ID)
                    if (attr != null) {
                        val clientId2 = attr.get().toIntOrNull()
                        println("尝试重新获取:${clientId2}")
                    } else {
                        ctx.close()
                    }

                }, 1, TimeUnit.SECONDS)
            }
        } else {
            ctx.close()
        }
    }

    override fun handlerRemoved(ctx: ChannelHandlerContext?) {
        super.handlerRemoved(ctx)
    }

    companion object {
        val sessionKey = AttributeKey.valueOf<AvatarDefinition>("key")   //定义一个属性，相当于map键值对：key是name，value是ActorRef
        val CLIENT_ID = AttributeKey.valueOf<String>("avatar-id") // 客户端编号的 AttributeKey
    }
}