package com.nvvi9.spotitube.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    val responseContext: ResponseContext,
    val contents: Contents,
    val trackingParams: String,
    val maxAgeStoreSeconds: Int,
    val background: Background
) {
    @Serializable
    data class ResponseContext(
        val visitorData: String,
        val serviceTrackingParams: List<ServiceTrackingParam>,
        val maxAgeSeconds: Int
    ) {
        @Serializable
        data class ServiceTrackingParam(
            val service: String,
            val params: List<Param>
        ) {
            @Serializable
            data class Param(
                val key: String,
                val value: String
            )
        }
    }

    @Serializable
    data class Contents(
        val singleColumnBrowseResultsRenderer: SingleColumnBrowseResultsRenderer
    ) {
        @Serializable
        data class SingleColumnBrowseResultsRenderer(
            val tabs: List<Tab>
        ) {
            @Serializable
            data class Tab(
                val tabRenderer: TabRenderer
            ) {
                @Serializable
                data class TabRenderer(
                    val endpoint: Endpoint,
                    val title: String,
                    val selected: Boolean,
                    val content: Content,
                    val icon: Icon,
                    val tabIdentifier: String,
                    val trackingParams: String
                ) {
                    @Serializable
                    data class Endpoint(
                        val clickTrackingParams: String,
                        val browseEndpoint: BrowseEndpoint
                    ) {
                        @Serializable
                        data class BrowseEndpoint(
                            val browseId: String
                        )
                    }

                    @Serializable
                    data class Content(
                        val sectionListRenderer: SectionListRenderer
                    ) {
                        @Serializable
                        data class SectionListRenderer(
                            val contents: List<Content>,
                            val continuations: List<Continuation>?,
                            val trackingParams: String,
                            val header: Header
                        ) {
                            @Serializable
                            data class Content(
                                val musicCarouselShelfRenderer: MusicCarouselShelfRenderer
                            ) {
                                @Serializable
                                data class MusicCarouselShelfRenderer(
                                    val header: Header,
                                    val contents: List<SectionContentItem>,
                                    val trackingParams: String,
                                    val itemSize: String,
                                    val numItemsPerColumn: String?
                                ) {
                                    @Serializable
                                    data class Header(
                                        val musicCarouselShelfBasicHeaderRenderer: MusicCarouselShelfBasicHeaderRenderer
                                    ) {
                                        @Serializable
                                        data class MusicCarouselShelfBasicHeaderRenderer(
                                            val title: Title,
                                            val strapline: Strapline?,
                                            val accessibilityData: AccessibilityData,
                                            val headerStyle: String,
                                            val moreContentButton: MoreContentButton?,
                                            val trackingParams: String
                                        ) {
                                            @Serializable
                                            data class Title(
                                                val runs: List<Run>
                                            ) {
                                                @Serializable
                                                data class Run(
                                                    val text: String,
                                                    val navigationEndpoint: NavigationEndpoint?
                                                ) {
                                                    @Serializable
                                                    data class NavigationEndpoint(
                                                        val clickTrackingParams: String,
                                                        val browseEndpoint: BrowseEndpoint
                                                    ) {
                                                        @Serializable
                                                        data class BrowseEndpoint(
                                                            val browseId: String
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Strapline(
                                                val runs: List<Run>
                                            ) {
                                                @Serializable
                                                data class Run(
                                                    val text: String
                                                )
                                            }

                                            @Serializable
                                            data class AccessibilityData(
                                                val accessibilityData: AccessibilityData
                                            ) {
                                                @Serializable
                                                data class AccessibilityData(
                                                    val label: String
                                                )
                                            }

                                            @Serializable
                                            data class MoreContentButton(
                                                val buttonRenderer: ButtonRenderer
                                            ) {
                                                @Serializable
                                                data class ButtonRenderer(
                                                    val style: String,
                                                    val text: Text,
                                                    val navigationEndpoint: NavigationEndpoint,
                                                    val trackingParams: String,
                                                    val accessibilityData: AccessibilityData
                                                ) {
                                                    @Serializable
                                                    data class Text(
                                                        val runs: List<Run>
                                                    ) {
                                                        @Serializable
                                                        data class Run(
                                                            val text: String
                                                        )
                                                    }

                                                    @Serializable
                                                    data class NavigationEndpoint(
                                                        val clickTrackingParams: String,
                                                        val watchPlaylistEndpoint: WatchPlaylistEndpoint?,
                                                        val browseEndpoint: BrowseEndpoint?
                                                    ) {
                                                        @Serializable
                                                        data class WatchPlaylistEndpoint(
                                                            val playlistId: String,
                                                            val params: String
                                                        )

                                                        @Serializable
                                                        data class BrowseEndpoint(
                                                            val browseId: String
                                                        )
                                                    }

                                                    @Serializable
                                                    data class AccessibilityData(
                                                        val accessibilityData: AccessibilityData
                                                    ) {
                                                        @Serializable
                                                        data class AccessibilityData(
                                                            val label: String
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    @Serializable
                                    data class SectionContentItem(
                                        val musicResponsiveListItemRenderer: MusicResponsiveListItemRenderer?,
                                        val musicTwoRowItemRenderer: MusicTwoRowItemRenderer?
                                    ) {
                                        @Serializable
                                        data class MusicResponsiveListItemRenderer(
                                            val trackingParams: String,
                                            val thumbnail: Thumbnail,
                                            val overlay: Overlay,
                                            val flexColumns: List<FlexColumn>,
                                            val menu: Menu,
                                            val playlistItemData: PlaylistItemData,
                                            val flexColumnDisplayStyle: String,
                                            val itemHeight: String,
                                            val badges: List<Badge>?
                                        ) {
                                            @Serializable
                                            data class Thumbnail(
                                                val musicThumbnailRenderer: MusicThumbnailRenderer
                                            ) {
                                                @Serializable
                                                data class MusicThumbnailRenderer(
                                                    val thumbnail: Thumbnail,
                                                    val thumbnailCrop: String,
                                                    val thumbnailScale: String,
                                                    val trackingParams: String
                                                ) {
                                                    @Serializable
                                                    data class Thumbnail(
                                                        val thumbnails: List<Thumbnail>
                                                    ) {
                                                        @Serializable
                                                        data class Thumbnail(
                                                            val url: String,
                                                            val width: Int,
                                                            val height: Int
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Overlay(
                                                val musicItemThumbnailOverlayRenderer: MusicItemThumbnailOverlayRenderer
                                            ) {
                                                @Serializable
                                                data class MusicItemThumbnailOverlayRenderer(
                                                    val background: Background,
                                                    val content: Content,
                                                    val contentPosition: String,
                                                    val displayStyle: String
                                                ) {
                                                    @Serializable
                                                    data class Background(
                                                        val verticalGradient: VerticalGradient
                                                    ) {
                                                        @Serializable
                                                        data class VerticalGradient(
                                                            val gradientLayerColors: List<String>
                                                        )
                                                    }

                                                    @Serializable
                                                    data class Content(
                                                        val musicPlayButtonRenderer: MusicPlayButtonRenderer
                                                    ) {
                                                        @Serializable
                                                        data class MusicPlayButtonRenderer(
                                                            val playNavigationEndpoint: PlayNavigationEndpoint,
                                                            val trackingParams: String,
                                                            val playIcon: PlayIcon,
                                                            val pauseIcon: PauseIcon,
                                                            val iconColor: Long,
                                                            val backgroundColor: Int,
                                                            val activeBackgroundColor: Int,
                                                            val loadingIndicatorColor: Long,
                                                            val playingIcon: PlayingIcon,
                                                            val iconLoadingColor: Int,
                                                            val activeScaleFactor: Int,
                                                            val buttonSize: String,
                                                            val rippleTarget: String,
                                                            val accessibilityPlayData: AccessibilityPlayData,
                                                            val accessibilityPauseData: AccessibilityPauseData
                                                        ) {
                                                            @Serializable
                                                            data class PlayNavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val watchEndpoint: WatchEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class WatchEndpoint(
                                                                    val videoId: String,
                                                                    val playlistId: String,
                                                                    val params: String,
                                                                    val loggingContext: LoggingContext,
                                                                    val watchEndpointMusicSupportedConfigs: WatchEndpointMusicSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class LoggingContext(
                                                                        val vssLoggingContext: VssLoggingContext
                                                                    ) {
                                                                        @Serializable
                                                                        data class VssLoggingContext(
                                                                            val serializedContextData: String
                                                                        )
                                                                    }

                                                                    @Serializable
                                                                    data class WatchEndpointMusicSupportedConfigs(
                                                                        val watchEndpointMusicConfig: WatchEndpointMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class WatchEndpointMusicConfig(
                                                                            val musicVideoType: String
                                                                        )
                                                                    }
                                                                }
                                                            }

                                                            @Serializable
                                                            data class PlayIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class PauseIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class PlayingIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class AccessibilityPlayData(
                                                                val accessibilityData: AccessibilityData
                                                            ) {
                                                                @Serializable
                                                                data class AccessibilityData(
                                                                    val label: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class AccessibilityPauseData(
                                                                val accessibilityData: AccessibilityData
                                                            ) {
                                                                @Serializable
                                                                data class AccessibilityData(
                                                                    val label: String
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class FlexColumn(
                                                val musicResponsiveListItemFlexColumnRenderer: MusicResponsiveListItemFlexColumnRenderer
                                            ) {
                                                @Serializable
                                                data class MusicResponsiveListItemFlexColumnRenderer(
                                                    val text: Text,
                                                    val displayPriority: String
                                                ) {
                                                    @Serializable
                                                    data class Text(
                                                        val runs: List<Run>
                                                    ) {
                                                        @Serializable
                                                        data class Run(
                                                            val text: String,
                                                            val navigationEndpoint: NavigationEndpoint?
                                                        ) {
                                                            @Serializable
                                                            data class NavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val watchEndpoint: WatchEndpoint?,
                                                                val browseEndpoint: BrowseEndpoint?
                                                            ) {
                                                                @Serializable
                                                                data class WatchEndpoint(
                                                                    val videoId: String,
                                                                    val playlistId: String,
                                                                    val params: String,
                                                                    val loggingContext: LoggingContext,
                                                                    val watchEndpointMusicSupportedConfigs: WatchEndpointMusicSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class LoggingContext(
                                                                        val vssLoggingContext: VssLoggingContext
                                                                    ) {
                                                                        @Serializable
                                                                        data class VssLoggingContext(
                                                                            val serializedContextData: String
                                                                        )
                                                                    }

                                                                    @Serializable
                                                                    data class WatchEndpointMusicSupportedConfigs(
                                                                        val watchEndpointMusicConfig: WatchEndpointMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class WatchEndpointMusicConfig(
                                                                            val musicVideoType: String
                                                                        )
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class BrowseEndpoint(
                                                                    val browseId: String,
                                                                    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class BrowseEndpointContextSupportedConfigs(
                                                                        val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class BrowseEndpointContextMusicConfig(
                                                                            val pageType: String
                                                                        )
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Menu(
                                                val menuRenderer: MenuRenderer
                                            ) {
                                                @Serializable
                                                data class MenuRenderer(
                                                    val items: List<Item>,
                                                    val trackingParams: String,
                                                    val topLevelButtons: List<TopLevelButton>,
                                                    val accessibility: Accessibility
                                                ) {
                                                    @Serializable
                                                    data class Item(
                                                        val menuNavigationItemRenderer: MenuNavigationItemRenderer?,
                                                        val menuServiceItemRenderer: MenuServiceItemRenderer?,
                                                        val toggleMenuServiceItemRenderer: ToggleMenuServiceItemRenderer?
                                                    ) {
                                                        @Serializable
                                                        data class MenuNavigationItemRenderer(
                                                            val text: Text,
                                                            val icon: Icon,
                                                            val navigationEndpoint: NavigationEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class Text(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class Icon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class NavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val watchEndpoint: WatchEndpoint?,
                                                                val modalEndpoint: ModalEndpoint?,
                                                                val browseEndpoint: BrowseEndpoint?,
                                                                val shareEntityEndpoint: ShareEntityEndpoint?
                                                            ) {
                                                                @Serializable
                                                                data class WatchEndpoint(
                                                                    val videoId: String,
                                                                    val playlistId: String,
                                                                    val params: String,
                                                                    val loggingContext: LoggingContext,
                                                                    val watchEndpointMusicSupportedConfigs: WatchEndpointMusicSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class LoggingContext(
                                                                        val vssLoggingContext: VssLoggingContext
                                                                    ) {
                                                                        @Serializable
                                                                        data class VssLoggingContext(
                                                                            val serializedContextData: String
                                                                        )
                                                                    }

                                                                    @Serializable
                                                                    data class WatchEndpointMusicSupportedConfigs(
                                                                        val watchEndpointMusicConfig: WatchEndpointMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class WatchEndpointMusicConfig(
                                                                            val musicVideoType: String
                                                                        )
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class BrowseEndpoint(
                                                                    val browseId: String,
                                                                    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class BrowseEndpointContextSupportedConfigs(
                                                                        val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class BrowseEndpointContextMusicConfig(
                                                                            val pageType: String
                                                                        )
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class ShareEntityEndpoint(
                                                                    val serializedShareEntity: String,
                                                                    val sharePanelType: String
                                                                )
                                                            }
                                                        }

                                                        @Serializable
                                                        data class MenuServiceItemRenderer(
                                                            val text: Text,
                                                            val icon: Icon,
                                                            val serviceEndpoint: ServiceEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class Text(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class Icon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class ServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val queueAddEndpoint: QueueAddEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class QueueAddEndpoint(
                                                                    val queueTarget: QueueTarget,
                                                                    val queueInsertPosition: String,
                                                                    val commands: List<Command>
                                                                ) {
                                                                    @Serializable
                                                                    data class QueueTarget(
                                                                        val videoId: String,
                                                                        val onEmptyQueue: OnEmptyQueue
                                                                    ) {
                                                                        @Serializable
                                                                        data class OnEmptyQueue(
                                                                            val clickTrackingParams: String,
                                                                            val watchEndpoint: WatchEndpoint
                                                                        ) {
                                                                            @Serializable
                                                                            data class WatchEndpoint(
                                                                                val videoId: String
                                                                            )
                                                                        }
                                                                    }

                                                                    @Serializable
                                                                    data class Command(
                                                                        val clickTrackingParams: String,
                                                                        val addToToastAction: AddToToastAction
                                                                    ) {
                                                                        @Serializable
                                                                        data class AddToToastAction(
                                                                            val item: Item
                                                                        ) {
                                                                            @Serializable
                                                                            data class Item(
                                                                                val notificationTextRenderer: NotificationTextRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class NotificationTextRenderer(
                                                                                    val successResponseText: SuccessResponseText,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class SuccessResponseText(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        @Serializable
                                                        data class ToggleMenuServiceItemRenderer(
                                                            val defaultText: DefaultText,
                                                            val defaultIcon: DefaultIcon,
                                                            val defaultServiceEndpoint: DefaultServiceEndpoint,
                                                            val toggledText: ToggledText,
                                                            val toggledIcon: ToggledIcon,
                                                            val toggledServiceEndpoint: ToggledServiceEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class DefaultText(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class DefaultIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class DefaultServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val modalEndpoint: ModalEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            @Serializable
                                                            data class ToggledText(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class ToggledIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class ToggledServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val feedbackEndpoint: FeedbackEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class FeedbackEndpoint(
                                                                    val feedbackToken: String
                                                                )
                                                            }
                                                        }
                                                    }

                                                    @Serializable
                                                    data class TopLevelButton(
                                                        val likeButtonRenderer: LikeButtonRenderer
                                                    ) {
                                                        @Serializable
                                                        data class LikeButtonRenderer(
                                                            val target: Target,
                                                            val likeStatus: String,
                                                            val trackingParams: String,
                                                            val likesAllowed: Boolean,
                                                            val dislikeNavigationEndpoint: DislikeNavigationEndpoint,
                                                            val likeCommand: LikeCommand
                                                        ) {
                                                            @Serializable
                                                            data class Target(
                                                                val videoId: String
                                                            )

                                                            @Serializable
                                                            data class DislikeNavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val modalEndpoint: ModalEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            @Serializable
                                                            data class LikeCommand(
                                                                val clickTrackingParams: String,
                                                                val modalEndpoint: ModalEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    @Serializable
                                                    data class Accessibility(
                                                        val accessibilityData: AccessibilityData
                                                    ) {
                                                        @Serializable
                                                        data class AccessibilityData(
                                                            val label: String
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class PlaylistItemData(
                                                val videoId: String
                                            )

                                            @Serializable
                                            data class Badge(
                                                val musicInlineBadgeRenderer: MusicInlineBadgeRenderer
                                            ) {
                                                @Serializable
                                                data class MusicInlineBadgeRenderer(
                                                    val trackingParams: String,
                                                    val icon: Icon,
                                                    val accessibilityData: AccessibilityData
                                                ) {
                                                    @Serializable
                                                    data class Icon(
                                                        val iconType: String
                                                    )

                                                    @Serializable
                                                    data class AccessibilityData(
                                                        val accessibilityData: AccessibilityData
                                                    ) {
                                                        @Serializable
                                                        data class AccessibilityData(
                                                            val label: String
                                                        )
                                                    }
                                                }
                                            }
                                        }

                                        @Serializable
                                        data class MusicTwoRowItemRenderer(
                                            val thumbnailRenderer: ThumbnailRenderer,
                                            val aspectRatio: String,
                                            val title: Title,
                                            val subtitle: Subtitle,
                                            val navigationEndpoint: NavigationEndpoint,
                                            val trackingParams: String,
                                            val menu: Menu,
                                            val thumbnailOverlay: ThumbnailOverlay,
                                            val subtitleBadges: List<SubtitleBadge>?
                                        ) {
                                            @Serializable
                                            data class ThumbnailRenderer(
                                                val musicThumbnailRenderer: MusicThumbnailRenderer
                                            ) {
                                                @Serializable
                                                data class MusicThumbnailRenderer(
                                                    val thumbnail: Thumbnail,
                                                    val thumbnailCrop: String,
                                                    val thumbnailScale: String,
                                                    val trackingParams: String
                                                ) {
                                                    @Serializable
                                                    data class Thumbnail(
                                                        val thumbnails: List<Thumbnail>
                                                    ) {
                                                        @Serializable
                                                        data class Thumbnail(
                                                            val url: String,
                                                            val width: Int,
                                                            val height: Int
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Title(
                                                val runs: List<Run>
                                            ) {
                                                @Serializable
                                                data class Run(
                                                    val text: String,
                                                    val navigationEndpoint: NavigationEndpoint
                                                ) {
                                                    @Serializable
                                                    data class NavigationEndpoint(
                                                        val clickTrackingParams: String,
                                                        val browseEndpoint: BrowseEndpoint
                                                    ) {
                                                        @Serializable
                                                        data class BrowseEndpoint(
                                                            val browseId: String,
                                                            val params: String,
                                                            val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                        ) {
                                                            @Serializable
                                                            data class BrowseEndpointContextSupportedConfigs(
                                                                val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                            ) {
                                                                @Serializable
                                                                data class BrowseEndpointContextMusicConfig(
                                                                    val pageType: String
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Subtitle(
                                                val runs: List<Run>
                                            ) {
                                                @Serializable
                                                data class Run(
                                                    val text: String,
                                                    val navigationEndpoint: NavigationEndpoint?
                                                ) {
                                                    @Serializable
                                                    data class NavigationEndpoint(
                                                        val clickTrackingParams: String,
                                                        val browseEndpoint: BrowseEndpoint
                                                    ) {
                                                        @Serializable
                                                        data class BrowseEndpoint(
                                                            val browseId: String,
                                                            val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                        ) {
                                                            @Serializable
                                                            data class BrowseEndpointContextSupportedConfigs(
                                                                val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                            ) {
                                                                @Serializable
                                                                data class BrowseEndpointContextMusicConfig(
                                                                    val pageType: String
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class NavigationEndpoint(
                                                val clickTrackingParams: String,
                                                val browseEndpoint: BrowseEndpoint
                                            ) {
                                                @Serializable
                                                data class BrowseEndpoint(
                                                    val browseId: String,
                                                    val params: String?,
                                                    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                ) {
                                                    @Serializable
                                                    data class BrowseEndpointContextSupportedConfigs(
                                                        val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                    ) {
                                                        @Serializable
                                                        data class BrowseEndpointContextMusicConfig(
                                                            val pageType: String
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class Menu(
                                                val menuRenderer: MenuRenderer
                                            ) {
                                                @Serializable
                                                data class MenuRenderer(
                                                    val items: List<Item>,
                                                    val trackingParams: String,
                                                    val accessibility: Accessibility
                                                ) {
                                                    @Serializable
                                                    data class Item(
                                                        val menuNavigationItemRenderer: MenuNavigationItemRenderer?,
                                                        val menuServiceItemRenderer: MenuServiceItemRenderer?,
                                                        val toggleMenuServiceItemRenderer: ToggleMenuServiceItemRenderer?
                                                    ) {
                                                        @Serializable
                                                        data class MenuNavigationItemRenderer(
                                                            val text: Text,
                                                            val icon: Icon,
                                                            val navigationEndpoint: NavigationEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class Text(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class Icon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class NavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val watchPlaylistEndpoint: WatchPlaylistEndpoint?,
                                                                val modalEndpoint: ModalEndpoint?,
                                                                val browseEndpoint: BrowseEndpoint?,
                                                                val shareEntityEndpoint: ShareEntityEndpoint?
                                                            ) {
                                                                @Serializable
                                                                data class WatchPlaylistEndpoint(
                                                                    val playlistId: String,
                                                                    val params: String
                                                                )

                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class BrowseEndpoint(
                                                                    val browseId: String,
                                                                    val browseEndpointContextSupportedConfigs: BrowseEndpointContextSupportedConfigs
                                                                ) {
                                                                    @Serializable
                                                                    data class BrowseEndpointContextSupportedConfigs(
                                                                        val browseEndpointContextMusicConfig: BrowseEndpointContextMusicConfig
                                                                    ) {
                                                                        @Serializable
                                                                        data class BrowseEndpointContextMusicConfig(
                                                                            val pageType: String
                                                                        )
                                                                    }
                                                                }

                                                                @Serializable
                                                                data class ShareEntityEndpoint(
                                                                    val serializedShareEntity: String,
                                                                    val sharePanelType: String
                                                                )
                                                            }
                                                        }

                                                        @Serializable
                                                        data class MenuServiceItemRenderer(
                                                            val text: Text,
                                                            val icon: Icon,
                                                            val serviceEndpoint: ServiceEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class Text(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class Icon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class ServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val queueAddEndpoint: QueueAddEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class QueueAddEndpoint(
                                                                    val queueTarget: QueueTarget,
                                                                    val queueInsertPosition: String,
                                                                    val commands: List<Command>
                                                                ) {
                                                                    @Serializable
                                                                    data class QueueTarget(
                                                                        val playlistId: String,
                                                                        val onEmptyQueue: OnEmptyQueue
                                                                    ) {
                                                                        @Serializable
                                                                        data class OnEmptyQueue(
                                                                            val clickTrackingParams: String,
                                                                            val watchEndpoint: WatchEndpoint
                                                                        ) {
                                                                            @Serializable
                                                                            data class WatchEndpoint(
                                                                                val playlistId: String
                                                                            )
                                                                        }
                                                                    }

                                                                    @Serializable
                                                                    data class Command(
                                                                        val clickTrackingParams: String,
                                                                        val addToToastAction: AddToToastAction
                                                                    ) {
                                                                        @Serializable
                                                                        data class AddToToastAction(
                                                                            val item: Item
                                                                        ) {
                                                                            @Serializable
                                                                            data class Item(
                                                                                val notificationTextRenderer: NotificationTextRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class NotificationTextRenderer(
                                                                                    val successResponseText: SuccessResponseText,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class SuccessResponseText(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        @Serializable
                                                        data class ToggleMenuServiceItemRenderer(
                                                            val defaultText: DefaultText,
                                                            val defaultIcon: DefaultIcon,
                                                            val defaultServiceEndpoint: DefaultServiceEndpoint,
                                                            val toggledText: ToggledText,
                                                            val toggledIcon: ToggledIcon,
                                                            val toggledServiceEndpoint: ToggledServiceEndpoint,
                                                            val trackingParams: String
                                                        ) {
                                                            @Serializable
                                                            data class DefaultText(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class DefaultIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class DefaultServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val modalEndpoint: ModalEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class ModalEndpoint(
                                                                    val modal: Modal
                                                                ) {
                                                                    @Serializable
                                                                    data class Modal(
                                                                        val modalWithTitleAndButtonRenderer: ModalWithTitleAndButtonRenderer
                                                                    ) {
                                                                        @Serializable
                                                                        data class ModalWithTitleAndButtonRenderer(
                                                                            val title: Title,
                                                                            val content: Content,
                                                                            val button: Button
                                                                        ) {
                                                                            @Serializable
                                                                            data class Title(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Content(
                                                                                val runs: List<Run>
                                                                            ) {
                                                                                @Serializable
                                                                                data class Run(
                                                                                    val text: String
                                                                                )
                                                                            }

                                                                            @Serializable
                                                                            data class Button(
                                                                                val buttonRenderer: ButtonRenderer
                                                                            ) {
                                                                                @Serializable
                                                                                data class ButtonRenderer(
                                                                                    val style: String,
                                                                                    val isDisabled: Boolean,
                                                                                    val text: Text,
                                                                                    val navigationEndpoint: NavigationEndpoint,
                                                                                    val trackingParams: String
                                                                                ) {
                                                                                    @Serializable
                                                                                    data class Text(
                                                                                        val runs: List<Run>
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class Run(
                                                                                            val text: String
                                                                                        )
                                                                                    }

                                                                                    @Serializable
                                                                                    data class NavigationEndpoint(
                                                                                        val clickTrackingParams: String,
                                                                                        val signInEndpoint: SignInEndpoint
                                                                                    ) {
                                                                                        @Serializable
                                                                                        data class SignInEndpoint(
                                                                                            val hack: Boolean
                                                                                        )
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            @Serializable
                                                            data class ToggledText(
                                                                val runs: List<Run>
                                                            ) {
                                                                @Serializable
                                                                data class Run(
                                                                    val text: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class ToggledIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class ToggledServiceEndpoint(
                                                                val clickTrackingParams: String,
                                                                val likeEndpoint: LikeEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class LikeEndpoint(
                                                                    val status: String,
                                                                    val target: Target
                                                                ) {
                                                                    @Serializable
                                                                    data class Target(
                                                                        val playlistId: String
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }

                                                    @Serializable
                                                    data class Accessibility(
                                                        val accessibilityData: AccessibilityData
                                                    ) {
                                                        @Serializable
                                                        data class AccessibilityData(
                                                            val label: String
                                                        )
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class ThumbnailOverlay(
                                                val musicItemThumbnailOverlayRenderer: MusicItemThumbnailOverlayRenderer
                                            ) {
                                                @Serializable
                                                data class MusicItemThumbnailOverlayRenderer(
                                                    val background: Background,
                                                    val content: Content,
                                                    val contentPosition: String,
                                                    val displayStyle: String
                                                ) {
                                                    @Serializable
                                                    data class Background(
                                                        val verticalGradient: VerticalGradient
                                                    ) {
                                                        @Serializable
                                                        data class VerticalGradient(
                                                            val gradientLayerColors: List<String>
                                                        )
                                                    }

                                                    @Serializable
                                                    data class Content(
                                                        val musicPlayButtonRenderer: MusicPlayButtonRenderer
                                                    ) {
                                                        @Serializable
                                                        data class MusicPlayButtonRenderer(
                                                            val playNavigationEndpoint: PlayNavigationEndpoint,
                                                            val trackingParams: String,
                                                            val playIcon: PlayIcon,
                                                            val pauseIcon: PauseIcon,
                                                            val iconColor: Long,
                                                            val backgroundColor: Long,
                                                            val activeBackgroundColor: Long,
                                                            val loadingIndicatorColor: Long,
                                                            val playingIcon: PlayingIcon,
                                                            val iconLoadingColor: Int,
                                                            val activeScaleFactor: Double,
                                                            val buttonSize: String,
                                                            val rippleTarget: String,
                                                            val accessibilityPlayData: AccessibilityPlayData,
                                                            val accessibilityPauseData: AccessibilityPauseData
                                                        ) {
                                                            @Serializable
                                                            data class PlayNavigationEndpoint(
                                                                val clickTrackingParams: String,
                                                                val watchPlaylistEndpoint: WatchPlaylistEndpoint
                                                            ) {
                                                                @Serializable
                                                                data class WatchPlaylistEndpoint(
                                                                    val playlistId: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class PlayIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class PauseIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class PlayingIcon(
                                                                val iconType: String
                                                            )

                                                            @Serializable
                                                            data class AccessibilityPlayData(
                                                                val accessibilityData: AccessibilityData
                                                            ) {
                                                                @Serializable
                                                                data class AccessibilityData(
                                                                    val label: String
                                                                )
                                                            }

                                                            @Serializable
                                                            data class AccessibilityPauseData(
                                                                val accessibilityData: AccessibilityData
                                                            ) {
                                                                @Serializable
                                                                data class AccessibilityData(
                                                                    val label: String
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            @Serializable
                                            data class SubtitleBadge(
                                                val musicInlineBadgeRenderer: MusicInlineBadgeRenderer
                                            ) {
                                                @Serializable
                                                data class MusicInlineBadgeRenderer(
                                                    val trackingParams: String,
                                                    val icon: Icon,
                                                    val accessibilityData: AccessibilityData
                                                ) {
                                                    @Serializable
                                                    data class Icon(
                                                        val iconType: String
                                                    )

                                                    @Serializable
                                                    data class AccessibilityData(
                                                        val accessibilityData: AccessibilityData
                                                    ) {
                                                        @Serializable
                                                        data class AccessibilityData(
                                                            val label: String
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            @Serializable
                            data class Continuation(
                                val nextContinuationData: NextContinuationData
                            ) {
                                @Serializable
                                data class NextContinuationData(
                                    val continuation: String,
                                    val clickTrackingParams: String
                                )
                            }

                            @Serializable
                            data class Header(
                                val chipCloudRenderer: ChipCloudRenderer
                            ) {
                                @Serializable
                                data class ChipCloudRenderer(
                                    val chips: List<Chip>,
                                    val trackingParams: String,
                                    val horizontalScrollable: Boolean
                                ) {
                                    @Serializable
                                    data class Chip(
                                        val chipCloudChipRenderer: ChipCloudChipRenderer
                                    ) {
                                        @Serializable
                                        data class ChipCloudChipRenderer(
                                            val style: Style,
                                            val text: Text,
                                            val navigationEndpoint: NavigationEndpoint,
                                            val trackingParams: String,
                                            val isSelected: Boolean,
                                            val onDeselectedCommand: OnDeselectedCommand
                                        ) {
                                            @Serializable
                                            data class Style(
                                                val styleType: String
                                            )

                                            @Serializable
                                            data class Text(
                                                val runs: List<Run>
                                            ) {
                                                @Serializable
                                                data class Run(
                                                    val text: String
                                                )
                                            }

                                            @Serializable
                                            data class NavigationEndpoint(
                                                val clickTrackingParams: String,
                                                val browseEndpoint: BrowseEndpoint
                                            ) {
                                                @Serializable
                                                data class BrowseEndpoint(
                                                    val browseId: String,
                                                    val params: String
                                                )
                                            }

                                            @Serializable
                                            data class OnDeselectedCommand(
                                                val clickTrackingParams: String,
                                                val browseEndpoint: BrowseEndpoint
                                            ) {
                                                @Serializable
                                                data class BrowseEndpoint(
                                                    val browseId: String,
                                                    val params: String
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Serializable
                    data class Icon(
                        val iconType: String
                    )
                }
            }
        }
    }

    @Serializable
    data class Background(
        val musicThumbnailRenderer: MusicThumbnailRenderer
    ) {
        @Serializable
        data class MusicThumbnailRenderer(
            val thumbnail: Thumbnail,
            val thumbnailCrop: String,
            val thumbnailScale: String,
            val trackingParams: String
        ) {
            @Serializable
            data class Thumbnail(
                val thumbnails: List<Thumbnail>
            ) {
                @Serializable
                data class Thumbnail(
                    val url: String,
                    val width: Int,
                    val height: Int
                )
            }
        }
    }
}
