package com.example.codingchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeedDto(
    @SerialName("id") val id: String,
    @SerialName("author") val author: AuthorDto,
    @SerialName("copyright") val copyright: String,
    @SerialName("country") val country: String,
    @SerialName("icon") val icon: String,
    @SerialName("links") val links: List<LinkDto>,
    @SerialName("results") val results: List<AlbumDto>,
    @SerialName("title") val title: String,
    @SerialName("updated") val updated: String,
)
