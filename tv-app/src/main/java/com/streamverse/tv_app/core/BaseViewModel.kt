package com.streamverse.tv_app.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface ViewState

interface ViewAction

interface ViewSideEffect

abstract class BaseViewModel<Action : ViewAction, UiState : ViewState, Effect : ViewSideEffect> :
    ViewModel() {

    private val initialState: UiState by lazy { setInitialState() }

    protected abstract fun setInitialState(): UiState

    private val _viewState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _viewState.asStateFlow()

    private val _action: MutableSharedFlow<Action> = MutableSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    init {
        subscribeToActions()
    }

    fun setAction(action: Action) {
        viewModelScope.launch {
            _action.emit(action)
        }
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = uiState.value.reducer()
        if (newState != _viewState.value) {
            _viewState.value = newState
        }
    }

    private fun subscribeToActions() {
        viewModelScope.launch {
            _action.collect { handleViewAction(it) }
        }
    }

    protected abstract fun handleViewAction(action: Action)

    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}