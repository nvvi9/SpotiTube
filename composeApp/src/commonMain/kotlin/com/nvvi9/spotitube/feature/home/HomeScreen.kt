package com.nvvi9.spotitube.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.platform.collectAsStatePlatform
import com.nvvi9.spotitube.ui.components.HomeSectionItem
import com.nvvi9.spotitube.ui.components.TopHomeItem
import com.nvvi9.spotitube.ui.components.TopItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoute(viewModel: HomeViewModel = koinViewModel()) {
    val homeSections by viewModel.homeSections.collectAsStatePlatform()

    HomeScreen(homeSections)
}

@Composable
fun HomeScreen(homeSections: List<HomeSection>) {
    val scrollState = rememberLazyListState()

    Box(contentAlignment = Alignment.Center) {
        LazyColumn(
            state = scrollState
        ) {
            item {
                TopHomeItem(TopItem.sample)
            }

            items(homeSections, key = { it.id }) {
                HomeSectionItem(it)
            }
        }
    }
}
