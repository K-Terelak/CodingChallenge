package com.example.codingchallenge.home.home.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import com.example.codingchallenge.common.components.AsyncImage
import com.example.codingchallenge.common.preview.ComponentPreview
import com.example.codingchallenge.common.theme.CodingChallengeTheme
import com.example.codingchallenge.common.theme.spacing
import com.example.codingchallenge.home.home.HandleAction
import com.example.codingchallenge.home.home.HomeViewAction
import com.example.codingchallenge.model.Album
import com.example.codingchallenge.model.Genre
import com.example.codingchallenge.ui.home.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
internal fun AlbumItem(modifier: Modifier = Modifier, album: Album, isSyncing: Boolean, onViewAction: HandleAction) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                if (!isSyncing) {
                    onViewAction(HomeViewAction.NavigateToAlbumDetails(album.id))
                } else {
                    Toast
                        .makeText(context, R.string.please_wait_until_sync_completes, Toast.LENGTH_LONG)
                        .show()
                }
            },
        shape = RoundedCornerShape(MaterialTheme.spacing.space8)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            imageUrl = album.artworkUrl100
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space8),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space6)
        ) {
            Text(
                text = album.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 2,
                minLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = album.artistName,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ComponentPreview
@Composable
private fun AlbumItemPreview() {
    CodingChallengeTheme {
        AlbumItem(
            album = Album(
                id = "1",
                artistId = "1",
                artistName = "Artist name",
                artistUrl = "url",
                artworkUrl100 = "",
                contentAdvisoryRating = "Explicit",
                genres = listOf(
                    Genre("1", name = "GenreName1", url = "url"),
                    Genre("1", name = "GenreName1", url = "url")
                ),
                kind = "albums",
                name = "Album name",
                releaseDate = LocalDate.parse("2024-06-14", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                url = "",
                copyright = ""
            ),
            onViewAction = {},
            isSyncing = false
        )
    }
}
