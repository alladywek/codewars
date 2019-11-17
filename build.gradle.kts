
plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.alladywekjd"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
    implementation("org.http4k:http4k-core:3.196.0")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}