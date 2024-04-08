//package com.point18.slg2d.avatar.actor
//
//import akka.actor.AbstractActor
//import akka.actor.OneForOneStrategy
//import akka.actor.SupervisorStrategy
//import akka.japi.pf.DeciderBuilder
//import scala.concurrent.duration.Duration
//
//class AvatarSupervisor : AbstractActor() {
//
//    override fun preStart() {
//        // 监督策略
//        val strategy: SupervisorStrategy = OneForOneStrategy(
//            3,
//            Duration.create("1 minute"),
//            DeciderBuilder
//                .match(Exception::class.java) { ex ->
//                    // 在子 Actor 抛出异常时进行处理
//                    println("SupervisorActor: Child actor encountered an exception: $ex")
//                    // 可以选择重启子 Actor
//                    SupervisorStrategy.Restart
//                }
//                .build()
//        )
//
//        // 使用监督策略
//        context.setSupervisorStrategy(strategy)
//    }
//
//    override fun createReceive(): Receive {
//        TODO("Not yet implemented")
//    }
//}