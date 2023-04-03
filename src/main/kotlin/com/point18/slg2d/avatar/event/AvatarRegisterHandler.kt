package com.point18.slg2d.avatar.event

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.actor.ActorSystem
import com.point18.slg2d.avatar.actor.AvatarFSM
import com.point18.slg2d.avatar.actor.TodoEvent
import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.extension.SpringExtension
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PostConstruct

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

    private val actorMap = ConcurrentHashMap<Int, ActorRef>()

    private lateinit var actorBeanName: String

    @PostConstruct
    fun prepareActorBeanName() {
        val annotation = AvatarFSM::class.java.getAnnotation(Actor::class.java)
            ?: throw IllegalArgumentException("AvatarRegisterHandler::获取不到actorBeanName")
        actorBeanName = annotation.value

        logger.debug("prepareActorBeanName: {}", actorBeanName)
    }

    override fun onApplicationEvent(event: StartupEvent) {
        val totalNum = avatarProperties.totalNum ?: 0
        val startId = avatarProperties.startId ?: 0
        for (index in 0 until totalNum) {
            val robotNo = index + startId
            this.actorMap[robotNo] = this.createAvatar(robotNo)
        }

        logger.info("avatar创建总数量:{}~", totalNum)

        // 准备一些资源
        for ((robotNo, actor) in actorMap) {
            actor.tell(Integer.valueOf(robotNo), ActorRef.noSender())
        }

        // 开始运行, 通过selection实例，批量发送消息
        // akka://AVATAR-WORLD/user/
        val selection: ActorSelection = actorSystem.actorSelection("user/$actorNamePrefix-*")
        selection.tell(TodoEvent, ActorRef.noSender())

        // down掉
        for ((_, actor) in actorMap) {
            //actor.tell(Disconnected, ActorRef.noSender())
        }

    }

    private fun createAvatar(robotNo: Int): ActorRef {
        if (!this::actorBeanName.isInitialized) {
            throw IllegalArgumentException("AvatarRegisterHandler::获取不到actorBeanName")
        }
        val actorName = "$actorNamePrefix-$robotNo"
        return springExtension.actorOf(actorSystem, actorBeanName, actorName)
    }
}