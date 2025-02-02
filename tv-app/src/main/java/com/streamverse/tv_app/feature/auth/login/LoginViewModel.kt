package com.streamverse.tv_app.feature.auth.login

import com.streamverse.tv_app.core.BaseViewModel


class LoginViewModel :
    BaseViewModel<LoginContract.Action, LoginContract.State, LoginContract.SideEffect>() {

    override fun setInitialState() = LoginContract.State()

    override fun handleViewAction(action: LoginContract.Action) {
        when (action) {
            is LoginContract.Action.UserNameValueChanged -> {
                setState { copy(userName = action.newValue) }
            }

            is LoginContract.Action.PasswordValueChanged -> setState { copy(password = action.newValue) }

            is LoginContract.Action.LogInButtonClicked -> loginButtonClicked()

        }
    }

    private fun loginButtonClicked() {
        val state = uiState.value

        if (state.adminAccount == Account(
                state.userName,
                state.password
            )
        ) setEffect { LoginContract.SideEffect.NavigateToHome }
        else setState { copy(errorMessage = "Acc doesn't exist") }
    }
}

