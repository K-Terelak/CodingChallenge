package com.example.codingchallenge.home

import androidx.lifecycle.SavedStateHandle
import com.example.codingchalenge.testtools.ViewModelDispatcherExtension
import com.example.codingchalenge.testtools.cancelAndConsumeItems
import com.example.codingchalenge.testtools.runCompoundTest
import com.example.codingchallenge.common.utils.toFormattedDate
import com.example.codingchallenge.contract.album.GetLocalAlbumUseCase
import com.example.codingchallenge.home.albumdetails.AlbumDetailsViewAction
import com.example.codingchallenge.home.albumdetails.AlbumDetailsViewEvent
import com.example.codingchallenge.home.albumdetails.AlbumDetailsViewModel
import com.example.codingchallenge.home.albumdetails.AlbumDetailsViewState
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ViewModelDispatcherExtension::class)
class AlbumDetailsViewModelTest {
    private lateinit var viewModel: AlbumDetailsViewModel

    private val getLocalAlbumUseCase = mockk<GetLocalAlbumUseCase> {
        coEvery { this@mockk.invoke(any()) } returns Result.success(albumData)
    }

    @Test
    fun `should load project details on init`() = runCompoundTest {
        // given
        buildViewModel()
        val stateTurbine = viewModel.state.testIn(this)

        val defaultState = AlbumDetailsViewState()
        val loadingState = defaultState.copy(isLoading = true)
        val stateWithData = loadingState.copy(
            albumId = albumData.id,
            artworkUrl100 = albumData.artworkUrl100,
            name = albumData.name,
            artistName = albumData.artistName,
            genre = albumData.genres.joinToString(",") { it.name },
            releaseDate = albumData.releaseDate.toFormattedDate(),
            copyrightInfo = albumData.copyright,
            url = albumData.url
        )
        val notLoadingState = stateWithData.copy(isLoading = false)

        val expectedResults = listOf(defaultState, loadingState, stateWithData, notLoadingState)

        // when
        runCurrent()

        // then
        assert(stateTurbine.cancelAndConsumeItems() == expectedResults)
    }

    @Test
    fun `should navigate back on view action`() = runCompoundTest {
        // given
        buildViewModel()
        val event = viewModel.event.testIn(this)

        // when
        viewModel.handleViewAction(AlbumDetailsViewAction.NavigateUp)
        runCurrent()

        // then
        assert(event.cancelAndConsumeItems().single() == AlbumDetailsViewEvent.NavigateUp)
    }

    private fun buildViewModel() {
        viewModel = AlbumDetailsViewModel(
            getLocalAlbumUseCase = getLocalAlbumUseCase,
            savedStateHandle = buildSavedState(
                key = "albumId",
                value = ALBUM_ID
            )
        )
    }

    companion object {
        private const val ALBUM_ID = "1"
    }
}

fun buildSavedState(key: String, value: String): SavedStateHandle {
    return mockk<SavedStateHandle> {
        every { this@mockk.get<String>(key) } returns value
        every { this@mockk.contains(key) } returns true
    }
}
