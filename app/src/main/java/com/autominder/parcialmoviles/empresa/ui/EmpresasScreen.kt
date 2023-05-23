package com.autominder.parcialmoviles.empresa.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.autominder.parcialmoviles.components.FloatingAddButton
import com.autominder.parcialmoviles.model.EmpresaDataModel

@Composable
fun EmpresasScreen(
    navController: NavController,
    empresaViewModel: EmpresaViewModel
) {
    Scaffold(
        floatingActionButton = { FloatingAddButton(navController) }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            MainEmpresaScreen(empresaViewModel, navController)
        }
    }
}

@Composable
fun MainEmpresaScreen(viewModel: EmpresaViewModel, navController: NavController) {
    val empresaListState = viewModel.empresaList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        if (empresaListState.value.isEmpty()) {
            item {
                Text(text = "No hay empresas")
            }
        } else {
            items(empresaListState.value) {
                EmpresaCard(it, navController)
            }
        }
    }
}

@Composable
fun EmpresaCard(empresa: EmpresaDataModel, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(280.dp)
            .height(50.dp),
        shape = MaterialTheme.shapes.small,
        onClick = {
            navController.navigate("empresa_details_screen/${empresa.id}")
        },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = "Nombre de la empresa: ${empresa.name}}",
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}