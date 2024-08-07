package com.example.codingchallenge.model

data class Feed(
    val id: String,
    val copyright: String,
    val results: List<Album> = emptyList(),
)
