package com.nvvi9.spotitube.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvvi9.spotitube.domain.GetMoodAndGenreCategoriesUseCase
import com.nvvi9.spotitube.model.MoodAndGenreCategory
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class SearchViewModel(getMoodAndGenreCategoriesUseCase: GetMoodAndGenreCategoriesUseCase) : ViewModel() {

    val moodsAndGenreCategories: StateFlow<List<MoodAndGenreCategory>> = getMoodAndGenreCategoriesUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}