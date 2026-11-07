# Dispositivos Móviles — Clase 29

> ⚠️ No se asistió a esta clase. Este resumen se armó con las anotaciones de las dos clases, los apuntes de un compañero y el código del proyecto `Juann_Ciro` en lo que se hizo ese día, así que puede faltar lo que se explicó en vivo y no quedó en ningún registro. Lo que se vio en esta clase y en la Clase_28 se separó según lo que muestra cada proyecto, no según un registro exacto de cada sesión.

## 📚 Tema central

Pantalla de precarga (splash) con animación Lottie, imágenes y textos guardados como recursos `string`. Es el arranque de `Juann_Ciro`, el proyecto principal del módulo.

## 🧠 Qué se vio

Una pantalla de precarga es la que aparece unos segundos al abrir la app, con el logo, el nombre y la versión, mientras la app termina de arrancar. En esta clase se armó solo su diseño.

Lottie es una librería que reproduce animaciones guardadas en formato JSON, que se descargan de LottieFiles (lottiefiles.com). La ventaja frente a un video o un GIF es que la animación se dibuja en la app, así que se ve nítida en cualquier tamaño y se controla desde el layout. Se trabaja con la versión 6.7.1, declarada en `gradle/libs.versions.toml` y usada en `app/build.gradle` con `implementation libs.lottie`. Como la versión vive en un solo lugar, cambiarla es tocar una línea.

El JSON de la animación se guarda en la carpeta `app/src/main/assets/`, que es donde Android deja archivos tal cual, sin procesarlos como recursos. En el layout se muestra con un `LottieAnimationView`:

- `lottie_fileName`: el nombre del JSON dentro de `assets/`.
- `lottie_autoPlay`: la animación arranca sola al abrir la pantalla.
- `lottie_loop`: se repite sin parar.

La animación de `Juann_Ciro`, `animation.json` («atomo»), dura 5 segundos (150 fotogramas a 30 por segundo). Cada fotograma va incrustado como imagen PNG dentro del JSON, por eso pesa unos 3 MB.

Las imágenes se descargan y se guardan en `res/drawable/`, y el layout las usa con `@drawable/nombre`.

Los textos fijos de la pantalla no se escriben directo en el layout: viven en `res/values/strings.xml` y el layout los llama con `@string/nombre`. Así se cambian en un solo archivo sin tocar los layouts, y la app queda lista para traducirse, porque basta con otro `strings.xml` por idioma.

| Variable | Texto |
| --- | --- |
| `nombre_app` | Juan Esteban Ciro |
| `dev` | Desarrollado por Ciro |
| `version` | Versión 1.0 |

Con los colores pasa lo mismo: los textos usan `@color/white`, definido en `res/values/colors.xml`.

## 💻 Ejercicios trabajados

`Juann_Ciro`: la pantalla `Precarga` es un `LinearLayout` vertical centrado, con una imagen de fondo y, de arriba abajo:

- el logo,
- la animación Lottie,
- el nombre de la app (26sp),
- el texto de desarrollador (15sp),
- la versión (15sp).

En esta clase `Precarga` solo muestra su diseño; el paso automático a la siguiente pantalla se hace en la Clase_31.

## ⚠️ Errores comunes / cosas a las que prestar atención

- En el Manifest, si `Precarga` y `MainActivity` tienen las dos `MAIN` + `LAUNCHER`, la app aparece dos veces en el celular. Para que `Precarga` sea la única de arranque, `MainActivity` no debe llevar ese `intent-filter`.
- El JSON tiene que estar en `app/src/main/assets/` y su nombre tiene que coincidir con `lottie_fileName`; si no, la animación no aparece.
- Un JSON con imágenes incrustadas pesa mucho; las animaciones hechas solo con vectores son bastante más livianas.

## ✅ Ideas clave

- 🎞️ Lottie reproduce animaciones JSON guardadas en `assets/` y descargadas de LottieFiles.
- 🔢 La versión de una librería se cambia en un solo lugar: `libs.versions.toml`.
- 🖼️ Las imágenes van en `drawable/` y se llaman con `@drawable/`.
- 🔤 Los textos van en `strings.xml` y se llaman con `@string/`, lo que facilita cambiarlos y traducir la app.
- 🚀 Solo la Activity con `MAIN` + `LAUNCHER` debe abrirse al tocar el ícono.
