package com.example.codingchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorDto(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String,
)
