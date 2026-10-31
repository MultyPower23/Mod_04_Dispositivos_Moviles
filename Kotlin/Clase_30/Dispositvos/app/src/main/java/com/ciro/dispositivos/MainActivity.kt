package com.ciro.dispositivos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciro.dispositivos.ui.theme.DispositivosTheme

// En Kotlin, ":" reemplaza a extends; ComponentActivity es la Activity base para Compose.
class MainActivity : ComponentActivity() {
    // override fun sobrescribe un método del padre; Bundle? con ? indica que puede ser null.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContent reemplaza al layout XML: la interfaz se escribe con funciones de Compose.
        setContent {
            // El tema envuelve toda la interfaz y le da colores y tipografía.
            DispositivosTheme {
                // Scaffold es la estructura base de una pantalla Material (barras, botones flotantes, contenido).
                // innerPadding es el espacio que ocupan las barras del sistema; se pasa al contenido para no taparlo.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MainView(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
