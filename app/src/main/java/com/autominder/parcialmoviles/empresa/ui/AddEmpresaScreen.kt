package com.autominder.parcialmoviles.empresa.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.autominder.parcialmoviles.model.EmpresaDataModel

@Composable
fun AddEmpresaScreen(viewModel: EmpresaViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        AddEmpresaForm(viewModel, navController)
    }
}

@Composable
fun AddEmpresaForm(viewModel: EmpresaViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val name: String by viewModel.name.collectAsState("")
        val sector: String by viewModel.sector.collectAsState("")
        val id: Int by viewModel.id.collectAsState(0)
        val newEmpresa: EmpresaDataModel by viewModel.newEmpresa.collectAsState(
            EmpresaDataModel(
                0,
                "",
                ""
            )
        )

        EmpresaName(name) { viewModel.onAddEmpresaChange(id, it, sector) }
        Spacer(modifier = Modifier.padding(8.dp))
        EmpresaSector(sector) { viewModel.onAddEmpresaChange(id, name, it) }
        Spacer(modifier = Modifier.padding(8.dp))
        EmpresaId(id) { viewModel.onAddEmpresaChange(it.toInt(), sector, name) }
        Button(onClick = {
            viewModel.addEmpresa(newEmpresa)
            navController.popBackStack()
        }) {
            Text(text = "Agregar empresa")
        }
    }
}

@Composable
fun EmpresaName(name: String, onAddChange: (String) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                onAddChange(it)
            },
            label = { Text(text = "Nombre de la empresa") }
        )
    }
}

@Composable
fun EmpresaSector(sector: String, onAddChange: (String) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = sector,
            onValueChange = {
                onAddChange(it)
            },
            label = { Text(text = "Sector de la empresa") }
        )
    }
}

@Composable
fun EmpresaId(id: Int, onAddChange: (String) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = id.toString(),
            onValueChange = {
                onAddChange(it)
            },
            label = { Text(text = "Id de la empresa") }
        )
    }
}