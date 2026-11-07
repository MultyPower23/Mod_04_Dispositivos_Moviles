package com.ciro.juann_ciro;

import org.junit.Test;

// import static deja usar los métodos de Assert, como assertEquals, sin escribir el nombre de la clase.
import static org.junit.Assert.*;

// Prueba unitaria de ejemplo: corre en el computador, sin celular ni emulador.
public class ExampleUnitTest {
    // @Test marca el método como una prueba que JUnit ejecuta.
    @Test
    public void addition_isCorrect() {
        // assertEquals compara el valor esperado con el obtenido y falla la prueba si son distintos.
        assertEquals(4, 2 + 2);
    }
}
