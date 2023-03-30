package com.point18.slg2d.avatar.actor

import akka.actor.AbstractActor
import com.point18.slg2d.avatar.extension.Actor

@Actor("avatarActor")
class AvatarActor : AbstractActor() {

    override fun createReceive(): Receive {

        return receiveBuilder()
            .match(
                String::class.java
            ) { s: String? -> println("Received String message: {}") }
            .matchAny { o: Any? -> println("received unknown message") }
            .build()
    }
}