package com.fifty.moviesapp.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState

@Composable
fun StandardScaffold(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    snackbarHostState: SnackbarHostState,
    showBottomBar: Boolean = true,
    appBarState: AppBarState,
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            StandardAppBar(
                modifier = Modifier.fillMaxWidth(),
                appBarState = appBarState
            )
        },
        bottomBar = {
            StandardBottomBar(
                onNavigate = onNavigate,
                navBackStackEntry = navBackStackEntry,
                showBottomBar = showBottomBar
            )
        }
    ) {
        GradientBox {
            content(it)
        }
    }
}