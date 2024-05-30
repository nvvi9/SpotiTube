package com.nvvi9.spotitube.network.model

import kotlinx.serialization.Serializable

@Serializable
data class BrowseRequest(
    val context: Context,
    val browseId: String? = null,
    val params: String? = null,
    val formData: FormData? = null,
    val enabledPersistentPlaylistPanel: Boolean? = null,
    val isAudioOnly: Boolean? = null,
    val tunerSettingValue: String? = null,
    val playlistId: String? = null
) {

    @Serializable
    data class FormData(
        val selectedValues: List<String> = listOf("ZZ")
    )

    @Serializable
    data class Context(
        val client: Client,
        val thirdParty: ThirdParty? = null
    ) {

        @Serializable
        data class Client(
            val clientName: String,
            val clientVersion: String,
            val gl: String,
            val hl: String,
            val visitorData: String?
        )

        @Serializable
        data class ThirdParty(
            val embedUrl: String
        )
    }
}
