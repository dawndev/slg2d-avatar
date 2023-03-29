package com.point18.slg2d.avatar

import com.point18.slg2d.avatar.config.ServerProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AvatarContext {

    val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var serverProperties: ServerProperties

    fun bootstrap() {
        logger.info("目标集群ID:{}", serverProperties.clusterId)
    }
}