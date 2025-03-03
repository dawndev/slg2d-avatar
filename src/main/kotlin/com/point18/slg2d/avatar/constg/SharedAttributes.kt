package com.point18.slg2d.avatar.constg

import akka.actor.ActorRef
import io.netty.util.AttributeKey

object SharedAttributes {
    val ACTOR_REF_KEY = AttributeKey.newInstance<ActorRef>("actor")

    val AVATAR_ID = AttributeKey.valueOf<AvatarId>("avatar-id") // 客户端编号的 AttributeKey
}