package com.example.codingchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumsDto(
    @SerialName("feed") val feed: FeedDto,
)
