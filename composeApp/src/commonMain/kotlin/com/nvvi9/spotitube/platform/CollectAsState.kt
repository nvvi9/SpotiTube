package com.nvvi9.spotitube.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
expect fun <T> StateFlow<T>.collectAsStatePlatform(context: CoroutineContext = EmptyCoroutineContext): State<T>
