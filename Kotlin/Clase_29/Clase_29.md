# Android Studio — Clase 29

> ⚠️ No se asistió a esta clase. Este resumen se armó con las anotaciones de las dos clases, los apuntes de un compañero y el código del proyecto `Juann_Ciro`, así que puede faltar lo que se explicó o se hizo en vivo y no quedó en ningún registro. Lo que se vio en esta clase y en la Clase_28 se separó según lo que muestra cada proyecto, no según un registro exacto de cada sesión.

## 📚 Tema central

Pantalla de precarga (splash) con animación Lottie, imágenes y textos guardados como variables `string`.

## 🧠 Qué se vio

**Animación con Lottie.** En esta clase la librería pasó de la versión 3.0.1 (con la que se venía trabajando) a la 6.7.1, que es la que queda declarada en `gradle/libs.versions.toml` y se usa en `app/build.gradle` con `implementation libs.lottie`. Las animaciones se descargan en formato JSON desde LottieFiles (lottiefiles.com). La animación es un archivo JSON que se guarda en la carpeta `assets/`, y en el layout se muestra con un `LottieAnimationView`:

- `lottie_fileName`: el nombre del JSON dentro de `assets/`.
- `lottie_autoPlay`: arranca sola al abrir la pantalla.
- `lottie_loop`: se repite sin parar.

**De animación a JSON.** La animación se convirtió a JSON antes de meterla al proyecto. El archivo `animation.json` ("atomo") dura 5 segundos (150 fotogramas a 30 por segundo) y cada fotograma va incrustado como una imagen PNG dentro del JSON, por eso pesa unos 3 MB.

**Descargar imágenes.** Las imágenes se descargan y se guardan en `res/drawable/`: el fondo, el logo del cohete y los títulos. Se usan desde el layout con `@drawable/nombre`.

**Variables `string`.** Los textos fijos de la pantalla viven en `res/values/strings.xml` y el layout los llama con `@string/nombre`:

| Variable | Texto |
| --- | --- |
| `nombre_app` | Juan Esteban Ciro |
| `dev` | Desarrollado por Ciro |
| `version` | Versión 1.0 |

Tener los textos en un solo archivo permite cambiarlos sin tocar los layouts y deja listo el terreno para traducir la app.

**Colores.** Los textos usan `@color/white`, que está definido en `res/values/colors.xml`.

## 💻 Ejercicios trabajados

**`Juann_Ciro`**: la pantalla `Precarga` es un `LinearLayout` vertical centrado, con `fondo.jpg` de fondo y, de arriba abajo:

- el logo `cohete_logo.png`,
- la animación Lottie,
- el nombre de la app (26sp),
- el texto de desarrollador (15sp),
- la versión (15sp).

`Precarga.java` solo muestra su layout. Todavía no hay código que pase de `Precarga` a `MainActivity`, que sigue siendo un layout con un «Hello World!».

## ⚠️ Errores comunes / cosas a las que prestar atención

- En el Manifest, `Precarga` y `MainActivity` tienen `MAIN` + `LAUNCHER`, así que la app aparece dos veces en el menú de apps del dispositivo. Para que `Precarga` sea la única pantalla de arranque, `MainActivity` no debería llevar ese `intent-filter`.
- El JSON de la animación debe estar en `app/src/main/assets/` y el nombre del archivo tiene que coincidir con `lottie_fileName`.
- El texto de `MainActivity` está escrito directo en el layout; lo recomendable es pasarlo a `strings.xml` como el resto.

## ✅ Ideas clave

- 🎞️ Lottie reproduce animaciones guardadas como JSON en `assets/`, descargadas de LottieFiles.
- 🔢 La versión de la librería se cambia en un solo lugar: `libs.versions.toml` — en esta clase pasó de 3.0.1 a 6.7.1.
- 🖼️ Las imágenes van en `drawable/` y se llaman con `@drawable/`.
- 🔤 Los textos van en `strings.xml` y se llaman con `@string/`.
- 🚀 Solo la Activity con `MAIN` + `LAUNCHER` debe abrirse al tocar el ícono.
