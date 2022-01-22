plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
}

group = "sh.nemo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")

    implementation(platform("io.ktor:ktor-bom:1.6.7"))
    implementation(platform("org.junit:junit-bom:5.8.2"))

    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-cio")
    implementation("io.ktor:ktor-client-serialization")
    implementation("io.ktor:ktor-client-logging")

    implementation("ch.qos.logback:logback-classic:1.2.10")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
