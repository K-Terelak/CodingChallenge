plugins {
    `kotlin-dsl`
    alias(libs.plugins.ktlint)
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.compose.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.power.assert.gradlePlugin)
    implementation(libs.ktlint.gradlePlugin)
    implementation(libs.dagger.hilt.gradlePlugin)
    implementation(libs.realm.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    implementation(libs.kotlinx.serialization.gradlePlugin)
}

val pluginIdPrefix = "com.example.codingchallenge"
val implementationClassPrefix = "$pluginIdPrefix.buildlogic.convention.plugins"

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "$pluginIdPrefix.android.application"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.AndroidApplicationPlugin"
        }

        register("kotlinLibrary") {
            id = "$pluginIdPrefix.kotlin.library"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.KotlinLibraryPlugin"
        }

        register("androidLibrary") {
            id = "$pluginIdPrefix.android.library"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.AndroidLibraryPlugin"
        }

        register("compose") {
            id = "$pluginIdPrefix.compose"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.ComposePlugin"
        }

        register("hilt") {
            id = "$pluginIdPrefix.hilt"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.HiltPlugin"
        }

        register("realm") {
            id = "$pluginIdPrefix.realm"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.RealmPlugin"
        }

        register("serialization") {
            id = "$pluginIdPrefix.serialization"
            version = libs.versions.cc.plugin
            implementationClass = "$implementationClassPrefix.SerializationPlugin"
        }
    }
}
