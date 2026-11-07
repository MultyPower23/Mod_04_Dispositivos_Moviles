# Dispositivos Móviles — Clase 27

## 📚 Tema central

Arranque de Programación para Dispositivos Móviles: los cuatro tipos de aplicación móvil y las primeras fases del proceso de desarrollo de una app.

## 🧠 Qué se vio

El módulo va con Android Studio y Kotlin y dura 10 semanas, pero la primera es de introducción y la última es para la entrega final, así que quedan 8 de contenido real. Cubre diseño de software pensado para móviles, desarrollo de apps y pruebas y depuración con simuladores.

Antes de entrar en materia hubo un repaso rápido de qué es software y qué es hardware, y quedó una idea que atraviesa todo el módulo: uno no programa para sí mismo, programa para el consumidor. Quién es cliente y quién es consumidor depende de para quién trabajás. Si le desarrollás a una empresa, la empresa es el cliente y los consumidores son las personas que le compran a esa empresa. Si hacés una app propia y la distribuís directo al público, el consumidor es quien la usa.

Lo central de la clase fueron los cuatro tipos de app. Lo que los diferencia es cuánto código se escribe por plataforma y qué tan cerca queda la app del sistema operativo, y de ahí salen el costo, el rendimiento y el acceso al hardware de cada uno.

La app nativa se hace para un solo sistema operativo, en su lenguaje propio: Kotlin para Android y Swift para iOS. Como está hecha a la medida de ese sistema, es la que mejor rinde, la que tiene acceso completo a la cámara, el micrófono, los sensores, el lector biométrico y las redes, y la que puede funcionar sin internet si se diseñó para eso. El costo es que una app de Android no corre en iOS ni al revés, así que para estar en los dos hacen falta dos desarrollos separados, gente experta en cada lenguaje y unos 4 a 6 meses de trabajo.

La app web es un sitio hecho con HTML5 y JavaScript que se ve como una app pero se abre desde el navegador (Chrome, Safari). Un solo desarrollo sirve para todas las plataformas, con tecnologías conocidas, poco tiempo y poco costo. A cambio tiene acceso limitado a las funciones del celular, no se puede subir a las tiendas, la experiencia cambia según el navegador y necesita internet aunque se haya pensado para funcionar sin conexión, por ejemplo para el primer ingreso o para actualizarse.

La app híbrida queda en el medio: se programa con HTML, CSS y JavaScript como una web, pero se empaqueta como una app instalable. Sale más barata porque usa lenguajes con más gente disponible, un solo desarrollo sirve para las dos plataformas, tarda unos 3 meses, accede a algunas funciones del celular y se puede subir a App Store y Google Play para monetizarla. Por dentro sigue siendo una web, así que suele pesar más, ir más lenta que una nativa y tener acceso limitado al dispositivo.

La app multiplataforma también comparte código, pero se escribe una vez con herramientas como Flutter, React Native o Xamarin y se compila un proyecto propio para cada plataforma. Una sola base de código sirve para iOS y Android, puede salir hasta un 30 % más barata y se compila para las dos al mismo tiempo. Rinde menos que la nativa, el código es más complejo de diseñar y cuando el sistema saca una función nueva hay que esperar a que el framework la soporte.

La otra parte fue el proceso de desarrollo de una app. Tiene seis fases: Estrategia, Planificación, Diseño, Implementación, Pruebas y Lanzamiento, y en esta clase se vieron a fondo dos.

La planificación es el cómo llegar al objetivo partiendo el proyecto en tareas manejables. Se arma un roadmap con las funcionalidades prioritarias (login, registro, notificaciones push), se estiman tiempo y recursos con Trello, Jira o hasta un Excel, se elige la tecnología (Kotlin o Java con Android Studio para Android, Swift con Xcode para iOS, o algo multiplataforma como Flutter) y se definen el equipo y los riesgos, por ejemplo la compatibilidad con versiones viejas del sistema.

El diseño es donde la app toma forma visual y funcional, como el plano de una casa antes de construirla. Por un lado está la interfaz y la experiencia de uso (UI/UX), con wireframes y mockups en Figma, Adobe XD o Sketch, pensando en el uso con el dedo: botones grandes y navegación intuitiva. Por el otro está la arquitectura técnica: la base de datos (por ejemplo Firebase), las APIs y cómo fluyen los datos. Se insistió en la accesibilidad: colores que funcionen para personas daltónicas y soporte para lectores de pantalla.

La clase cerró con algunas dinámicas para conocer al grupo.

## 💻 Ejercicios trabajados

No hubo código: toda la clase fue teoría introductoria del módulo.

## ⚠️ Errores comunes / cosas a las que prestar atención

- Híbrida y multiplataforma se confunden fácil. La híbrida mete una sola app web dentro de un contenedor nativo; la multiplataforma compila un proyecto propio por plataforma desde la misma base de código. Por eso rinden distinto.
- De las seis fases del proceso solo se vieron Planificación y Diseño; Estrategia, Implementación, Pruebas y Lanzamiento quedan para cuando se vean en clase.
- Las fechas de evaluación que se anotaron en clase no son las correctas; las oficiales llegan en la hoja que entregan en la siguiente clase.

## ✅ Ideas clave

- 🎯 El módulo usa Android Studio y Kotlin: 10 semanas, 8 de contenido real.
- 🙋 Se programa para el consumidor, y quién es cliente y quién es consumidor depende de para quién trabajás.
- 📱 Nativa: el mejor rendimiento y acceso total al hardware, pero la más cara y lenta de construir.
- 🌐 Web: la más barata y rápida, pero la más limitada en funciones y sin tiendas de apps.
- 🔀 Híbrida y multiplataforma reutilizan código para las dos plataformas, cada una a su manera y con menos rendimiento que la nativa.
- 📋 La planificación define el roadmap, las herramientas y los riesgos antes de tocar código.
- 🎨 El diseño le da forma visual y arquitectura técnica a la app, sin dejar de lado la accesibilidad.
