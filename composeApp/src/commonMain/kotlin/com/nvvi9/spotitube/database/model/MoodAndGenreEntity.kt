package com.nvvi9.spotitube.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moods_and_genres")
data class MoodAndGenreEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val trackingParams: String?,
    val color: Long
)