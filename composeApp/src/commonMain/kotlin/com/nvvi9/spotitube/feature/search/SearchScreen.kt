package com.nvvi9.spotitube.feature.search

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.platform.collectAsStatePlatform
import com.nvvi9.spotitube.ui.components.MoodAndGenreItem
import com.nvvi9.spotitube.ui.components.SearchBar
import com.nvvi9.spotitube.utils.bouncingClickable
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import spotitube.composeapp.generated.resources.Res
import spotitube.composeapp.generated.resources.search
import spotitube.composeapp.generated.resources.what_do_you_want_to_listen_to
import kotlin.math.roundToInt

@Composable
fun SearchRoute(viewModel: SearchViewModel = koinViewModel()) {
    val moodAndGenreCategories by viewModel.moodsAndGenreCategories.collectAsStatePlatform()

    SearchScreen(moodAndGenreCategories)
}

@Composable
fun SearchScreen(moodAndGenreCategories: List<MoodAndGenreCategory>) {
    val scrollState = rememberLazyGridState()

    var collapsingTopHeight by remember { mutableStateOf(0f) }
    var topHeight by remember { mutableStateOf(0) }
    var offset by remember { mutableStateOf(0f) }

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset =
            if (available.y >= 0 || offset == -collapsingTopHeight) {
                Offset.Zero
            } else {
                calculateOffset(available.y)
            }

        override fun onPostScroll(consumed: Offset, available: Offset, source: NestedScrollSource): Offset =
            if (available.y <= 0 || offset == 0f) {
                Offset.Zero
            } else {
                calculateOffset(available.y)
            }

        private fun calculateOffset(delta: Float): Offset {
            val old = offset
            val new = (old + delta).coerceIn(-collapsingTopHeight, 0f)
            offset = new
            return Offset(0f, new - old)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
                .offset { IntOffset(x = 0, y = offset.roundToInt()) }
                .onSizeChanged { topHeight = it.height }
        ) {
            val density = LocalDensity.current
            Text(
                text = stringResource(Res.string.search),
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .onSizeChanged { collapsingTopHeight = it.height.toFloat() + with(density) { 32.dp.toPx() } }
            )
            SearchBar(
                modifier = Modifier
                    .height(50.dp)
                    .bouncingClickable(
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {}
                    ),
                title = stringResource(Res.string.what_do_you_want_to_listen_to)
            )
        }

        LazyVerticalGrid(
            state = scrollState,
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .offset { IntOffset(x = 0, y = (topHeight + offset).roundToInt()) },
            contentPadding = PaddingValues(bottom = 60.dp),
            columns = GridCells.Fixed(2)
        ) {
            moodAndGenreCategories.forEach { (name, moodsAndGenres) ->
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 12.dp)
                            .fillMaxWidth()
                    )
                }
                items(items = moodsAndGenres, key = { it.id }) {
                    MoodAndGenreItem(it)
                }
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}