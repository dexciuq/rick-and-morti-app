package com.dexciuq.rickandmortyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dexciuq.rickandmortyapp.presentation.navigation.Screen
import com.dexciuq.rickandmortyapp.presentation.screen.main.MainScreen
import com.dexciuq.rickandmortyapp.presentation.screen.splash.SplashScreen
import com.dexciuq.rickandmortyapp.presentation.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Splash.route) {
                    composable(Screen.Splash.route) { SplashScreen(navController) }
                    composable(Screen.Main.route) { MainScreen(navController) }
                }
            }
        }
    }
}