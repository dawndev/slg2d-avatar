package com.point18.slg2d.avatar.extension

import org.springframework.context.annotation.Scope
import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
@Scope("prototype")
annotation class Actor(@get:AliasFor(annotation = Component::class) val value: String = "")