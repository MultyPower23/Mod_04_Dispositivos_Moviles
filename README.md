# Mod_04_Dispositivos_Moviles

Proyectos de Android Studio y resúmenes de clase del Módulo 4 (Programación para Dispositivos Móviles). Este repo entra al repo [`Tecnica`](https://github.com/MultyPower23/Tecnica) como submódulo en `Mod_04_Dispositivos_Moviles`.

## 📂 Estructura

```txt
Mod_04_Dispositivos_Moviles/
├── Kotlin/
│   ├── Clase_27/
│   │   └── Clase_27.md
│   ├── Clase_28/
│   │   ├── Clase_28.md
│   │   ├── Prueba1/
│   │   └── Proyecto_Prueba/
│   ├── Clase_29/
│   │   ├── Clase_29.md
│   │   └── Juann_Ciro/
│   └── Clase_30/
│       ├── Clase_30.md
│       └── Dispositivos/
├── .gitignore
└── README.md
```

Cada `Clase_N/` lleva su resumen `Clase_N.md` y, si la clase dejó código, los proyectos de Android Studio en subcarpetas. El trabajo grande del módulo irá en este mismo repo.

## 📱 Proyectos

| Proyecto | Clase | Qué es |
| --- | --- | --- |
| `Prueba1` | Clase_28 | Layout con `TextView`, `ImageView`, `Button` y `CheckBox` |
| `Proyecto_Prueba` | Clase_28 | Pantalla `Precarga` con fondo e imagen, y la librería Lottie agregada |
| `Juann_Ciro` | Clase_29 | Pantalla `Precarga` con animación Lottie, imágenes y textos en `strings.xml` |
| `Dispositivos` | Clase_30 | Primer proyecto en Kotlin con Jetpack Compose: clases de datos para una lista de dispositivos |

## ▶️ Cómo abrir un proyecto

En Android Studio: `File → Open` y elegir la carpeta del proyecto (la que contiene `settings.gradle` o `settings.gradle.kts`, por ejemplo `Kotlin/Clase_29/Juann_Ciro`), no la raíz del repo. Gradle descarga las dependencias en la primera sincronización y Android Studio crea por su cuenta `local.properties` y `.idea/`, que no se versionan.

## 📥 Cómo clonar

Como parte de `Tecnica`:

```bash
git clone --recurse-submodules https://github.com/MultyPower23/Tecnica.git
```

Solo este repo:

```bash
git clone https://github.com/MultyPower23/Mod_04_Dispositivos_Moviles.git
```
