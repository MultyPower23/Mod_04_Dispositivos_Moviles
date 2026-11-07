# Reglas propias de ProGuard, la herramienta que reduce y ofusca el código al compilar en release.
# Solo se aplican si minifyEnabled está en true.

# Si la app usa un WebView con JavaScript, esta regla evita que se renombre la clase que lo conecta.
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Conserva los números de línea para que los errores muestren dónde ocurrieron.
#-keepattributes SourceFile,LineNumberTable

# Oculta el nombre original de los archivos si se conservan los números de línea.
#-renamesourcefileattribute SourceFile