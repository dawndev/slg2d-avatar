package com.point18.slg2d.avatar

import com.point18.slg2d.avatar.event.ActorStopEventBus
import com.point18.slg2d.avatar.event.StartupEvent
import com.point18.slg2d.avatar.pojo.ActorStopEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.atomic.AtomicBoolean
import javax.annotation.PreDestroy

/**
 * avatar上下文
 */
@Service
class AvatarContext : ApplicationEventPublisherAware {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private lateinit var eventPublisher: ApplicationEventPublisher

    @Autowired
    private lateinit var actorStopEventBus: ActorStopEventBus

    // 全局终止标记，当添加机器人出现异常时，设置这个标记为true。后续结束整个机器人的运行。
    var terminate = AtomicBoolean(false)


    /**
     * 启动
     */
    fun startup() {
        logger.info("start up...")
        this.eventPublisher.publishEvent(StartupEvent())
    }


    @PreDestroy
    fun dispose() {
        actorStopEventBus.publish(ActorStopEvent)
    }

    override fun setApplicationEventPublisher(applicationEventPublisher: ApplicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher
    }
}