package com.point18.slg2d.avatar.extension

import akka.actor.Actor
import akka.actor.IndirectActorProducer
import org.springframework.context.ApplicationContext

/**
 * An actor producer that lets Spring create the Actor instances.
 */
class SpringActorProducer : IndirectActorProducer {

    private val applicationContext: ApplicationContext
    private val actorBeanName: String?
    private val requiredType: Class<*>?
    private val args: Array<Any>?

    constructor(applicationContext: ApplicationContext, actorBeanName: String?) {
        this.applicationContext = applicationContext
        this.actorBeanName = actorBeanName
        requiredType = null
        args = null
    }

    constructor(applicationContext: ApplicationContext, actorBeanName: String?, args: Array<Any>?) {
        this.applicationContext = applicationContext
        this.actorBeanName = actorBeanName
        requiredType = null
        this.args = args
    }

    constructor(applicationContext: ApplicationContext, requiredType: Class<*>?) {
        this.applicationContext = applicationContext
        actorBeanName = null
        this.requiredType = requiredType
        args = null
    }

    constructor(applicationContext: ApplicationContext, requiredType: Class<*>?, args: Array<Any>?) {
        this.applicationContext = applicationContext
        actorBeanName = null
        this.requiredType = requiredType
        this.args = args
    }

    constructor(applicationContext: ApplicationContext, actorBeanName: String?, requiredType: Class<*>?) {
        this.applicationContext = applicationContext
        this.actorBeanName = actorBeanName
        this.requiredType = requiredType
        args = null
    }

    override fun produce(): Actor = if (actorBeanName != null && requiredType != null) {
        applicationContext.getBean(actorBeanName, requiredType) as Actor
    } else if (requiredType != null) {
        if (args == null) {
            applicationContext.getBean(requiredType) as Actor
        } else {
            applicationContext.getBean(requiredType, *args) as Actor
        }
    } else {
        if (args == null) {
            applicationContext.getBean(actorBeanName!!) as Actor
        } else {
            applicationContext.getBean(actorBeanName!!, *args) as Actor
        }
    }

    override fun actorClass(): Class<out Actor> {
        return (requiredType ?: applicationContext.getType(actorBeanName!!)) as Class<out Actor>
    }
}