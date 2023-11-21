package com.apolisb42.mviwithhomescreen.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.apolisb42.mviwithhomescreen.view.NavRoutes.ADD_SCREEN
import com.apolisb42.mviwithhomescreen.view.NavRoutes.HOME_SCREEN
import com.apolisb42.mviwithhomescreen.viewmodel.AddScreenViewModel
import com.apolisb42.mviwithhomescreen.viewmodel.HomeViewModel
import androidx.navigation.NavHost as NavHost1

@Composable
fun Navigation(startDestination:String = HOME_SCREEN, viewModel: AddScreenViewModel, viewModel1: HomeViewModel){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = ADD_SCREEN){
            AddScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = HOME_SCREEN){
            HomeScreen(viewModel = viewModel1, navController = navController)
        }
    }
}
object NavRoutes{
    const val ADD_SCREEN = "AddScreen"
    const val HOME_SCREEN = "HomeScreen"
}