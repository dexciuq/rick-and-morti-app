package com.dexciuq.rickandmortyapp.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Home")
    }
}