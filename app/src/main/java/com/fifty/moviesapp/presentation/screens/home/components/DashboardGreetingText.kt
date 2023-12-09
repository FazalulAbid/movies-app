package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.fifty.moviesapp.R
import com.fifty.moviesapp.presentation.ui.theme.SizeLarge
import com.fifty.moviesapp.presentation.ui.theme.SizeMedium

@Composable
fun DashboardGreetingText(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.greeting_text) + ", $text",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier = Modifier.width(SizeMedium))
        Image(
            modifier = Modifier.size(SizeLarge),
            painter = painterResource(id = R.drawable.ic_vector_wave),
            contentDescription = null
        )
    }
}