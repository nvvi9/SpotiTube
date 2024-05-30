package com.nvvi9.spotitube.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nvvi9.spotitube.database.dao.MoodAndGenreDao
import com.nvvi9.spotitube.database.model.MoodAndGenreEntity

@Database(
    entities = [MoodAndGenreEntity::class],
    version = 1,
    exportSchema = true
)
abstract class SpotiTubeDatabase : RoomDatabase() {
    abstract fun moodAndGenreDao(): MoodAndGenreDao
}