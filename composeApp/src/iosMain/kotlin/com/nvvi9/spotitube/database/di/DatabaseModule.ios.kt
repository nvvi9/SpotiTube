package com.nvvi9.spotitube.database.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.nvvi9.spotitube.database.SpotiTubeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory

actual fun databaseModule() = module {
    single<SpotiTubeDatabase> {
        val dbFilePath = NSHomeDirectory() + "/spotitube.db"
        Room.databaseBuilder(
            name = dbFilePath,
            factory = { SpotiTubeDatabase::class.instantiateImpl() }
        )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}