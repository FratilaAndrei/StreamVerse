package com.streamverse.tv_app.feature.auth.login

import com.streamverse.tv_app.core.ViewAction
import com.streamverse.tv_app.core.ViewSideEffect
import com.streamverse.tv_app.core.ViewState

interface LoginContract {
    sealed class Action : ViewAction {
        data object LogInButtonClicked : Action()


        data class UserNameValueChanged(val newValue: String) : Action()

        data class PasswordValueChanged(val newValue: String) : Action()
    }

    data class State(
        val userName: String = "",
        val password: String = "",
        val adminAccount: Account = Account("test", "test"),
        val errorMessage: String = "",
    ) : ViewState

    sealed class SideEffect : ViewSideEffect {
        data object NavigateToHome : SideEffect()
    }
}


data class Account(val email: String, val password: String)

