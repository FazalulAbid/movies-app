package com.fifty.moviesapp.core_framework.presentation.utils.topappbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.fifty.moviesapp.presentation.utils.Screen
import com.fifty.moviesapp.presentation.utils.getScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Stable
class AppBarState(
    navController: NavController,
    scope: CoroutineScope,
) {
    init {
        navController.currentBackStackEntryFlow
            .distinctUntilChanged()
            .onEach { backStackEntry ->
                val route = backStackEntry.destination.route
                currentScreen = getScreen(route)
            }
            .launchIn(scope)
    }

    var currentScreen by mutableStateOf<Screen?>(null)
        private set

    var title by mutableStateOf("")
        private set

    val isVisible: Boolean
        @Composable get() = currentScreen?.isAppBarVisible == true

    val navigationIcon: ImageVector?
        @Composable get() = currentScreen?.navigationIcon

    val navigationIconContentDescription: String?
        @Composable get() = currentScreen?.navigationIconContentDescription

    val onNavigationIconClick: (() -> Unit)?
        @Composable get() = currentScreen?.onNavigationIconClick

    val actions: List<ActionMenuItem>
        @Composable get() = currentScreen?.actions.orEmpty()

    fun setActionBarTitle(newTitle: String) {
        title = newTitle
    }
}

@Composable
fun rememberAppBarState(
    navController: NavController,
    scope: CoroutineScope = rememberCoroutineScope(),
) = remember {
    AppBarState(
        navController,
        scope,
    )
}