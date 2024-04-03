package org.d3if3051.assessmen1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if3051.assessmen1.ui.screen.AppScreen
import org.d3if3051.assessmen1.ui.screen.FirstScreen
import org.d3if3051.assessmen1.ui.screen.HistoryScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = ScreenApp.Home.route
    ){
        composable(route = ScreenApp.Home.route){
            FirstScreen(navController)
        }
        composable(route = ScreenApp.Content.route){
            AppScreen(navController)
        }
        composable(route = ScreenApp.List.route){
            HistoryScreen(navController)
        }
    }
}