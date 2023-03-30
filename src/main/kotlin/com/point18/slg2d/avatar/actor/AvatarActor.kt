package com.point18.slg2d.avatar.actor

import akka.actor.AbstractActor
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.pojo.AvatarVo
import org.slf4j.LoggerFactory

@Actor("avatarActor")
class AvatarActor : AbstractActor {

    private val logger = LoggerFactory.getLogger(AvatarActor::class.java)

    private var avatarVo: AvatarVo? = null

    constructor() : super()

    constructor(avatarVo: AvatarVo) : super()

    override fun createReceive(): Receive {

        return receiveBuilder()
            .match(
                String::class.java
            ) { s: String? -> println("Received String message: {}") }
            .matchAny { o: Any? -> println("received unknown message") }
            .build()
    }

    override fun preStart() {
        logger.info("actor start")
    }

    override fun postStop() {
        logger.info("actor stop")
    }
}