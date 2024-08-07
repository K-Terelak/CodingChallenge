package com.example.codingchallenge.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun interface NavigationNestedGraph {
    fun create(navController: NavHostController, navGraphBuilder: NavGraphBuilder)
}
