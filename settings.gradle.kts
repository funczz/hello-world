/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/6.3/userguide/multi_project_builds.html
 */

pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }
}

rootProject.name = "hello-world"

include(":hello-world-lib")
include(":hello-world-demo")
