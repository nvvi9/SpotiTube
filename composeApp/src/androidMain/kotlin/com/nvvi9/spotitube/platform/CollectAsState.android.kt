package com.nvvi9.spotitube.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

@Composable
actual fun <T> StateFlow<T>.collectAsStatePlatform(context: CoroutineContext): State<T> =
    this.collectAsStateWithLifecycle(lifecycleOwner = LocalLifecycleOwner.current, context = context)
