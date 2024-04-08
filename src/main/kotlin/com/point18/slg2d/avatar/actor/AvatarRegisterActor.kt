//package com.point18.slg2d.avatar.actor
//
//import akka.actor.AbstractActor
//import akka.pattern.CircuitBreaker
//import com.point18.slg2d.avatar.extension.Actor
//import org.slf4j.LoggerFactory
//import scala.runtime.BoxedUnit
//import java.time.Duration
//
//@Actor("avatarRegisterActor")
//class AvatarRegisterActor: AbstractActor() {
//
//    private val logger = LoggerFactory.getLogger(AvatarRegisterActor::class.java)
//
//    private val breaker: CircuitBreaker
//
//    init {
//        breaker = CircuitBreaker(
//            context.dispatcher(),
//            context.system().scheduler(),
//            5,  // 在熔断器打开之前，允许失败的最大次数
//            Duration.ofSeconds(10), // 每个调用的最大执行时间
//            Duration.ofMinutes(1)    // 熔断器打开之后，在重新尝试执行操作之前等待的时间。
//        ).onOpen(::onBreakerOpen)
//            .onHalfOpen(::onBreakerHalfOpen)
//            .onClose(::onBreakerClose)
//    }
//
//    override fun createReceive(): Receive {
//
//    }
//
//    override fun preStart() {
//        logger.debug("{} start", self.path().name())
//    }
//
//    override fun postStop() {
//        logger.debug("{} stop", self.path().name())
//    }
//
//    private fun onBreakerOpen(): BoxedUnit {
//        logger.warn("CircuitBreaker is now open.")
//        return BoxedUnit.UNIT
//    }
//
//    private fun onBreakerHalfOpen(): BoxedUnit {
//        logger.warn("CircuitBreaker is now half-open.")
//        return BoxedUnit.UNIT
//    }
//
//    private fun onBreakerClose(): BoxedUnit {
//        logger.warn("CircuitBreaker is now close.")
//        return BoxedUnit.UNIT
//    }
//}