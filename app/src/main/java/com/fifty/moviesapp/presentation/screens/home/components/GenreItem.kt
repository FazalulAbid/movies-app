package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.times
import com.fifty.moviesapp.domain.model.GenreItem
import com.fifty.moviesapp.presentation.ui.theme.SizeExtraSmall
import com.fifty.moviesapp.presentation.ui.theme.SizeMedium
import com.fifty.moviesapp.presentation.ui.theme.SizeSmall

@Composable
fun GenresItem(
    modifier: Modifier = Modifier,
    item: GenreItem,
    isSelected: Boolean,
    colorSelected: Color = MaterialTheme.colorScheme.primary,
    selectedTextColor: Color = MaterialTheme.colorScheme.background,
    unselectedTextColor: Color = MaterialTheme.colorScheme.onBackground,
    selectedBoxColor: Color = MaterialTheme.colorScheme.secondary,
    animationDuration: Int = 300,
    onClick: (Int) -> Unit
) {
    val animatedSelectedCircleColor: Color by animateColorAsState(
        if (isSelected) colorSelected else Color.Transparent,
        label = "",
        animationSpec = tween(animationDuration, easing = FastOutSlowInEasing)
    )
    val animatedSelectedBoxColor: Color by animateColorAsState(
        if (isSelected) selectedBoxColor else Color.Transparent,
        label = "",
        animationSpec = tween(animationDuration, easing = LinearEasing)
    )
    val animatedTextColor: Color by animateColorAsState(
        if (isSelected) selectedTextColor else unselectedTextColor,
        label = "",
        animationSpec = tween(animationDuration, easing = LinearEasing)
    )
    val lineLength = animateFloatAsState(
        targetValue = if (isSelected) 0.5f else 0f,
        animationSpec = tween(
            delayMillis = animationDuration,
            durationMillis = animationDuration
        ), label = ""
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(animatedSelectedBoxColor)
            .clickable { onClick(item.genreId) }
    ) {
        Box(
            modifier = Modifier
                .offset(x = -(SizeMedium - lineLength.value * SizeMedium))
                .background(
                    color = animatedSelectedCircleColor,
                    shape = MaterialTheme.shapes.medium
                )
                .size(SizeMedium)
        )
        Text(
            text = "Action",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                color = animatedTextColor,
            ),
            modifier = Modifier
                .padding(end = SizeMedium, top = SizeSmall, bottom = SizeSmall)
        )
    }
}