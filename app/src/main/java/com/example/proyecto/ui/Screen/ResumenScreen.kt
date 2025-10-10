package com.example.proyecto.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyecto.viewmodel.UsuarioViewModel


@Composable
fun ResumenScreen(viewModel: UsuarioViewModel) {
    // 1. Observa el estado del ViewModel (reactividad con StateFlow)
    val estado by viewModel.estado.collectAsState()

    Column(
        modifier = Modifier.padding(all = 16.dp)
    ) {
        Text(
            text = "Resumen del Registro",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 2. Muestra los datos del estado
        Text(text = "Nombre: ${estado.nombre}")
        Text(text = "Correo: ${estado.correo}")
        Text(text = "Dirección: ${estado.direccion}")

        // Ocultar la contraseña
        Text(text = "Contraseña: ${"*".repeat(n = estado.clave.length)}")

        // Formatear el campo booleano
        Text(
            text = "Términos: ${if (estado.aceptaTerminos) "Aceptados" else "No Aceptados"}"
        )
    }
}