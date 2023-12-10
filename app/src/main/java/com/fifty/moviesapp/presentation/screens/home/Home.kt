package com.fifty.moviesapp.presentation.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.ActionMenuItem
import com.fifty.moviesapp.presentation.utils.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

const val HomeRoute = "home"

object Home : Screen {
    enum class AppBarIcons {
        Search
    }

    private val _buttons = MutableSharedFlow<AppBarIcons>(extraBufferCapacity = 1)
    val buttons: Flow<AppBarIcons> = _buttons.asSharedFlow()

    override val route: String = HomeRoute
    override val isAppBarVisible: Boolean = true
    override val navigationIcon: ImageVector? = null
    override val onNavigationIconClick: (() -> Unit)? = null
    override val navigationIconContentDescription: String? = null
    override val title: String = "Home"
    override val actions: List<ActionMenuItem> = listOf(
        ActionMenuItem.IconMenuItem.AlwaysShown(
            title = "Search",
            onClick = {
                _buttons.tryEmit(AppBarIcons.Search)
            },
            icon = Icons.Filled.Settings,
            contentDescription = null,
        )
    )
}