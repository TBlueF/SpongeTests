import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    java
    id("org.spongepowered.gradle.plugin") version "2.0.0"
}

val javaTarget = 8
java {
    sourceCompatibility = JavaVersion.toVersion(javaTarget)
    targetCompatibility = JavaVersion.toVersion(javaTarget)
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/") {
        name = "sponge"
    }
}

sponge {
    apiVersion("8.0.0-SNAPSHOT")
    license("MIT")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("testplugin") {
        displayName("TestPlugin")
        version(version.get())
        entrypoint("de.bluecolored.spongetest.testplugin.Plugin")
        description("A Sponge-Plugin that tests something.")
        contributor("Blue") {description("Developer")}
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType(JavaCompile::class).configureEach {
    options.apply {
        encoding = "utf-8" // Consistent source file encoding
        if (JavaVersion.current().isJava10Compatible) {
            release.set(javaTarget)
        }
    }
}

// Make sure all tasks which produce archives (jar, sources jar, javadoc jar, etc) produce more consistent output
tasks.withType(AbstractArchiveTask::class).configureEach {
    isReproducibleFileOrder = true
    isPreserveFileTimestamps = false
}
