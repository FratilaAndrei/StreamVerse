package com.streamverse.tv_app.feature.auth
import com.streamverse.tv_app.feature.auth.login.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val LoginModule = module {
    viewModel { LoginViewModel() }
}