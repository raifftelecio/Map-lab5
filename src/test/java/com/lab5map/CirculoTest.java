package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void deveCalcularAreaCorretamente() {
        Circulo c = Circulo.getInstance(10);
        assertEquals(Math.PI * 100, c.calculaArea(), 1e-9);
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Circulo c = Circulo.getInstance(10);
        assertEquals(2 * Math.PI * 10, c.calculaPerimetro(), 1e-9);
    }

    @Test
    void deveRetornarMesmaInstanciaParaMesmoRaio() {
        Circulo c1 = Circulo.getInstance(10);
        Circulo c2 = Circulo.getInstance(10);
        assertSame(c1, c2);
    }

    @Test
    void deveLancarErroAoTentarCriarComRaioDiferente() {
        Circulo.getInstance(10);
        assertThrows(IllegalStateException.class, () -> Circulo.getInstance(12));
    }

    @Test
    void deveLancarErroSeRaioInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Circulo.getInstance(0));
    }
}