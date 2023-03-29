package com.point18.slg2d.avatar.pojo

data class ServerConfig(
    var clusterId: Long = 0,
    var address: String = "",
    var port: Int = 0,
    var area: Int = 0,
    var partition: Int = 0
)