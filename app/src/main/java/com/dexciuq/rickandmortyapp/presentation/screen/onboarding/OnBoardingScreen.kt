package com.dexciuq.rickandmortyapp.presentation.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dexciuq.rickandmortyapp.presentation.navigation.Graph
import com.dexciuq.rickandmortyapp.presentation.navigation.Screen

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun OnBoardingScreen(navHostController: NavHostController) {
//    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
//        HorizontalPager(
//            modifier = Modifier.padding(vertical = 16.dp),
//            pageCount = 3,
//            state = pagerState
//        ) {
//            Text(
//                text = "Page: $it",
//            )
//        }
        Button(
            onClick = {
                navHostController.navigate(Screen.Main.route) {
                    popUpTo(Graph.NavGraph.route)
                }
            }
        ) {
            Text(text = "Next")
        }
    }
}