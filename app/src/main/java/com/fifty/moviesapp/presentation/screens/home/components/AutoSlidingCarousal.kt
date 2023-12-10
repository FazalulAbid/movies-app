package com.fifty.moviesapp.presentation.screens.home.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.fifty.moviesapp.domain.model.Movie
import com.fifty.moviesapp.domain.model.moviesList
import com.fifty.moviesapp.presentation.ui.theme.SizeGigantic56
import com.fifty.moviesapp.presentation.ui.theme.SizeStandard16
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoSlidingCarousal(
    modifier: Modifier = Modifier,
    movies: List<Movie> = moviesList,
    imageLoader: ImageLoader,
    pageChangeDelay: Long = 2000,
    animationDuration: Int = 600,
    cardElevation: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = SizeGigantic56),
    aspectRatio: Float = 1.77f,
    cornerRadius: CornerBasedShape = MaterialTheme.shapes.large,
) {
    val pagerState = rememberPagerState(
        pageCount = { movies.size }, initialPage = 2, initialPageOffsetFraction = 0.5f
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(pageChangeDelay)
            if (pagerState.pageCount > 1) {
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                    animationSpec = tween(animationDuration)
                )
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides null
        ) {
            HorizontalPager(
                state = pagerState,
                contentPadding = contentPadding,
                verticalAlignment = Alignment.Top,
                modifier = modifier
                    .fillMaxWidth()
            ) { page ->
                val pageOffset = (pagerState.currentPage - page) +
                        pagerState.currentPageOffsetFraction
                val scaleFactor = 0.85f + 0.15f * (1 - pageOffset.absoluteValue)
                Card(
                    modifier = Modifier
                        .aspectRatio(aspectRatio)
                        .graphicsLayer {
                            scaleX = scaleFactor
                            scaleY = scaleFactor
                        }
                        .clip(cornerRadius),
                    elevation = CardDefaults.cardElevation(cardElevation)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        val movie = movies.getOrNull(page)
                        Image(
                            painter = rememberImagePainter(
                                data = movie?.imageUrl, imageLoader = imageLoader
                            ),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

