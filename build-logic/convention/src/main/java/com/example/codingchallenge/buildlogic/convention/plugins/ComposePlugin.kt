package com.example.codingchallenge.buildlogic.convention.plugins

import com.android.build.gradle.BaseExtension
import com.example.codingchallenge.buildlogic.convention.utils.bundleImplementation
import com.example.codingchallenge.buildlogic.convention.utils.getBundle
import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePluginExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            setupPluginManager()
            setupBuildFeatures()
            addComposeDependencies()
        }
    }

    private fun Project.setupPluginManager() {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.plugin.compose")
        }
    }

    private fun Project.setupBuildFeatures() {
        with(extensions.getByType<BaseExtension>()) {
            with(buildFeatures) {
                compose = true
            }
        }
    }

    private fun Project.addComposeDependencies() {
        with(extensions.getByType<BasePluginExtension>()) {
            dependencies {
                bundleImplementation(libs.getBundle("compose"))
                implementation(libs.getLibrary("androidx-ui-tooling"))
                implementation(libs.getLibrary("androidx-ui-tooling-preview"))
            }
        }
    }
}
