package com.fifty.moviesapp.presentation.screens.commons

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.fifty.moviesapp.R
import com.fifty.moviesapp.domain.model.BottomNavItem
import com.fifty.moviesapp.presentation.utils.NoRippleInteractionSource
import com.fifty.moviesapp.presentation.utils.Screen
import com.fifty.moviesapp.presentation.ui.theme.SizeSmall

@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBottomBar(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?,
    showBottomBar: Boolean = true,
    selectedColor: Color = MaterialTheme.colorScheme.primary
) {
    val context = LocalContext.current
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
            route = Screen.FavoriteScreen.route,
            title = stringResource(R.string.favorite),
            selectedIcon = painterResource(id = R.drawable.ic_favorite_filled),
            unselectedIcon = painterResource(id = R.drawable.ic_favorite),
            contentDescription = null,
            hasNews = false
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            title = stringResource(R.string.profile),
            selectedIcon = painterResource(id = R.drawable.ic_person_filled),
            unselectedIcon = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            hasNews = false
        ),
    )

    val selectedItemIndex = remember { mutableStateOf(0) }
    val parentRouteName = navBackStackEntry?.destination?.route
    if (showBottomBar) {
        NavigationBar(containerColor = Color.Transparent) {
            bottomNavItems.forEachIndexed { index, item ->
                val isSelected = parentRouteName == item.route
                val lineLength = animateFloatAsState(
                    targetValue = if (isSelected) 1f else 0f,
                    animationSpec = tween(
                        durationMillis = 300
                    ), label = ""
                )
                NavigationBarItem(
                    interactionSource = NoRippleInteractionSource(),
                    selected = isSelected,
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
                                targetValue = if (isSelected) 32.dp else 24.dp,
                                animationSpec = tween(
                                    durationMillis = 300
                                ), label = ""
                            )
                            Icon(
                                painter = if (isSelected) {
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
    }
}