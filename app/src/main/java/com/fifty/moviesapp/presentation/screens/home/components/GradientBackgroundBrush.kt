package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun gradientBackgroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {
     val endOffset = if(isVerticalGradient) {
         Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
     } else {
         Offset(Float.POSITIVE_INFINITY, 0f)
     }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}