package com.streamverse.tv_app.feature.auth.login
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val LoginModule = module {
    viewModel { LoginViewModel() }
}