package com.example.codingchallenge.buildlogic.convention.plugins

import com.android.build.gradle.BaseExtension
import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.getVersionByName
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

const val NAMESPACE_PREFIX = "com.example.codingchallenge"

class AndroidBasePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-android")
                apply(CompilerPlugin::class)
                apply(StaticCodeAnalysisPlugin::class)
                apply(TestingPlugin::class)
            }

            dependencies {
                implementation(libs.getLibrary("timber"))
            }

            with(extensions.getByType<BaseExtension>()) {
                compileSdkVersion = libs.getVersionByName("compileSdk")
                namespace = NAMESPACE_PREFIX + path.replace(":", ".").replace("-", "")
            }
        }
    }
}
