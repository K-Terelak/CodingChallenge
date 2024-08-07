package com.example.codingchallenge.home.albumdetails

internal data class AlbumDetailsViewState(
    val albumId: String = "",
    val artworkUrl100: String = "",
    val name: String = "",
    val artistName: String = "",
    val genre: String = "",
    val releaseDate: String = "",
    val copyrightInfo: String = "",
    val url: String = "",
)
