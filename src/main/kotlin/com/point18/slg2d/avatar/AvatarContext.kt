package com.point18.slg2d.avatar

import com.point18.slg2d.avatar.actor.ActorStopEvent
import com.point18.slg2d.avatar.event.ActorStopEventBus
import com.point18.slg2d.avatar.event.StartupEvent
import com.point18.slg2d.avatar.pojo.AvatarDefinition
import com.point18.slg2d.avatar.pojo.ConnectedChannelInfo
import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicBoolean
import javax.annotation.PreDestroy

/**
 * avatar上下文
 */
@Service
class AvatarContext : ApplicationEventPublisherAware {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private lateinit var eventPublisher: ApplicationEventPublisher

    // 连接channel和机器人的关联表 holder
    private val connectedChannelList = ConcurrentLinkedQueue<ConnectedChannelInfo>() // 连接上的channel表
    private val registeredRobots = ConcurrentHashMap<Channel, AvatarDefinition>() // channel对应的robot

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

    /**
     * 连接，并注册channel对应的机器人实例
     *
     * @param b Bootstrap
     * @param addr String
     * @param port Int
     * @param avatarVo AvatarVo
     * @return ChannelFuture
     */
    @Synchronized
    fun connect(b: Bootstrap, addr: String, port: Int, avatarVo: AvatarDefinition): ChannelFuture {
        // 这个连接过程必须放在同步方法块中，否则会异常
        val f = b.connect(addr, port)  //  非阻塞链接得到一个future
        val channel = f.channel()

        //  这个异步锁作用: awaitConnectRobots资源操作不能同时共享
        this.registeredRobots[channel] = avatarVo

        return f
    }

    /**
     * 添加channel对应的连接成功信息
     * @param channelInfo ConnectedChannelInfo
     */
    operator fun plus(channelInfo: ConnectedChannelInfo) {
        this.connectedChannelList.add(channelInfo)
    }
}