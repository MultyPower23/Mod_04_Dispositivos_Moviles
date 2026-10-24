# Android Studio — Clase 28

> ⚠️ Resumen armado con las anotaciones propias de la clase y con el código de los proyectos `Prueba1` y `Proyecto_Prueba`. Faltan los apuntes de un compañero para completar el detalle. Lo que se vio en esta clase y en la Clase_29 se separó según lo que muestra cada proyecto, no según un registro exacto de cada sesión. El punto «id» de las anotaciones se interpretó como el identificador de los elementos del layout.

## 📚 Tema central

Primer contacto con Android Studio: qué es un IDE, cómo se organiza un proyecto Android, cómo se prueba en el emulador y las primeras pantallas con imágenes.

## 🧠 Qué se vio

**IDE e id.** Un IDE (entorno de desarrollo integrado) junta en un solo programa el editor, el compilador, el emulador y las herramientas para depurar. Android Studio es el IDE para hacer apps Android. El `id` es el nombre que se le pone a cada elemento de un layout (`@+id/button`, `@+id/main`) para poder encontrarlo desde el código con `findViewById(R.id.main)`.

**Paquetes de archivos.** Un proyecto Android trae muchas carpetas, pero casi todo pasa en `app/src/main/`:

- `java/com/ciro/proyecto_prueba/`: el paquete con las clases de las pantallas (`MainActivity`, `Precarga`). El nombre del paquete coincide con el `namespace` y el `applicationId` de `app/build.gradle`.
- `res/layout/`: el diseño de cada pantalla en XML.
- `res/drawable/`: imágenes y gráficos vectoriales.
- `res/values/`: textos (`strings.xml`), colores (`colors.xml`) y temas (`themes.xml`).
- `res/mipmap-*/`: los íconos de la app en varias densidades.

**Archivos de configuración.** Son los que le dicen a Android y a Gradle cómo armar la app:

- `AndroidManifest.xml`: declara las pantallas (Activities), el tema, el ícono y el nombre de la app. La Activity con el `intent-filter` `MAIN` + `LAUNCHER` es la que se abre al tocar el ícono.
- `app/build.gradle`: `namespace`, `compileSdk` y `targetSdk` 36, `minSdk` 28 y las dependencias.
- `build.gradle` (raíz) y `settings.gradle`: plugins y módulos del proyecto.
- `gradle/libs.versions.toml`: catálogo con las versiones de las librerías, que luego se usan como `libs.appcompat`, `libs.lottie`, etc.
- `gradle.properties` y `gradle/wrapper/gradle-wrapper.properties`: opciones de Gradle y la versión que descarga el proyecto (8.13).

**Partes del entorno.** `Prueba1` se armó arrastrando elementos desde la paleta hasta el editor de diseño: las coordenadas `tools:layout_editor_absoluteX/Y` y la imagen por defecto de estrella son el rastro de ese arrastre. El detalle del resto de paneles y barras queda por completar con los apuntes del compañero.

**Emulador Android Pixel 9.** Las apps se prueban en un dispositivo virtual Pixel 9 que se crea desde el Device Manager, sin necesidad de un celular físico.

**Librería Lottie.** Se agregó la librería de animaciones de Airbnb (`com.airbnb.android:lottie`) declarándola en `libs.versions.toml` y llamándola desde `app/build.gradle` con `implementation libs.lottie`. En `Proyecto_Prueba` quedó la versión 3.1.0. En las anotaciones aparece 3.0.1, así que conviene confirmar cuál fue la que se escribió en clase.

**Imágenes.** Las imágenes descargadas se guardan en `res/drawable/` y se usan desde el layout con `@drawable/nombre`.

## 💻 Ejercicios trabajados

- **`Prueba1`**: un layout con un `TextView`, un `ImageView`, un `Button` y un `CheckBox` colocados con el editor visual. En `res/drawable/` quedaron cuatro imágenes de prueba que todavía no se usan en el layout.
- **`Proyecto_Prueba`**: la pantalla `Precarga` con `fondo.jpg` de fondo y `cohete_logo.png` centrado en un `LinearLayout` vertical. `MainActivity` sigue siendo la pantalla que abre la app; `Precarga` está declarada pero todavía no es la de arranque.

## ⚠️ Errores comunes / cosas a las que prestar atención

- Los nombres de los recursos van en minúscula, sin espacios ni tildes y sin empezar por número (`cohete_logo.png`, no `Cohete Logo.png`), si no Android no los reconoce.
- Si se borra la clase de una Activity, hay que quitarla también del `AndroidManifest.xml`. `Prueba1` conserva la entrada `.tsc` sin su clase.
- Abrir en Android Studio la carpeta del proyecto (la que tiene `settings.gradle`), no la carpeta de la clase.

## ✅ Ideas clave

- 🧰 Android Studio es el IDE: editor, emulador y compilación en un mismo lugar.
- 🏷️ El `id` de cada elemento del layout es lo que permite encontrarlo desde el código.
- 📂 El código va en `java/`, lo visual en `res/` y la configuración en el Manifest y los `.gradle`.
- 📱 El emulador Pixel 9 permite probar sin celular físico.
- 📦 Las librerías se declaran en `libs.versions.toml` y se usan en `app/build.gradle`.
- 🖼️ Las imágenes viven en `drawable/` y se llaman con `@drawable/`.
