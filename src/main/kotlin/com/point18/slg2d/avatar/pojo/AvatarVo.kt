package com.point18.slg2d.avatar.pojo

import com.point18.slg2d.avatar.constg.Parameter


class AvatarVo(
    var id: Int
) {
    // var name: String = String.format("%s%06d", coxArea.robotCfgInstance.namePrefix, id)

    var aesKey: String = Parameter.DEFAULT_KEY        // 加密密钥
}