package com.nvvi9.spotitube.feature.library.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nvvi9.spotitube.feature.library.YourLibraryRoute

const val YOUR_LIBRARY_ROUTE = "your_library_route"

fun NavController.navigateToYourLibrary(navOptions: NavOptions? = null) = navigate(YOUR_LIBRARY_ROUTE, navOptions)

fun NavGraphBuilder.yourLibraryScreen() {
    composable(route = YOUR_LIBRARY_ROUTE) {
        YourLibraryRoute()
    }
}
