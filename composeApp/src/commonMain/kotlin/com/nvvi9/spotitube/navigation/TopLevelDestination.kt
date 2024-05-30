package com.nvvi9.spotitube.navigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import spotitube.composeapp.generated.resources.*

enum class TopLevelDestination(
    val title: StringResource,
    val icon: DrawableResource
) {
    HOME(
        title = Res.string.home,
        icon = Res.drawable.ic_home
    ),
    SEARCH(
        title = Res.string.search,
        icon = Res.drawable.ic_search
    ),
    YOUR_LIBRARY(
        title = Res.string.your_library,
        icon = Res.drawable.ic_your_library
    )
}
