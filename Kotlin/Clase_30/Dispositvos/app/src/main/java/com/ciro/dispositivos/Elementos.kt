package com.ciro.dispositivos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ciro.dispositivos.ui.theme.DispositivosTheme
import com.ciro.dispositivos.ui.theme.Typography


// Composable que dibuja una fila con la información de un dispositivo.
// "modifier: Modifier = Modifier" es un parámetro con valor por defecto; se puede omitir al llamar la función.
@Composable
fun DeviceView(device: Dispositivos, modifier: Modifier = Modifier) {
    // Column apila sus hijos en vertical y Row los pone en horizontal.
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // contentDescription describe el icono para lectores de pantalla; null indica que es decorativo.
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            Column {
                Text(
                    text = device.name,
                    style = Typography.headlineMedium
                )
                // ?. accede a la propiedad solo si no es null; ?: (Elvis) da el valor de respaldo "-".
                Text(
                    text = device.data?.color?: "-",
                    style = Typography.bodyMedium
                )
            }
        }
        // Línea horizontal que separa un elemento del siguiente.
        HorizontalDivider()
    }   
}

// Vista previa con datos de prueba; los argumentos con nombre (id = 1) hacen la llamada más legible.
@Preview(showBackground = true)
@Composable
fun DeviceItemPreview() {
    DispositivosTheme {
        DeviceView(
            device = Dispositivos(
                id = 1,
                name = "Nexus",
                data = Specs(color = "Black", capacity = "64 GB")
            )
        )
    }
}