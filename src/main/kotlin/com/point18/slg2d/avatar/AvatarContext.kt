package com.point18.slg2d.avatar

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.annotation.PreDestroy

/**
 * avatar上下文
 */
@Service
class AvatarContext {

    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 启动
     */
    fun startup() {
        logger.info("start up...")
    }

    @PreDestroy
    fun dispose() {
        // pass
    }
}