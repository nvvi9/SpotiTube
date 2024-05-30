package com.nvvi9.spotitube.network

import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse

interface YouTubeMusicDataSource {

    suspend fun getMoodsAndGenres(): Result<MoodsAndGenresResponse>
}