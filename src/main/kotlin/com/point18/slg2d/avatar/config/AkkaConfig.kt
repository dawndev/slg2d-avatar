package com.point18.slg2d.avatar.config

import akka.actor.ActorSystem
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Configuration
class AkkaConfig {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${akka.system.name}")
    lateinit var systemName: String

    @Bean
    fun akkaConfiguration(): Config {
        return ConfigFactory.load("akka-avatar.conf")
    }

    @Lazy
    @Bean
    fun actorSystem(): ActorSystem {
        val config = akkaConfiguration()
        val actorSystem = ActorSystem.create(systemName, config)
        logger.info("创建ActorSystem【{}】成功;-)", systemName)
        return actorSystem
    }
}