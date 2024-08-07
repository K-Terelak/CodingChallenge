package com.example.codingchallenge.home.home

import androidx.annotation.StringRes
import com.example.codingchallenge.model.Album

internal data class HomeViewState(
    val albums: List<Album> = emptyList(),
    val copyright: String = "",
    val isSyncing: Boolean = false,
    @StringRes val errorMessage: Int? = null,
)
