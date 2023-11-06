package com.fifty.moviesapp.presentation.utils

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
}
