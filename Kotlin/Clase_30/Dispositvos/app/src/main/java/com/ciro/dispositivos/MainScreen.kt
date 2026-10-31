package com.ciro.dispositivos

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciro.dispositivos.ui.theme.DispositivosTheme

// @Composable marca una función que dibuja interfaz; por convención su nombre empieza en mayúscula.
// Modifier ajusta tamaño, espaciado o apariencia de un elemento desde afuera.
@Composable
fun MainView(modifier: Modifier){
    Text(text = "Comprar",
        modifier = modifier)
}

// @Preview muestra el composable en el panel de diseño de Android Studio sin correr la app.
// showSystemUi dibuja también la barra de estado y el marco del celular.
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainView_A() {
    DispositivosTheme {
        MainView(Modifier.padding(top = 24.dp))
    }
}
