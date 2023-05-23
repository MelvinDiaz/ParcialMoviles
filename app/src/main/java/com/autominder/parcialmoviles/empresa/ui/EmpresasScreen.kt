package com.autominder.parcialmoviles.empresa.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.autominder.parcialmoviles.components.FloatingAddButton

@Composable
fun EmpresasScreen(
    navController: NavController,
    empresaViewModel: EmpresaViewModel
) {
    Scaffold(
        floatingActionButton = { FloatingAddButton(navController) }
    ) {
        Box(modifier = Modifier.padding(it)){
            MainEmpresaScreen(empresaViewModel, navController)
        }
    }
}

@Composable
fun MainEmpresaScreen(viewModel: EmpresaViewModel, navController: NavController){
    val empresaListState = viewModel.empresaList.collectAsState()


}