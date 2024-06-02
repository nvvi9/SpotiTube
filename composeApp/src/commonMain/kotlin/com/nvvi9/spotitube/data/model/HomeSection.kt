package com.nvvi9.spotitube.data.model

import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.network.model.HomeResponse

fun HomeResponse.Contents.SingleColumnBrowseResultsRenderer.Tab.TabRenderer.Content.SectionListRenderer.Content.MusicCarouselShelfRenderer.SectionContentItem.MusicTwoRowItemRenderer.asHomeItem(): HomeSection.HomeItem? {
    val title = this.title.runs.firstOrNull()?.text ?: return null
    val subtitle = this.subtitle.runs.firstOrNull()?.text
    val thumbnailUrl = this.thumbnailRenderer.musicThumbnailRenderer.thumbnail.thumbnails.maxByOrNull { it.height }?.url
    val browseEndpoint = this.navigationEndpoint.browseEndpoint
    val pageType = browseEndpoint.browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig.pageType
    val type = HomeSection.HomeItem.HomeItemType.entries.find { it.value == pageType } ?: return null
    val browseId = browseEndpoint.browseId
    val params = browseEndpoint.params

    return HomeSection.HomeItem(
        browseId = browseId,
        params = params,
        title = title,
        subtitle = subtitle,
        thumbnailUrl = thumbnailUrl,
        type = type
    )
}

fun HomeResponse.Contents.SingleColumnBrowseResultsRenderer.Tab.TabRenderer.Content.SectionListRenderer.Content.MusicCarouselShelfRenderer.asHomeSection(): HomeSection? {
    val headerRenderer = this.header.musicCarouselShelfBasicHeaderRenderer
    val id = headerRenderer.trackingParams
    val run = headerRenderer.title.runs.firstOrNull() ?: return null
    val title = run.text
    val browseId = run.navigationEndpoint?.browseEndpoint?.browseId

    val items = this.contents.mapNotNull {
        it.musicTwoRowItemRenderer?.asHomeItem()
    }.takeIf { it.isNotEmpty() } ?: return null

    return HomeSection(
        id = id,
        browseId = browseId,
        title = title,
        items = items
    )
}

fun HomeResponse.asHomeSections(): List<HomeSection> =
    this.contents.singleColumnBrowseResultsRenderer.tabs.flatMap { tab ->
        tab.tabRenderer.content.sectionListRenderer.contents.mapNotNull {
            it.musicCarouselShelfRenderer.asHomeSection()
        }
    }