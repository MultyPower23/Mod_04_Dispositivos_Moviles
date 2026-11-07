# Dispositivos Móviles — Clase 28

> ⚠️ Resumen armado con las anotaciones propias de la clase, apuntes de un compañero y el código de los proyectos `Prueba1` y `Proyecto_Prueba`. Lo visto en esta clase y en la Clase_29 se separó según lo que muestra cada proyecto, no según un registro exacto de cada sesión. El punto «id» de las anotaciones se interpretó como el identificador de los elementos del layout.

## 📚 Tema central

Primer contacto con Android Studio: qué es un IDE, cómo se organiza un proyecto Android, cómo se prueba en el emulador y las primeras pantallas con imágenes.

## 🧠 Qué se vio

Un IDE (entorno de desarrollo integrado) junta en un solo programa todo lo que hace falta para hacer software: el editor, el compilador, el emulador y las herramientas para depurar. Android Studio es el IDE para apps Android y trabaja con Java, C y C++, además de Kotlin. Sus ventajas son que se programa más rápido, está pensado para trabajo en equipo, soporta Android de forma nativa y trae plantillas de proyecto listas. Las desventajas son que pide bastante equipo y que la instalación es lenta. Hay dos ediciones: la morada, con todas las funciones, y la azul, más liviana y solo con lo esencial.

Para funcionar, Android Studio se apoya en dos kits. El JDK (Java Development Kit) trae la máquina virtual de Java sobre la que corre todo por debajo; en clase se instaló la versión 25.0.1. El SDK (Software Development Kit) trae las herramientas y librerías propias de Android para compilar y probar las apps.

Un proyecto Android trae muchas carpetas, pero la idea es simple: el código va por un lado, lo visual por otro y la configuración aparte. Casi todo pasa en `app/src/main/`:

- `java/`: el paquete con las clases de cada pantalla, como `MainActivity`. El nombre del paquete (`com.ciro.proyecto_prueba`) coincide con el `namespace` y el `applicationId` de `app/build.gradle`.
- `res/layout/`: el diseño de cada pantalla en XML.
- `res/drawable/`: imágenes y gráficos.
- `res/values/`: textos (`strings.xml`), colores (`colors.xml`) y temas (`themes.xml`).
- `res/mipmap-*/`: el ícono de la app en varios tamaños según la densidad de pantalla.

Cada pantalla de la app es una Activity: una clase en `java/` y un layout en `res/layout/`. Para encontrar un elemento del layout desde el código, cada uno lleva un `id` (`@+id/button`, `@+id/main`), y en Java se busca con `findViewById(R.id.main)`. `R` es una clase que Android genera sola con todos los recursos del proyecto.

Los archivos de configuración le dicen a Android y a Gradle cómo armar la app. Gradle es la herramienta que compila el proyecto y descarga las librerías:

- `AndroidManifest.xml`: declara las pantallas, el tema, el ícono y el nombre de la app. La Activity que tenga el `intent-filter` con `MAIN` y `LAUNCHER` es la que se abre al tocar el ícono.
- `app/build.gradle`: el `namespace`, `compileSdk` y `targetSdk` en 36, `minSdk` en 28 y las dependencias, cada una como `implementation libs.nombre`.
- `build.gradle` (raíz) y `settings.gradle`: los plugins y los módulos del proyecto.
- `gradle/libs.versions.toml`: el catálogo con las versiones de las librerías, que luego se usan como `libs.appcompat` o `libs.lottie`.
- `gradle.properties` y `gradle/wrapper/gradle-wrapper.properties`: opciones de Gradle y la versión que descarga el proyecto (8.13).

Para armar una pantalla se pueden arrastrar elementos desde la paleta hasta el editor de diseño. Las coordenadas `tools:layout_editor_absoluteX/Y` que aparecen en `Prueba1` son el rastro de ese arrastre: solo sirven para la vista previa del editor, no para el celular.

Las apps se prueban en un emulador: un celular virtual, en este caso un Pixel 9, que se crea desde el Device Manager sin necesidad de un celular físico. Cuando la app está lista para compartirse se genera el APK, el archivo instalable de Android, desde el menú de las tres rayas (☰) en Build. Queda en `app/build/outputs/apk/`.

Las librerías agregan funciones que Android no trae. En clase se agregó Lottie, la librería de animaciones de Airbnb (`com.airbnb.android:lottie`): se declara en `libs.versions.toml` y se llama desde `app/build.gradle` con `implementation libs.lottie`. En `Proyecto_Prueba` está en la versión 6.7.1.

Las imágenes descargadas se guardan en `res/drawable/` y el layout las usa con `@drawable/nombre`.

## 💻 Ejercicios trabajados

- `Prueba1`: un layout con un `TextView`, un `ImageView`, un `Button` y un `CheckBox` colocados con el editor visual. En `res/drawable/` hay cuatro imágenes de prueba que el layout no usa.
- `Proyecto_Prueba`: la pantalla `Precarga` con `fondo.jpg` de fondo y `cohete_logo.png` centrado en un `LinearLayout` vertical. La app abre en `MainActivity`; `Precarga` está declarada pero no es la de arranque.

## ⚠️ Errores comunes / cosas a las que prestar atención

- Los nombres de los recursos van en minúscula, sin espacios ni tildes y sin empezar por número (`cohete_logo.png`, no `Cohete Logo.png`); si no, Android no los reconoce.
- Si se borra la clase de una Activity, hay que quitarla también del `AndroidManifest.xml`. `Prueba1` conserva la entrada `.tsc` sin su clase.
- En Android Studio se abre la carpeta del proyecto (la que tiene `settings.gradle`), no la carpeta de la clase.

## ✅ Ideas clave

- 🧰 Android Studio es el IDE: editor, emulador y compilación en un mismo lugar.
- ⚙️ El JDK trae la máquina virtual de Java; el SDK, las herramientas de Android.
- 📂 El código va en `java/`, lo visual en `res/` y la configuración en el Manifest y los `.gradle`.
- 🏷️ El `id` de cada elemento es lo que permite encontrarlo desde el código con `findViewById`.
- 🚀 La Activity con `MAIN` y `LAUNCHER` es la que abre la app.
- 📦 Las librerías se declaran en `libs.versions.toml` y se usan en `app/build.gradle`.
- 📱 El emulador Pixel 9 permite probar sin celular físico, y el APK es el instalable que se comparte.
