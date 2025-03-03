package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.avatar.constg.AvatarId
import com.point18.slg2d.avatar.constg.SharedAttributes
import com.point18.slg2d.avatar.event.AvatarRegisterHandler
import com.point18.slg2d.avatar.exception.ChannelAttrException
import com.point18.slg2d.avatar.extension.tellWithNoSender
import com.point18.slg2d.common.netmsg.C2SMsg
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.util.AttributeKey
import com.point18.slg2d.avatar.pojo.AvatarPlayingData
import com.point18.slg2d.avatar.pojo.ConnectedEvent
import com.point18.slg2d.avatar.pojo.Disconnected
import com.point18.slg2d.avatar.util.ApplicationContextProvider
import io.netty.channel.Channel
import org.slf4j.LoggerFactory
import java.util.Optional
import java.util.concurrent.TimeUnit


@ChannelHandler.Sharable
class RobotClientHandler : SimpleChannelInboundHandler<C2SMsg>() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun channelActive(ctx: ChannelHandlerContext) {
        ctx.channel().attr(SharedAttributes.ACTOR_REF_KEY).get()
        val channel = ctx.channel()
        Optional.ofNullable(ctx.channel().attr(SharedAttributes.ACTOR_REF_KEY).get()).ifPresentOrElse(
            {
                logger.debug("客户端收到channel激活通知，通知actor:{}", it.path())
                it.tellWithNoSender(ConnectedEvent(channel))
            }
        ) {
            throw ChannelAttrException()
        }
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: C2SMsg) {
        //val avatarId = ctx.getAvatarId()
    }

//    @Deprecated("Deprecated in Java")
//    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
//        if (cause is ChannelAttrException) {
//            Optional.ofNullable(ctx.getAvatarId()).ifPresentOrElse({ avatarId ->
//                logger.info("第一次尝试重新获取成功~:actor:{}", avatarId)
//                ctx.channel() connect avatarId
//            }) {
//                logger.info("第一次尝试重新获取失败，注册一个定时任务")
//                ctx.channel().eventLoop().schedule({
//                    val avatarId = ctx.getAvatarId()
//                    logger.info("第二次尝试重新获取结果:{}", avatarId)
//                    if (avatarId == null) {
//                        logger.error("第二次依旧获取失败~")
//                        ctx.close()
//                    } else {
//                        ctx.channel() connect avatarId
//                    }
//
//                }, 1, TimeUnit.SECONDS)
//            }
//        } else {
//            logger.error("RobotClientHandler::exceptionCaught 捕获到了异常, {}", cause::class.java)
//            ctx.close()
//        }
//    }

    override fun handlerRemoved(ctx: ChannelHandlerContext) {
        super.handlerRemoved(ctx)
//        logger.debug("actor:[${ctx.getAvatarId()}]的channel[${ctx.name()}]被移除~")
//
//        ctx.getAvatarId()?.let { no ->
//            ApplicationContextProvider.getBean(AvatarRegisterHandler::class.java)?.let {
//                it.tellAvatarById(no, Disconnected)
//            }
//        }
    }


    companion object {
        val sessionKey = AttributeKey.valueOf<AvatarPlayingData>("key")   //定义一个属性，相当于map键值对：key是name，value是ActorRef
        val AVATAR_ID = AttributeKey.valueOf<AvatarId>("avatar-id") // 客户端编号的 AttributeKey
    }
}