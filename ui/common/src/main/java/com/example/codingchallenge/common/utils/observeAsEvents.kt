package com.example.codingchallenge.common.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow

@SuppressLint("ComposableNaming")
@Composable
fun <T> Flow<T>.observeAsEvents(onLifecycle: Lifecycle.State = Lifecycle.State.STARTED, onEvent: suspend (T) -> Unit) {
    val lifeCycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(this, lifeCycleOwner.lifecycle) {
        lifeCycleOwner.repeatOnLifecycle(onLifecycle) {
            this@observeAsEvents.collect(onEvent)
        }
    }
}
