package com.nvvi9.spotitube.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    val responseContext: ResponseContext,
    val contents: Contents,
    val trackingParams: String,
    val maxAgeStoreSeconds: Long,
    val background: ThumbnailClass
)

@Serializable
data class ThumbnailClass(
    val musicThumbnailRenderer: MusicThumbnailRenderer
)

@Serializable
data class MusicThumbnailRenderer(
    val thumbnail: MusicThumbnailRendererThumbnail,
    val trackingParams: String
)

@Serializable
data class MusicThumbnailRendererThumbnail(
    val thumbnails: List<ThumbnailElement>
)

@Serializable
data class ThumbnailElement(
    val url: String,
    val width: Long,
    val height: Long
)

@Serializable
data class Contents(
    val singleColumnBrowseResultsRenderer: SingleColumnBrowseResultsRenderer
)

@Serializable
data class SingleColumnBrowseResultsRenderer(
    val tabs: List<Tab>
)

@Serializable
data class Tab(
    val tabRenderer: TabRenderer
)

@Serializable
data class TabRenderer(
    val endpoint: Endpoint,
    val title: String,
    val selected: Boolean,
    val content: TabRendererContent,
    val trackingParams: String
)

@Serializable
data class TabRendererContent(
    val sectionListRenderer: SectionListRenderer
)

@Serializable
data class SectionListRenderer(
    val contents: List<SectionListRendererContent>,
    val continuations: List<Continuation>?,
    val trackingParams: String
)

@Serializable
data class SectionListRendererContent(
    val musicCarouselShelfRenderer: MusicCarouselShelfRenderer
)

@Serializable
data class MusicCarouselShelfRenderer(
    val header: MusicCarouselShelfRendererHeader,
    val contents: List<MusicCarouselShelfRendererContent>,
    val trackingParams: String,
    val itemSize: String,
    val numItemsPerColumn: String?
)

@Serializable
data class MusicCarouselShelfRendererContent(
    val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer?,
    val musicTwoRowItemRenderer: MusicTwoRowItemRenderer?
)

@Serializable
data class MusicResponsiveListItemRenderer(
    val trackingParams: String,
    val thumbnail: ThumbnailClass,
    val menu: MusicResponsiveListItemRendererMenu,
    val playlistItemData: PlaylistItemData,
    val flexColumnDisplayStyle: String
)

@Serializable
data class PurpleBrowseEndpoint(
    val browseId: String,
    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
)

@Serializable
data class BrowseEndpointContextSupportedConfigs(
    val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
)

@Serializable
data class BrowseEndpointContextMusicConfig(
    val pageType: PageType
)

enum class PageType {
    MUSIC_PAGE_TYPE_ALBUM,
    MUSIC_PAGE_TYPE_ARTIST,
    MUSIC_PAGE_TYPE_PLAYLIST,
    MUSIC_PAGE_TYPE_USER_CHANNEL
}

@Serializable
data class NavigationEndpointWatchEndpoint(
    val videoId: String,
    val playlistId: String,
    val loggingContext: LoggingContext,
    val watchEndpointMusicSupportedConfigs: WatchEndpointMusicSupportedConfigs
)

@Serializable
data class LoggingContext(
    val vssLoggingContext: VssLoggingContext
)

@Serializable
data class VssLoggingContext(
    val serializedContextData: String
)

@Serializable
data class WatchEndpointMusicSupportedConfigs(
    val watchEndpointMusicConfig: WatchEndpointMusicConfig
)

@Serializable
data class WatchEndpointMusicConfig(
    val musicVideoType: MusicVideoType
)

enum class MusicVideoType {
    MUSIC_VIDEO_TYPE_ATV,
    MUSIC_VIDEO_TYPE_UGC,
    MUSIC_VIDEO_TYPE_OMV
}

@Serializable
data class MusicResponsiveListItemRendererMenu(
    val menuRenderer: PurpleMenuRenderer
)

@Serializable
data class PurpleMenuRenderer(
    val items: List<PurpleItem>,
    val trackingParams: String,
    val topLevelButtons: List<TopLevelButton>,
)

@Serializable
data class PurpleItem(
    val menuNavigationItemRenderer: MenuItemRenderer?,
    val menuServiceItemRenderer: MenuItemRenderer?,
    val toggleMenuServiceItemRenderer: PurpleToggleMenuServiceItemRenderer?
)

@Serializable
data class MenuItemRenderer(
    val text: Strapline,
    val navigationEndpoint: MenuNavigationItemRendererNavigationEndpoint?,
    val trackingParams: String,
)

@Serializable
data class MenuNavigationItemRendererNavigationEndpoint(
    val clickTrackingParams: String,
    val watchEndpoint: NavigationEndpointWatchEndpoint?,
    val modalEndpoint: ModalEndpoint?,
    val browseEndpoint: PurpleBrowseEndpoint?,
    val watchPlaylistEndpoint: WatchPlaylistEndpoint?
)

@Serializable
data class ModalEndpoint(
    val modal: Modal
)

@Serializable
data class Modal(
    val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
)

@Serializable
data class ModalWithTitleAndButtonRenderer(
    val title: Strapline,
    val content: Strapline,
    val button: Button
)

@Serializable
data class Button(
    val buttonRenderer: ButtonButtonRenderer
)

