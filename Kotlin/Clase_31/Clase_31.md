# Dispositivos Móviles — Clase 31

> ⚠️ No hay apuntes de esta clase. Este resumen se armó con los commits del día de la clase sobre el proyecto `Juann_Ciro` y con su código, así que puede faltar lo que se explicó en vivo y no quedó en el código. El mensaje del último commit menciona el emulador, pero no quedó ningún registro de qué se hizo con él más allá de probar la app.

## 📚 Tema central

Navegar entre pantallas: la precarga de `Juann_Ciro` pasa sola al login después de unos segundos. Además, el login queda diseñado con `RelativeLayout`, campos de texto de Material y botones.

## 🧠 Qué se vio

Una app con varias pantallas necesita una forma de ir de una a otra. En Android eso se hace con un `Intent`, que es un mensaje que dice a qué Activity se quiere ir. `startActivity(intent)` abre esa pantalla, y `finish()` cierra la actual. En una precarga, `finish()` es lo que evita que el botón atrás vuelva a la pantalla de carga.

Para que el cambio ocurra solo, `Precarga.java` usa un `Handler` con `postDelayed`, que programa un bloque de código para dentro de un tiempo, aquí 4000 ms (4 segundos). La clave es que no detiene la app mientras espera: la pantalla sigue dibujándose y la animación sigue corriendo, y cuando se cumple el tiempo se ejecuta el `Runnable` con el `Intent` hacia `MainActivity`.

```java
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        startActivity(new Intent(Precarga.this, MainActivity.class));
        finish();
    }
}, 4000);
```

`MainActivity` es el login, y su layout está hecho con `RelativeLayout`. La plantilla de Android Studio trae `ConstraintLayout` por defecto. `RelativeLayout` ubica cada vista respecto al padre o respecto a otra vista por su `id`, lo que sirve para formularios donde cada elemento va debajo del anterior:

- `layout_below="@id/..."` pone la vista debajo de otra.
- `layout_centerHorizontal="true"` la centra en horizontal.
- `layout_alignParentEnd="true"` la pega al borde derecho.

Como el orden depende de los `id`, si una vista cambia de `id` hay que actualizar todos los `layout_below` que la nombran.

El formulario va dentro de un `ScrollView` para que se pueda desplazar cuando no cabe, por ejemplo con el teclado abierto en un celular pequeño. Un `ScrollView` solo admite un hijo directo, por eso los campos van dentro de otro `RelativeLayout`.

Cada campo de texto es un `TextInputLayout` de Material con un `EditText` adentro. El `EditText` es donde se escribe; el `TextInputLayout` lo envuelve y hace que el `hint` (el texto guía) suba como etiqueta cuando se empieza a escribir. El `inputType` le dice al celular qué teclado mostrar y cómo tratar el texto:

- `textEmailAddress` en el usuario abre el teclado con `@` y punto a la mano.
- `textPassword` en la clave oculta lo que se escribe.
- `app:passwordToggleEnabled="true"` en el `TextInputLayout` de la clave agrega el ícono de ojo para mostrarla u ocultarla.

Los botones usan `backgroundTint` con dos colores nuevos en `colors.xml`. Igual que con los textos, el color se define una vez con nombre y el layout lo llama con `@color/nombre`:

| Color | Valor | Dónde |
| --- | --- | --- |
| `verde_esmeralda` | `#17916C` | botón «Ingresar» |
| `azul_cielo` | `#66BDBD` | botón «Pagina Web» |

`strings.xml` está dividido con comentarios en tres grupos: pantalla de carga, controles generales y login. Agrupar los textos ayuda a encontrarlos cuando la app crece.

| Grupo | Variables |
| --- | --- |
| Controles generales | `nuevo`, `editar`, `actualizar`, `eliminar` |
| Login | `login`, `usuario`, `clave`, `olvidaste_contraseña`, `ingresar`, `web`, `no_cuenta`, `sello_personal` |

Los controles generales todavía no se usan en ningún layout. `sello_personal` es el `contentDescription` del logo: el texto que leen los lectores de pantalla para describir la imagen a quien no la ve.

La precarga y el login usan imágenes propias: `fondo_carga.jpg` de fondo en la carga, `fondo_principal.jpg` en el login y `sello_shairo.png`, un sello personal, como logo en las dos.

También se generó el APK, `JuanEstebanCiro.apk`, que queda en la carpeta del proyecto y se volvió a generar al final de la clase con el login terminado.

## 💻 Ejercicios trabajados

`Juann_Ciro`: la app abre en `Precarga` y a los 4 segundos pasa a `MainActivity`, el login. El login tiene, de arriba abajo:

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

- En el Manifest, `MainActivity` tiene `MAIN` + `LAUNCHER`, así que la app aparece dos veces en el celular y uno de los íconos abre el login sin pasar por la carga. Hay que quitarle ese `intent-filter` y dejarlo solo en `Precarga`.
- Sin `finish()`, el botón atrás del login volvería a la pantalla de carga.
- `new Handler()` sin parámetros está obsoleto. La forma recomendada es `new Handler(Looper.getMainLooper())`.
- `passwordToggleEnabled` también está obsoleto en Material. El reemplazo es `app:endIconMode="password_toggle"`.
- Dentro de un `TextInputLayout`, Material recomienda `TextInputEditText` en lugar de `EditText` para que la etiqueta flotante funcione bien.
- El campo de usuario tiene `textColor="@color/white"` y el de clave no, así que el texto se ve de distinto color en cada uno.
- El nombre `olvidaste_contraseña` lleva ñ. Para los nombres de recursos lo más seguro es usar solo letras sin tilde, números y guion bajo.

## ✅ Ideas clave

- 🚪 Un `Intent` dice a qué pantalla ir, `startActivity` la abre y `finish()` cierra la actual.
- ⏱️ `Handler.postDelayed` ejecuta algo después de un tiempo sin congelar la pantalla.
- 📐 `RelativeLayout` acomoda cada vista respecto a otras con `layout_below` y los `align`.
- 📜 `ScrollView` deja desplazar el formulario y solo acepta un hijo directo.
- 🔐 `TextInputLayout` + `EditText` arman campos con etiqueta flotante, y el `inputType` define el teclado y si el texto se oculta.
- 🎨 Los colores se definen en `colors.xml` y se aplican a los botones con `backgroundTint`.
- 🔤 Agrupar `strings.xml` con comentarios ayuda a encontrar los textos cuando la app crece.
