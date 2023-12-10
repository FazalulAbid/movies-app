package com.fifty.moviesapp.core_framework.presentation.utils.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.fifty.moviesapp.R

@Composable
fun ActionsMenu(
    items: List<ActionMenuItem>,
    isOpen: Boolean,
    onToggleOverflow: () -> Unit,
    maxVisibleItems: Int,
) {
    val menuItems = remember(
        key1 = items,
        key2 = maxVisibleItems,
    ) {
        splitMenuItems(items, maxVisibleItems)
    }

    menuItems.alwaysShownItems.forEach { item ->
        IconButton(onClick = item.onClick) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.contentDescription,
            )
        }
    }

    if (menuItems.overflowItems.isNotEmpty()) {
        IconButton(onClick = onToggleOverflow) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource(id = R.string.accessibility_overflow),
            )
        }
        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = onToggleOverflow,
        ) {
            menuItems.overflowItems.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(item.title)
                    },
                    onClick = item.onClick
                )
            }
        }
    }
}