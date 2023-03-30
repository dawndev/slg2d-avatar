package com.point18.slg2d.avatar.runner

import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.config.ServerProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class SystemPromptRunner : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var serverProperties: ServerProperties

    @Autowired
    private lateinit var avatarProperties: AvatarProperties

    @Autowired
    private lateinit var env: Environment

    override fun run(vararg args: String?) {
        logger.info(
            "目标集群ID:{}, 服务器地址:{}:{}",
            serverProperties.clusterId,
            serverProperties.host,
            serverProperties.port
        )
        logger.info(
            "机器人脚本类型:{}",
            avatarProperties.scenario
        )
        logger.debug("JAVA_HOME:{}", env.getProperty("JAVA_HOME"))
    }
}