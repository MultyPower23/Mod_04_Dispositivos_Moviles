# Android Studio — Clase 31

> ⚠️ No hay apuntes de esta clase. Este resumen se armó con los commits del día de la clase sobre el proyecto `Juann_Ciro` y con su código, así que puede faltar lo que se explicó en vivo y no quedó en el código. El mensaje del último commit menciona el emulador, pero no quedó ningún registro de qué se hizo con él más allá de probar la app.

## 📚 Tema central

La pantalla de carga de `Juann_Ciro` ya pasa sola al login después de unos segundos, y el login queda armado con campos de usuario y clave, botones y textos.

## 🧠 Qué se vio

**Pasar de una pantalla a otra.** `Precarga.java` usa un `Handler` con `postDelayed` para esperar 4000 ms (4 segundos) sin bloquear la pantalla. Cuando se cumple el tiempo:

- `new Intent(Precarga.this, MainActivity.class)` indica a qué pantalla se quiere ir.
- `startActivity(...)` la abre.
- `finish()` cierra la pantalla de carga, así el botón atrás no vuelve a ella.

**Imágenes nuevas.** El fondo de la carga se llama `fondo_carga.jpg`, el logo de la carga y del login es `sello_shairo.png` (un sello personal) y el login tiene su propio fondo, `fondo_principal.jpg`.

**Generar el APK.** Se generó el instalador de la app, `JuanEstebanCiro.apk`, que quedó en la carpeta del proyecto y se volvió a generar al final de la clase con el login terminado.

**`RelativeLayout`.** El login cambió el `ConstraintLayout` por un `RelativeLayout`, que ubica cada vista respecto al padre o a otra vista por su `id`:

- `layout_below="@id/..."`: pone la vista debajo de otra.
- `layout_centerHorizontal="true"`: la centra en horizontal.
- `layout_alignParentEnd="true"`: la pega al borde derecho.

**`ScrollView`.** El formulario va dentro de un `ScrollView` para poder desplazarlo si no cabe, por ejemplo con el teclado abierto. Solo admite un hijo directo, por eso los campos van dentro de otro `RelativeLayout`.

**Campos de texto.** Cada campo es un `TextInputLayout` de Material con un `EditText` adentro. El `hint` es el texto guía que sube como etiqueta cuando se empieza a escribir.

- `inputType="textEmailAddress"` en el usuario abre el teclado con `@` y punto a la mano.
- `inputType="textPassword"` en la clave oculta lo que se escribe.
- `app:passwordToggleEnabled="true"` agrega el ícono de ojo para mostrar u ocultar la clave.

**Botones con color.** Los botones usan `backgroundTint` con dos colores nuevos en `colors.xml`:

| Color | Valor | Dónde |
| --- | --- | --- |
| `verde_esmeralda` | `#17916C` | botón «Ingresar» |
| `azul_cielo` | `#66BDBD` | botón «Pagina Web» |

**Textos agrupados.** `strings.xml` quedó dividido con comentarios en tres grupos: pantalla de carga, controles generales y login.

| Grupo | Variables |
| --- | --- |
| Controles generales | `nuevo`, `editar`, `actualizar`, `eliminar` |
| Login | `login`, `usuario`, `clave`, `olvidaste_contraseña`, `ingresar`, `web`, `no_cuenta`, `sello_personal` |

Los controles generales todavía no se usan en ningún layout. `sello_personal` se usa como `contentDescription` del logo, el texto que leen los lectores de pantalla.

## 💻 Ejercicios trabajados

**`Juann_Ciro`**: la app abre en `Precarga` y a los 4 segundos pasa a `MainActivity`, que es el login. El login tiene, de arriba abajo:

- el logo `sello_shairo.png`,
- el título «Login de Acceso» (22sp, negrita),
- el campo de usuario,
- el campo de clave con el ícono de ojo,
- el texto «Olvidaste tu contraseña», alineado a la derecha,
- el botón «Ingresar» (verde),
- el botón «Pagina Web» (azul),
- el texto «Registrarte» (25sp, negrita, centrado).

Por ahora el login es solo diseño: `MainActivity.java` muestra el layout pero no tiene código que lea los campos ni que responda a los botones.

## ⚠️ Errores comunes / cosas a las que prestar atención

- En el Manifest, `MainActivity` sigue con `MAIN` + `LAUNCHER`, así que la app aparece dos veces en el celular y uno de los íconos abre el login sin pasar por la carga. Hay que quitarle ese `intent-filter` y dejarlo solo en `Precarga`.
- `new Handler()` sin parámetros está obsoleto. La forma recomendada es `new Handler(Looper.getMainLooper())`.
- `passwordToggleEnabled` también está obsoleto en Material. El reemplazo es `app:endIconMode="password_toggle"`.
- Dentro de un `TextInputLayout`, Material recomienda usar `TextInputEditText` en lugar de `EditText` para que la etiqueta flotante funcione bien.
- El campo de usuario tiene `textColor="@color/white"` y el de clave no, así que el texto se ve de distinto color en cada uno.
- El nombre `olvidaste_contraseña` lleva ñ. Para los nombres de recursos lo más seguro es usar solo letras sin tilde, números y guion bajo.
- El APK pesa unos 18 MB y queda versionado en el repo; cada vez que se regenera, el historial crece otro tanto.

## ✅ Ideas clave

- ⏱️ `Handler.postDelayed` ejecuta algo después de un tiempo sin congelar la pantalla.
- 🚪 `Intent` + `startActivity` abren otra pantalla, y `finish()` cierra la actual.
- 📐 `RelativeLayout` acomoda las vistas respecto a otras con `layout_below` y los `align`.
- 📜 `ScrollView` deja desplazar el formulario y solo acepta un hijo directo.
- 🔐 `TextInputLayout` + `inputType="textPassword"` arman un campo de clave con el ícono de ojo.
- 🎨 Los colores nuevos van en `colors.xml` y se aplican a los botones con `backgroundTint`.
- 🔤 `strings.xml` se puede ordenar en grupos con comentarios.
- 📦 El APK es el instalador que se genera para probar la app fuera de Android Studio.
