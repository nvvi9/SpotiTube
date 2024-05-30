package com.nvvi9.spotitube.data.model

import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse

fun MoodsAndGenresResponse.asMoodAndGenreCategories(): List<MoodAndGenreCategory> =
    contents.singleColumnBrowseResultsRenderer.tabs.flatMap { (tabRenderer) ->
        tabRenderer.content.sectionListRenderer.contents.mapNotNull { (gridRenderer) ->
            val categoryName = gridRenderer.header.gridHeaderRenderer.title.runs.firstOrNull()?.text
                ?: return@mapNotNull null
            val moods = gridRenderer.items.mapNotNull { (musicNavigationButtonRenderer) ->
                musicNavigationButtonRenderer.buttonText.runs.firstOrNull()?.text?.let { name ->
                    MoodAndGenreCategory.MoodAndGenre(
                        id = musicNavigationButtonRenderer.clickCommand.browseEndpoint.params,
                        name = name,
                        color = musicNavigationButtonRenderer.solid.leftStripeColor
                    )
                }
            }

            MoodAndGenreCategory(categoryName, moods)
        }
    }