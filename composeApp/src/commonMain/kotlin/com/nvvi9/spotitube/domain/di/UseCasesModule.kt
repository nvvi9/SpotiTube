package com.nvvi9.spotitube.domain.di

import com.nvvi9.spotitube.domain.GetHomeSectionsUseCase
import com.nvvi9.spotitube.domain.GetMoodAndGenreCategoriesUseCase
import org.koin.dsl.module

fun useCasesModule() = module {
    single<GetMoodAndGenreCategoriesUseCase> {
        GetMoodAndGenreCategoriesUseCase(moodAndGenreCategoriesRepository = get())
    }

    single<GetHomeSectionsUseCase> {
        GetHomeSectionsUseCase(homeSectionsRepository = get())
    }
}