package com.streamverse.tv_app.feature.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streamverse.tv_app.core.HandleEffects
import com.streamverse.tv_app.feature.auth.login.components.LoginScreenContent
import org.koin.androidx.compose.koinViewModel


@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel(),
    navigateToHome: () -> Unit
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    LoginScreenContent(
        modifier = Modifier,
        state = state,
        setAction = viewModel::setAction,
    )

    HandleEffects(effects = viewModel.effect) {
        handleEffects(effect = it, navigateToHome = navigateToHome)
    }
}

private fun handleEffects(effect: LoginContract.SideEffect, navigateToHome: () -> Unit){
    when(effect) {
        is LoginContract.SideEffect.NavigateToHome -> navigateToHome()
    }
}