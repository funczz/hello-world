/**
 * plugins
 */
plugins {
    kotlin("jvm") version "1.4.20" apply false
    id("nebula.release") version "15.3.1"
}

/**
 * plugin: nebula.release, nebula.maven-publish
 */
tasks {
    "release" {
        dependsOn(":hello-world-lib:publish")
    }
}

/**
 * all projects
 */
allprojects {
    /**
     * build script
     */
    buildscript {
        /**
         * repositories
         */
        repositories {
            mavenLocal()
            mavenCentral()
            jcenter()
            maven { setUrl(CommonRepos.Sonatype.snapshots) }
            maven { setUrl(CommonRepos.Jitpack.releases) }
            maven { setUrl(CommonRepos.FunczzGithub.releases) }
            maven { setUrl(CommonRepos.FunczzGithub.snapshots) }
        }
    }

    /**
     * repositories
     */
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven { setUrl(CommonRepos.Sonatype.snapshots) }
        maven { setUrl(CommonRepos.Jitpack.releases) }
        maven { setUrl(CommonRepos.FunczzGithub.releases) }
        maven { setUrl(CommonRepos.FunczzGithub.snapshots) }
    }
}

/**
 * sub projects
 */
subprojects {
    /**
     * plugins
     */
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "jacoco")

    /**
     * dependencies: kotlin
     */
    kotlinProjectDependencies()

    /**
     * task: JavaCompile
     */
    org.gradle.api.Action<org.gradle.api.plugins.JavaPluginExtension> {
        sourceCompatibility = CommonDeps.Java.version
        targetCompatibility = CommonDeps.Java.version
    }
    tasks.withType(JavaCompile::class) {
        options.encoding = CommonDeps.Java.encoding
    }

    /**
     * task: KotlinCompile
     */
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = CommonDeps.Kotlin.jvmTarget
            freeCompilerArgs = CommonDeps.Kotlin.freeCompilerArgs
        }
    }

    /**
     * task: Test
     */
    tasks.withType(Test::class.java) {
        useJUnitPlatform() //task: kotlintest-runner-junit5
        testLogging {
            events(*CommonTasks.Test.loggingEvent)
        }
    }
}
