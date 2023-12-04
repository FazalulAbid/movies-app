package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    name: String? = null,
    greetingText: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = ("$greetingText, ") + (name ?: stringResource(R.string.there)) + "!",
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