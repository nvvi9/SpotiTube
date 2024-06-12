package com.nvvi9.spotitube

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import com.nvvi9.spotitube.navigation.SpotitubeNavHost
import com.nvvi9.spotitube.ui.components.SpotitubeBottomNavigation
import com.nvvi9.spotitube.ui.components.TabNavigationItem
import com.nvvi9.spotitube.ui.rememberSpotitubeAppState
import com.nvvi9.spotitube.ui.theme.AppTheme
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.KoinContext

@Composable
internal fun App() {
    Napier.base(DebugAntilog())
    KoinContext {
        val appState = rememberSpotitubeAppState()

        AppTheme {
            Surface(
                modifier = Modifier.safeDrawingPadding(),
                color = MaterialTheme.colorScheme.background
            ) {
                Box {
                    SpotitubeNavHost(appState)
                    Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                        SpotitubeBottomNavigation {
                            appState.topLevelDestinations.forEach { topLevelDestination ->
                                TabNavigationItem(
                                    selected = appState.currentDestination?.hierarchy?.any {
                                        it.route?.contains(
                                            topLevelDestination.name,
                                            true
                                        ) ?: false
                                    } ?: false,
                                    onClick = {
                                        appState.navigateToTopLevelDestination(
                                            topLevelDestination
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(topLevelDestination.icon),
                                            contentDescription = null
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = stringResource(topLevelDestination.title),
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    },
                                    selectedContentColor = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
