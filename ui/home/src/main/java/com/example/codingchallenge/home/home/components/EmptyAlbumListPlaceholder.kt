package com.example.codingchallenge.home.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.codingchallenge.common.preview.ComponentPreview
import com.example.codingchallenge.common.theme.CodingChallengeTheme
import com.example.codingchallenge.ui.home.R

@Composable
internal fun EmptyAlbumListPlaceholder(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = stringResource(R.string.empty_list),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@ComponentPreview
@Composable
private fun EmptyAlbumListPlaceholderPreview() {
    CodingChallengeTheme {
        EmptyAlbumListPlaceholder()
    }
}
