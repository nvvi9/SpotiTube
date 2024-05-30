package com.nvvi9.spotitube.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.nvvi9.spotitube.feature.home.navigation.HOME_ROUTE
import com.nvvi9.spotitube.feature.home.navigation.homeScreen
import com.nvvi9.spotitube.feature.library.navigation.yourLibraryScreen
import com.nvvi9.spotitube.feature.search.navigation.searchScreen
import com.nvvi9.spotitube.ui.SpotitubeAppState

@Composable
fun SpotitubeNavHost(
    appState: SpotitubeAppState,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        homeScreen()
        searchScreen()
        yourLibraryScreen()
    }
}
