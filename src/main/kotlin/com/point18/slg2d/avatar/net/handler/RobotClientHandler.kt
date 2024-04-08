package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.event.AvatarRegisterHandler
import com.point18.slg2d.avatar.exception.ChannelAttrException
import com.point18.slg2d.common.netmsg.C2SMsg
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.util.AttributeKey
import com.point18.slg2d.avatar.pojo.AvatarPlayingData
import com.point18.slg2d.avatar.pojo.ConnectedEvent
import com.point18.slg2d.avatar.pojo.Disconnected
import com.point18.slg2d.avatar.util.ApplicationContextProvider
import org.slf4j.LoggerFactory
import java.util.Optional
import java.util.concurrent.TimeUnit


@ChannelHandler.Sharable
class RobotClientHandler : SimpleChannelInboundHandler<C2SMsg>() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun channelActive(ctx: ChannelHandlerContext) {
        val avatarId = ctx.getAvatarId()
            ?: throw ChannelAttrException()

        // 给指定actor发送通知
        logger.debug("客户端收到channel激活通知，通知actor:${avatarId}")
        avatarId.noticeAvatarConnected()
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: C2SMsg) {
        val avatarId = ctx.getAvatarId()
    }

    @Deprecated("Deprecated in Java")
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        if (cause is ChannelAttrException) {
            Optional.ofNullable(ctx.getAvatarId()).ifPresentOrElse({ robotNo ->
                logger.info("第一次尝试重新获取成功~:${robotNo}")
                robotNo.noticeAvatarConnected()
            }) {
                logger.info("第一次尝试重新获取失败，注册一个定时任务")
                ctx.channel().eventLoop().schedule({
                    val robotNo = ctx.getAvatarId()
                    logger.info("第二次尝试重新获取结果:${robotNo}")
                    if (robotNo == null) {
                        logger.error("第二次依旧获取失败~")
                        ctx.close()
                    } else {
                        robotNo.noticeAvatarConnected()
                    }

                }, 1, TimeUnit.SECONDS)
            }
        } else {
            logger.error("RobotClientHandler::exceptionCaught 捕获到了异常, {}", cause::class.java)
            ctx.close()
        }
    }

    override fun handlerRemoved(ctx: ChannelHandlerContext) {
        super.handlerRemoved(ctx)
        logger.debug("actor:[${ctx.getAvatarId()}]的channel[${ctx.name()}]被移除~")

        ctx.getAvatarId()?.let { no ->
            ApplicationContextProvider.getBean(AvatarRegisterHandler::class.java)?.let {
                it.tellActor(no, Disconnected)
            }
        }
    }


    private fun Int.noticeAvatarConnected() {
        ApplicationContextProvider.getBean(AvatarRegisterHandler::class.java)?.let {
            val rt = it.tellActor(this, ConnectedEvent)
            logger.debug("客户端收到channel激活通知actor:${this}，结果:$rt")
        }
    }


    private fun ChannelHandlerContext.getAvatarId(): Int? {
        return Optional.ofNullable(channel().attr(AVATAR_ID).get()).orElseGet { null }
    }

    companion object {
        val sessionKey = AttributeKey.valueOf<AvatarPlayingData>("key")   //定义一个属性，相当于map键值对：key是name，value是ActorRef
        val AVATAR_ID = AttributeKey.valueOf<Int>("avatar-id") // 客户端编号的 AttributeKey
    }
}