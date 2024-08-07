plugins {
    alias(libs.plugins.cc.kotlin.library)
}

dependencies {
    api(project(":domain:model"))
}
