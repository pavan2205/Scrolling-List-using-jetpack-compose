package com.example.avengers

sealed class Screen(val route:String){
    object Home:Screen(route="home_screen")
    object Description:Screen(route="description_screen")
}
