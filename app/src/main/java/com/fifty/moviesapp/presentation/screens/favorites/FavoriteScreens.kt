package com.fifty.moviesapp.presentation.screens.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun FavoriteScreen(
    paddingValues: PaddingValues,
    imageLoader: ImageLoader,
    appBarState: AppBarState,
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        Favorites.buttons
            .onEach { button ->
                when (button) {
                    Favorites.AppBarIcons.NavigationIcon -> Unit
                }
            }
            .launchIn(this)
    }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Favorite Screen Content"
        )
    }
}