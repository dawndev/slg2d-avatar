//package com.point18.slg2d.avatar.actor
//
//import akka.actor.AbstractActor
//import akka.actor.ActorRef
//import akka.actor.Props
//import akka.pattern.CircuitBreaker
//import org.slf4j.LoggerFactory
//import scala.runtime.BoxedUnit
//import java.time.Duration
//import java.net.Socket
//
//class RegisterSupervisor : AbstractActor() {
//
//    private val logger = LoggerFactory.getLogger(AvatarRegisterActor::class.java)
//    private val registerActor: ActorRef = context.actorOf(Props.create(RegisterActor::class.java))
//
//    private val circuitBreaker = CircuitBreaker(
//        context.dispatcher(),
//        context.system().scheduler(),
//        3,  // 在熔断器打开之前，允许失败的最大次数
//        Duration.ofSeconds(3), // 每个调用的最大执行时间
//        Duration.ofSeconds(5)    // 熔断器打开之后，在重新尝试执行操作之前等待的时间。
//    ).onOpen(::onBreakerOpen)
//        .onHalfOpen(::onBreakerHalfOpen)
//        .onClose(::onBreakerClose)
//
//    override fun createReceive(): Receive {
//        return receiveBuilder()
//            .matchEquals("triggerTask", this::triggerTask)
//            .build()
//    }
//
//    private fun triggerTask(message: Any) {
//        // 使用熔断器保护任务的执行
//        circuitBreaker.withCircuitBreaker {
//
//        }
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
//    // 一旦 CircuitBreaker 进入半开状态，它会允许一定数量的请求通过执行操作，以测试外部服务是否恢复正常
//    private fun onBreakerHalfOpen(): BoxedUnit {
//        logger.warn("CircuitBreaker is now half-open.")
//        return BoxedUnit.UNIT
//    }
//
//    private fun onBreakerClose(): BoxedUnit {
//        logger.warn("CircuitBreaker is now close.")
//        return BoxedUnit.UNIT
//    }
//
//}