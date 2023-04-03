package com.point18.slg2d.avatar.net.handler

import com.point18.slg2d.common.netmsg.C2SMsg
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.util.AttributeKey
import com.point18.slg2d.avatar.pojo.AvatarDefinition


@ChannelHandler.Sharable
class RobotClientHandler : SimpleChannelInboundHandler<C2SMsg>() {

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: C2SMsg?) {
        // pass
    }

    companion object {
        val sessionKey = AttributeKey.valueOf<AvatarDefinition>("key")   //定义一个属性，相当于map键值对：key是name，value是ActorRef
    }
}