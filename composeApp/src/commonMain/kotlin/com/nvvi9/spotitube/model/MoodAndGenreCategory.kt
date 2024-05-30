package com.nvvi9.spotitube.model

data class MoodAndGenreCategory(
    val name: String,
    val moodsAndGenres: List<MoodAndGenre>
) {
    data class MoodAndGenre(
        val id: String,
        val name: String,
        val color: Long
    )
}