package com.streamverse.tv_app

import com.streamverse.tv_app.feature.auth.login.LoginModule
import org.koin.core.context.startKoin

fun initializeKoin() {
    startKoin {
        modules(LoginModule)
    }
}