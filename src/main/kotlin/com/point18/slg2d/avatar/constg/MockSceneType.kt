package com.point18.slg2d.avatar.constg

import com.point18.slg2d.lang.EnumConverter
import com.point18.slg2d.lang.buildValueMap

enum class MockSceneType(val code: Int) {

    NOTHING(0),
    ;

    companion object : EnumConverter<Int, MockSceneType>(buildValueMap(MockSceneType::code))
}