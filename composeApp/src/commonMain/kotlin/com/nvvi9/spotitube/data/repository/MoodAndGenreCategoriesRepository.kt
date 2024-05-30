package com.nvvi9.spotitube.data.repository

import com.nvvi9.spotitube.model.MoodAndGenreCategory
import kotlinx.coroutines.flow.Flow

interface MoodAndGenreCategoriesRepository {
    fun getMoodGenres(): Flow<List<MoodAndGenreCategory>>
}