@Serializable
data class ButtonButtonRenderer(
    val isDisabled: Boolean,
    val text: Strapline,
    val trackingParams: String
)

@Serializable
data class Strapline(
    val runs: List<StraplineRun>
)

@Serializable
data class StraplineRun(
    val text: String
)

@Serializable
data class WatchPlaylistEndpoint(
    val playlistId: String,
    val params: String
)

@Serializable
data class PurpleToggleMenuServiceItemRenderer(
    val defaultText: Strapline,
    val defaultServiceEndpoint: DefaultServiceEndpoint,
    val toggledText: Strapline,
    val trackingParams: String
)

@Serializable
data class DefaultServiceEndpoint(
    val clickTrackingParams: String,
    val modalEndpoint: ModalEndpoint
)

@Serializable
data class TopLevelButton(
    val likeButtonRenderer: LikeButtonRenderer
)

@Serializable
data class LikeButtonRenderer(
    val target: PlaylistItemData,
    val trackingParams: String,
    val likesAllowed: Boolean,
    val dislikeNavigationEndpoint: DefaultServiceEndpoint,
    val likeCommand: DefaultServiceEndpoint
)

@Serializable
data class PlaylistItemData(
    val videoId: String
)

@Serializable
data class MusicTwoRowItemRenderer(
    val thumbnailRenderer: ThumbnailClass,
    val title: MusicTwoRowItemRendererTitle,
    val subtitle: Subtitle,
    val navigationEndpoint: MusicTwoRowItemRendererNavigationEndpoint,
    val trackingParams: String,
    val menu: MusicTwoRowItemRendererMenu
)

@Serializable
data class MusicTwoRowItemRendererMenu(
    val menuRenderer: FluffyMenuRenderer
)

@Serializable
data class FluffyMenuRenderer(
    val items: List<FluffyItem>,
    val trackingParams: String
)

@Serializable
data class FluffyItem(
    val menuNavigationItemRenderer: MenuItemRenderer?,
    val menuServiceItemRenderer: MenuItemRenderer?,
    val toggleMenuServiceItemRenderer: FluffyToggleMenuServiceItemRenderer?
)

@Serializable
data class FluffyToggleMenuServiceItemRenderer(
    val defaultText: Strapline,
    val defaultServiceEndpoint: DefaultServiceEndpoint,
    val toggledText: Strapline,
    val trackingParams: String
)

@Serializable
data class MusicTwoRowItemRendererNavigationEndpoint(
    val clickTrackingParams: String,
    val browseEndpoint: FluffyBrowseEndpoint
)

@Serializable
data class FluffyBrowseEndpoint(
    val browseId: String,
    val params: String?,
    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
)

@Serializable
data class Subtitle(
    val runs: List<SubtitleRun>
)

@Serializable
data class SubtitleRun(
    val text: String,
    val navigationEndpoint: TentacledNavigationEndpoint?
)

@Serializable
data class TentacledNavigationEndpoint(
    val clickTrackingParams: String,
    val browseEndpoint: PurpleBrowseEndpoint
)

@Serializable
data class MusicTwoRowItemRendererTitle(
    val runs: List<FluffyRun>
)

@Serializable
data class FluffyRun(
    val text: String,
    val navigationEndpoint: MusicTwoRowItemRendererNavigationEndpoint
)

@Serializable
data class MusicCarouselShelfRendererHeader(
    val musicCarouselShelfBasicHeaderRenderer: MusicCarouselShelfBasicHeaderRenderer
)

@Serializable
data class MusicCarouselShelfBasicHeaderRenderer(
    val title: MusicCarouselShelfBasicHeaderRendererTitle,
    val strapline: Strapline?,
    val headerStyle: String,
    val moreContentButton: MoreContentButton?,
    val trackingParams: String
)

@Serializable
data class MoreContentButton(
    val buttonRenderer: MoreContentButtonButtonRenderer
)

@Serializable
data class MoreContentButtonButtonRenderer(
    val style: String,
    val text: Strapline,
    val navigationEndpoint: StickyNavigationEndpoint,
    val trackingParams: String
)

@Serializable
data class StickyNavigationEndpoint(
    val clickTrackingParams: String,
    val watchPlaylistEndpoint: WatchPlaylistEndpoint?,
    val browseEndpoint: EndpointBrowseEndpoint?
)

@Serializable
data class EndpointBrowseEndpoint(
    val browseId: String
)

@Serializable
data class MusicCarouselShelfBasicHeaderRendererTitle(
    val runs: List<TentacledRun>
)

@Serializable
data class TentacledRun(
    val text: String,
    val navigationEndpoint: Endpoint?
)

@Serializable
data class Endpoint(
    val clickTrackingParams: String,
    val browseEndpoint: EndpointBrowseEndpoint
)

@Serializable
data class Continuation(
    val nextContinuationData: NextContinuationData
)

@Serializable
data class NextContinuationData(
    val continuation: String,
    val clickTrackingParams: String
)

@Serializable
data class ResponseContext(
    val visitorData: String,
    val serviceTrackingParams: List<ServiceTrackingParam>,
    val maxAgeSeconds: Long
)

@Serializable
data class ServiceTrackingParam(
    val service: String,
    val params: List<Param>
)

@Serializable
data class Param(
    val key: String,
    val value: String
)
