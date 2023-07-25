package com.dexciuq.rickandmortyapp.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dexciuq.rickandmortyapp.presentation.navigation.BottomNavigationScreen
import com.dexciuq.rickandmortyapp.presentation.navigation.Graph
import com.dexciuq.rickandmortyapp.presentation.navigation.Screen
import com.dexciuq.rickandmortyapp.presentation.navigation.bottomNavGraph

@Preview(showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(Screen.Home, Screen.About)
    Scaffold(
        bottomBar = {
            BottomNavigationBar(items, navController) {
                navController.navigate(it.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Graph.BottomNavGraph.route,
            modifier = Modifier.padding(it)
        ) {
            bottomNavGraph(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationScreen>,
    navController: NavController,
    onClick: (BottomNavigationScreen) -> Unit,
) {
    NavigationBar(
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
            )
            clip = true
        },
        contentColor = Color.DarkGray,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(screen.icon),
                        stringResource(screen.title),
                    )
                },
                label = {
                    Text(
                        stringResource(screen.title),
                        fontSize = 14.sp,
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.LightGray
                ),
                onClick = { onClick(screen) },
            )
        }
    }
}