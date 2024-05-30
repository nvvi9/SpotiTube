package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.utils.bouncingClickable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun TopHomeItem(items: List<TopItem>, modifier: Modifier = Modifier) {
    VerticalGrid(columns = 2, modifier = Modifier.padding(12.dp)) {
        items.forEach {
            HomeItemRecent(it, modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun HomeItemRecent(item: TopItem, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Row(
        modifier = modifier
            .bouncingClickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .clip(RoundedCornerShape(8.dp))
            .background(CardDefaults.cardColors().containerColor)
            .clipToBounds(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        KamelImage(
            resource = asyncPainterResource(item.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier.size(58.dp)
        )
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 8.dp),
        )
    }
}

data class TopItem(val title: String, val imageUrl: String) {
    companion object {
        val sample
            get() = List(8) {
                TopItem(
                    title = "sample",
                    imageUrl = "https://i.pinimg.com/originals/7c/19/c8/7c19c86dfa64b8e8374fd2f43735adb2.jpg"
                )
            }
    }
}