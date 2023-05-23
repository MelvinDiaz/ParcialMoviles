package com.autominder.parcialmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.autominder.parcialmoviles.empresa.ui.EmpresaViewModel
import com.autominder.parcialmoviles.empresa.ui.EmpresasScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String = "empresas_screen",
    empresaViewModel: EmpresaViewModel = viewModel(
        factory = EmpresaViewModel.Factory
    )
) {
    NavHost(navController = navController, startDestination = startDestination){
        composable("empresas_screen"){
            EmpresasScreen(navController, empresaViewModel)
        }
    }
}