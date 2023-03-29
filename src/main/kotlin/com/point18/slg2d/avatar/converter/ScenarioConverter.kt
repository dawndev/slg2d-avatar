package com.point18.slg2d.avatar.converter

import com.point18.slg2d.avatar.constg.MockSceneType
import org.springframework.core.convert.converter.Converter

class ScenarioConverter : Converter<String, MockSceneType> {

    override fun convert(source: String): MockSceneType {
        val type = source.toIntOrNull()
            ?: throw IllegalArgumentException("ScenarioConverter:source1:$source")
        return MockSceneType.fromValue(type)
            ?: throw IllegalArgumentException("ScenarioConverter:source2:$source")
    }

}