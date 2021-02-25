/**
 * plugins
 */
plugins {
    id("nebula.maven-publish") version "17.3.2"
}

/**
 * buildscript
 */
buildscript {
    dependencies {
    }
}

/**
 * dependencies
 */
dependencies {
    //logger
    implementation(CommonDeps.Logger.slf4jApi)
    testImplementation(CommonDeps.Logger.logbackClassic)
    testImplementation(CommonDeps.Logger.jansi)
    testImplementation(CommonDeps.Logger.slf4jJcl)
}

/**
 * plugin: nebula.maven-publish
 */
publishing {
    publications {
        group = "com.github.funczz"
    }

    repositories {
        maven {
            val stableRepoUrl = "$buildDir/mvn-repos/pub/stable"
            val testingRepoUrl = "$buildDir/mvn-repos/pub/testing"
            val unstableRepoUrl = "$buildDir/mvn-repos/pub/unstable"
            val uncommittedUrl = "$buildDir/mvn-repos/uncommitted"
            val snapshotsRepoUrl = "$buildDir/mvn-repos/pub/snapshots"
            url = when {
                version.toString().endsWith("-SNAPSHOT") -> {
                    snapshotsRepoUrl
                }
                version.toString().contains("""-dev\.\d+\.uncommitted\+.+""".toRegex()) -> {
                    uncommittedUrl
                }
                version.toString().contains("""-dev\.""".toRegex()) -> {
                    unstableRepoUrl
                }
                version.toString().contains("""-rc\.""".toRegex()) -> {
                    testingRepoUrl
                }
                else -> stableRepoUrl
            }.let {
                uri(it)
            }
        }
    }
}