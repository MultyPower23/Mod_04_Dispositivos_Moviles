package com.ciro.juann_ciro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Pantalla de carga (splash) que se muestra unos segundos y luego abre MainActivity.
public class Precarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_precarga);

        // Handler programa una tarea para más tarde sin bloquear la pantalla.
        // postDelayed ejecuta el Runnable después de 4000 ms (4 segundos).
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Un Intent indica a qué Activity se quiere ir; startActivity la abre.
                startActivity(new Intent(Precarga.this, MainActivity.class));
                // finish cierra el splash para que el botón atrás no regrese a él.
                finish();
            }
        }, 4000);
    }
}
