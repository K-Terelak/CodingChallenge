package com.example.codingchallenge.navigation.route

import kotlinx.serialization.Serializable

interface Route

sealed class HomeRoute : Route {
    @Serializable
    data object HomeGraph : HomeRoute()

    @Serializable
    data object HomeScreen : HomeRoute()

    @Serializable
    data class AlbumDetailsScreen(val albumId: String) : HomeRoute()
}
