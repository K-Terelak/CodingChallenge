plugins {
    alias(libs.plugins.cc.android.library)
}

dependencies {
    implementation(libs.ktor.client.core)

    api(project(":data:api:model"))
}
