package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.utils.bouncingClickable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun HomeSectionItem(data: HomeSection, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = data.title,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(data.items) { item ->
                HomeItem(item = item)
            }
        }
    }
}

@Composable
fun HomeItem(modifier: Modifier = Modifier, item: HomeSection.HomeItem) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .focusable(true)
            .bouncingClickable(
                interactionSource = remember { MutableInteractionSource() },
                onClick = {}
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            item.thumbnailUrl?.let {
                KamelImage(
                    resource = asyncPainterResource(it),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                        .padding(bottom = 10.dp)
                )
            }
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(160.dp)
                    .wrapContentHeight()
                    .focusable()
            )
            item.subtitle?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(160.dp)
                        .alpha(0.5f)
                        .wrapContentHeight()
                        .focusable()
                )
            }
        }
    }
}
