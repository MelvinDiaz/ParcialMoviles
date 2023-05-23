package com.autominder.parcialmoviles.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FloatingAddButton(
    navController: NavController
) {
    FloatingActionButton(onClick = { navController.navigate("add_empresa_screen") }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}