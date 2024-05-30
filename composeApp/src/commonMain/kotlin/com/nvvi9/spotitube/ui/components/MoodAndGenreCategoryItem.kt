package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.utils.bouncingClickable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun MoodAndGenreCategoryItem(category: MoodAndGenreCategory) {
    val backgroundColor = Color(category.color)
    val luminance = backgroundColor.luminance()

    Row(
        modifier = Modifier.padding(8.dp)
            .bouncingClickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = {}
            )
            .height(90.dp)
            .clip(RoundedCornerShape(8.dp))
            .clipToBounds()
            .background(if (luminance > 0.45) backgroundColor.copy(alpha = backgroundColor.alpha - luminance + 0.45f) else backgroundColor),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = category.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            modifier = Modifier
                .padding(10.dp)
                .weight(1f)
        )
    }
}

data class SearchCategoryItemData(
    val title: String,
    val imageUrl: String
) {

    companion object {
        val sample
            get() = List(50) {
                SearchCategoryItemData(
                    "MAYBE BABY",
                    "https://i.pinimg.com/originals/7c/19/c8/7c19c86dfa64b8e8374fd2f43735adb2.jpg"
                )
            }
    }
}