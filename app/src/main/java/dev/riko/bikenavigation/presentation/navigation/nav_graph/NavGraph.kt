package dev.riko.bikenavigation.presentation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.riko.bikenavigation.presentation.features.google_maps.MapsScreen
import dev.riko.bikenavigation.presentation.navigation.Screen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MapsScreen.route) {
        composable(route = Screen.MapsScreen.route) {
            MapsScreen()
        }
    }
}