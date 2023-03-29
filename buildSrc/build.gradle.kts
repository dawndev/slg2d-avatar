import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    // mavenCentral()
    maven {
        val nexusHost = "192.168.70.11:8081"
        setUrl("http://$nexusHost/repository/maven-public/")
        isAllowInsecureProtocol = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        // kotlin的API
        apiVersion = "1.6"
        languageVersion = "1.6"

        jvmTarget = "11"
    }
}
