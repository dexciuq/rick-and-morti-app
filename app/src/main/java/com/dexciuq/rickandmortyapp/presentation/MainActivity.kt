package com.dexciuq.rickandmortyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dexciuq.rickandmortyapp.presentation.navigation.Graph
import com.dexciuq.rickandmortyapp.presentation.navigation.navGraph
import com.dexciuq.rickandmortyapp.presentation.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Graph.NavGraph.route) {
                    navGraph(navController)
                }
            }
        }
    }
}