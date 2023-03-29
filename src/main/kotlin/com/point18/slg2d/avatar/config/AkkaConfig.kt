package com.point18.slg2d.avatar.config

import akka.actor.ActorSystem
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@ComponentScan(basePackages = ["com.point18.slg2d.avatar"])
@Configuration
class AkkaConfig {

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
        return ActorSystem.create(systemName, config)
    }
}