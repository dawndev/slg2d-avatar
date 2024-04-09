package com.point18.slg2d.avatar.event

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.actor.ActorSystem
import com.point18.slg2d.avatar.actor.AvatarFSM
import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.constg.AvatarId
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.extension.SpringExtension
import com.point18.slg2d.avatar.extension.tellWithNoSender
import com.point18.slg2d.avatar.pojo.DefineEvent
import com.point18.slg2d.avatar.pojo.PingEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentSkipListSet
import javax.annotation.PostConstruct

/**
 * 机器人启动注册器
 */
@Component
class AvatarRegisterHandler : ApplicationListener<StartupEvent> {

    @Autowired
    private lateinit var avatarProperties: AvatarProperties

    @Autowired
    private lateinit var actorSystem: ActorSystem

    @Autowired
    private lateinit var springExtension: SpringExtension

    @Value("\${akka.actor.name.prefix}")
    private lateinit var actorNamePrefix: String

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val actorRegisteredIds = ConcurrentSkipListSet<Int>()
    val actorConnectedIds = ConcurrentSkipListSet<Int>()

    private lateinit var actorBeanName: String

    @PostConstruct
    fun prepareActorBeanName() {
        val annotation = AvatarFSM::class.java.getAnnotation(Actor::class.java)
            ?: throw IllegalArgumentException("AvatarRegisterHandler::获取不到actorBeanName")
        actorBeanName = annotation.value

        logger.debug("prepareActorBeanName: {}", actorBeanName)
    }

    override fun onApplicationEvent(event: StartupEvent) {
        if (!this::actorBeanName.isInitialized) {
            throw IllegalArgumentException("AvatarRegisterHandler::获取不到actorBeanName")
        }
        val totalNum = avatarProperties.totalNum
            ?: throw IllegalArgumentException("AvatarRegisterHandler::获取不到totalNum")
        val startId = avatarProperties.startId
            ?: throw IllegalArgumentException("AvatarRegisterHandler::获取不到startId")

        for (index in 0 until totalNum) {
            val avatarId = index + startId
            avatarId.newActor {
                this@newActor.tellWithNoSender(DefineEvent(avatarId))
                this@AvatarRegisterHandler.actorRegisteredIds.add(avatarId)
            }
        }
        logger.info("avatar配置的创建总数量:{}, 实际创建的数量{}~", totalNum, this.actorRegisteredIds.size)

        // 开始运行, 通过selection实例，批量发送消息
        this.tellAllAvatar(PingEvent)
    }

    /**
     * new一个actor
     * @receiver AvatarId
     * @param action [@kotlin.ExtensionFunctionType] Function1<ActorRef, Unit>
     */
    private fun AvatarId.newActor(action: ActorRef.() -> Unit) {
        val actorName = "$actorNamePrefix-${this@newActor}"
        val actorOf = springExtension.actorOf(actorSystem, actorBeanName, actorName)
        actorOf.action()
    }

    /**
     * 给指定id的avatar发送消息
     * @param no Int
     * @param any Any
     */
    fun tellAvatarById(no: AvatarId, any: Any) {
        if (!this.actorRegisteredIds.contains(no)) {
            logger.error("avatarId:{} 没有注册，收到消息{}", no, any::class.java.name)
            return
        }
        val selection: ActorSelection = actorSystem.actorSelection("user/$actorNamePrefix-$no")
        selection.tell(any, ActorRef.noSender())
    }

    /**
     * 通过selection实例，批量发送消息
     * <p>
     *     akka://AVATAR-WORLD/user/
     *
     * @param any Any
     */
    fun tellAllAvatar(any: Any) {
        val selection: ActorSelection = actorSystem.actorSelection("user/$actorNamePrefix-*")
        selection.tell(any, ActorRef.noSender())
    }
}