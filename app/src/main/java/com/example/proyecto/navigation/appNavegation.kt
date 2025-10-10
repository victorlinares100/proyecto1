package com.example.proyecto.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.ui.Screen.ResumenScreen
import com.example.proyecto.ui.Screen.RegistroScreen
import com.example.proyecto.viewmodel.UsuarioViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // 💡 Paso Clave para COMPARTIR EL VIEWMODEL
    // Al llamar a 'viewModel()' sin especificar un NavBackStackEntry,
    // el ViewModel se asocia al ciclo de vida del NavHost (o la Activity)
    // y se comparte implícitamente entre todos los composables dentro de él.
    val usuarioViewModel: UsuarioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "registro"
    ) {
        // --- RUTA: "registro" ---
        composable(route = "registro") {
            // Pasamos el navController para poder navegar
            // Pasamos la instancia compartida del ViewModel
            RegistroScreen(
                navController = navController,
                viewModel = usuarioViewModel
            )
        }

        // --- RUTA: "resumen" ---
        composable(route = "resumen") {
            // Solo necesitamos pasar la misma instancia compartida del ViewModel
            ResumenScreen(
                viewModel = usuarioViewModel
            )
        }
    }
}