package com.nvvi9.spotitube.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = scrollState,
            contentPadding = PaddingValues(bottom = 60.dp)
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
