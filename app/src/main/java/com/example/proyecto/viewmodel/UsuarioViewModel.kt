package com.example.proyecto.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto.model.UsuarioErrores
import com.example.proyecto.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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

    fun validarFormulario(): Boolean {
        // 1. Obtener el estado actual del StateFlow
        val estadoActual = _estado.value

        // 2. Ejecutar las reglas de validación y construir el nuevo objeto UsuarioErrores
        val errores = UsuarioErrores(
            nombre = if (estadoActual.nombre.isBlank()) {
                "Campo obligatorio"
            } else null,

            correo = if (!estadoActual.correo.contains("@")) { // Validación: debe contener '@'
                "Correo inválido"
            } else null,

            clave = if (estadoActual.clave.length < 6) { // Validación: Mínimo 6 caracteres
                "Debe tener al menos 6 caracteres"
            } else null,

            direccion = if (estadoActual.direccion.isBlank()) {
                "Campo obligatorio"
            } else null

            // Aquí puedes añadir la validación de 'aceptaTerminos' si es obligatoria
            // aceptaTerminos = if (!estadoActual.aceptaTerminos) "Debe aceptar términos" else null
        )

        // 3. Determinar si existe algún error
        // Se usa ListOfNotNull para filtrar los 'null' y verificar si la lista resultante está vacía
        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()

        // 4. Actualizar el StateFlow con los nuevos errores
        _estado.update {
            it.copy(errores = errores)
        }

        // 5. Retornar el resultado de la validación
        return !hayErrores
    }
}