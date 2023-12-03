package com.fifty.moviesapp.presentation.screens.commons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions

@Composable
fun StandardScaffold(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    showBottomBar: Boolean = true,
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(
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