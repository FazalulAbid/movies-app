package com.fifty.moviesapp.screens.commons

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.fifty.moviesapp.R
import com.fifty.moviesapp.domain.model.BottomNavItem
import com.fifty.moviesapp.presentation.utils.Screen
import com.fifty.moviesapp.ui.theme.SizeSmall

@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.StandardBottomBar(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    showBottomBar: Boolean = true,
    selectedColor: Color = MaterialTheme.colorScheme.primary
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
    bottomNavItems.forEachIndexed { index, item ->
        val selected = selectedItemIndex.value == index
        val lineLength = animateFloatAsState(
            targetValue = if (selected) 1f else 0f,
            animationSpec = tween(
                durationMillis = 300
            ), label = ""
        )
        NavigationBarItem(
            selected = selected,
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
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(SizeSmall)
                        .drawBehind {
                            if (lineLength.value > 0f) {
                                drawLine(
                                    color = selectedColor,
                                    start = Offset(
                                        size.width / 2f - lineLength.value * 5.dp.toPx(),
                                        size.height
                                    ),
                                    end = Offset(
                                        size.width / 2f + lineLength.value * 5.dp.toPx(),
                                        size.height
                                    ),
                                    strokeWidth = 4.dp.toPx(),
                                    cap = StrokeCap.Round
                                )
                            }
                        }
                ) {
                    val sizeInDp = animateDpAsState(
                        targetValue = if (selected) 32.dp else 24.dp,
                        animationSpec = tween(
                            durationMillis = 300
                        ), label = ""
                    )
                    Icon(
                        painter = if (index == selectedItemIndex.value) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        modifier = Modifier.size(sizeInDp.value)
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
        )
    }
}