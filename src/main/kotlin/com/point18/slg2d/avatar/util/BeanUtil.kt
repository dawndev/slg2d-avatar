package com.point18.slg2d.avatar.util

import org.springframework.context.ConfigurableApplicationContext

object BeanUtil {

    private lateinit var applicationContext: ConfigurableApplicationContext

    fun initialize(ctx: ConfigurableApplicationContext) {
        applicationContext = ctx
    }

    fun <T> getBean(c: Class<T>): T {
        if (!this::applicationContext.isInitialized) {
            throw IllegalStateException("BeanUtil::context没有初始化")
        }
        return applicationContext.getBean(c)
    }

    fun getBean(name: String): Any {
        if (!this::applicationContext.isInitialized) {
            throw IllegalStateException("BeanUtil::context没有初始化")
        }
        return applicationContext.getBean(name)
    }
}