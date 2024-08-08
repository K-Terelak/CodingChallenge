package com.example.codingchallenge.buildlogic.convention.plugins

import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class KotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin")
                apply(CompilerPlugin::class)
                apply(StaticCodeAnalysisPlugin::class)
                apply(TestingPlugin::class)
            }

            dependencies {
                implementation(libs.getLibrary("javax-inject"))
                implementation(libs.getLibrary("kotlinx-coroutines-core"))
            }
        }
    }
}
