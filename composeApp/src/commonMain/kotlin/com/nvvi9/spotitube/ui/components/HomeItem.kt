package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import com.nvvi9.spotitube.utils.bouncingClickable
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun HomeItem(data: HomeItemData, modifier: Modifier = Modifier) {
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
                HomeItemPlaylist(item = item)
            }
        }
    }
}

@Composable
fun HomeItemPlaylist(modifier: Modifier = Modifier, item: HomeItemData.Item) {
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
            KamelImage(
                resource = asyncPainterResource(item.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(160.dp)
                    .padding(bottom = 10.dp)
            )
            item.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(160.dp)
                        .wrapContentHeight()
                        .focusable()
                )
            }
            Text(
                text = item.description,
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


data class HomeItemData(
    val title: String,
    val items: List<Item>
) {

    data class Item(
        val title: String? = null,
        val description: String,
        val imageUrl: String
    ) {
        companion object {
            val sample
                get() = Item(
                    title = if (listOf(
                            true,
                            false
                        ).random()
                    ) "Title tyiel adf adsf adsfasdf adf asdf ds asdf asdf sadf asfsa" else null,
                    description = List((10..70).random()) { ('a'..'z').random() }.joinToString(
                        separator = ""
                    ),
                    imageUrl = "https://i.pinimg.com/originals/7c/19/c8/7c19c86dfa64b8e8374fd2f43735adb2.jpg"
                )
        }
    }

    companion object {
        val sample
            get() = HomeItemData(
                title = "Sample!",
                items = List((10..20).random()) { Item.sample }
            )
    }
}
