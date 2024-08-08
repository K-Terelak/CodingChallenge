package com.example.codingchallenge.home.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.codingchallenge.common.theme.spacing
import com.example.codingchallenge.common.utils.observeAsEvents
import com.example.codingchallenge.home.home.components.AlbumItem
import com.example.codingchallenge.home.home.components.EmptyAlbumListPlaceholder
import com.example.codingchallenge.home.home.components.SyncErrorComponent
import com.example.codingchallenge.home.home.components.SyncingComponent
import com.example.codingchallenge.navigation.route.HomeRoute

internal typealias HandleAction = (HomeViewAction) -> Unit

@Composable
internal fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    viewModel.event.observeAsEvents { event ->
        when (event) {
            is HomeViewEvent.NavigateToAlbumDetails -> navController.navigate(HomeRoute.AlbumDetailsScreen(event.albumId))
        }
    }

    HomeScreenContent(state = state, onViewAction = viewModel::handleViewAction)
}

@Composable
private fun HomeScreenContent(modifier: Modifier = Modifier, state: HomeViewState, onViewAction: HandleAction) {
    val lazyGridState = rememberLazyGridState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SyncingComponent(isSyncing = state.isSyncing)

        AnimatedContent(
            targetState = state,
            label = "Sync error",
            transitionSpec = {
                slideInVertically(animationSpec = tween()) togetherWith
                    slideOutVertically(animationSpec = tween())
            }
        ) {
            if (it.errorMessage != null) {
                SyncErrorComponent(modifier = Modifier.animateContentSize(), errorMessage = it.errorMessage, onViewAction = onViewAction)
            }
        }

        if (state.albums.isEmpty()) {
            EmptyAlbumListPlaceholder()
        } else {
            LazyVerticalGrid(
                state = lazyGridState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = MaterialTheme.spacing.space12),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space8),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space8)
            ) {
                items(state.albums) { album ->
                    AlbumItem(
                        album = album,
                        isSyncing = state.isSyncing,
                        onViewAction = onViewAction
                    )
                }
            }
        }
    }
}
