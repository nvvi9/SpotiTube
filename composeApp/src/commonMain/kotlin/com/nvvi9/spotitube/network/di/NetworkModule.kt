package com.nvvi9.spotitube.network.di

import com.nvvi9.spotitube.network.ktor.KtorYouTubeMusicDataSource
import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parametersOf
import io.ktor.http.userAgent
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

private const val CLIENT_NAME = "WEB_REMIX"
private const val CLIENT_VERSION = "1.20230731.00.00"
private const val API_KEY = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30"
private const val USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36"
private const val REFERER = "https://music.youtube.com/"

fun networkModule() = module {
    single<HttpClient> {
        HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                    encodeDefaults = true
                })
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                url("https://music.youtube.com/youtubei/v1/")
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
            }
        }
    }

    single<YouTubeMusicDataSource> {
        KtorYouTubeMusicDataSource(httpClient = get())
    }
}
