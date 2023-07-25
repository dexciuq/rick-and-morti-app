package com.dexciuq.rickandmortyapp.presentation.screen.about

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun AboutScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "About")
    }
}