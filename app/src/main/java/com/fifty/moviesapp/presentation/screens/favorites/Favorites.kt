package com.fifty.moviesapp.presentation.screens.favorites

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.ActionMenuItem
import com.fifty.moviesapp.presentation.utils.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

const val FavoritesRoute = "favorite"

object Favorites : Screen {
    override val route: String = FavoritesRoute
    override val isAppBarVisible: Boolean = true
    override val navigationIcon: ImageVector = Icons.Default.ArrowBack
    override val onNavigationIconClick: () -> Unit = {
        _buttons.tryEmit(AppBarIcons.NavigationIcon)
    }
    override val navigationIconContentDescription: String? = null
    override val title: String = "Favorites"
    override val actions: List<ActionMenuItem> = emptyList()

    enum class AppBarIcons {
        NavigationIcon
    }

    private val _buttons = MutableSharedFlow<AppBarIcons>(extraBufferCapacity = 1)
    val buttons: Flow<AppBarIcons> = _buttons.asSharedFlow()
}