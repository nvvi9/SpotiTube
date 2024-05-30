package com.nvvi9.spotitube.platform

import androidx.compose.runtime.Composable
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.setStatusBarStyle

@Composable
actual fun DarkSystemBars() {
    UIApplication.sharedApplication.setStatusBarStyle(UIStatusBarStyleDarkContent)
}