package com.example.proyecto.model

// Archivo: UsuarioUiState.kt o dentro de tu paquete de modelos
data class UsuarioUiState(
    // 🗃️ Datos del formulario
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val direccion: String = "",
    val aceptaTerminos: Boolean = false,

    // 🚨 Estado de la validación
    // Inicializamos con una instancia vacía de UsuarioErrores
    val errores: UsuarioErrores = UsuarioErrores()
)