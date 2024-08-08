package com.example.codingchallenge.buildlogic.convention.plugins

import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.libs
import com.example.codingchallenge.buildlogic.convention.utils.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class TestingPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(
                "org.jetbrains.kotlin.plugin.power-assert"
            )
            dependencies {
                testImplementation(libs.getLibrary("junit"))
                testImplementation(libs.getLibrary("junit-params"))
                testImplementation(libs.getLibrary("mockk"))
                testImplementation(libs.getLibrary("turbine"))
                testImplementation(libs.getLibrary("kotlinx-coroutines-test"))
                testImplementation(project(":test-tools"))
                add("testRuntimeOnly", libs.getLibrary("junit-runtime"))
            }

            tasks.withType<Test> {
                useJUnitPlatform()
                testLogging {
                    events(TestLogEvent.FAILED, TestLogEvent.PASSED)
                    exceptionFormat = TestExceptionFormat.FULL
                }
            }
        }
    }
}