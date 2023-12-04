package com.fifty.moviesapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fifty.moviesapp.R

val circularStd = FontFamily(
    Font(R.font.circular_std_book, FontWeight.Normal),
    Font(R.font.circular_std_medium, FontWeight.Medium),
    Font(R.font.circular_std_bold, FontWeight.Bold),
    Font(R.font.circular_std_black, FontWeight.Black)
)

// Set of Material typography styles to start with
val Typography = Typography(
    // Body
    bodyLarge = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Title
    titleLarge = TextStyle(
        fontFamily = circularStd,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold
    )
)