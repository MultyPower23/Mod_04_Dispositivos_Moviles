# Dispositivos Móviles — Clase 30

> ⚠️ No se tomaron notas propias de esta clase. Este resumen se armó con el código del proyecto `Dispositivos` y los apuntes de un compañero, así que puede faltar lo que se explicó en vivo y no quedó en ninguno de los dos.

## 📚 Tema central

Primer proyecto en Kotlin con Jetpack Compose: la pantalla se escribe como código en vez de XML, y los datos se modelan con clases de datos.

## 🧠 Qué se vio

Jetpack Compose es la forma actual de armar pantallas en Android. En lugar de dibujar la pantalla en un layout XML y después buscar cada vista desde el código con `findViewById`, la pantalla se describe con funciones de Kotlin. Por eso el proyecto no tiene carpeta `res/layout/`: todo se arma dentro de `setContent { ... }`.

Cada pedazo de pantalla es una función marcada con `@Composable`. Se pueden meter unas dentro de otras, como cajas, y así se arma la pantalla completa:

- `Mainview` es la pantalla, que por ahora muestra un `Text("Comprar")`.
- `Scaffold` es la estructura base. Entrega un `innerPadding` que se le pasa al contenido para que no quede tapado por las barras del sistema.
- `Modifier` es la forma de darle tamaño, relleno y otros ajustes a cada elemento.
- `@Preview` muestra la función en el editor sin abrir el emulador, como hace `GreetingPreview`.

La Activity de un proyecto con Compose hereda de `ComponentActivity`, no de `AppCompatActivity`, que es la base de los proyectos con layouts XML. `enableEdgeToEdge()` hace que la app use toda la pantalla, también detrás de las barras del sistema.

El tema, `DispositivosTheme`, vive en `ui/theme/` (`Color.kt`, `Theme.kt`, `Type.kt`). Cambia entre claro y oscuro según el celular y usa los colores dinámicos del sistema en Android 12 o superior.

La configuración de Gradle también está en Kotlin: los archivos son `build.gradle.kts` y `settings.gradle.kts`, con sintaxis como `namespace = "com.ciro.dispositivos"` e `include(":app")`. En los proyectos de Java la sintaxis es Groovy (`namespace '...'`, `include ':app'`). En `libs.versions.toml` aparecen los plugins de Kotlin (versión 2.0.21) y de Compose, y el BOM de Compose, que fija en un solo lugar las versiones de todas las librerías de Compose para que sean compatibles entre sí.

La otra mitad de la clase fueron las clases de datos (`data class`). Sirven para guardar información sin escribir a mano constructores, getters ni métodos para comparar o imprimir el objeto; Kotlin los genera solo:

- `Dispositivos(val id: Long, val name: String, val data: Specs)`
- `Specs(val color: String?, val capacity: String?)`

`val` hace que el valor no se pueda cambiar después de crear el objeto. El `?` en `String?` permite que el campo sea `null` cuando el dato no existe; sin el `?`, Kotlin no deja guardar `null` ahí, y así evita errores por datos vacíos.

Las clases representan los datos que trae `restful-api.dev`, una API REST pública y gratuita pensada para practicar. Al final de `Dispositivos.kt` hay un JSON comentado con 13 dispositivos (`id`, `name` y `data`) que muestra la forma de esos datos.

Para mostrar cada dispositivo, `Elementos.kt` define `DeviceView`, un `@Composable` que arma una fila: un ícono de teléfono, el nombre y el color organizados con `Column` y `Row`, y una línea divisoria (`HorizontalDivider`) al final. `Column` pone los elementos uno debajo del otro y `Row` uno al lado del otro. Si el dispositivo no tiene color, la fila muestra `"-"`.

## 💻 Ejercicios trabajados

`Dispositivos`: el proyecto con las dos clases de datos, el JSON de referencia de `restful-api.dev`, la fila `DeviceView` para un dispositivo y una pantalla que por ahora solo muestra el texto «Comprar». El JSON todavía no se lee ni se arma la lista completa con `DeviceView`.

## ⚠️ Errores comunes / cosas a las que prestar atención

- En el JSON, el dispositivo 2 tiene `"data": null`, pero en la clase `data` es `Specs`, que no admite `null`. Para ese caso tendría que ser `Specs?`.
- Los campos de `data` cambian entre dispositivos (`capacity GB`, `Capacity`, `price`, `year`) y `Specs` solo modela `color` y `capacity`.
- En el JSON los `id` son texto (`"1"`) y en la clase `id` es `Long`.
- Para abrir el proyecto en Android Studio hay que elegir la carpeta `Dispositivos`, la que contiene `settings.gradle.kts`.

## ✅ Ideas clave

- 🧩 Compose arma la pantalla con funciones `@Composable` en vez de layouts XML.
- 📐 `Scaffold` da el `innerPadding` para no quedar debajo de las barras del sistema.
- 👀 `@Preview` deja ver una función composable sin correr la app.
- ↕️ `Column` apila los elementos en vertical y `Row` en horizontal.
- 📦 Una `data class` guarda datos sin escribir código repetido.
- ❓ `String?` admite `null`; `String` no.
- 🧾 Las clases modelan los datos de `restful-api.dev`, que es de donde sale el JSON de referencia.
