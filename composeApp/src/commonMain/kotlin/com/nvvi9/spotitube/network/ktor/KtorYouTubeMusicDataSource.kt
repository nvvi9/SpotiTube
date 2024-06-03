package com.nvvi9.spotitube.network.ktor

import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import com.nvvi9.spotitube.network.model.BrowseRequest
import com.nvvi9.spotitube.network.model.HomeResponse
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse
import com.nvvi9.spotitube.platform.defaultCountry
import com.nvvi9.spotitube.platform.defaultLanguageTag
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

private const val CLIENT_NAME = "WEB_REMIX"
private const val CLIENT_VERSION = "1.20230731.00.00"

class KtorYouTubeMusicDataSource(private val httpClient: HttpClient) : YouTubeMusicDataSource {

    override suspend fun getMoodsAndGenres(): Result<MoodsAndGenresResponse> =
        withContext(Dispatchers.IO) {
            runCatching {
                browse("FEmusic_moods_and_genres").body()
            }
        }

    override suspend fun getHome(continuation: String?): Result<HomeResponse> =
        withContext(Dispatchers.IO) {
            runCatching {
                browse("FEmusic_home", continuation).body()
            }
        }

    private suspend fun browse(browseId: String? = null, continuation: String? = null) = httpClient.post("browse") {
        parametersOf("alt", "json")
        continuation?.let {
            parametersOf("continuation", it)
            parametersOf("ctoken", it)
            parametersOf("type", "next")
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
                        visitorData = "Cgt6SUNYVzB2VkJDbyjGrrSmBg%3D%3D"
                    )
                )
            )
        )
    }
}