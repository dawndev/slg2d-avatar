package com.point18.slg2d.avatar

import com.point18.slg2d.avatar.event.StartupEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Service
import javax.annotation.PreDestroy

/**
 * avatar上下文
 */
@Service
class AvatarContext : ApplicationEventPublisherAware {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private lateinit var eventPublisher: ApplicationEventPublisher


    /**
     * 启动
     */
    fun startup() {
        logger.info("start up...")
        this.eventPublisher.publishEvent(StartupEvent())
    }


    @PreDestroy
    fun dispose() {
        // pass
    }

    override fun setApplicationEventPublisher(applicationEventPublisher: ApplicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher
    }
}