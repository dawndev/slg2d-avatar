package com.point18.slg2d.avatar.actor

import akka.actor.AbstractFSM
import akka.actor.ActorRef
import akka.actor.PoisonPill
import akka.actor.Terminated
import akka.japi.pf.FI
import akka.japi.pf.UnitMatch
import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.constg.AvatarState
import com.point18.slg2d.avatar.event.ActorStopEventBus
import com.point18.slg2d.avatar.event.ActorStopEventBus.Companion.ACTOR_STOP_BUS_ALL
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.pojo.AvatarVo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@Actor("avatarFSM")
class AvatarFSM : AbstractFSM<AvatarState, AvatarData> {

    private val logger = LoggerFactory.getLogger(AvatarActor::class.java)

    @Autowired
    private lateinit var avatarProperties: AvatarProperties

    @Autowired
    private lateinit var actorStopEventBus: ActorStopEventBus

    constructor() : super()

    init {
        // starting point
        startWith(AvatarState.NEW, AvatarVo(0, "undefined"))

        `when`(
            AvatarState.NEW,
            matchEvent(
                SetEvent::class.java,
                AvatarVo::class.java
            ) { param1, _ ->
                goTo(AvatarState.READY).using(AvatarVo(param1.robotNo, param1.robotName))
            }.event(Integer::class.java) { robotNo, _ ->
                val namePrefix = avatarProperties.nameprefix
                val robotName = String.format("%s%06d", namePrefix, robotNo)
                if (namePrefix == null) {
                    logger.error("robotNo: {}, 找不到namePrefix", robotNo)
                    stay()
                } else {
                    goTo(AvatarState.READY).using(AvatarVo(robotNo.toInt(), robotName))
                }
            }
        )

        `when`(
            AvatarState.READY,
            matchEvent(
                TodoEvent::class.java,
                AvatarVo::class.java
            ) { _, vo ->
                goTo(AvatarState.RUNNING).using(vo)
            }
        )

        `when`(
            AvatarState.RUNNING,
            matchEvent(
                SuspendEvent::class.java
            ) { _, vo ->
                goTo(AvatarState.WAITING).using(vo)
            }
        )

        `when`(
            AvatarState.WAITING,
            matchEvent(
                TodoEvent::class.java
            ) { _, vo ->
                goTo(AvatarState.RUNNING).using(vo)
            }
        )

        `when`(
            AvatarState.TERMINATED,
            matchEvent(
                TodoEvent::class.java
            ) { event, _ ->
                logger.error("state:{}, 收到了{}", stateName(), event::class.java)
                stay()
            }
        )

        // region 状态捕获
        onTransition(
            matchState(AvatarState.NEW, AvatarState.READY, FI.UnitApplyVoid {
                logger.debug("NEW-->READY")
            }).state(AvatarState.READY, AvatarState.RUNNING, FI.UnitApplyVoid {
                val m = UnitMatch.create(matchData(AvatarVo::class.java) {
                    logger.info("准备建立连接:{}", it)
                })
                m.match(stateData())
            }).state(null, AvatarState.TERMINATED) { from, _ ->
                if (AvatarState.TERMINATED != from) {
                    self.tell(PoisonPill.getInstance(), ActorRef.noSender())
                }
            }
        )
        // endregion

        whenUnhandled(
            matchEvent(Disconnected::class.java) { msg, data ->
                goto(AvatarState.TERMINATED).using(data)
            }.event(ActorStopEvent::class.java) { _, data ->
                goto(AvatarState.TERMINATED).using(data)
            }.event(Terminated::class.java) { _, data ->
                stay()
            }.anyEvent { event: Any, _: Any? ->
                logger.error("@${stateName()}阶段, 收到${event::class.java}消息，但这个阶段无法处理！")
                stay()
            }.build()
        )
    }

    override fun preStart() {
        logger.debug("{} preStart: state:{}, data:{}", self.path().name(), stateName(), stateData())
        actorStopEventBus.subscribe(self, ACTOR_STOP_BUS_ALL)
    }

    override fun postStop() {
        logger.info("{} stop", self.path().name())
        actorStopEventBus.unsubscribe(self)
    }

}

interface AvatarData

interface AvatarEvent

data class SetEvent(
    val robotNo: Int,
    val robotName: String
) : AvatarEvent

object TodoEvent : AvatarEvent

object SuspendEvent : AvatarEvent

object Disconnected : AvatarEvent

object ActorStopEvent