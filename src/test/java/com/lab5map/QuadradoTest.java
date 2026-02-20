package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Quadrado;

public class QuadradoTest {

    @Test
    void quadradosDevemSerInstanciasDiferentes() {
        Quadrado q1 = new Quadrado(4);
        Quadrado q2 = new Quadrado(4);
        assertNotSame(q1, q2);
    }

    @Test
    void areaEPerimetro() {
        Quadrado q = new Quadrado(4);
        assertEquals(16, q.area(), 1e-9);
        assertEquals(16, q.perimetro(), 1e-9);
    }
}