package com.dexciuq.rickandmortyapp.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.dexciuq.rickandmortyapp.R

@Composable
fun SplashScreen(navHostController: NavHostController) {
    val isOnBoardingShown =
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo"
        )
    }
}