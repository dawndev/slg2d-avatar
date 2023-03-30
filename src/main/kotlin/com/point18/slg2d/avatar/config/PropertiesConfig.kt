package com.point18.slg2d.avatar.config

import com.point18.slg2d.avatar.constg.MockSceneType
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.convert.converter.Converter

@Configuration
class PropertiesConfig {

    @Bean
    @ConfigurationPropertiesBinding
    fun scenarioConverter(): ScenarioConverter = ScenarioConverter()

    class ScenarioConverter : Converter<String, MockSceneType> {

        override fun convert(source: String): MockSceneType {
            val type = source.toIntOrNull()
                ?: throw IllegalArgumentException("ScenarioConverter:source1:$source")
            return MockSceneType.fromValue(type)
                ?: throw IllegalArgumentException("ScenarioConverter:source2:$source")
        }

    }
}

@Configuration
@PropertySource(
    //value = ["classpath:avatar.properties"],
    value = ["file:\${user.dir}/config/avatar.properties"],
    encoding = "UTF-8",
    ignoreResourceNotFound = false
)
@ConfigurationProperties(prefix = "slg2d.server", ignoreInvalidFields = false)
class ServerProperties {
    var clusterId: Long? = null
    var host: String? = null
    var port: Int? = null
    var area: Int? = null
    var partition: Int? = null
}

@Configuration
@PropertySource(
    value = ["file:\${user.dir}/config/avatar.properties"],
    encoding = "UTF-8",
    ignoreResourceNotFound = false
)
@ConfigurationProperties(prefix = "slg2d.avatar", ignoreInvalidFields = false)
class AvatarProperties {
    var nameprefix: String? = null
    var startId: Int? = null
    var onlineNum: Int? = null
    var totalNum: Int? = null
    var scenario: MockSceneType? = null
    var extend: String? = null
    var speed: Int? = null
}