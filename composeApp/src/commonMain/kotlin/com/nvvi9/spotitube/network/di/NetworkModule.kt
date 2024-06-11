package com.nvvi9.spotitube.network.di

import com.nvvi9.spotitube.network.YouTubeMusicDataSource
import com.nvvi9.spotitube.network.ktor.KtorYouTubeMusicDataSource
import com.nvvi9.spotitube.network.utils.*
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

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

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.d(tag = "Ktor", message = message)
                    }
                }
                level = LogLevel.HEADERS
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                url{
                    protocol = URLProtocol.HTTPS
                    host = "music.youtube.com"
                    path("youtubei/v1/")
                    parameters.append("key", API_KEY)
                    parameters.append("prettyPrint", "false")
                }
                headers {
                    append("X-Goog-Api-Format-Version", "1")
                    append("X-YouTube-Client-Name", CLIENT_NAME)
                    append("X-YouTube-Client-Version", CLIENT_VERSION)
                    append("x-origin", "https://music.youtube.com")
                    append("X-Goog-Visitor-Id", DEFAULT_VISITOR)
                    append("Referer", REFERER)
                }
                userAgent(USER_AGENT)
            }
        }
    }

    single<YouTubeMusicDataSource> {
        KtorYouTubeMusicDataSource(httpClient = get())
    }
}
