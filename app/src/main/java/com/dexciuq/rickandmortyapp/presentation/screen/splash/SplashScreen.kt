package com.dexciuq.rickandmortyapp.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.dexciuq.rickandmortyapp.R
import com.dexciuq.rickandmortyapp.presentation.navigation.Graph
import com.dexciuq.rickandmortyapp.presentation.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(1500)
        navHostController.navigate(Screen.Main.route) {
            popUpTo(Graph.NavGraph.route)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo"
        )
    }
}