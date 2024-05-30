package com.nvvi9.spotitube.data.model

import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse

fun MoodsAndGenresResponse.asMoodAndGenreCategories(): List<MoodAndGenreCategory> =
    contents.singleColumnBrowseResultsRenderer.tabs.flatMap { (tabRenderer) ->
        tabRenderer.content.sectionListRenderer.contents.flatMap { (gridRenderer) ->
            gridRenderer.items.mapNotNull { (musicNavigationButtonRenderer) ->
                val name = musicNavigationButtonRenderer.buttonText.runs.firstOrNull()?.text ?: return@mapNotNull null
                val clickCommand = musicNavigationButtonRenderer.clickCommand
                MoodAndGenreCategory(
                    id = clickCommand.browseEndpoint.params,
                    name = name,
                    trackingParams = musicNavigationButtonRenderer.trackingParams,
                    color = musicNavigationButtonRenderer.solid.leftStripeColor
                )
            }
        }
    }