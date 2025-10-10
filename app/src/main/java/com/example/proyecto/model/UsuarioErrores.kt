package com.example.proyecto.model

// Archivo: UsuarioErrores.kt o dentro de tu paquete de modelos
data class UsuarioErrores(
    // Si es `null`, no hay error. Si tiene un String, es el mensaje de error a mostrar.
    val nombre: String? = null,
    val correo: String? = null,
    val clave: String? = null,
    val direccion: String? = null
)