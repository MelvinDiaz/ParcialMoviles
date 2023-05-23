package com.autominder.parcialmoviles.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun PrincipalScaffold() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {},
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavigationHost(navController)
        }

    }
}