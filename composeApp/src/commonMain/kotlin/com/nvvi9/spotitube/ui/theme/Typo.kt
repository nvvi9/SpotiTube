package com.nvvi9.spotitube.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import spotitube.composeapp.generated.resources.Res
import spotitube.composeapp.generated.resources.poppins_vh

val poppinsFamily
    @Composable
    get() = FontFamily(
        Font(
            Res.font.poppins_vh,
            FontWeight.Normal,
            FontStyle.Normal
        )
    )

val Typography
    @Composable
    get() = Typography(
        titleSmall = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        ),
        titleMedium = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        ),
        titleLarge = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        ),
        bodySmall = TextStyle(
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFamily
        ),
        bodyMedium = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFamily
        ),
        bodyLarge = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = poppinsFamily
        ),
        headlineMedium = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        ),
        headlineLarge = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        ),
        labelMedium = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily
        )
    )