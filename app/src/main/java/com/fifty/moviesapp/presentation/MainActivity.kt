package com.fifty.moviesapp.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fifty.moviesapp.core_framework.utils.Constants.SPLASHSCREEN_DELAY
import com.fifty.moviesapp.presentation.navigation.Navigation
import com.fifty.moviesapp.presentation.screens.commons.StandardScaffold
import com.fifty.moviesapp.presentation.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initializeSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        onNavigate = navController::navigate,
                        navBackStackEntry = navBackStackEntry
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