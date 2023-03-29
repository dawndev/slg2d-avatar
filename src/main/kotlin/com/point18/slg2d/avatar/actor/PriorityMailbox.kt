package com.point18.slg2d.avatar.actor

import akka.actor.ActorSystem
import akka.dispatch.PriorityGenerator
import akka.dispatch.UnboundedPriorityMailbox
import com.typesafe.config.Config

/**
 * Simple priority queue mapping the task priority to the mailbox priority.
 */
class PriorityMailbox(settings: ActorSystem.Settings?, config: Config?) :
    UnboundedPriorityMailbox(
        object : PriorityGenerator() {
            override fun gen(message: Any): Int {
                return if (message is Task) {
                    message.priority
                } else {
                    // default
                    100
                }
            }
        }
    )