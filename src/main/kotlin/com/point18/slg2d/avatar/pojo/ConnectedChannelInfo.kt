package com.point18.slg2d.avatar.pojo

import io.netty.channel.Channel

data class ConnectedChannelInfo(
    val channel: Channel,
    val connectedTime: Long
)