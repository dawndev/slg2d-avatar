package com.point18.slg2d.avatar.extension

import akka.actor.*
import akka.routing.RouterConfig
import com.point18.slg2d.avatar.extension.SpringExtension.SpringExt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class SpringExtension : AbstractExtensionId<SpringExt>() {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Autowired
    private lateinit var actorSystem: ActorSystem

    @PostConstruct
    fun postConstruct() {
        this[actorSystem].initialize(applicationContext)
    }

    /**
     * Is used by Akka to instantiate the Extension identified by this
     * ExtensionId, internal use only.
     */
    override fun createExtension(system: ExtendedActorSystem): SpringExt {
        return SpringExt()
    }

    fun actorOf(
        actorContext: ActorContext,
        actorSpringBeanName: String?,
        actorLogicalName: String?,
        vararg actorParameters: Any?
    ): ActorRef {
        return actorContext.actorOf(
            get(actorContext.system()).props(actorSpringBeanName, *actorParameters),
            actorLogicalName
        )
    }

    fun actorOf(
        actorContext: ActorContext,
        requiredType: Class<*>?,
        actorLogicalName: String?,
        vararg actorParameters: Any?
    ): ActorRef {
        return actorContext.actorOf(get(actorContext.system()).props(requiredType, *actorParameters), actorLogicalName)
    }

    fun actorOf(
        actorContext: ActorContext,
        actorSpringBeanName: String?,
        actorLogicalName: String?,
        requiredType: Class<*>?
    ): ActorRef {
        return actorContext.actorOf(
            get(actorContext.system()).props(actorSpringBeanName, requiredType),
            actorLogicalName
        )
    }

    fun actorOf(actorContext: ActorContext, actorSpringBeanName: String?, vararg actorParameters: Any?): ActorRef {
        return actorContext.actorOf(get(actorContext.system()).props(actorSpringBeanName, *actorParameters))
    }

    fun actorOf(actorSystem: ActorSystem, actorSpringBeanName: String?, vararg actorParameters: Any?): ActorRef {
        return actorSystem.actorOf(get(actorSystem).props(actorSpringBeanName, *actorParameters))
    }

    fun actorOf(actorSystem: ActorSystem, actorSpringBeanName: String?): ActorRef {
        return actorSystem.actorOf(get(actorSystem).props(actorSpringBeanName))
    }

    //@since 2020/10/22
    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        dispatcher: String?,
        actorLogicalName: String?
    ): ActorRef {
        return actorSystem.actorOf(
            get(actorSystem).props(actorSpringBeanName).withDispatcher(dispatcher),
            actorLogicalName
        )
    }

    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        routerConfig: RouterConfig?,
        dispatcher: String?,
        actorLogicalName: String?
    ): ActorRef {
        return actorSystem.actorOf(
            get(actorSystem).props(actorSpringBeanName).withRouter(routerConfig).withDispatcher(dispatcher),
            actorLogicalName
        )
    }

    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        routerConfig: RouterConfig?,
        dispatcher: String?
    ): ActorRef {
        return actorSystem.actorOf(
            get(actorSystem).props(actorSpringBeanName).withRouter(routerConfig).withDispatcher(dispatcher)
        )
    }

    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        routerConfig: RouterConfig?,
        dispatcher: String?,
        vararg actorParameters: Any?
    ): ActorRef {
        return actorSystem.actorOf(
            get(actorSystem).props(actorSpringBeanName, *actorParameters).withRouter(routerConfig)
                .withDispatcher(dispatcher)
        )
    }

    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        routerConfig: RouterConfig?,
        dispatcher: String?,
        actorLogicalName: String?,
        vararg actorParameters: Any?
    ): ActorRef {
        return actorSystem.actorOf(
            get(actorSystem).props(actorSpringBeanName, *actorParameters).withRouter(routerConfig)
                .withDispatcher(dispatcher), actorLogicalName
        )
    }

    fun actorOf(
        actorSystem: ActorSystem,
        actorSpringBeanName: String?,
        actorLogicalName: String?,
        vararg actorParameters: Any?
    ): ActorRef {
        return actorSystem.actorOf(get(actorSystem).props(actorSpringBeanName, *actorParameters), actorLogicalName)
    }

    /**
     * The Extension implementation.
     */
    class SpringExt : Extension {
        @Volatile
        private var applicationContext: ApplicationContext? = null

        /**
         * Used to initialize the Spring application context for the extension.
         *
         * @param applicationContext - spring application context.
         */
        fun initialize(applicationContext: ApplicationContext?) {
            this.applicationContext = applicationContext
        }

        /**
         * Create a Props for the specified actorBeanName using the
         * SpringActorProducer class.
         *
         * @param actorBeanName The name of the actor bean to create Props for
         * @return a Props that will create the named actor bean using Spring
         */
        fun props(actorBeanName: String?): Props {
            return props(actorBeanName, emptyList<Any>())
        }

        /**
         * Create a Props for the specified actorBeanName using the
         * SpringActorProducer class.
         *
         * @param actorBeanName The name of the actor bean to create Props for
         * @param parameters    If any parameters this Actor needs, pass null if no parameters.
         * @return a Props that will create the named actor bean using Spring
         */
        fun props(actorBeanName: String?, vararg parameters: Any?): Props {
            return if (parameters.isNotEmpty()) Props.create(
                SpringActorProducer::class.java, applicationContext,
                actorBeanName,
                parameters
            ) else Props.create(
                SpringActorProducer::class.java,
                applicationContext,
                actorBeanName
            )
        }

        /**
         * Create a Props for the specified actorBeanName using the SpringActorProducer class.
         *
         * @param requiredType Type of the actor bean must match. Can be an interface or superclass of the actual class,
         * or `null` for any match. For example, if the value is `Object.class`, this method will succeed
         * whatever the class of the returned instance.
         * @return a Props that will create the actor bean using Spring
         */
        fun props(requiredType: Class<*>?, vararg args: Any?): Props {
            return if (args.isNotEmpty()) Props.create(
                SpringActorProducer::class.java, applicationContext,
                requiredType,
                args
            ) else Props.create(
                SpringActorProducer::class.java,
                applicationContext,
                requiredType
            )
        }

        /**
         * Create a Props for the specified actorBeanName using the SpringActorProducer class.
         *
         * @param actorBeanName The name of the actor bean to create Props for
         * @param requiredType  Type of the actor bean must match. Can be an interface or superclass of the actual class,
         * or `null` for any match. For example, if the value is `Object.class`, this method will succeed
         * whatever the class of the returned instance.
         * @return a Props that will create the actor bean using Spring
         */
        fun props(actorBeanName: String?, requiredType: Class<out AbstractActor?>?): Props {
            return Props.create(SpringActorProducer::class.java, applicationContext, actorBeanName, requiredType)
        }
    }
}