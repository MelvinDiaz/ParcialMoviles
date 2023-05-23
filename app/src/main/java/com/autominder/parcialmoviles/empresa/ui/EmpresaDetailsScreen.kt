package com.autominder.parcialmoviles.empresa.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Informacion de la empresa: ",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(text = "Nombre de la empresa = ${empresa.name}", modifier = Modifier.padding(8.dp))
        Text(text = "Sector de la empresa = ${empresa.sector}", modifier = Modifier.padding(8.dp))
    }
}