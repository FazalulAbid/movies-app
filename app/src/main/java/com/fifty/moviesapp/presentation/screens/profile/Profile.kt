package com.fifty.moviesapp.presentation.screens.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.ActionMenuItem
import com.fifty.moviesapp.presentation.utils.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

const val ProfileRoute = "profile"

object Profile : Screen {
    override val route: String = ProfileRoute
    override val isAppBarVisible: Boolean = true
    override val navigationIcon: ImageVector = Icons.Default.ArrowBack
    override val onNavigationIconClick: () -> Unit = {
        _buttons.tryEmit(AppBarIcons.NavigationIcon)
    }
    override val navigationIconContentDescription: String? = null
    override val title: String = "Many Options"

    private var _favoriteIcon by mutableStateOf<ImageVector>(Icons.Default.FavoriteBorder)
    override val actions: List<ActionMenuItem> by derivedStateOf {
        listOf(
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Search",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.Search)
                },
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Favorite",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.Favorite)
                },
                // 3
                icon = _favoriteIcon,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Star",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.Star)
                },
                icon = Icons.Filled.Star,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Refresh",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.Refresh)
                },
                icon = Icons.Filled.Refresh,
                contentDescription = null,
            ),
            ActionMenuItem.NeverShown(
                title = "Settings",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.Settings)
                },
            ),
            ActionMenuItem.NeverShown(
                title = "About",
                onClick = {
                    _buttons.tryEmit(AppBarIcons.About)
                },
            ),
        )
    }

    fun setFavoriteIcon(icon: ImageVector) {
        _favoriteIcon = icon
    }

    enum class AppBarIcons {
        NavigationIcon,
        Search,
        Favorite,
        Star,
        Refresh,
        Settings,
        About,
    }

    private val _buttons = MutableSharedFlow<AppBarIcons>(extraBufferCapacity = 1)
    val buttons: Flow<AppBarIcons> = _buttons.asSharedFlow()
}