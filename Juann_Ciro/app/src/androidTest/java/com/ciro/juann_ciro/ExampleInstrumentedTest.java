package com.ciro.juann_ciro;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

// Prueba instrumentada de ejemplo: corre dentro de un celular o emulador con la app instalada.
// @RunWith indica que la ejecuta el runner de Android en lugar del de JUnit normal.
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context da acceso a la información y los recursos de la app que se está probando.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // Comprueba que el paquete de la app sea el esperado.
        assertEquals("com.ciro.juann_ciro", appContext.getPackageName());
    }
}
