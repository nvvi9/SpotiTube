package com.nvvi9.spotitube.feature.di

import com.nvvi9.spotitube.feature.home.HomeViewModel
import com.nvvi9.spotitube.feature.search.SearchViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun viewModelsModule() = module {
    viewModelOf(::SearchViewModel)
    viewModelOf(::HomeViewModel)
}
