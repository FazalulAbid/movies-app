package com.fifty.moviesapp.presentation.screens.commons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    showBottomBar: Boolean = true,
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
                 TopAppBar(title = { Text(text = "Hello") })
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