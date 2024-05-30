package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.utils.bouncingClickable

@Composable
fun MoodAndGenreItem(moodAndGenre: MoodAndGenreCategory.MoodAndGenre) {
    val backgroundColor = Color(moodAndGenre.color)
    val luminance = backgroundColor.luminance()

    Box(
        modifier = Modifier.padding(8.dp)
            .bouncingClickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = {}
            )
            .height(90.dp)
            .clip(RoundedCornerShape(8.dp))
            .clipToBounds()
            .background(if (luminance > 0.45) backgroundColor.copy(alpha = backgroundColor.alpha - luminance + 0.45f) else backgroundColor)
    ) {
        Text(
            text = moodAndGenre.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}
