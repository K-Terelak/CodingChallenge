package com.example.codingchallenge.home.albumdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.codingchallenge.common.utils.toFormattedDate
import com.example.codingchallenge.contract.album.GetLocalAlbumUseCase
import com.example.codingchallenge.navigation.route.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class AlbumDetailsViewModel @Inject constructor(
    private val getLocalAlbumUseCase: GetLocalAlbumUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val navArgs = savedStateHandle.toRoute<HomeRoute.AlbumDetailsScreen>()

    private val _state = MutableStateFlow(AlbumDetailsViewState())
    val state = _state.asStateFlow()

    private val _event = Channel<AlbumDetailsViewEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadAlbum()
    }

    fun handleViewAction(action: AlbumDetailsViewAction) {
        when (action) {
            is AlbumDetailsViewAction.NavigateUp -> viewModelScope.launch {
                _event.send(AlbumDetailsViewEvent.NavigateUp)
            }
        }
    }

    private fun loadAlbum() {
        viewModelScope.launch {
            withLoading {
                getLocalAlbumUseCase(navArgs.albumId)
                    .onSuccess { album ->
                        _state.update { currentState ->
                            currentState.copy(
                                albumId = album.id,
                                artworkUrl100 = album.artworkUrl100,
                                name = album.name,
                                artistName = album.artistName,
                                genre = album.genres.joinToString(",") { it.name },
                                releaseDate = album.releaseDate.toFormattedDate(),
                                copyrightInfo = album.copyright,
                                url = album.url
                            )
                        }
                    }.onFailure { error ->
                        Timber.e(error, "AlbumDetailsViewModel: Load album failure")
                    }
            }
        }
    }

    private suspend fun withLoading(block: suspend () -> Unit) {
        withContext(currentCoroutineContext()) {
            _state.update { it.copy(isLoading = true) }
            block()
            _state.update { it.copy(isLoading = false) }
        }
    }
}
