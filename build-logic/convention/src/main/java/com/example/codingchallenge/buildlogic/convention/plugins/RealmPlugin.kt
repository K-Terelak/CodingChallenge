package com.example.codingchallenge.buildlogic.convention.plugins

import com.example.codingchallenge.buildlogic.convention.utils.getLibrary
import com.example.codingchallenge.buildlogic.convention.utils.implementation
import com.example.codingchallenge.buildlogic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RealmPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            addRealmPlugins()
            addRealmDependencies()
        }
    }
    private fun Project.addRealmPlugins(){
        with(pluginManager){
            apply("io.realm.kotlin")
        }
    }

    private fun Project.addRealmDependencies(){
        dependencies{
            implementation(libs.getLibrary("realm-base"))
            implementation(libs.getLibrary("realm-sync"))
        }
    }
}
