package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Quadrado;

class QuadradoTest {

    @Test // deve Criar Quadrado Com Lado Valido
    void CriarQuadradoLadoValido() {
        assertDoesNotThrow(() -> new Quadrado(3.0));
    }

    @Test // deve Lancar Erro Quando Lado For Zero
    void ErroLadoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Quadrado(0));
    }

    @Test // deve Lancar Erro Quando Lado For Negativo
    void ErroLadoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Quadrado(-2));
    }

    @Test // deve Calcular Area Corretamente
    void CalcularAreaCorreta() {
        Quadrado q = new Quadrado(3.0);
        assertEquals(9.0, q.area(), 1e-9);
    }

    @Test // deveCalcular Perimetro Corretamente
    void CalcularPerimetroCorreto() {
        Quadrado q = new Quadrado(3.0);
        assertEquals(12.0, q.perimetro(), 1e-9);
    }

    @Test // deve Retornar Nome Correto
    void RetornarNomeCorreto() {
        Quadrado q = new Quadrado(1.0);
        assertEquals("Quadrado", q.nome());
    }
}
