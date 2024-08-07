package com.example.codingchallenge.home.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.codingchallenge.common.preview.ComponentPreview
import com.example.codingchallenge.common.theme.CodingChallengeTheme
import com.example.codingchallenge.common.theme.dimension
import com.example.codingchallenge.ui.home.R

@Composable
internal fun SyncingComponent(modifier: Modifier = Modifier, isSyncing: Boolean) {
    AnimatedVisibility(visible = isSyncing, enter = expandVertically(), exit = shrinkVertically()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(MaterialTheme.dimension.icon20),
                imageVector = Icons.Default.Refresh,
                tint = MaterialTheme.colorScheme.onSecondary,
                contentDescription = stringResource(R.string.content_description_sync_icon)
            )

            Text(
                text = stringResource(R.string.syncing),
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@ComponentPreview
@Composable
private fun SyncingComponentPreview() {
    CodingChallengeTheme {
        SyncingComponent(isSyncing = true)
    }
}
