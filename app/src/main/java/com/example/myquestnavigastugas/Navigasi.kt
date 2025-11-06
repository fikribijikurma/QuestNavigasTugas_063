package com.example.myquestnavigastugas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

num class PengelolaHalaman {
    Welcome,
    ListPeserta,
    Formulir
}
@Composable
fun Navigasiku(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = PengelolaHalaman.Welcome.name
    ){
        composable(route = PengelolaHalaman.Welcome.name) {
        }
        composable(route = PengelolaHalaman.ListPeserta.name) {
        }
        composable(route = PengelolaHalaman.Formulir.name) {
        }
    }
}
