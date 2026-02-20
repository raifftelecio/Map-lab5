package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Circulo;

public class CirculoTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        Field f = Circulo.class.getDeclaredField("instance");
        f.setAccessible(true);
        f.set(null, null);
    }

    @Test
    void deveRetornarMesmaInstancia() {
        Circulo c1 = Circulo.getInstance(5);
        Circulo c2 = Circulo.getInstance(10);
        assertSame(c1, c2);
    }

    @Test
    void raioNaoMudaDepoisDaPrimeiraCriacao() {
        Circulo c1 = Circulo.getInstance(5);
        Circulo c2 = Circulo.getInstance(10);
        assertEquals(5, c2.getRaio(), 1e-9);
    }
}