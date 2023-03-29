package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.constg.MockSceneType

data class AvatarConfig(
    var nameprefix: String = "",
    var nameStart: Int = 0,
    var onlineNum: Int = 0,
    var totalNum: Int = 0,
    var scenario: MockSceneType? = null
)