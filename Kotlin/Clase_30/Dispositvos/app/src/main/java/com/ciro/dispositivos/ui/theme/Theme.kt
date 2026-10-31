package com.ciro.dispositivos.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Paletas de colores para modo oscuro y claro; private las deja visibles solo en este archivo.
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Otros colores que se pueden sobrescribir
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// Tema de la app; content: @Composable () -> Unit recibe como parámetro la interfaz que va dentro.
// Cuando el último parámetro es una función, se puede pasar con llaves después de la llamada: DispositivosTheme { ... }.
@Composable
fun DispositivosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // El color dinámico toma la paleta del fondo de pantalla; solo existe desde Android 12.
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // when es como un switch que devuelve un valor; se usa la primera condición que sea verdadera.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // LocalContext.current obtiene el Context de Android dentro de un composable.
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // MaterialTheme pone los colores y la tipografía a disposición de todos los composables hijos.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}