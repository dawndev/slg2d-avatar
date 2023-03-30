package com.point18.slg2d.avatar.config

import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LengthFieldPrepender
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope

@Lazy
@Configuration
class NettyConfig {

    /**
     * 处理每个帧数据的最大长度
     * @return Int
     */
    @Bean
    fun maxFrameBytesLength(): Int = 1024 * 1024

    /**
     * 解码处理
     * @return ChannelHandler
     */
    @Bean
    @Scope("prototype")
    @Qualifier("frameDecoder")
    fun lengthFieldBasedFrameDecoder(): LengthFieldBasedFrameDecoder {
        return LengthFieldBasedFrameDecoder(
            maxFrameBytesLength(), 0, 4, -4, 4, true
        )
    }

    @Bean
    @Scope("prototype")
    @Qualifier("frameEncoder")
    fun lengthFieldPrepender(): LengthFieldPrepender {
        return LengthFieldPrepender(4, true)
    }
}