package com.nvvi9.spotitube.network.ktor

import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import com.nvvi9.spotitube.network.model.BrowseRequest
import com.nvvi9.spotitube.network.model.HomeResponse
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse
import com.nvvi9.spotitube.network.utils.CLIENT_NAME
import com.nvvi9.spotitube.network.utils.CLIENT_VERSION
import com.nvvi9.spotitube.network.utils.DEFAULT_VISITOR
import com.nvvi9.spotitube.platform.defaultCountry
import com.nvvi9.spotitube.platform.defaultLanguageTag
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class KtorYouTubeMusicDataSource(private val httpClient: HttpClient) : YouTubeMusicDataSource {

    override suspend fun getMoodsAndGenres(): Result<MoodsAndGenresResponse> = withContext(Dispatchers.IO) {
        runCatching {
            browse("FEmusic_moods_and_genres").body()
        }
    }

    override suspend fun getHome(): Result<HomeResponse> = withContext(Dispatchers.IO) {
        runCatching {
            browse("FEmusic_home").body()
        }
    }

    override suspend fun getHomeContinuation(continuation: String): Result<HomeResponse> = withContext(Dispatchers.IO) {
        runCatching {
            browse(continuation = continuation).body()
        }
    }

    private suspend fun browse(browseId: String? = null, continuation: String? = null) = httpClient.post("browse") {
        parameter("alt", "json")
        continuation?.let {
            parameter("continuation", it)
            parameter("ctoken", it)
            parameter("type", "next")
        }

        setBody(
            BrowseRequest(
                browseId = browseId,
                context = BrowseRequest.Context(
                    client = BrowseRequest.Context.Client(
                        clientName = CLIENT_NAME,
                        clientVersion = CLIENT_VERSION,
                        gl = defaultCountry.orEmpty(),
                        hl = defaultLanguageTag.orEmpty(),
                        visitorData = DEFAULT_VISITOR
                    )
                )
            )
        )
    }
}