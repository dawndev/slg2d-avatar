package com.point18.slg2d.avatar.actor

import akka.actor.ActorSystem
import akka.dispatch.PriorityGenerator
import akka.dispatch.UnboundedPriorityMailbox
import com.typesafe.config.Config

/**
 * 自定义邮箱设置类
 */
class PriorityMailbox(settings: ActorSystem.Settings, config: Config) :
    UnboundedPriorityMailbox(
        object : PriorityGenerator() {
            override fun gen(message: Any): Int {
                return if (message is IPriorityMessage) {
                    message.priority
                } else {
                    // default
                    100
                }
            }
        }
    )

interface IPriorityMessage {
    val priority: Int
}