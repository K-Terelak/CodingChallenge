package com.example.codingchallenge.buildlogic.convention.plugins

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.example.codingchallenge.buildlogic.convention.utils.getVersionByName
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply(AndroidBasePlugin::class)
            }

            with(extensions.getByType<BaseAppModuleExtension>()) {
                configureDefaultConfig(libs)
            }

        }
    }

    private fun BaseAppModuleExtension.configureDefaultConfig(libs: VersionCatalog) {
        namespace = NAMESPACE_PREFIX

        defaultConfig {
            applicationId = NAMESPACE_PREFIX
            minSdk = libs.getVersionByName("minSdk").toInt()
            targetSdk = libs.getVersionByName("targetSdk").toInt()
            versionCode = libs.getVersionByName("versionCode").toInt()
            versionName = libs.getVersionByName("versionName")
            testInstrumentationRunner = libs.getVersionByName("testInstrumentationRunner")

        }

        buildFeatures {
            buildConfig = true
        }
    }
}
