package com.example.codingchallenge.buildlogic.convention.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType


class StaticCodeAnalysisPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jlleitschuh.gradle.ktlint")

            with(extensions.getByType<KtlintExtension>()) {
                version.set("1.2.1")
                reporters {
                    reporter(ReporterType.HTML)
                }
            }
        }
    }
}
