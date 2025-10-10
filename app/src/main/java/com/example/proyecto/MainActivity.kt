package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box // Importación necesaria para el Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
// 1. IMPORTACIÓN CLAVE: Tu función AppNavigation
import com.example.proyecto.navigation.AppNavigation
// 2. Importación de tu tema
import com.example.proyecto.theme.ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usa tu tema principal
            ProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 3. Reemplazamos Greeting() por el componente Box y AppNavigation()
                    Box(modifier = Modifier.padding(innerPadding)) {
                        // 🚀 Inicia el NavHost y el flujo completo del formulario
                        AppNavigation()
                    }
                }
            }
        }
    }
}

// 4. CÓDIGO DE PRUEBA  -----------------
/*
@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Ingrese Nombre") }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoTheme {
        SimpleTextField()
    }
}
*/