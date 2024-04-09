package com.point18.slg2d.avatar.actor

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Cancellable
import akka.pattern.CircuitBreaker
import com.point18.slg2d.avatar.extension.Actor
import com.point18.slg2d.avatar.pojo.AvatarInvalid
import com.point18.slg2d.avatar.pojo.AvatarValid
import com.point18.slg2d.avatar.pojo.HeartEvent
import com.point18.slg2d.avatar.pojo.WaitConnect
import org.slf4j.LoggerFactory
import scala.concurrent.duration.FiniteDuration
import scala.runtime.BoxedUnit
import java.time.Duration
import java.util.concurrent.TimeUnit

@Actor("avatarKeeper")
class AvatarKeeper: AbstractActor() {

    private val logger = LoggerFactory.getLogger(AvatarKeeper::class.java)

    private val breaker: CircuitBreaker
    var cancelTick: Cancellable? = null
    val connectedIds = LinkedHashSet<Int>()
    var expectConnectCount = 0

    init {
        breaker = CircuitBreaker(
            context.dispatcher(),
            context.system().scheduler(),
            5,  // 在熔断器打开之前，允许失败的最大次数
            Duration.ofSeconds(10), // 每个调用的最大执行时间
            Duration.ofMinutes(1)    // 熔断器打开之后，在重新尝试执行操作之前等待的时间。
        ).onOpen(::onBreakerOpen)
            .onHalfOpen(::onBreakerHalfOpen)
            .onClose(::onBreakerClose)
    }

    override fun createReceive() = initialBehavior()

    private fun initialBehavior(): Receive {
        return receiveBuilder()
            .match(HeartEvent::class.java) { message ->
                // pass
            }
            .match(WaitConnect::class.java) {
                // 切换到新的行为
                logger.info("AvatarKeeper::等待连接数量:{}", it.expect)
                expectConnectCount = it.expect
                context.become(maintainBehavior())
            }.matchAny { o: Any? ->
                logger.info("received unknown message: {}", o)
            }.build()
    }

    private fun maintainBehavior(): Receive {
        return receiveBuilder()
            .match(HeartEvent::class.java) { message ->
                if (connectedIds.size >= expectConnectCount) {
                    logger.info("AvatarKeeper::连接数量:{} 已达标~", expectConnectCount)
                    context.become(completeBehavior())
                }
            }.match(AvatarValid::class.java) { message ->
                connectedIds.add(message.avatarId)
            }.matchAny { o: Any? ->
                logger.info("received unknown message: {}", o)
            }.build()
    }

    private fun completeBehavior(): Receive {
        return receiveBuilder()
            .match(HeartEvent::class.java) { message ->
                if (connectedIds.size < expectConnectCount) {
                    context.become(maintainBehavior())
                }
            }.match(AvatarInvalid::class.java) { message ->
                connectedIds.remove(message.avatarId)
            }.matchAny { o: Any? ->
                logger.info("received unknown message: {}", o)
            }.build()
    }

    override fun preStart() {
        logger.debug("{} start", self.path().name())
        val delayDuration = FiniteDuration.apply(1L, TimeUnit.SECONDS)
        val intervalDuration = FiniteDuration.apply(1L, TimeUnit.SECONDS)
        this.cancelTick = context.system().scheduler().scheduleAtFixedRate(
            delayDuration, intervalDuration, self, HeartEvent,
            context.dispatcher(), ActorRef.noSender()
        )
    }

    override fun postStop() {
        logger.debug("{} stop", self.path().name())
    }

    private fun onBreakerOpen(): BoxedUnit {
        logger.warn("CircuitBreaker is now open.")
        return BoxedUnit.UNIT
    }

    private fun onBreakerHalfOpen(): BoxedUnit {
        logger.warn("CircuitBreaker is now half-open.")
        return BoxedUnit.UNIT
    }

    private fun onBreakerClose(): BoxedUnit {
        logger.warn("CircuitBreaker is now close.")
        return BoxedUnit.UNIT
    }
}