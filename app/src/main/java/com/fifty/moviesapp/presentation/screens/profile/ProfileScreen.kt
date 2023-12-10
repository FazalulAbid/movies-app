package com.fifty.moviesapp.presentation.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues,
    imageLoader: ImageLoader,
    appBarState: AppBarState,
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onNavigate: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    var favoritesEnabled by remember { mutableStateOf(false) }
    fun showSnackbar(text: String) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = text
            )
        }
    }
    LaunchedEffect(key1 = Unit) {
        Profile
            .buttons
            .onEach { button ->
                when (button) {
                    Profile.AppBarIcons.NavigationIcon -> Unit
                    Profile.AppBarIcons.Search,
                    Profile.AppBarIcons.Star,
                    Profile.AppBarIcons.Refresh,
                    Profile.AppBarIcons.Settings,
                    Profile.AppBarIcons.About -> showSnackbar(
                        "Clicked on ${button.name}"
                    )

                    Profile.AppBarIcons.Favorite -> {
                        favoritesEnabled = !favoritesEnabled
                        Profile.setFavoriteIcon(
                            if (favoritesEnabled) Icons.Default.Favorite else Icons.Default.FavoriteBorder
                        )
                    }
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
            text = "Profile Screen Content"
        )
    }
}