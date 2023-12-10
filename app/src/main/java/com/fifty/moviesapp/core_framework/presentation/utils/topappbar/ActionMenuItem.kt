package com.fifty.moviesapp.core_framework.presentation.utils.topappbar

import androidx.compose.ui.graphics.vector.ImageVector

sealed interface ActionMenuItem {
    val title: String
    val onClick: () -> Unit

    sealed interface IconMenuItem : ActionMenuItem {
        val icon: ImageVector
        val contentDescription: String?

        data class AlwaysShown(
            override val title: String,
            override val contentDescription: String?,
            override val onClick: () -> Unit,
            override val icon: ImageVector,
        ) : IconMenuItem

        data class ShownIfRoom(
            override val title: String,
            override val contentDescription: String?,
            override val onClick: () -> Unit,
            override val icon: ImageVector,
        ) : IconMenuItem
    }

    data class NeverShown(
        override val title: String,
        override val onClick: () -> Unit,
    ) : ActionMenuItem
}