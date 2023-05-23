package com.autominder.parcialmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.autominder.parcialmoviles.empresa.ui.EmpresaDetailsScreen
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
    NavHost(navController = navController, startDestination = startDestination) {
        composable("empresas_screen") {
            EmpresasScreen(navController, empresaViewModel)
        }
        composable(
            "empresa_details_screen/{empresaId}",
            arguments = listOf(navArgument("empresaId") { type = NavType.IntType })
        ) {
            val empresaId = it.arguments?.getInt("empresaId")
            val empresa = empresaViewModel.getEmpresaById(empresaId!!)
            if (empresa != null) {
                EmpresaDetailsScreen(navController, empresaViewModel, empresa)
            }
        }
    }
}