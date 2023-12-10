package com.fifty.moviesapp.domain.model

data class Movie(
    val movieId: Int,
    val movieName: String,
    val imageUrl: String
)

val moviesList = listOf(
    Movie(
        1,
        "Captain America Captain America ",
        "https://anniehaydesign.weebly.com/uploads/9/5/4/6/95469676/landscape-poster-3_orig.jpg"
    ),
    Movie(
        2,
        "Oblivion Captain America",
        "https://images.squarespace-cdn.com/content/v1/507b2f30e4b066e116488db6/1366581664395-1EOF0V8KL1COY6OENC67/Oblivion-Poster.jpg"
    ),
    Movie(
        3,
        "Live Die Repeat Captain America",
        "https://www.wallpaperflare.com/static/527/639/639/edge-of-tomorrow-tom-cruise-emily-blunt-movie-poster-wallpaper.jpg"
    )
)
