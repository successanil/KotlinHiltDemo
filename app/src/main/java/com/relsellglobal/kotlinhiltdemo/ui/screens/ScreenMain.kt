package com.relsellglobal.kotlinhiltdemo.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.relsellglobal.kotlinloginjpc.Routes
import com.relsellglobal.kotlinloginjpc.screens.LoginPage
import com.relsellglobal.kotlinloginjpc.screens.SignupPage

@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Routes.Signup.route) {
            SignupPage(navController = navController)
        }
    }
}
