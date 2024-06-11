package com.nvvi9.spotitube.data.repository

import com.nvvi9.spotitube.data.model.asHomeSections
import com.nvvi9.spotitube.model.HomeSection
import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteHomeSectionsRepository(
    private val youTubeMusicDataSource: YouTubeMusicDataSource
) : HomeSectionsRepository {

    override fun getHomeSections(): Flow<List<HomeSection>> = flow {
        youTubeMusicDataSource.getHome().onSuccess { homeResponse ->
            val homeSections = homeResponse.asHomeSections().toMutableList()
            emit(homeSections.toList())

            var continuation =
                homeResponse.contents.singleColumnBrowseResultsRenderer.tabs.firstNotNullOfOrNull { tab ->
                    tab.tabRenderer.content?.sectionListRenderer?.continuations?.firstOrNull()?.nextContinuationData?.continuation
                }

            while (continuation != null) {
                youTubeMusicDataSource.getHomeContinuation(continuation)
                    .onSuccess { response ->
                        continuation =
                            response.continuationContents?.sectionListContinuation?.continuations?.firstOrNull()?.nextContinuationData?.continuation
                        homeSections += response.asHomeSections()
                        emit(homeSections.toList())
                    }.onFailure {
                        continuation = null
                    }
            }
        }.onFailure {
            emit(emptyList())
        }
    }
}
