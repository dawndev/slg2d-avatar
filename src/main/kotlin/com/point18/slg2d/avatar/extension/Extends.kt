package com.point18.slg2d.avatar.extension

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props

fun ActorRef.tellWithNoSender(any: Any) {
    this@tellWithNoSender.tell(any, ActorRef.noSender())
}

fun ActorSystem.createActor(props: Props, name: String): ActorRef {
    return this.actorOf(props, name)
}

fun ActorRef.send(message: Any, sender: ActorRef = ActorRef.noSender()) {
    this.tell(message, sender)
}

inline fun <reified T : AbstractActor> propsOf(vararg args: Any?): Props {
    return Props.create(T::class.java, *args)
}

// "hello world" --> "HelloWorld"
fun String.toCamelCase(): String {
    return this.split(" ").joinToString("") { it.capitalize() }
}