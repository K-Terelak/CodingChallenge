package com.example.codingchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.codingchallenge.navigation.route.HomeRoute

@Composable
fun AppNavGraph(modifier: Modifier = Modifier, navController: NavHostController, navigationProvider: NavigationProvider) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute.HomeGraph
    ) {
        with(navigationProvider) {
            homeNestedGraph.create(navController, this@NavHost)
        }
    }
}
