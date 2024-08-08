package com.example.codingchallenge.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.codingchallenge.home.albumdetails.AlbumDetailsScreen
import com.example.codingchallenge.home.home.HomeScreen
import com.example.codingchallenge.navigation.graph.NavigationNestedGraph
import com.example.codingchallenge.navigation.route.HomeRoute

class HomeNestedGraph : NavigationNestedGraph {
    override fun create(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<HomeRoute.HomeGraph>(
            startDestination = HomeRoute.HomeScreen
        ) {
            composable<HomeRoute.HomeScreen> {
                HomeScreen(navController)
            }

            composable<HomeRoute.AlbumDetailsScreen> {
                AlbumDetailsScreen(navController = navController)
            }
        }
    }
}
