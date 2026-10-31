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


@Composable
fun DeviceView(device: Dispositivos, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            Column {
                Text(
                    text = device.name,
                    style = Typography.headlineMedium
                )
                Text(
                    text = device.data?.color?: "-",
                    style = Typography.bodyMedium
                )
            }
        }
        HorizontalDivider()
    }   
}

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