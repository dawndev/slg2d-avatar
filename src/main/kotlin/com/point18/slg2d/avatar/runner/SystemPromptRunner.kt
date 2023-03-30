package com.point18.slg2d.avatar.runner

import com.point18.slg2d.avatar.config.ServerProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemPromptRunner : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var serverProperties: ServerProperties

    override fun run(vararg args: String?) {
        logger.info("目标集群ID:{}", serverProperties.clusterId)
    }
}