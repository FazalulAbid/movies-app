package com.fifty.moviesapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.fifty.moviesapp.presentation.screens.favorites.FavoriteScreen
import com.fifty.moviesapp.presentation.utils.Screen
import com.fifty.moviesapp.presentation.screens.home.HomeScreen
import com.fifty.moviesapp.presentation.screens.profile.ProfileScreen

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
    imageLoader: ImageLoader
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        enterTransition = { enterTransitionHorizontal },
        exitTransition = { exitTransitionHorizontal },
        popEnterTransition = { popEnterTransitionHorizontal },
        popExitTransition = { popExitTransitionHorizontal }
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(
                paddingValues = paddingValues,
                imageLoader = imageLoader
            )
        }
        composable(Screen.FavoriteScreen.route) {
            FavoriteScreen()
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}