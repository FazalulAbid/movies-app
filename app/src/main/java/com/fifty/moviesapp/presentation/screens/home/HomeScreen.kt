package com.fifty.moviesapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.ImageLoader
import com.fifty.moviesapp.R
import com.fifty.moviesapp.core_framework.presentation.components.StandardAppBar
import com.fifty.moviesapp.domain.model.GenreItem
import com.fifty.moviesapp.presentation.screens.home.components.AutoSlidingCarousal
import com.fifty.moviesapp.presentation.screens.home.components.DashboardGreetingText
import com.fifty.moviesapp.presentation.screens.home.components.GenresItem
import com.fifty.moviesapp.presentation.ui.theme.SizeMedium

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    imageLoader: ImageLoader
) {
    // Pending - Move to ViewModel
    val isSelectedValue = remember {
        mutableIntStateOf(0)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StandardAppBar(
            title = {
                // Greeting Text
                DashboardGreetingText(
                    text = stringResource(id = R.string.there)
                )
            },
            navActions = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = stringResource(R.string.search_movies_or_shows),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(SizeMedium))

        // Sliding Banners
        AutoSlidingCarousal(
            imageLoader = imageLoader
        )
        Spacer(modifier = Modifier.height(SizeMedium))

        // Genres List
        LazyRow(
            contentPadding = PaddingValues(SizeMedium),
            horizontalArrangement = Arrangement.spacedBy(SizeMedium)
        ) {
            items(10) {
                GenresItem(
                    item = GenreItem(it, ""),
                    isSelected = it == isSelectedValue.intValue,
                    onClick = { itemId ->
                        isSelectedValue.intValue = itemId
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(SizeMedium))
    }
}

