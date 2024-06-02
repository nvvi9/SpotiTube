package com.nvvi9.spotitube.model

data class HomeSection(
    val id: String,
    val browseId: String?,
    val title: String,
    val items: List<HomeItem>
) {

    data class HomeItem(
        val browseId: String,
        val params: String?,
        val title: String,
        val subtitle: String?,
        val thumbnailUrl: String?,
        val type: HomeItemType
    ) {
        enum class HomeItemType(val value: String) {
            PLAYLIST("MUSIC_PAGE_TYPE_PLAYLIST"),
            USER_CHANNEL("MUSIC_PAGE_TYPE_USER_CHANNEL"),
            ARTIST("MUSIC_PAGE_TYPE_ARTIST"),
            ALBUM("MUSIC_PAGE_TYPE_ALBUM")
        }
    }
}