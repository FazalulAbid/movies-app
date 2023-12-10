package com.fifty.moviesapp.core_framework.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.fifty.moviesapp.core_framework.presentation.utils.topappbar.rememberAppBarState
import com.fifty.moviesapp.core_framework.util.Constants.SPLASHSCREEN_DELAY
import com.fifty.moviesapp.presentation.components.StandardScaffold
import com.fifty.moviesapp.presentation.navigation.Navigation
import com.fifty.moviesapp.presentation.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

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
                    val snackBarHostState = remember { SnackbarHostState() }
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val appBarState = rememberAppBarState(navController)

                    StandardScaffold(
                        onNavigate = navController::navigate,
                        navBackStackEntry = navBackStackEntry,
                        snackbarHostState = snackBarHostState,
                        appBarState = appBarState
                    ) { paddingValues ->
                        Navigation(
                            navController = navController,
                            paddingValues = paddingValues,
                            imageLoader = imageLoader,
                            appBarState = appBarState,
                            snackbarHostState = snackBarHostState
                        )
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