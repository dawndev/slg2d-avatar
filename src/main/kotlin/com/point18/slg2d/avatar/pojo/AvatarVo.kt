package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.actor.AvatarData
import com.point18.slg2d.avatar.constg.Parameter


class AvatarVo(
    val id: Int,
    val name: String
): AvatarData {

    var aesKey: String = Parameter.DEFAULT_KEY        // 加密密钥

    override fun toString(): String {
        return "AvatarVo(id:$id,name:$name)"
    }
}