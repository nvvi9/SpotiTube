package com.nvvi9.spotitube.database.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.nvvi9.spotitube.database.SpotiTubeDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun databaseModule() = module {
    single<SpotiTubeDatabase> {
        val appContext = get<Context>().applicationContext
        val dbFile = appContext.getDatabasePath("spotitube.db")

        Room.databaseBuilder<SpotiTubeDatabase>(context = appContext, name = dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}