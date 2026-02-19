package com.lab5map;

import com.lab5map.model.Circulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    void deveCriarCirculoComRaioValido() {
        assertDoesNotThrow(() -> new Circulo(2.0));
    }

    @Test
    void deveLancarErroQuandoRaioForZero() {
        assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
    }

    @Test
    void deveLancarErroQuandoRaioForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Circulo(-1));
    }

    @Test
    void deveCalcularAreaCorretamente() {
        Circulo c = new Circulo(2.0);
        assertEquals(Math.PI * 4.0, c.area(), 1e-9);
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Circulo c = new Circulo(2.0);
        assertEquals(2 * Math.PI * 2.0, c.perimetro(), 1e-9);
    }

    @Test
    void deveRetornarNomeCorreto() {
        Circulo c = new Circulo(1.0);
        assertEquals("Círculo", c.nome());
    }
}
