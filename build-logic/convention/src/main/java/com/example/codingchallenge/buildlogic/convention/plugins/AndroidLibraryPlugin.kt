package com.example.codingchallenge.buildlogic.convention.plugins

import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.BaseExtension
import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.getVersionByName
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply(AndroidBasePlugin::class)
            }

            with(extensions.getByType<BaseExtension>()) {
                configureDefaultConfig(libs)
            }

            dependencies {
                implementation(libs.getLibrary("javax-inject"))
                implementation(libs.getLibrary("kotlinx-coroutines-core"))
            }

            with(extensions.getByType<LibraryExtension>()) {
                lint.checkReleaseBuilds = false

                buildFeatures {
                    buildConfig = false
                    dataBinding = false
                    resValues = false
                    shaders = false
                }
            }
        }
    }

    private fun BaseExtension.configureDefaultConfig(libs: VersionCatalog) {

        defaultConfig {
            minSdk = libs.getVersionByName("minSdk").toInt()
            targetSdk = libs.getVersionByName("targetSdk").toInt()
            versionCode = libs.getVersionByName("versionCode").toInt()
            versionName = libs.getVersionByName("versionName")
            testInstrumentationRunner = libs.getVersionByName("testInstrumentationRunner")

            vectorDrawables {
                useSupportLibrary = true
            }
        }
    }
}