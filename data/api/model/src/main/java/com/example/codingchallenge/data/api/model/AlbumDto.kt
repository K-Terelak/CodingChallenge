package com.example.codingchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDto(
    @SerialName("id") val id: String,
    @SerialName("artistId") val artistId: String? = null,
    @SerialName("artistName") val artistName: String? = null,
    @SerialName("artistUrl") val artistUrl: String? = null,
    @SerialName("artworkUrl100") val artworkUrl100: String? = null,
    @SerialName("contentAdvisoryRating") val contentAdvisoryRating: String? = null,
    @SerialName("genres") val genres: List<GenreDto>? = emptyList(),
    @SerialName("kind") val kind: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("releaseDate") val releaseDate: String? = null,
    @SerialName("url") val url: String? = null,
)
