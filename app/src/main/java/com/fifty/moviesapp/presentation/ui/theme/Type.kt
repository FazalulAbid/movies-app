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

    bodyMedium = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp
    ),

    bodySmall = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Display
    displayLarge = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = -0.2.sp
    ),

    displayMedium = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.0.sp
    ),

    displaySmall = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.0.sp
    ),

    // Headline
    headlineLarge = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.0.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.0.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.0.sp
    ),

    // Label
    labelLarge = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    labelMedium = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    labelSmall = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    // Title
    titleLarge = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp, // 22 Default
        lineHeight = 28.sp,
        letterSpacing = 0.0.sp
    ),

    titleMedium = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),

    titleSmall = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)