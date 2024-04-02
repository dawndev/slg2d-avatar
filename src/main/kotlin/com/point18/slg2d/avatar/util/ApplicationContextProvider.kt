package com.point18.slg2d.avatar.util

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class ApplicationContextProvider : ApplicationContextAware {

    @Throws(BeansException::class)
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        if (Companion.applicationContext == null) {
            Companion.applicationContext = applicationContext
        }
    }

    companion object {

        var applicationContext: ApplicationContext? = null
            private set

        fun <T> getBean(clazz: Class<T>): T? {
            return applicationContext?.getBean(clazz)
        }

        inline fun <reified T : Any> getBean(name: String): T? {
            val bean = applicationContext?.getBean(name)
                ?: return null
            if (bean !is T) {
                return null
            }
            return bean
        }
    }
}