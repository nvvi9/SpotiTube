package com.nvvi9.spotitube.data.repository

import com.nvvi9.spotitube.data.model.asMoodAndGenreCategories
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteMoodAndGenreCategoriesRepository(
    private val youTubeMusicDataSource: YouTubeMusicDataSource
) : MoodAndGenreCategoriesRepository {

    override fun getMoodGenres(): Flow<List<MoodAndGenreCategory>> = flow {
        val moodsAndGenres = youTubeMusicDataSource.getMoodsAndGenres()
            .map { it.asMoodAndGenreCategories() }
            .getOrDefault(emptyList())
        emit(moodsAndGenres)
    }
}