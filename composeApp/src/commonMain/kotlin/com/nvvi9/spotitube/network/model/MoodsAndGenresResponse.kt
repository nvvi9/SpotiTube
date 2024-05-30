package com.nvvi9.spotitube.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MoodsAndGenresResponse(
    val contents: Contents,
    val trackingParams: String,
    val maxAgeStoreSeconds: Int
) {

    @Serializable
    data class Contents(val singleColumnBrowseResultsRenderer: SingleColumnBrowseResultsRenderer) {

        @Serializable
        data class SingleColumnBrowseResultsRenderer(val tabs: List<Tab>) {

            @Serializable
            data class Tab(val tabRenderer: TabRenderer) {

                @Serializable
                data class TabRenderer(
                    val content: Content,
                    val trackingParams: String
                ) {

                    @Serializable
                    data class Content(val sectionListRenderer: SectionListRenderer) {

                        @Serializable
                        data class SectionListRenderer(
                            val contents: List<Content>,
                            val trackingParams: String
                        ) {

                            @Serializable
                            data class Content(val gridRenderer: GridRenderer) {

                                @Serializable
                                data class GridRenderer(
                                    val items: List<Item>,
                                    val trackingParams: String,
                                    val itemSize: String,
                                    val header: Header
                                ) {

                                    @Serializable
                                    data class Item(val musicNavigationButtonRenderer: MusicNavigationButtonRenderer) {

                                        @Serializable
                                        data class MusicNavigationButtonRenderer(
                                            val buttonText: ButtonText,
                                            val solid: Solid,
                                            val clickCommand: ClickCommand,
                                            val trackingParams: String
                                        ) {

                                            @Serializable
                                            data class ButtonText(val runs: List<Run>) {

                                                @Serializable
                                                data class Run(val text: String)
                                            }

                                            @Serializable
                                            data class Solid(val leftStripeColor: Long)

                                            @Serializable
                                            data class ClickCommand(
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

                                    @Serializable
                                    data class Header(val gridHeaderRenderer: GridHeaderRenderer) {

                                        @Serializable
                                        data class GridHeaderRenderer(val title: Title) {

                                            @Serializable
                                            data class Title(val runs: List<Run>) {

                                                @Serializable
                                                data class Run(val text: String)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}