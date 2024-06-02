package com.nvvi9.spotitube.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvvi9.spotitube.domain.GetHomeSectionsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(getHomeSectionsUseCase: GetHomeSectionsUseCase) : ViewModel() {

    val homeSections = getHomeSectionsUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}