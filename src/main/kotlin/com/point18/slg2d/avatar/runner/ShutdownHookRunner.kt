package com.point18.slg2d.avatar.runner

import akka.actor.ActorSystem
import akka.actor.CoordinatedShutdown
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ShutdownHookRunner : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var actorSystem: ActorSystem

    override fun run(vararg args: String?) {
//        Runtime.getRuntime().addShutdownHook(
//            Thread {
//                logger.info("shutdown hook")
//            })
        CoordinatedShutdown.get(actorSystem).addJvmShutdownHook {
            logger.warn("响应宕机~, shutdown")
        }
    }
}