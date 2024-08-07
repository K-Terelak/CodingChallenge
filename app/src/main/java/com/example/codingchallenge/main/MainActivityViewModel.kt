package com.example.codingchallenge.main

import androidx.lifecycle.ViewModel
import com.example.codingchallenge.navigation.NavigationProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val navigationProvider: NavigationProvider,
) : ViewModel()
