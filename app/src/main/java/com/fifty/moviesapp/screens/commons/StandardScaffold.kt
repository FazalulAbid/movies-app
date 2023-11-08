package com.fifty.moviesapp.screens.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = Color.Transparent
                ) {
                    StandardBottomBar(
                        onNavigate = onNavigate,
                        navBackStackEntry = navBackStackEntry
                    )
                }
            }
        }
    ) {
        content(it)
    }
}