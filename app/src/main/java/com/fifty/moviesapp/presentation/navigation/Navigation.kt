package com.fifty.moviesapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState
import com.fifty.moviesapp.presentation.screens.favorites.FavoriteScreen
import com.fifty.moviesapp.presentation.screens.favorites.Favorites
import com.fifty.moviesapp.presentation.screens.home.Home
import com.fifty.moviesapp.presentation.utils.Screen
import com.fifty.moviesapp.presentation.screens.home.HomeScreen
import com.fifty.moviesapp.presentation.screens.profile.Profile
import com.fifty.moviesapp.presentation.screens.profile.ProfileScreen

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
    imageLoader: ImageLoader,
    appBarState: AppBarState,
    snackbarHostState: SnackbarHostState
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        enterTransition = { enterTransitionHorizontal },
        exitTransition = { exitTransitionHorizontal },
        popEnterTransition = { popEnterTransitionHorizontal },
        popExitTransition = { popExitTransitionHorizontal }
    ) {
        composable(Home.route) {
            HomeScreen(
                imageLoader = imageLoader,
                paddingValues = paddingValues,
                appBarState = appBarState,
                onNavigate = navController::navigate
            )
        }
        composable(Favorites.route) {
            FavoriteScreen(
                imageLoader = imageLoader,
                paddingValues = paddingValues,
                appBarState = appBarState,
                onNavigate = navController::navigate
            )
        }
        composable(Profile.route) {
            ProfileScreen(
                imageLoader = imageLoader,
                paddingValues = paddingValues,
                appBarState = appBarState,
                onNavigate = navController::navigate,
                snackbarHostState = snackbarHostState
            )
        }
    }
}