package com.point18.slg2d.avatar

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AvatarContext {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun bootstrap() {
        logger.info("start up...")
    }
}