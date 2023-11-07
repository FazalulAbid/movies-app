package com.fifty.moviesapp.screens.commons

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.fifty.moviesapp.R
import com.fifty.moviesapp.domain.model.BottomNavItem
import com.fifty.moviesapp.presentation.utils.Screen

@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBottomBar(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    showBottomBar: Boolean = true
) {
    val bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            title = stringResource(R.string.home),
            selectedIcon = painterResource(id = R.drawable.ic_home_filled),
            unselectedIcon = painterResource(id = R.drawable.ic_home),
            contentDescription = null,
            hasNews = false
        ),
        BottomNavItem(
            route = Screen.HomeScreen.route,
            title = stringResource(R.string.home),
            selectedIcon = painterResource(id = R.drawable.ic_favorite_filled),
            unselectedIcon = painterResource(id = R.drawable.ic_favorite),
            contentDescription = null,
            hasNews = false
        ),
        BottomNavItem(
            route = Screen.HomeScreen.route,
            title = stringResource(R.string.home),
            selectedIcon = painterResource(id = R.drawable.ic_person_filled),
            unselectedIcon = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            hasNews = false
        ),
    )
    val selectedItemIndex = rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(
        containerColor = Color.Transparent
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex.value == index,
                onClick = {
                    selectedItemIndex.value = index
                    onNavigate(item.route, navOptions {
                        popUpTo(Screen.HomeScreen.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    })
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = if (index == selectedItemIndex.value) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}