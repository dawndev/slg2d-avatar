package com.point18.slg2d.avatar.config

import com.point18.slg2d.avatar.constg.MockSceneType
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.convert.converter.Converter
import org.springframework.validation.annotation.Validated

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

@Validated
@ConfigurationProperties(prefix = "slg2d.server", ignoreInvalidFields = false)
@PropertySource(value = ["file:///./config/avatar.properties"])
class ServerProperties {
    var clusterId: Long = 0
    var address: String = ""
    var port: Int = 0
    var area: Int = 0
    var partition: Int = 0
}

@ConfigurationProperties(prefix = "slg2d.avatar", ignoreInvalidFields = false)
@PropertySource(value = ["file:///./config/avatar.properties"])
class AvatarProperties {
    var nameprefix: String = ""
    var nameStart: Int = 0
    var onlineNum: Int = 0
    var totalNum: Int = 0
    var scenario: MockSceneType? = null
}