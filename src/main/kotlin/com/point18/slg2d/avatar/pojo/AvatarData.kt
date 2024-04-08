package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.constg.Parameter

interface AvatarData {
    val id: Int
    val name: String
}

class AvatarUndefinedData: AvatarData {
    override val id: Int = 0
    override val name: String = "undefined"
}

data class AvatarDefinedData(
    override val id: Int,
    override val name: String
) : AvatarData

data class AvatarPlayingData(
    override val id: Int,
    override val name: String
) : AvatarData {

    var aesKey: String = Parameter.DEFAULT_KEY        // 加密密钥
    var sendNo: Int = 1  //  该机器人发送的第sendNo个消息
    var logined: Boolean = false  //是否登陆成功
    var makeCity: Boolean = false // 是否已创角
    var enterGame: Boolean = false // 是否已经进入游戏了
}