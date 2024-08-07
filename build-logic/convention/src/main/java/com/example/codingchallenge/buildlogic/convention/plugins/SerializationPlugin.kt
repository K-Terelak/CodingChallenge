package com.example.codingchallenge.buildlogic.convention.plugins

import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SerializationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                implementation(libs.getLibrary("kotlinx-serialization-json"))
            }
        }
    }
}
