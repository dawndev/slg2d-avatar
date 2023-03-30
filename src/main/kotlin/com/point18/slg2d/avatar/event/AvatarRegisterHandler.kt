package com.point18.slg2d.avatar.event

import akka.actor.ActorSystem
import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.extension.SpringExtension
import com.point18.slg2d.avatar.pojo.AvatarVo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

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

    override fun onApplicationEvent(event: StartupEvent) {
        val totalNum = avatarProperties.totalNum ?: 0
        val startId = avatarProperties.startId ?: 0
        val nameprefix = avatarProperties.nameprefix ?: "AAR"
        for (index in 0 until totalNum) {
            val robotNo = index + startId
            val name = String.format("%s%06d", nameprefix, robotNo)
            this.createAvatar(robotNo, name)
        }
    }

    private fun createAvatar(robotNo: Int, name: String) {
        val avatarVo = AvatarVo(robotNo, name)
        logger.info("mock::{}", avatarVo)
        val actorName = actorNamePrefix + robotNo
        springExtension.actorOf(actorSystem, "avatarActor", actorName, avatarVo)

        //PoisonPill
    }
}