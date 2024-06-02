package com.nvvi9.spotitube.data.di

import com.nvvi9.spotitube.data.repository.HomeSectionsRepository
import com.nvvi9.spotitube.data.repository.MoodAndGenreCategoriesRepository
import com.nvvi9.spotitube.data.repository.RemoteHomeSectionsRepository
import com.nvvi9.spotitube.data.repository.RemoteMoodAndGenreCategoriesRepository
import org.koin.dsl.module

fun repositoriesModule() = module {
    single<MoodAndGenreCategoriesRepository> {
        RemoteMoodAndGenreCategoriesRepository(youTubeMusicDataSource = get())
    }

    single<HomeSectionsRepository> {
        RemoteHomeSectionsRepository(youTubeMusicDataSource = get())
    }
}