package com.example.codingchallenge.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimension(
    val albumImageAspectRatio: Float = 1f,
    val icon20: Dp = 20.dp,
    val icon44: Dp = 44.dp,
)

@Suppress("ConstructorParameterNaming")
@Immutable
data class Spacing(
    val space64: Dp = 64.dp,
    val space40: Dp = 40.dp,
    val space32: Dp = 32.dp,
    val space30: Dp = 30.dp,
    val space24: Dp = 24.dp,
    val space20: Dp = 20.dp,
    val space18: Dp = 18.dp,
    val space16: Dp = 16.dp,
    val space12: Dp = 12.dp,
    val space10: Dp = 10.dp,
    val space8: Dp = 8.dp,
    val space6: Dp = 6.dp,
    val space4: Dp = 4.dp,
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

val LocalDimension = staticCompositionLocalOf { Dimension() }

val MaterialTheme.dimension: Dimension
    @Composable
    @ReadOnlyComposable
    get() = LocalDimension.current
