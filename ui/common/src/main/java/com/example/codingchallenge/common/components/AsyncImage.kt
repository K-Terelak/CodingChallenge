package com.example.codingchallenge.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import timber.log.Timber

private typealias ErrorContent = Pair<Boolean, Throwable?>

@Composable
fun AsyncImage(
    imageUrl: Any,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    alpha: Float = 1f,
    clipToBounds: Boolean = true,
    colorFilter: ColorFilter? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    filterQuality: FilterQuality = FilterQuality.Low,
    errorContent: (@Composable BoxScope.() -> Unit)? = null,
    loadingContent: (@Composable BoxScope.() -> Unit)? = null,
) {
    Box(modifier = modifier) {
        var error by remember { mutableStateOf<ErrorContent>(false to null) }
        var isLoading by remember { mutableStateOf(false) }

        if (isLoading) {
            loadingContent?.invoke(this)
        }

        error.let { (isError, message) ->
            if (isError) {
                errorContent?.invoke(this)
                message?.let { Timber.e(it, "Loading image failure") }
            }
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            onState = { state ->
                when (state) {
                    AsyncImagePainter.State.Empty -> {
                        // no-op
                    }

                    is AsyncImagePainter.State.Error -> {
                        error = true to state.result.throwable
                        isLoading = false
                    }

                    is AsyncImagePainter.State.Loading -> {
                        isLoading = true
                    }

                    is AsyncImagePainter.State.Success -> {
                        error = false to null
                        isLoading = false
                    }
                }
            },
            modifier = Modifier.fillMaxSize(),
            contentScale = contentScale,
            clipToBounds = clipToBounds,
            alpha = alpha,
            alignment = alignment,
            colorFilter = colorFilter,
            filterQuality = filterQuality
        )
    }
}
