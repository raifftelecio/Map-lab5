package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Quadrado;

class QuadradoTest {

    @Test
    void deveCriarQuadradoComLadoValido() {
        assertDoesNotThrow(() -> new Quadrado(3.0));
    }

    @Test
    void deveLancarErroQuandoLadoForZero() {
        assertThrows(IllegalArgumentException.class, () -> new Quadrado(0));
    }

    @Test
    void deveLancarErroQuandoLadoForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Quadrado(-2));
    }

    @Test
    void deveCalcularAreaCorretamente() {
        Quadrado q = new Quadrado(3.0);
        assertEquals(9.0, q.area(), 1e-9);
    }

    @Test
    void deveCalcularPerimetroCorretamente() {
        Quadrado q = new Quadrado(3.0);
        assertEquals(12.0, q.perimetro(), 1e-9);
    }

    @Test
    void deveRetornarNomeCorreto() {
        Quadrado q = new Quadrado(1.0);
        assertEquals("Quadrado", q.nome());
    }
}
