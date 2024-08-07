plugins {
    alias(libs.plugins.cc.kotlin.library)
}

dependencies {
    implementation(project(":domain:contract"))
    implementation(project(":data:repository:contract"))
    implementation(project(":di"))

    implementation(libs.kotlinx.coroutines.core)
}
