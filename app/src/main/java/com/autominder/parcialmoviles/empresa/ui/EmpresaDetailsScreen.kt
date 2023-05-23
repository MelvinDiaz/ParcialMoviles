package com.autominder.parcialmoviles.empresa.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.autominder.parcialmoviles.model.EmpresaDataModel

@Composable
fun EmpresaDetailsScreen(
    navController: NavController,
    viewModel: EmpresaViewModel,
    empresa: EmpresaDataModel
) {

    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Nombre de la empresa = ${empresa.name}")
        Text(text = "Sector de la empresa = ${empresa.sector}")
    }
}