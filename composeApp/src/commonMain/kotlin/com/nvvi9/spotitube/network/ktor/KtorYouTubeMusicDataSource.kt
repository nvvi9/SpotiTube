package com.nvvi9.spotitube.network.ktor

import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import com.nvvi9.spotitube.network.model.BrowseRequest
import com.nvvi9.spotitube.network.model.MoodsAndGenresResponse
import com.nvvi9.spotitube.platform.defaultCountry
import com.nvvi9.spotitube.platform.defaultLanguageTag
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.parametersOf
import io.ktor.http.userAgent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

private const val CLIENT_NAME = "WEB_REMIX"
private const val CLIENT_VERSION = "1.20230731.00.00"
private const val API_KEY = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30"
private const val USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36"
private const val REFERER = "https://music.youtube.com/"


class KtorYouTubeMusicDataSource(private val httpClient: HttpClient) : YouTubeMusicDataSource {

    override suspend fun getMoodsAndGenres(): Result<MoodsAndGenresResponse> =
        withContext(Dispatchers.IO) {
            runCatching {
                browse("FEmusic_moods_and_genres").body()
            }
        }

    private suspend fun browse(browseId: String? = null) = httpClient.post("browse") {
        headers {
            append("X-Goog-Api-Format-Version", "1")
            append("X-YouTube-Client-Name", CLIENT_NAME)
            append("X-YouTube-Client-Version", CLIENT_VERSION)
            append("x-origin", "https://music.youtube.com")
            append("X-Goog-Visitor-Id", "Cgt6SUNYVzB2VkJDbyjGrrSmBg%3D%3D")
            append("Referer", REFERER)
        }
        userAgent(USER_AGENT)
        parametersOf("key", API_KEY)
        parametersOf("prettyPrint", "false")
        parametersOf("alt", "json")
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