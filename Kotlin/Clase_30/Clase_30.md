# Kotlin — Clase 30

> ⚠️ No se tomaron notas propias de esta clase. Este resumen se armó con el código del proyecto `Dispositivos` y los apuntes de un compañero, así que puede faltar lo que se explicó en vivo y no quedó en ninguno de los dos.

## 📚 Tema central

Primer proyecto en Kotlin con Jetpack Compose: la pantalla se escribe como código y los datos se modelan con clases de datos.

## 🧠 Qué se vio

**Gradle con Kotlin.** Los archivos de configuración son `build.gradle.kts` y `settings.gradle.kts`, escritos con la sintaxis de Kotlin: `namespace = "com.ciro.dispositivos"` e `include(":app")`. Los proyectos de Java usan la sintaxis Groovy (`namespace '...'`, `include ':app'`). En `libs.versions.toml` aparecen los plugins de Kotlin (versión 2.0.21) y de Compose, y el BOM de Compose, que fija en un solo lugar las versiones de todas sus librerías.

**Compose en lugar de XML.** El proyecto no tiene carpeta `res/layout/`. La pantalla se arma en código dentro de `setContent { ... }`, con funciones marcadas con `@Composable`:

- `Mainview`: la pantalla, por ahora con un `Text("Comprar")`.
- `Scaffold`: la estructura base de la pantalla. Entrega un `innerPadding` que se le pasa al contenido para que no quede tapado por las barras del sistema.
- `Modifier`: la forma de darle tamaño, relleno y otros ajustes a cada elemento.
- `@Preview`: muestra la función en el editor sin abrir el emulador (`GreetingPreview`).

**Activity de Compose.** `MainActivity` hereda de `ComponentActivity`, no de `AppCompatActivity` (la base de los proyectos con layouts XML), y llama a `enableEdgeToEdge()` para que la app use toda la pantalla.

**Tema.** `DispositivosTheme` vive en `ui/theme/` (`Color.kt`, `Theme.kt`, `Type.kt`). Cambia entre claro y oscuro según el sistema y usa los colores dinámicos del teléfono en Android 12 o superior.

**Clases de datos.** Sirven para guardar información sin escribir a mano constructores ni getters:

- `Dispositivos(val id: Long, val name: String, val data: Specs)`
- `Specs(val color: String?, val capacity: String?)`

`val` hace que el valor no se pueda cambiar después de crear el objeto, y el `?` en `String?` permite que el campo sea `null` cuando el dato no existe.

**Estructura de los datos.** Al final de `Dispositivos.kt` hay un JSON comentado con 13 dispositivos (`id`, `name` y `data`), que es la forma de datos que las clases intentan representar. El JSON sale de `restful-api.dev`, una API REST pública gratuita pensada para pruebas y aprendizaje.

**Elemento de lista.** `Elementos.kt` define `DeviceView`, un `@Composable` que arma una fila por dispositivo: un ícono de teléfono, el nombre y el color (con `Column` y `Row`), y una línea divisoria (`HorizontalDivider`) al final. Si el dispositivo no tiene color, muestra un `"-"` en su lugar.

## 💻 Ejercicios trabajados

**`Dispositivos`**: el proyecto con las dos clases de datos, el JSON de referencia (tomado de `restful-api.dev`), la fila `DeviceView` para mostrar un dispositivo, y una pantalla que por ahora solo muestra el texto «Comprar». Todavía no se lee el JSON ni se arma la lista completa de dispositivos con `DeviceView`.

## ⚠️ Errores comunes / cosas a las que prestar atención

- En el JSON, el dispositivo 2 tiene `"data": null`, pero en la clase `data` es de tipo `Specs`, que no admite `null`. Para ese caso tendría que ser `Specs?`.
- Los campos de `data` cambian entre dispositivos (`capacity GB`, `Capacity`, `price`, `year`), y `Specs` solo tiene `color` y `capacity`. El resto de datos queda sin modelar.
- En el JSON los `id` son texto (`"1"`) y en la clase `id` es `Long`.
- Para abrir el proyecto en Android Studio hay que elegir la carpeta `Dispositivos`, la que contiene `settings.gradle.kts`.

## ✅ Ideas clave

- 🧩 Compose arma la pantalla con funciones `@Composable` en vez de layouts XML.
- 📐 `Scaffold` da el `innerPadding` para no quedar debajo de las barras del sistema.
- 👀 `@Preview` permite ver una función composable sin correr la app.
- 📦 Una `data class` guarda datos sin código repetido.
- ❓ `String?` admite `null`; `String` no.
- 🧾 El JSON de referencia sale de `restful-api.dev` y muestra cómo son los datos que luego se van a usar.
- 📱 `DeviceView` en `Elementos.kt` ya arma la fila visual de un dispositivo, aunque todavía no se conecta con la lista completa.
