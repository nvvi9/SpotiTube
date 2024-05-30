package com.nvvi9.spotitube.feature.search

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.ui.components.MoodAndGenreCategoryItem
import com.nvvi9.spotitube.ui.components.SearchBar
import com.nvvi9.spotitube.utils.bouncingClickable
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import spotitube.composeapp.generated.resources.Res
import spotitube.composeapp.generated.resources.search
import spotitube.composeapp.generated.resources.what_do_you_want_to_listen_to

@Composable
fun SearchRoute(viewModel: SearchViewModel = koinViewModel()) {
    val moodAndGenreCategories by viewModel.moodsAndGenreCategories.collectAsState()

    SearchScreen(moodAndGenreCategories)
}

@Composable
fun SearchScreen(moodAndGenreCategories: List<MoodAndGenreCategory>) {
    val scrollState = rememberLazyGridState()
    val topBarHeight = 100.dp

    val offsetY = if (scrollState.firstVisibleItemIndex != 0) {
        topBarHeight
    } else {
        with(LocalDensity.current) {
            scrollState.firstVisibleItemScrollOffset.toDp().coerceAtMost(topBarHeight)
        }
    }

    LazyVerticalGrid(
        state = scrollState,
        modifier = Modifier.padding(top = 70.dp),
        contentPadding = PaddingValues(top = 130.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(items = moodAndGenreCategories, key = { it.id }) {
            MoodAndGenreCategoryItem(it)
        }
    }

    Column(modifier = Modifier.offset(y = -offsetY)) {
        Box(
            modifier = Modifier
                .height(topBarHeight)
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(Res.string.search),
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        SearchBar(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(50.dp)
                .bouncingClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {}
                ),
            title = stringResource(Res.string.what_do_you_want_to_listen_to)
        )
    }
}