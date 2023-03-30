package com.point18.slg2d.avatar

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication(scanBasePackages = ["com.point18.slg2d.avatar"])
@ConfigurationPropertiesScan("com.point18.slg2d.avatar.config")
class Application

/**
 *
 *                            _ooOoo_
 *                           o8888888o
 *                           88" . "88
 *                           (| -_- |)
 *                           O\  =  /O
 *                        ____/`---'\____
 *                      .'  \\|     |//  `.
 *                     /  \\|||  :  |||//  \
 *                    /  _||||| -:- |||||-  \
 *                    |   | \\\  -  /// |   |
 *                    | \_|  ''\---/''  |   |
 *                    \  .-\__  `-`  ___/-. /
 *                  ___`. .'  /--.--\  `. . __
 *               ."" '<  `.___\_<|>_/___.'  >'"".
 *              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *              \  \ `-.   \_ __\ /__ _/   .-` /  /
 *         ======`-.____`-.___\_____/___.-`____.-'======
 *                            `=---='
 *        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                      Buddha Bless, No Bug !
 */
fun main(args: Array<String>) {
    val application = SpringApplication(Application::class.java)
    application.setBannerMode(Banner.Mode.LOG)
    application.webApplicationType = WebApplicationType.NONE
    val context = application.run(*args)

    val avatarContext = context.getBean(AvatarContext::class.java)
    avatarContext.startup()
}
