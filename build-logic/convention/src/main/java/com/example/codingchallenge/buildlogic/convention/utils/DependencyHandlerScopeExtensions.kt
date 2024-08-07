package com.example.codingchallenge.buildlogic.convention.utils

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.add

/**
 * An extension that allows implementing a dependency in the Kotlin DSL `dependency {}` block.
 * It is equivalent to `implementation(libs.dependency.name)` in `build.gradle.kts`.
 *
 * @param dependency notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal fun DependencyHandlerScope.implementation(dependency: Provider<MinimalExternalModuleDependency>): Dependency? =
    add("implementation", dependency)

/**
 * An extension that allows implementing a bundle in the Kotlin DSL `dependency {}` block.
 * It is equivalent to `implementation(libs.bundles.name)` in `build.gradle.kts`.
 *
 * @param dependency Notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal fun DependencyHandlerScope.bundleImplementation(dependency: Provider<ExternalModuleDependencyBundle>): Dependency? =
    add("implementation", dependency)

/**
 * Adds a dependency to the 'ksp' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
internal fun DependencyHandlerScope.ksp(dependency: Provider<MinimalExternalModuleDependency>): Dependency? = add("ksp", dependency)
