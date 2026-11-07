// El paquete agrupa las clases de la app y le da a cada una un nombre completo único.
package com.ciro.juann_ciro;

// import trae clases de Android y de las librerías para poder usarlas por su nombre corto.
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Pantalla de carga (splash) que se muestra unos segundos y luego abre MainActivity.
// extends AppCompatActivity hace que esta clase sea una pantalla y herede su comportamiento.
public class Precarga extends AppCompatActivity {

    // @Override indica que este método reemplaza al que ya existe en AppCompatActivity.
    // onCreate es lo primero que Android ejecuta al crear la pantalla.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super llama al onCreate original para que Android prepare la pantalla antes del código propio.
        super.onCreate(savedInstanceState);
        // Dibuja el contenido detrás de la barra de estado y la de navegación, ocupando toda la pantalla.
        EdgeToEdge.enable(this);
        // Conecta esta clase con su diseño; R.layout.activity_precarga es el XML de res/layout.
        setContentView(R.layout.activity_precarga);

        // Handler programa una tarea para más tarde sin bloquear la pantalla.
        // postDelayed ejecuta el Runnable después de 4000 ms (4 segundos).
        new Handler().postDelayed(new Runnable() {
            // Runnable es una tarea con un solo método, run, que contiene lo que se va a ejecutar.
            @Override
            public void run() {
                // Un Intent indica a qué Activity se quiere ir; startActivity la abre.
                // Precarga.this es la pantalla actual, porque dentro del Runnable this sería el Runnable.
                startActivity(new Intent(Precarga.this, MainActivity.class));
                // finish cierra el splash para que el botón atrás no regrese a él.
                finish();
            }
        }, 4000);
    }
}
