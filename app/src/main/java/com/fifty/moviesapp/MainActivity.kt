package com.fifty.moviesapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.fifty.moviesapp.presentation.navigation.Navigation
import com.fifty.moviesapp.screens.commons.StandardScaffold
import com.fifty.moviesapp.ui.theme.MoviesAppTheme
import com.fifty.moviesapp.utils.Constants.SPLASHSCREEN_DELAY

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initializeSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    StandardScaffold(
                        onNavigate = navController::navigate,
                        navBackStackEntry = navController.currentBackStackEntry
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }

    private fun initializeSplashScreen() {
        var keepSplashOnScreen = true
        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed(
            { keepSplashOnScreen = false },
            SPLASHSCREEN_DELAY
        )
    }
}