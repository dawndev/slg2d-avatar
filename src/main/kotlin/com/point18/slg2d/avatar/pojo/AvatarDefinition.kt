package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.actor.AvatarData
import com.point18.slg2d.avatar.constg.Parameter
import io.netty.channel.Channel


class AvatarDefinition(
    val id: Int,
    val name: String
) : AvatarData {

    var aesKey: String = Parameter.DEFAULT_KEY        // 加密密钥

    var sendNo: Int = 1  //  该机器人发送的第sendNo个消息

    var logined: Boolean = false  //是否登陆成功
    var makeCity: Boolean = false // 是否已创角
    var enterGame: Boolean = false // 是否已经进入游戏了

    override fun toString(): String {
        return "AvatarVo(id:$id,name:$name)"
    }
}