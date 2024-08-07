package com.example.codingchallenge.buildlogic.convention.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class KspPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
        }
    }
}
