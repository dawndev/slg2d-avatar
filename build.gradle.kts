import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version Versions.SpringBoot
	id("io.spring.dependency-management") version Versions.SpringManager
	kotlin("jvm") version Versions.Kotlin
	kotlin("plugin.spring") version Versions.Kotlin
}

group = "com.point18.slg2d.avatar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	val nexusUrl = "192.168.70.11:8081"
	maven {
		setUrl("http://${nexusUrl}/repository/maven-public/")
		isAllowInsecureProtocol = true
	}
	maven {
		setUrl("http://${nexusUrl}/repository/topg-releases/")
		isAllowInsecureProtocol = true
	}
}

dependencies {
	implementation(Deps.BaseProto)
	implementation(Deps.SpringBoot.Starter)
	implementation(Deps.Kotlin.Reflect)
	implementation(Deps.Akka.Actor)
	implementation(Deps.Netty.All)
	implementation(Deps.Protobuf)
	annotationProcessor(Deps.SpringBoot.ConfigProcessor)
	implementation(Deps.SpringBoot.StarterTest)
}

tasks {
	withType<JavaCompile> {
		options.encoding = "UTF-8"
	}

	withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	jar {
		manifest {
			attributes(
				"Implementation-Title" to project.name,
				"Implementation-Version" to archiveVersion,
				"Main-Class" to "com.point18.slg2d.avatar.ApplicationKt",
				"Built-By" to "mumgames"
			)
		}
	}

	withType<Test> {
		useJUnitPlatform()
	}
}