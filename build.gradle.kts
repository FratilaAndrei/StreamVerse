// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

dependencies {
    (libs.androidx.core.ktx)
    (libs.androidx.appcompat)
    (platform(libs.androidx.compose.bom))
    (libs.androidx.ui)
    (libs.androidx.ui.graphics)
    (libs.androidx.ui.tooling.preview)
    (libs.androidx.tv.foundation)
    (libs.androidx.tv.material)
    (libs.androidx.lifecycle.runtime.ktx)
    (libs.androidx.activity.compose)
    (platform(libs.androidx.compose.bom))
    (libs.androidx.ui.test.junit4)
    (libs.androidx.ui.tooling)
    (libs.androidx.ui.test.manifest)
    (libs.androidx.navigation.compose)
}

