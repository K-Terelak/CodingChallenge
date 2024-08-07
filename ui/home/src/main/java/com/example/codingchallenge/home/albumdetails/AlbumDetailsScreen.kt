package com.example.codingchallenge.home.albumdetails

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.codingchallenge.common.components.AsyncImage
import com.example.codingchallenge.common.theme.spacing
import com.example.codingchallenge.common.utils.observeAsEvents
import com.example.codingchallenge.ui.home.R

internal typealias HandleAction = (AlbumDetailsViewAction) -> Unit

@Composable
internal fun AlbumDetailsScreen(navController: NavHostController, viewModel: AlbumDetailsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    viewModel.event.observeAsEvents { event ->
        when (event) {
            is AlbumDetailsViewEvent.NavigateUp -> navController.navigateUp()
        }
    }

    AlbumDetailsScreenContent(state = state, onViewAction = viewModel::handleViewAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AlbumDetailsScreenContent(modifier: Modifier = Modifier, state: AlbumDetailsViewState, onViewAction: HandleAction) {
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {}
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .scrollable(state = scrollState, orientation = Vertical),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(R.string.album_details)) },
            windowInsets = WindowInsets(
                top = 0.dp,
                bottom = 0.dp
            ),
            navigationIcon = {
                IconButton(onClick = { onViewAction(AlbumDetailsViewAction.NavigateUp) }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.navigate_back))
                }
            }
        )

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(.7f)
                .aspectRatio(1f),
            imageUrl = state.artworkUrl100
        )

        Text(
            text = state.copyrightInfo,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Text(
            text = state.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = state.artistName,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Text(
            text = state.genre,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = state.releaseDate,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Button(onClick = { launcher.launch(Intent(Intent.ACTION_VIEW, Uri.parse(state.url))) }) {
            Text(text = stringResource(R.string.open_itunes))
        }
    }
}
