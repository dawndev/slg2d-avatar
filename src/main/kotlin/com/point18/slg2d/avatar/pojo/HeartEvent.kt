package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.constg.AvatarId

sealed class Message
data class WaitConnect(val expect: Int) : Message()
data class AvatarValid(val avatarId: AvatarId) : Message()
data class AvatarInvalid(val avatarId: AvatarId) : Message()
object HeartEvent : Message()