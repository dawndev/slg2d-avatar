package com.point18.slg2d.avatar.exception

abstract class BaseAvatarException(message: String? = null) : RuntimeException(message) {

    override fun fillInStackTrace(): Throwable {
        return this
    }
}


class ChannelAttrException: BaseAvatarException()