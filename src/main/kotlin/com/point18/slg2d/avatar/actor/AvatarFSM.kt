package com.point18.slg2d.avatar.actor

import akka.actor.AbstractFSM
import akka.actor.ActorRef
import akka.actor.PoisonPill
import akka.japi.pf.FI
import akka.japi.pf.UnitMatch
import com.point18.slg2d.avatar.constg.AvatarState
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.pojo.AvatarVo
import org.slf4j.LoggerFactory

@Actor("avatarFSM")
class AvatarFSM : AbstractFSM<AvatarState, AvatarData> {

    private val logger = LoggerFactory.getLogger(AvatarActor::class.java)


    constructor() : super()

    init {
        // starting point
        startWith(AvatarState.NEW, Uninitialized)

        `when`(
            AvatarState.NEW,
            matchEvent(
                SetEvent::class.java,
                Uninitialized::class.java
            ) { param1, _ ->
                goTo(AvatarState.READY).using(AvatarVo(param1.robotNo, param1.robotName))
            }
        )

        `when`(
            AvatarState.READY,
            matchEvent(
                TodoEvent::class.java,
                AvatarVo::class.java
            ) { _, vo -> goTo(AvatarState.RUNNING).using(vo) }
        )

        // region 状态捕获
        onTransition(
            matchState(AvatarState.NEW, AvatarState.READY, FI.UnitApplyVoid {
                val m = UnitMatch.create(matchData(AvatarVo::class.java) {
                    logger.info("ready:{}", it)
                })
                m.match(stateData())
            }).state(AvatarState.READY, AvatarState.RUNNING, FI.UnitApplyVoid {
                val m = UnitMatch.create(matchData(AvatarVo::class.java) {
                    logger.info("准备连接:{}", it)
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
            }.anyEvent { event: Any, state: Any? ->
                logger.info("@${stateName()}阶段 收到${event::class.java}消息，但这个阶段无法处理！")
                stay()
            }.build()
        )
    }

    override fun preStart() {
        logger.info("{} start: state:{}, data:{}", self.path().name(), stateName(), stateData())

    }

    override fun postStop() {
        logger.debug("{} stop", self.path().name())
    }
}

interface AvatarData

interface AvatarEvent

object Uninitialized : AvatarData

data class SetEvent(
    val robotNo: Int,
    val robotName: String
) : AvatarEvent

object TodoEvent : AvatarEvent

object Disconnected : AvatarEvent