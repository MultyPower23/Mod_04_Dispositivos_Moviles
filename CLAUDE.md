# Contexto del repo `Mod_04_Dispositivos_Moviles`

Repo del Módulo 4 (Programación para Dispositivos Móviles) del Técnico en Programación y Desarrollo de Software (UPB Medellín). Entra a [`MultyPower23/Tecnica`](https://github.com/MultyPower23/Tecnica) como git submodule en `Mod_04_Dispositivos_Moviles/`. Las reglas generales viven en el `CLAUDE.md` de `Tecnica`; este archivo resume las que aplican aquí.

## Estructura

```
Mod_04_Dispositivos_Moviles/
├── Kotlin/          Clase_27 en adelante, una carpeta por clase
│   └── Clase_N/     Clase_N.md + proyectos de Android Studio de esa clase
├── Juann_Ciro/      proyecto principal del módulo (Java), desde la Clase_29
├── .vscode/         settings.json, extensions.json
├── .gitignore
├── CLAUDE.md
└── README.md
```

- La numeración de clase es continua con `Tecnica` (no reinicia en el módulo).
- El resumen `Clase_N.md` siempre va en su carpeta de clase, aunque la clase no haya dejado código.
- Cada proyecto de Android Studio va en su propia subcarpeta dentro de la clase y se abre desde ella, no desde la raíz.
- El proyecto principal del módulo es `Juann_Ciro/`, en la raíz; los avances de cada clase sobre él se documentan en el `Clase_N.md` de esa clase.

## Conexión con `Tecnica`

- `INDICE_GENERAL.md` y `COMMIT_CONVENTION.md` están en `Tecnica`, no aquí.
- Una clase nueva o un resumen nuevo implica dos cambios: el commit aquí y, en `Tecnica`, la fila en `INDICE_GENERAL.md` más la actualización del puntero del submódulo.
- Tras un `pull` en `Tecnica`: `git submodule update --init --recursive`.

## ⚠️ Verificar rutas después de cualquier cambio

Al mover o renombrar algo, revisar y reparar en el mismo cambio:

- Links en los `.md` de este repo y las rutas del `INDICE_GENERAL.md` de `Tecnica`.
- `package` de Java/Kotlin, `namespace`/`applicationId` en `build.gradle(.kts)` y `rootProject.name` en `settings.gradle(.kts)`.
- Referencias a recursos (`@drawable/`, `@string/`, `R.layout.`) y al `AndroidManifest.xml`.
- La tabla de proyectos y el diagrama del `README.md`.

## Android Studio

- El código Android se edita y formatea en Android Studio (4 espacios). VS Code no reformatea Java, Kotlin, XML ni Gradle.
- `.idea/`, `.gradle/`, `build/` y `local.properties` no se versionan; Android Studio los regenera.

## Git y PR

- Nunca trabajar sobre `main`: una rama descriptiva por tarea (`clase-31`, `fix-readme`).
- Commits según `COMMIT_CONVENTION.md` de `Tecnica`: `work:`, `clase:`, `resumen:`, `fix:`, `ejercicio:`, `config:`, `docs:`, `chore:`; minúscula, verbo en presente, sin punto final, un commit por propósito.
- Al terminar, PR hacia `main` con el mismo prefijo en el título y un par de líneas de qué y por qué. El merge lo hago yo.

## Comentarios en el código

- Una a tres líneas, tono neutro, arriba de la línea que describen; qué hace y por qué.
- Sin emojis, sin notas meta, sin referencias a otros archivos del repo, con tildes correctas.
- En layouts XML, comentarios `<!-- -->` arriba de la vista o atributo que explican.
- Al explicar código en el chat, cerrar con bullets con emoji: una línea por método o función.

## Resúmenes `Clase_N.md`

- Cinco secciones: `📚 Tema central`, `🧠 Qué se vio`, `💻 Ejercicios trabajados`, `⚠️ Errores comunes / cosas a las que prestar atención` (si aplica), `✅ Ideas clave`.
- Tono casual de compañero de clase, sin muletillas ni cierres genéricos, sin negritas ni HTML.
- Si falta material, declararlo con ⚠️ al inicio; nunca inventar contenido.
- Solo el estado actual: nada de "antes era así", ni en resúmenes ni en comentarios.

## Estilo de trabajo y entorno

- Fase por fase, pausando para confirmación; explicar el problema antes de la solución.
- Las decisiones se difieren hasta que haya un caso real que las justifique.
- Windows, VS Code para `.md` y Android Studio para los proyectos.
- El `.vscode/` de este repo aplica al abrirlo solo; abierto desde `Tecnica` rige el de `Tecnica`.
