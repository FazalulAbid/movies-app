package com.fifty.moviesapp.presentation.utils

import androidx.compose.ui.graphics.vector.ImageVector
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.ActionMenuItem
import com.fifty.moviesapp.presentation.screens.favorites.Favorites
import com.fifty.moviesapp.presentation.screens.favorites.FavoritesRoute
import com.fifty.moviesapp.presentation.screens.home.Home
import com.fifty.moviesapp.presentation.screens.home.HomeRoute
import com.fifty.moviesapp.presentation.screens.profile.Profile
import com.fifty.moviesapp.presentation.screens.profile.ProfileRoute

interface Screen {
    val route: String
    val isAppBarVisible: Boolean
    val navigationIcon: ImageVector?
    val navigationIconContentDescription: String?
    val onNavigationIconClick: (() -> Unit)?
    val title: String
    val actions: List<ActionMenuItem>
}

fun getScreen(route: String?): Screen? = when (route) {
    HomeRoute -> Home
    FavoritesRoute -> Favorites
    ProfileRoute -> Profile
    else -> null
}