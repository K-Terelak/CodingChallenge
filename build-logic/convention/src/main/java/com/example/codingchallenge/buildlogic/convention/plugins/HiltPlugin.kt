package com.example.codingchallenge.buildlogic.convention.plugins

import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.ksp
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            addHiltPlugins()
            addHiltDependencies()
        }
    }

    private fun Project.addHiltPlugins() {
        with(pluginManager) {
            apply(KspPlugin::class)
            apply("com.google.dagger.hilt.android")
        }
    }

    private fun Project.addHiltDependencies() {
        dependencies {
            implementation(libs.getLibrary("dagger-hiltLib"))
            ksp(libs.getLibrary("dagger-hiltProc"))
        }
    }
}
