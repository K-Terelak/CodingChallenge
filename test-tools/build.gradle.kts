plugins {
    alias(libs.plugins.cc.kotlin.library)
}

dependencies {
    implementation(libs.turbine)
    implementation(libs.junit)
    implementation(libs.mockk)
    implementation(libs.kotlinx.coroutines.test)
}
