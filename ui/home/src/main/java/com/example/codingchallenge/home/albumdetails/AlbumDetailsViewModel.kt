package com.example.codingchallenge.home.albumdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.common.utils.toFormattedDate
import com.example.codingchallenge.contract.album.GetLocalAlbumUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel(assistedFactory = AlbumDetailsViewModel.Factory::class)
internal class AlbumDetailsViewModel @AssistedInject constructor(
    private val getLocalAlbumUseCase: GetLocalAlbumUseCase,
    @Assisted val albumId: String,
) : ViewModel() {

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
            getLocalAlbumUseCase(albumId)
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

    @AssistedFactory
    interface Factory {
        fun create(organizationId: String): AlbumDetailsViewModel
    }
}
