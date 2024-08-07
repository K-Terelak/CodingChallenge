package com.example.codingchallenge.home.home

internal interface HomeViewAction {
    data class NavigateToAlbumDetails(val albumId: String) : HomeViewAction
    object Refresh : HomeViewAction
}
