package com.relsellglobal.kotlinloginjpc

sealed class Routes(val route:String) {
    object Login : Routes("Login")
    object Signup : Routes("Signup")
}