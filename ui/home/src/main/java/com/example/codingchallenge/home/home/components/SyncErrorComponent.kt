package com.example.codingchallenge.home.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.codingchallenge.common.preview.ComponentPreview
import com.example.codingchallenge.common.theme.CodingChallengeTheme
import com.example.codingchallenge.home.home.HandleAction
import com.example.codingchallenge.home.home.HomeViewAction
import com.example.codingchallenge.ui.home.R

@Composable
internal fun SyncErrorComponent(modifier: Modifier = Modifier, errorMessage: Int, onViewAction: HandleAction) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.errorContainer)
            .clickable { onViewAction(HomeViewAction.Refresh) }
    ) {
        Text(
            text = stringResource(id = errorMessage),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )

        Text(
            text = stringResource(R.string.click_here_to_refresh),
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@ComponentPreview
@Composable
private fun SyncErrorComponentPreview() {
    CodingChallengeTheme {
        SyncErrorComponent(
            errorMessage = com.example.codingchallenge.ui.common.R.string.error_message_syncing_data_failure,
            onViewAction = {}
        )
    }
}
