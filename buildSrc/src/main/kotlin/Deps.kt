import com.github.javaparser.utils.Log.Adapter

object Deps {

    object Kotlin {
        private const val Version = Versions.Kotlin
        const val Compiler = "org.jetbrains.kotlin:kotlin-compiler-embeddable:$Version"
        const val Jvm = "org.jetbrains.kotlin:kotlin-stdlib:$Version"
        const val Reflect = "org.jetbrains.kotlin:kotlin-reflect:$Version"
        const val Gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$Version"
        const val GradleApi = "org.jetbrains.kotlin:kotlin-gradle-plugin-api:$Version"
        const val AllOpen = "org.jetbrains.kotlin:kotlin-allopen:$Version"
    }

    object Netty {
        private const val Version = Versions.Netty
        const val All = "io.netty:netty-all:$Version"
        const val CodecHttp = "io.netty:netty-codec-http:$Version"
        const val Epoll = "io.netty:netty-transport-native-epoll:$Version"
        const val Handler = "io.netty:netty-handler:$Version"
        const val Buffer = "io.netty:netty-buffer:$Version"
        const val Util = "io.netty:netty-util:$Version"
    }

    object SpringBoot {
        private const val Version = Versions.SpringBoot
        const val Boot = "org.springframework.boot:spring-boot:${Versions.SpringBoot}"
        const val Starter = "org.springframework.boot:spring-boot-starter:${Versions.SpringBoot}"
        const val ConfigProcessor = "org.springframework.boot:spring-boot-configuration-processor:${Versions.SpringBoot}"
        const val StarterLogging = "org.springframework.boot:spring-boot-starter-logging:${Versions.SpringBoot}"
        const val StarterShell = "org.springframework.shell:spring-shell-starter:${Versions.SpringBootStarterShell}"
        const val StarterTest = "org.springframework.boot:spring-boot-starter-test:${Versions.SpringBoot}"
    }

    object Akka {
        private const val Adapter = "${Versions.Scala}:${Versions.Akka}"
        const val Actor = "com.typesafe.akka:akka-actor_$Adapter"
    }

    object Junit {
        private const val Version = Versions.Junit
        const val JupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$Version"
        const val JupiterApi = "org.junit.jupiter:junit-jupiter-api:$Version"
        const val Jupiter = "org.junit.jupiter:junit-jupiter:$Version"
    }

    const val BaseProto = "com.point18.conquer:base-protocol-kr:${Versions.BaseProto}"
    const val Framework = "xyz.ariane:framework-util:${Versions.Framework}"
    const val Guava = "com.google.guava:guava:${Versions.Guava}"
    const val Protobuf = "com.google.protobuf:protobuf-java:${Versions.Protobuf}"
}