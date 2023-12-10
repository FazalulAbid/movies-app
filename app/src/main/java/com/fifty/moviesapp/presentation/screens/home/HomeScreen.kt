package com.fifty.moviesapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState
import com.fifty.moviesapp.domain.model.GenreItem
import com.fifty.moviesapp.presentation.screens.favorites.Favorites
import com.fifty.moviesapp.presentation.screens.home.components.AutoSlidingCarousal
import com.fifty.moviesapp.presentation.screens.home.components.GenresItem
import com.fifty.moviesapp.presentation.screens.home.components.TrendingMoviesSection
import com.fifty.moviesapp.presentation.ui.theme.SizeStandard16
import com.fifty.moviesapp.presentation.ui.theme.StandardScreenPadding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    imageLoader: ImageLoader,
    appBarState: AppBarState,
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit
) {
    appBarState.setActionBarTitle("Hey, There!\uD83D\uDC4B")
    val screen = appBarState.currentScreen as? Home
    LaunchedEffect(key1 = screen) {
        screen?.buttons?.onEach { button ->
            when (button) {
                Home.AppBarIcons.Search -> onNavigate(Favorites.route)
            }
        }?.launchIn(this)
    }

    // Pending - Move to ViewModel
    val isSelectedValue = remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(SizeStandard16))

        // Sliding Banners
        AutoSlidingCarousal(
            imageLoader = imageLoader
        )
        Spacer(modifier = Modifier.height(SizeStandard16))

        // Genres List
        LazyRow(
            contentPadding = PaddingValues(StandardScreenPadding),
            horizontalArrangement = Arrangement.spacedBy(SizeStandard16)
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

        //Trending Movies
        TrendingMoviesSection(
            imageLoader = imageLoader
        )
    }
}

