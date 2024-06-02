package com.nvvi9.spotitube.data.repository

import com.nvvi9.spotitube.model.HomeSection
import kotlinx.coroutines.flow.Flow

interface HomeSectionsRepository {
    fun getHomeSections(): Flow<List<HomeSection>>
}