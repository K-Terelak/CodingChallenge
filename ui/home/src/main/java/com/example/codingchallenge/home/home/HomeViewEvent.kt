package com.example.codingchallenge.home.home

internal sealed interface HomeViewEvent {
    data class NavigateToAlbumDetails(val albumId: String) : HomeViewEvent
}
