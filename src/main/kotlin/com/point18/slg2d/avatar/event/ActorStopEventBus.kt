package com.point18.slg2d.avatar.event

import akka.actor.ActorRef
import akka.event.japi.LookupEventBus
import com.point18.slg2d.avatar.pojo.ActorStopEvent
import org.springframework.stereotype.Component

@Component
class ActorStopEventBus : LookupEventBus<ActorStopEvent, ActorRef, String>() {

    /**
     * 根据什么分类
     */
    override fun classify(event: ActorStopEvent): String {
        return ACTOR_STOP_BUS_ALL
    }

    override fun compareSubscribers(a: ActorRef, b: ActorRef): Int {
        return a.compareTo(b)
    }

    /**
     * 索引数据结构的大小，有多少种可能的分类。
     */
    override fun mapSize(): Int {
        return 5
    }

    override fun publish(event: ActorStopEvent, subscriber: ActorRef) {
        subscriber.tell(event, ActorRef.noSender())
    }

    companion object {
        const val ACTOR_STOP_BUS_ALL = "ALL"
    }
}