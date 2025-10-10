package com.example.proyecto.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyecto.R

@Composable
fun HomeExpanded() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Imagen Expandida",
            modifier = Modifier.size(250.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Pantalla Expandida (Tablet Horizontal)", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {}) {
                Text("Explorar")
            }
        }
    }
}
