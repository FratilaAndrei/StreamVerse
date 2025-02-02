package com.streamverse.tv_app.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun <SideEffect : ViewSideEffect> HandleEffects(
    effects: Flow<SideEffect>, handleEffect: suspend (SideEffect) -> Unit
) {
    val effectThrottleTime = 500L

    DisposableEffect(Unit) {
        val effectsJob = CoroutineScope(SupervisorJob() + Dispatchers.Main).launch {
            effects.throttle(effectThrottleTime).collectLatest {
                handleEffect(it)
            }
        }
        onDispose {
            effectsJob.cancel()
        }
    }
}