package com.example.travelsupport.module.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ailandmarkrecognition.model.LocationDetailViewModel
import com.example.travelsupport.module.screen.accountscreen.AccountScreenNotLogin
import com.example.travelsupport.module.screen.FavoriteScreen
import com.example.travelsupport.module.screen.homescreen.HomeScreen
import com.example.travelsupport.module.screen.PlanScreen
import com.example.travelsupport.module.screen.homescreen.HotelSearchScreen
import com.example.travelsupport.module.screen.homescreen.LocationDetailScreen
import com.example.travelsupport.module.screen.homescreen.LocationSearchScreen
import com.example.travelsupport.module.screen.homescreen.locationmodel.LocationViewModel
import com.example.travelsupport.module.screen.homescreen.RestaurantSearchScreen
import com.example.travelsupport.module.screen.homescreen.locationmodel.SelectedLocationModel
import com.example.travelsupport.module.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = "splash_screen",
        ){
        composable(route = Screens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(route = Screens.FavoriteScreen.name){
            FavoriteScreen(navController)
        }
        composable(route = Screens.PlanScreen.name){
            PlanScreen(navController)
        }
        composable(route = Screens.AccountScreen.name){
            AccountScreenNotLogin(navController)
        }
        composable("splash_screen"){
            SplashScreen(navController)
        }
        composable("restaurant_search_screen"){
            RestaurantSearchScreen(navController, LocationViewModel())
        }
        composable("location_search_screen"){
            LocationSearchScreen(navController, LocationViewModel())
        }
        composable("hotel_search_screen"){
            HotelSearchScreen(navController, LocationViewModel())
        }
        composable("location_detail_screen/{id}"){it->
            val id = it.arguments?.getString("id")
            LocationDetailScreen(navController, LocationDetailViewModel(),id)
            }
        composable("explore_screen"){

        }
        }
}