package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.ImageLoader
import com.fifty.moviesapp.R
import com.fifty.moviesapp.presentation.components.SecondaryHeader
import com.fifty.moviesapp.presentation.ui.theme.SizeSmall8
import com.fifty.moviesapp.presentation.ui.theme.SizeStandard16
import com.fifty.moviesapp.presentation.ui.theme.StandardScreenPadding

@Composable
fun TrendingMoviesSection(
    imageLoader: ImageLoader
) {
    Column {
        SecondaryHeader(
            modifier = Modifier.padding(horizontal = StandardScreenPadding),
            text = "Trending Today",
            moreOptionText = stringResource(id = R.string.show_more)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = StandardScreenPadding),
            horizontalArrangement = Arrangement.spacedBy(SizeStandard16)
        ) {
            items(10) {
                VerticalGradientCard(
                    title = "",
                    imageLoader = imageLoader
                )
            }
        }
    }
}