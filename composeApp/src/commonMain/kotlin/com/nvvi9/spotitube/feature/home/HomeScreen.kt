package com.nvvi9.spotitube.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.nvvi9.spotitube.ui.components.HomeItem
import com.nvvi9.spotitube.ui.components.HomeItemData
import com.nvvi9.spotitube.ui.components.TopHomeItem
import com.nvvi9.spotitube.ui.components.TopItem

@Composable
fun HomeRoute() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    val scrollState = rememberLazyListState()

    Box(contentAlignment = Alignment.Center) {
        LazyColumn(
            state = scrollState
        ) {
            item {
                TopHomeItem(TopItem.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
            item {
                HomeItem(HomeItemData.sample)
            }
        }
    }
}