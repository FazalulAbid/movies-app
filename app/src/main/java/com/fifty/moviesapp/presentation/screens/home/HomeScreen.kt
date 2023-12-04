package com.fifty.moviesapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.fifty.moviesapp.R
import com.fifty.moviesapp.presentation.screens.home.components.DashboardGreetingText
import com.fifty.moviesapp.presentation.ui.theme.SizeMedium

@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DashboardGreetingText(
            modifier = Modifier.padding(SizeMedium),
            greetingText = stringResource(R.string.greeting_text)
        )
    }
}

