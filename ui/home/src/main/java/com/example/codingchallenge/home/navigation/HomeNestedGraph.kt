package com.example.codingchallenge.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.codingchallenge.home.albumdetails.AlbumDetailsScreen
import com.example.codingchallenge.home.albumdetails.AlbumDetailsViewModel
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

            composable<HomeRoute.AlbumDetailsScreen> { navBackStackEntry ->
                val args = navBackStackEntry.toRoute<HomeRoute.AlbumDetailsScreen>()

                AlbumDetailsScreen(
                    navController = navController,
                    viewModel = hiltViewModel<AlbumDetailsViewModel, AlbumDetailsViewModel.Factory>(
                        creationCallback = { factory ->
                            factory.create(args.albumId)
                        }
                    )
                )
            }
        }
    }
}
