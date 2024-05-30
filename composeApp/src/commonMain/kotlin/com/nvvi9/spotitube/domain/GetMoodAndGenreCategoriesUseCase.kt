package com.nvvi9.spotitube.domain

import com.nvvi9.spotitube.data.repository.MoodAndGenreCategoriesRepository
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import kotlinx.coroutines.flow.Flow

class GetMoodAndGenreCategoriesUseCase(private val moodAndGenreCategoriesRepository: MoodAndGenreCategoriesRepository) {

    operator fun invoke(): Flow<List<MoodAndGenreCategory>> = moodAndGenreCategoriesRepository.getMoodGenres()
}