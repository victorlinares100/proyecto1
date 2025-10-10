package com.example.proyecto.ui.theme

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyecto.R
import com.example.proyecto.ui.utils.obtenerWindowSizeClass

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen(windowWidthSizeClass: WindowWidthSizeClass) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi App Kotlin") }) }
    ) { innerPadding ->

        when (windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(text = "¡Bienvenido desde un teléfono!")
                    Button(onClick = { /* acción futura */ }) {
                        Text("Presióname")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo App",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            WindowWidthSizeClass.Medium -> {
                Row(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo App",
                        modifier = Modifier
                            .weight(1f)
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(text = "¡Bienvenido desde una tablet!")
                        Button(onClick = { /* acción futura */ }) {
                            Text("Explorar más")
                        }
                    }
                }
            }

            WindowWidthSizeClass.Expanded -> {
                Row(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Interfaz Expandida (pantalla grande)")
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = { /* acción futura */ }) {
                            Text("Ir al contenido")
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo App",
                        modifier = Modifier
                            .weight(1f)
                            .height(250.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val activity = context as Activity
    val windowSizeClass = obtenerWindowSizeClass()
    HomeScreen(windowWidthSizeClass = windowSizeClass.widthSizeClass)
}

// Previews para simular los diferentes tamaños de pantalla

@Preview(showBackground = true, name = "Compact Preview")
@Composable
fun HomeScreenCompactPreview() {
    HomeScreen(windowWidthSizeClass = WindowWidthSizeClass.Compact)
}

@Preview(showBackground = true, name = "Medium Preview", widthDp = 700, heightDp = 500)
@Composable
fun HomeScreenMediumPreview() {
    HomeScreen(windowWidthSizeClass = WindowWidthSizeClass.Medium)
}

@Preview(showBackground = true, name = "Expanded Preview", widthDp = 1000, heightDp = 700)
@Composable
fun HomeScreenExpandedPreview() {
    HomeScreen(windowWidthSizeClass = WindowWidthSizeClass.Expanded)
}
