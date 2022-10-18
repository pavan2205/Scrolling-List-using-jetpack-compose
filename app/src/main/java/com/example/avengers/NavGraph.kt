package com.example.avengers

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(navController:NavHostController){
    NavHost(navController = navController, startDestination = "home_screen" ){
        composable(
            route="home_screen"
        ){
            HomeScreen(modifier = Modifier,navController=navController)
        }
        composable(
            route = "description_screen",
            arguments = listOf(
                navArgument("name"){
                    type=NavType.StringType
                },
                navArgument("desc"){
                    type=NavType.StringType
                },
                navArgument("image"){
                    type=NavType.IntType
                }
            )

        ){
            Log.d("Args",it.arguments?.getString("name").toString())
            Log.d("Args",it.arguments?.getString("desc").toString())
            DescriptionScreen(it.arguments?.getString("name").toString(),it.arguments?.getString("desc").toString(),it.arguments?.getInt("image").toString())
        }
    }
}