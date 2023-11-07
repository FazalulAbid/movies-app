package com.fifty.moviesapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fifty.moviesapp.screens.home.components.gradientBackgroundBrush
import com.fifty.moviesapp.ui.theme.SizeMedium

@Composable
fun HomeScreen(

) {
    val gradientColorList = listOf(
        Color(0xFF160008),
        Color(0xFF0E0005),
        Color(0xFF090003),
        Color(0xFF000000)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(
                    brush = gradientBackgroundBrush(
                        isVerticalGradient = true,
                        colors = gradientColorList
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Hello World!")
        }
    }

}

