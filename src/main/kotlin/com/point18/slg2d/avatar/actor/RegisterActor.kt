//package com.point18.slg2d.avatar.actor
//
//import akka.actor.AbstractActor
//
//class RegisterActor : AbstractActor() {
//    override fun createReceive(): Receive {
//        return receiveBuilder()
//            .matchEquals("task", this::performTask)
//            .build()
//    }
//
//    private fun performTask(message: Any) {
//        // 模拟执行任务
//        // 这里可以是调用远程服务或执行需要保护的操作
//
//        // 模拟随机异常
//        if (Math.random() < 0.5) {
//            throw Exception("Worker actor encountered an exception")
//        }
//
//        println("WorkerActor: Task performed successfully: $message")
//    }
//}