package com.point18.slg2d.avatar.actor

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.PoisonPill
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.pojo.AvatarDefinition
import org.slf4j.LoggerFactory

@Actor("avatarActor")
class AvatarActor : AbstractActor {

    private val logger = LoggerFactory.getLogger(AvatarActor::class.java)

    private var avatarVo: AvatarDefinition? = null

    constructor() : super()

    constructor(avatarVo: AvatarDefinition) : super() {
        this.avatarVo = avatarVo
    }

    override fun createReceive(): Receive {

        return receiveBuilder()
            .match(
                String::class.java
            ) { s: String -> logger.info("Received String message: {}", s) }
            .matchAny { o: Any? -> logger.info("received unknown message: {}", o) }
            .build()
    }

    override fun preStart() {
        logger.debug("{} start, name:{}", self.path().name(), avatarVo)
        if (avatarVo == null) {
            self.tell(PoisonPill.getInstance(), ActorRef.noSender())
        }
    }

    override fun postStop() {
        logger.debug("{} stop, name:{}", self.path().name(), avatarVo)
    }
}