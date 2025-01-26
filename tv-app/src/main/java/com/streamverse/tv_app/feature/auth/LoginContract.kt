package com.streamverse.tv_app.feature.auth

import com.streamverse.tv_app.core.ViewAction
import com.streamverse.tv_app.core.ViewState
import com.streamverse.tv_app.core.ViewEffect


interface LoginContract {
    sealed class Action : ViewAction {
        data class LogInButtonClicked(val smth: String) : Action()

        data class UserNameValueChanged(val newValue: String) : Action()

        data class PasswordValueChanged(val newValue: String) : Action()
    }

    data class State(
        val userName: String = "",
        val password: String = ""
    ) : ViewState

    sealed class SideEffect : ViewEffect {
//    data object NavigateToHome: SideEffect()
    }

}

