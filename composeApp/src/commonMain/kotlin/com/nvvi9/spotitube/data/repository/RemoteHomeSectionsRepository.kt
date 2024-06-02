package com.nvvi9.spotitube.data.repository

import com.nvvi9.spotitube.data.model.asHomeSections
import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import com.nvvi9.spotitube.network.model.HomeResponse
import kotlinx.coroutines.flow.*

class RemoteHomeSectionsRepository(private val youTubeMusicDataSource: YouTubeMusicDataSource) :
    HomeSectionsRepository {

    override fun getHomeSections(): Flow<List<HomeSection>> = flow {
        youTubeMusicDataSource.getHome().onSuccess { homeResponse ->
            val continuations = homeResponse.contents.singleColumnBrowseResultsRenderer.tabs.flatMap { tab ->
                tab.tabRenderer.content.sectionListRenderer.continuations?.map { it.nextContinuationData.continuation }
                    .orEmpty()
            }.distinct()

            val homeSections =
                homeResponse.asHomeSections() + getHomeResponsesFromContinuations(continuations).map { it.asHomeSections() }
                    .toList().flatten()

            emit(homeSections)
        }.onFailure {
            emit(emptyList())
        }
    }

    private suspend fun getHomeResponsesFromContinuations(continunations: List<String>): Flow<HomeResponse> =
        continunations.asFlow().flatMapMerge {
            flow {
                youTubeMusicDataSource.getHome(it).onSuccess { homeResponse ->
                    emit(homeResponse)

                    val continuations =
                        homeResponse.contents.singleColumnBrowseResultsRenderer.tabs.flatMap { tab ->
                            tab.tabRenderer.content.sectionListRenderer.continuations?.map {
                                it.nextContinuationData.continuation
                            }.orEmpty()
                        }.distinct()

                    if (continuations.isNotEmpty()) {
                        emitAll(getHomeResponsesFromContinuations(continuations))
                    }
                }
            }
        }
}