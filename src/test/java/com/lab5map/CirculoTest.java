package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Circulo;

class CirculoTest {

    @Test // deve criar um circulo com raio válido
    void CriarCirculoRaioValido() {
        assertDoesNotThrow(() -> new Circulo(2.0));
    }

    @Test // deve lancar erro quando raio for zero
    void ErroRaioIgualZero() {
        assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
    }

    @Test // deve lancar erro quando raio for negativo
    void ErroRaioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Circulo(-1));
    }

    @Test // deve calcular area corretamente
    void CalcularAreaCorretamente() {
        Circulo c = new Circulo(2.0);
        assertEquals(Math.PI * 4.0, c.area(), 1e-9);
    }

    @Test // deve calcular perimetro corretamente
    void CalcularPerimetroCorretamente() {
        Circulo c = new Circulo(2.0);
        assertEquals(2 * Math.PI * 2.0, c.perimetro(), 1e-9);
    }

    @Test // deve retornar nome correto
    void RetornarNomeCorreto() {
        Circulo c = new Circulo(1.0);
        assertEquals("Círculo", c.nome());
    }
}
