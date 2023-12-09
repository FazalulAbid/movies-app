package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.fifty.moviesapp.domain.model.moviesList
import com.fifty.moviesapp.presentation.ui.theme.SizeSmall8
import com.fifty.moviesapp.presentation.ui.theme.VerticalCardHeight
import com.fifty.moviesapp.presentation.ui.theme.VerticalCardWidth

@Composable
fun VerticalGradientCard(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    title: String,
    showTitle: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    height: Dp = VerticalCardHeight,
    width: Dp = VerticalCardWidth,
    imageLoader: ImageLoader,
    maxLines: Int = 2,
    cornerRadius: CornerBasedShape = MaterialTheme.shapes.medium
) {
    Column(
        modifier = modifier
            .width(width)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(cornerRadius),
            painter = rememberImagePainter(
                data = moviesList.random().imageUrl,
                imageLoader = imageLoader
            ),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
        if (showTitle) {
            Spacer(modifier = Modifier.height(SizeSmall8))
            Text(
                text = moviesList.random().movieName,
                style = textStyle.copy(
                    color = textColor
                ),
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}