package com.example.proyecto.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.proyecto.model.UsuarioErrores
import com.example.proyecto.model.UsuarioUiState


class UsuarioViewModel : ViewModel() {

    // 1. Estado interno mutable (MutableStateFlow)
    // Solo el ViewModel puede modificar este estado.
    private val _estado = MutableStateFlow(UsuarioUiState())

    // 2. Estado expuesto (StateFlow)
    // La UI (Composables) solo puede 'observar' este estado (collectAsState).
    val estado: StateFlow<UsuarioUiState> = _estado.asStateFlow()

    // ----------------------------------------------------
    // Funciones para manejar los eventos del usuario (Event Handlers)
    // ----------------------------------------------------

    // Actualiza el campo nombre y 'limpia' su error, asumiendo una validación básica
    fun onNombreChange(valor: String) {
        _estado.update {
            it.copy(
                nombre = valor,
                // Al actualizar, se 'limpia' el error de nombre para que desaparezca
                errores = it.errores.copy(nombre = null)
            )
        }
    }

    // Actualiza el campo correo y limpia su error
    fun onCorreoChange(valor: String) {
        _estado.update {
            it.copy(
                correo = valor,
                errores = it.errores.copy(correo = null)
            )
        }
    }

    // Actualiza el campo clave y limpia su error
    fun onClaveChange(valor: String) {
        _estado.update {
            it.copy(
                clave = valor,
                errores = it.errores.copy(clave = null)
            )
        }
    }

    // Actualiza el campo dirección y limpia su error
    fun onDireccionChange(valor: String) {
        _estado.update {
            it.copy(
                direccion = valor,
                errores = it.errores.copy(direccion = null)
            )
        }
    }

    // Actualiza el checkbox de aceptación de términos
    fun onAceptarTerminosChange(valor: Boolean) {
        _estado.update {
            it.copy(
                aceptaTerminos = valor
            )
        }
    }
}