package com.example.codingchallenge.home

import com.example.codingchallenge.model.Album
import com.example.codingchallenge.model.Genre
import java.time.LocalDate
import java.time.format.DateTimeFormatter

val albumData = Album(
    id = "1",
    artistId = "1",
    artistName = "Artist name",
    artistUrl = "url",
    artworkUrl100 = "",
    contentAdvisoryRating = "Explicit",
    genres = listOf(
        Genre("1", name = "GenreName1", url = "url"),
        Genre("1", name = "GenreName1", url = "url")
    ),
    kind = "albums",
    name = "Album name",
    releaseDate = LocalDate.parse("2024-06-14", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    url = "",
    copyright = ""
)
