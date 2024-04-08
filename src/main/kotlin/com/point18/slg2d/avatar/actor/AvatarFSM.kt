package com.point18.slg2d.avatar.actor

import akka.actor.AbstractFSM
import akka.actor.ActorRef
import akka.actor.PoisonPill
import akka.actor.Terminated
import akka.japi.pf.FI
import akka.japi.pf.UnitMatch
import com.point18.slg2d.avatar.config.AvatarProperties
import com.point18.slg2d.avatar.config.ServerProperties
import com.point18.slg2d.avatar.constg.AvatarState
import com.point18.slg2d.avatar.event.ActorStopEventBus
import com.point18.slg2d.avatar.event.ActorStopEventBus.Companion.ACTOR_STOP_BUS_ALL
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.net.NettyClient
import com.point18.slg2d.avatar.pojo.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@Actor("avatarFSM")
class AvatarFSM : AbstractFSM<AvatarState, AvatarData>() {

    private val logger = LoggerFactory.getLogger(AvatarFSM::class.java)

    @Autowired
    private lateinit var avatarProperties: AvatarProperties
    @Autowired
    private lateinit var serverProperties: ServerProperties
    @Autowired
    private lateinit var actorStopEventBus: ActorStopEventBus
    @Autowired
    private lateinit var nettyClient: NettyClient

    init {
        // starting point
        startWith(AvatarState.NEW, AvatarUndefinedData())

        `when`(
            AvatarState.NEW,
            matchEvent(
                SetEvent::class.java,
                AvatarDefinedData::class.java
            ) { param1, vo ->
                logger.debug("avatar:{} 准备从NEW切入READY~", vo.id)
                goTo(AvatarState.READY).using(vo)
            }.event(Integer::class.java) { robotNo, _ ->
                val namePrefix = avatarProperties.nameprefix
                val robotName = String.format("%s%06d", namePrefix, robotNo)
                if (namePrefix == null) {
                    logger.error("robotNo: {}, 找不到namePrefix", robotNo)
                    stay()
                } else {
                    logger.debug("avatar:{} 数据准备完成~", robotNo)
                    goTo(AvatarState.READY).using(AvatarDefinedData(robotNo.toInt(), robotName))
                }
            }.anyEvent { e, s ->
                logger.info("avatar:{} NEW阶段不应该收到 {}~", s, e::class.java)
                stay()
            }
        )

        `when`(
            AvatarState.READY,
            matchEvent(
                TodoEvent::class.java,
                AvatarDefinedData::class.java
            ) { _, vo ->
                if (vo.id <= 0) {
                    logger.error("捕获NEW-->READY时，发现avatarNo:{} 没有完成初始化", vo.id)
                    self.tell(PoisonPill.getInstance(), ActorRef.noSender())
                }
                logger.debug("准备建立连接:{},并挂起, path:{}", vo, self.path())
                nettyClient.connect(vo.id, serverProperties.host, serverProperties.port)
                stay()
            }.event(
                ConnectedEvent::class.java,
                AvatarDefinedData::class.java
            ) { _, vo ->
                logger.debug("已经成功建立连接, 准备进入RUNNING, {}", self.path())
                goTo(AvatarState.RUNNING).using(AvatarPlayingData(vo.id, vo.name))
            }
        )

        `when`(
            AvatarState.RUNNING,
            matchEvent(
                SuspendEvent::class.java,
                AvatarPlayingData::class.java
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
            matchState(AvatarState.NEW, AvatarState.READY) { from, to ->
                val stateData = stateData()
//                if (stateData is AvatarDefinition) {
//                }
            }.state(AvatarState.READY, AvatarState.RUNNING, FI.UnitApplyVoid {
                val m = UnitMatch.create(matchData(AvatarDefinedData::class.java) {
                    logger.debug("成功进入RUNNING状态:{}", it)
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