package com.example.codingchallenge.appinitializer

import android.app.Application
import com.example.codingchallenge.initializer.contract.AppInitializer
import javax.inject.Inject

class AppInitializersContainer @Inject constructor(
    private val initializersProvider: Set<@JvmSuppressWildcards AppInitializer>,
) {

    fun init(application: Application) = initializersProvider.forEach {
        it.init(application)
    }
}
