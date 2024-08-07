package com.example.codingchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreDto(
    @SerialName("genreId") val genreId: String,
    @SerialName("name") val name: String,
    @SerialName("url") val url: String,
)
