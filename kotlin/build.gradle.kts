plugins {
    kotlin("jvm") version "1.5.10"
    `java-library`
}

repositories {
    mavenCentral()
}

val kotestVersion = "5.0.3"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.test {
    useJUnitPlatform()
}
