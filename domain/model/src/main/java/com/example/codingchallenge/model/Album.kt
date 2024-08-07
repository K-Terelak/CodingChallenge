package com.example.codingchallenge.model

import java.time.LocalDate

data class Album(
    val id: String,
    val artistId: String,
    val artistName: String,
    val artistUrl: String,
    val artworkUrl100: String,
    val contentAdvisoryRating: String,
    val genres: List<Genre>,
    val kind: String,
    val name: String,
    val releaseDate: LocalDate,
    val url: String,
    val copyright: String,
)
