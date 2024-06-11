package com.nvvi9.spotitube.network

import com.nvvi9.spotitube.network.model.HomeResponse
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse

interface YouTubeMusicDataSource {

    suspend fun getMoodsAndGenres(): Result<MoodsAndGenresResponse>
    suspend fun getHome(): Result<HomeResponse>
    suspend fun getHomeContinuation(continuation: String): Result<HomeResponse>
}