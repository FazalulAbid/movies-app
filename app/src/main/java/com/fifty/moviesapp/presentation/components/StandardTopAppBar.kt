package com.fifty.moviesapp.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.ActionsMenu
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.AppBarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardAppBar(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.background,
    titleColor: Color = MaterialTheme.colorScheme.onBackground,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    appBarState: AppBarState,
) {
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
        ),
        navigationIcon = {
            val icon = appBarState.navigationIcon
            val callback = appBarState.onNavigationIconClick
            if (icon != null) {
                IconButton(onClick = { callback?.invoke() }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = appBarState.navigationIconContentDescription
                    )
                }
            }
        },
        title = {
            val title = appBarState.title
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    style = titleStyle.copy(
                        color = titleColor
                    )
                )
            }
        },
        actions = {
            val items = appBarState.actions
            if (items.isNotEmpty()) {
                ActionsMenu(
                    items = items,
                    isOpen = menuExpanded,
                    onToggleOverflow = { menuExpanded = !menuExpanded },
                    maxVisibleItems = 3,
                )
            }
        },
        modifier = modifier
    )
}