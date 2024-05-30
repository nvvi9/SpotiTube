package com.nvvi9.spotitube.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.nvvi9.spotitube.database.model.MoodAndGenreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoodAndGenreDao {

    @Query("SELECT * FROM moods_and_genres")
    fun getMoodsAndGenres(): Flow<List<MoodAndGenreEntity>>

    @Upsert
    suspend fun upsertMoodsAndGenres(moodAndGenreEntities: List<MoodAndGenreEntity>)
}