import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.bundling.Jar

plugins {
    base
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.serialization") version "1.6.10" apply false
    `maven-publish`
}

group = "dev.simonestefani"
version = "0.3.0"

val Project.sourceSets: SourceSetContainer get() =
    (this as ExtensionAware).extensions.getByName("sourceSets") as SourceSetContainer

subprojects {
    apply {
        plugin("kotlin")
        plugin("org.jetbrains.kotlin.plugin.serialization")
        plugin("org.gradle.maven-publish")
    }

    group = "dev.simonestefani"
    version = "0.3.7"

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        fun implementation(dependencyNotation: Any) = this.add("implementation", dependencyNotation)

        implementation(kotlin("stdlib-jdk8"))
        implementation(platform("io.ktor:ktor-bom:1.6.7"))

        implementation("io.ktor:ktor-client-core")
        implementation("io.ktor:ktor-client-cio")
        implementation("io.ktor:ktor-client-serialization")
        implementation("io.ktor:ktor-client-logging")

        implementation("ch.qos.logback:logback-classic:1.2.10")
    }

    val sourcesJar by tasks.registering(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    val project = this
    publishing {
        publications {
            register("mavenJava", MavenPublication::class) {
                from(components["java"])
                artifact(sourcesJar.get())
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
}
