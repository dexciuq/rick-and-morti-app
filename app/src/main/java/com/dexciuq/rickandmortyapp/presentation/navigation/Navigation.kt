package com.dexciuq.rickandmortyapp.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dexciuq.rickandmortyapp.R
import com.dexciuq.rickandmortyapp.presentation.screen.about.AboutScreen
import com.dexciuq.rickandmortyapp.presentation.screen.home.HomeScreen
import com.dexciuq.rickandmortyapp.presentation.screen.main.MainScreen
import com.dexciuq.rickandmortyapp.presentation.screen.onboarding.OnBoardingScreen
import com.dexciuq.rickandmortyapp.presentation.screen.splash.SplashScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object OnBoarding : Screen("on_boarding")
    object Main : Screen("main")
    object Home : BottomNavigationScreen(R.string.home, R.drawable.ic_home, "home")
    object About : BottomNavigationScreen(R.string.about, R.drawable.ic_about, "about")
}

sealed class BottomNavigationScreen(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    route: String
) : Screen(route)

sealed class Graph(val route: String) {
    object NavGraph: Graph("nav_graph")
    object BottomNavGraph : Graph("bottom_nav_graph")
}

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = Graph.BottomNavGraph.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.About.route) { AboutScreen() }
    }
}

fun NavGraphBuilder.navGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Splash.route,
        route = Graph.NavGraph.route
    ) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.OnBoarding.route) { OnBoardingScreen(navController) }
        composable(Screen.Main.route) { MainScreen() }
    }
}