package com.fifty.moviesapp.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val route: String,
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val contentDescription: String? = null,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)