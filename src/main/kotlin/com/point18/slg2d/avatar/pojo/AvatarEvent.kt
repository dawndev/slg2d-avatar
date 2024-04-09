package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.constg.AvatarId
import io.netty.channel.Channel

interface AvatarEvent

data class DefineEvent(
    val id: AvatarId
): AvatarEvent

object PingEvent : AvatarEvent

data class ConnectedEvent(
    val channel: Channel
) : AvatarEvent

object SuspendEvent : AvatarEvent

object Disconnected : AvatarEvent