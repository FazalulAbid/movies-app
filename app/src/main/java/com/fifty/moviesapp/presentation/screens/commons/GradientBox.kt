package com.fifty.moviesapp.presentation.screens.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fifty.moviesapp.presentation.screens.home.components.gradientBackgroundBrush

val gradientColorList = listOf(
//    Color(0xFF160008),
//    Color(0xFF0E0005),
//    Color(0xFF090003),
    Color.Black,
    Color.Black,
)

@Composable
fun GradientBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = gradientBackgroundBrush(
                    isVerticalGradient = true,
                    colors = gradientColorList
                )
            )
    ) {
        content()
    }
}