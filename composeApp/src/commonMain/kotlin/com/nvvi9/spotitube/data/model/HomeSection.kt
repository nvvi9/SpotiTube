package com.nvvi9.spotitube.data.model

import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.network.model.HomeResponse
import com.nvvi9.spotitube.network.model.MusicCarouselShelfRenderer
import com.nvvi9.spotitube.network.model.MusicTwoRowItemRenderer
import com.nvvi9.spotitube.network.model.PageType

private fun MusicTwoRowItemRenderer.asHomeItem(): HomeSection.HomeItem? {
    val title = this.title.runs.firstOrNull()?.text ?: return null
    val browseEndpoint = this.navigationEndpoint.browseEndpoint ?: return null
    val type = when (browseEndpoint.browseEndpointContextSupportedConfigs?.browseEndpointContextMusicConfig?.pageType) {
        PageType.MUSIC_PAGE_TYPE_ALBUM -> HomeSection.HomeItem.HomeItemType.ALBUM
        PageType.MUSIC_PAGE_TYPE_ARTIST -> HomeSection.HomeItem.HomeItemType.ARTIST
        PageType.MUSIC_PAGE_TYPE_PLAYLIST -> HomeSection.HomeItem.HomeItemType.PLAYLIST
        PageType.MUSIC_PAGE_TYPE_USER_CHANNEL -> HomeSection.HomeItem.HomeItemType.USER_CHANNEL
        null -> return null
    }
    val subtitle = this.subtitle.runs.firstOrNull()?.text
    val thumbnailUrl = this.thumbnailRenderer.musicThumbnailRenderer.thumbnail.thumbnails.maxByOrNull { it.height }?.url
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

private fun MusicCarouselShelfRenderer.asHomeSection(): HomeSection? {
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
    this.contents.singleColumnBrowseResultsRenderer.tabs
        .asSequence()
        .flatMap { it.tabRenderer.content?.sectionListRenderer?.contents.orEmpty() }
        .plus(this.continuationContents?.sectionListContinuation?.contents.orEmpty())
        .mapNotNull { it.musicCarouselShelfRenderer.asHomeSection() }
        .toList()
