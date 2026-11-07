package com.ciro.juann_ciro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Una Activity representa una pantalla de la app.
// AppCompatActivity agrega compatibilidad con versiones antiguas de Android.
public class MainActivity extends AppCompatActivity {

    Button btnWeb;

    Button btnIngresar;
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

        btnWeb = findViewById(R.id.btnWeb);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Estamos aprendiendo", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, PaginaWeb.class));
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "No tienes errores", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
