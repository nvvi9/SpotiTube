package com.nvvi9.spotitube.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.nvvi9.spotitube.feature.home.navigation.HOME_ROUTE
import com.nvvi9.spotitube.feature.home.navigation.navigateToHome
import com.nvvi9.spotitube.feature.library.navigation.YOUR_LIBRARY_ROUTE
import com.nvvi9.spotitube.feature.library.navigation.navigateToYourLibrary
import com.nvvi9.spotitube.feature.search.navigation.SEARCH_ROUTE
import com.nvvi9.spotitube.feature.search.navigation.navigateToSearch
import com.nvvi9.spotitube.navigation.TopLevelDestination

@Composable
fun rememberSpotitubeAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        SpotitubeAppState(navController)
    }

@Stable
class SpotitubeAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val showNavBar
        @Composable get() = currentDestination?.route?.let {
            it == HOME_ROUTE || it == SEARCH_ROUTE || it == YOUR_LIBRARY_ROUTE
        } ?: false

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val navOptions = navOptions {
            navController.graph.findStartDestination().route?.let {
                popUpTo(it) {
                    saveState = true
                }
            }

            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome(navOptions)
            TopLevelDestination.SEARCH -> navController.navigateToSearch(navOptions)
            TopLevelDestination.YOUR_LIBRARY -> navController.navigateToYourLibrary(navOptions)
        }
    }
}