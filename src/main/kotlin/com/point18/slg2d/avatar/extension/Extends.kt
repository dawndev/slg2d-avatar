package com.point18.slg2d.avatar.extension

import akka.actor.ActorRef

fun ActorRef.tellWithNoSender(any: Any) {
    this@tellWithNoSender.tell(any, ActorRef.noSender())
}