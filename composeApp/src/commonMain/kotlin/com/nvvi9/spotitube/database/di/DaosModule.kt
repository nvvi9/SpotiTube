package com.nvvi9.spotitube.database.di

import com.nvvi9.spotitube.database.SpotiTubeDatabase
import com.nvvi9.spotitube.database.dao.MoodAndGenreDao
import org.koin.dsl.module

fun daosModule() = module {
    single<MoodAndGenreDao> {
        get<SpotiTubeDatabase>().moodAndGenreDao()
    }
}