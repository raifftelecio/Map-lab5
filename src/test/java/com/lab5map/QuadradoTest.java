package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Quadrado;

public class QuadradoTest {

    @Test
    void deveCalcularAreaCorretamente() {
        Quadrado q = new Quadrado(4);
        assertEquals(16.0, q.calculaArea(), 1e-9);
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Quadrado q = new Quadrado(4);
        assertEquals(16.0, q.calculaPerimetro(), 1e-9);
    }

    @Test
    void devePermitirMultiplasInstancias() {
        Quadrado q1 = new Quadrado(4);
        Quadrado q2 = new Quadrado(4);
        assertNotSame(q1, q2);
    }

    @Test
    void deveLancarErroSeLadoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Quadrado(0));
    }
}