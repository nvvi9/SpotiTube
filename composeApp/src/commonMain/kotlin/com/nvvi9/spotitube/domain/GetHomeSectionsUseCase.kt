package com.nvvi9.spotitube.domain

import com.nvvi9.spotitube.data.repository.HomeSectionsRepository
import com.nvvi9.spotitube.model.HomeSection
import kotlinx.coroutines.flow.Flow

class GetHomeSectionsUseCase(private val homeSectionsRepository: HomeSectionsRepository) {

    operator fun invoke(): Flow<List<HomeSection>> = homeSectionsRepository.getHomeSections()
}