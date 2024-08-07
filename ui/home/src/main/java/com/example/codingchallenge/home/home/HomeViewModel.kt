package com.example.codingchallenge.home.home

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallenge.contract.album.ObserveLocalAlbumsUseCase
import com.example.codingchallenge.contract.album.SyncRemoteAlbumsUseCase
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
import com.example.codingchallenge.ui.common.R as CommonRes

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val syncRemoteAlbumsUseCase: SyncRemoteAlbumsUseCase,
    private val observeLocalAlbumsUseCase: ObserveLocalAlbumsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val _event = Channel<HomeViewEvent>()
    val event = _event.receiveAsFlow()

    init {
        syncAlbums()
        observeAlbums()
    }

    fun handleViewAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.NavigateToAlbumDetails -> viewModelScope.launch {
                _event.send(HomeViewEvent.NavigateToAlbumDetails(albumId = action.albumId))
            }

            is HomeViewAction.Refresh -> {
                _state.update { currentState ->
                    currentState.copy(
                        errorMessage = null
                    )
                }
                syncAlbums()
            }
        }
    }

    private fun observeAlbums() {
        viewModelScope.launch {
            observeLocalAlbumsUseCase().collect { feed ->
                feed?.let {
                    _state.update { currentState ->
                        currentState.copy(
                            albums = feed.results,
                            copyright = feed.copyright
                        )
                    }
                }
            }
        }
    }

    private fun syncAlbums() {
        viewModelScope.launch {
            withSyncing {
                syncRemoteAlbumsUseCase()
                    .onFailure { error ->
                        Timber.e(error, "HomeViewModel: Syncing albums failure")
                        showError()
                    }
            }
        }
    }

    private fun showError(@StringRes messageId: Int = CommonRes.string.error_message_syncing_data_failure) = viewModelScope.launch {
        _state.update { currentState ->
            currentState.copy(
                errorMessage = messageId
            )
        }
    }

    private suspend fun withSyncing(block: suspend () -> Unit) {
        withContext(currentCoroutineContext()) {
            _state.update { it.copy(isSyncing = true) }
            block()
            _state.update { it.copy(isSyncing = false) }
        }
    }
}
