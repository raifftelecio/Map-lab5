package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Triangulo;

class TrianguloTest {

    @Test
    void deveCriarTrianguloEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertNotNull(t);
    }

    @Test
    void tipoDoTrianguloEquilateroDeveSerEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals(Triangulo.Tipo.EQUILATERO, t.getTipo());
    }

    @Test
    void deveCriarTrianguloIsosceles() {
        Triangulo t = Triangulo.isosceles(4, 6);
        assertNotNull(t);
    }

    @Test
    void tipoDoTrianguloIsoscelesDeveSerIsosceles() {
        Triangulo t = Triangulo.isosceles(4, 6);
        assertEquals(Triangulo.Tipo.ISOSCELES, t.getTipo());
    }

    @Test
    void deveCriarTrianguloRetangulo() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertNotNull(t);
    }

    @Test
    void tipoDoTrianguloRetanguloDeveSerRetangulo() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertEquals(Triangulo.Tipo.RETANGULO, t.getTipo());
    }

    @Test
    void trianguloRetanguloDeveTerHipotenusaCorreta() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertEquals(5.0, t.getC(), 1e-9);
    }

    @Test
    void deveLancarErroQuandoLadoForZeroNoEquilatero() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.equilatero(0));
    }

    @Test
    void deveLancarErroQuandoCatetoForNegativoNoRetangulo() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.retangulo(-3, 4));
    }

    @Test
    void deveLancarErroQuandoLadosNaoFormamTriangulo() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.isosceles(1, 99));
    }

    @Test
    void deveCalcularPerimetroCorretamenteNoEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals(9.0, t.perimetro(), 1e-9);
    }

    @Test
    void deveRetornarNomeCorretoNoEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals("Triângulo Equilátero", t.nome());
    }
}
