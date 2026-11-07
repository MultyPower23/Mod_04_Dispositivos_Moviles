package com.ciro.juann_ciro;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Una Activity representa una pantalla de la app.
// AppCompatActivity agrega compatibilidad con versiones antiguas de Android.
public class MainActivity extends AppCompatActivity {

    // onCreate es el primer método que Android llama al abrir la pantalla.
    // savedInstanceState trae el estado guardado si la pantalla se recrea (por ejemplo, al girar el celular).
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hace que el contenido se dibuje detrás de la barra de estado y la de navegación.
        EdgeToEdge.enable(this);
        // Conecta esta Activity con su diseño XML; R.layout es la clase generada con los recursos.
        setContentView(R.layout.activity_main);
        // Agrega un padding igual al tamaño de las barras del sistema para que no tapen el contenido.
        // R.id.main es el id que tiene la vista raíz en el XML.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
