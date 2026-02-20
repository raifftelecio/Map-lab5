package com.lab5map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Triangulo;

class TrianguloTest {

    @Test // deve criar triangulo equilatero
    void CriarTrianguloEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertNotNull(t);
    }

    @Test // tipo do triangulo equilatero deve ser equilatero
    void tipoDoTrianguloEquilateroCorreto() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals(Triangulo.Tipo.EQUILATERO, t.getTipo());
    }

    @Test // deve criar triangulo isosceles
    void CriarTrianguloIsosceles() {
        Triangulo t = Triangulo.isosceles(4, 6);
        assertNotNull(t);
    }

    @Test // tipo do triangulo isosceles deve ser isosceles
    void tipoDoTrianguloIsoscelesCorreto() {
        Triangulo t = Triangulo.isosceles(4, 6);
        assertEquals(Triangulo.Tipo.ISOSCELES, t.getTipo());
    }

    @Test // deve criar triangulo retangulo
    void CriarTrianguloRetangulo() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertNotNull(t);
    }

    @Test // tipo Do Triangulo Retangulo Deve Ser Retangulo
    void tipoDoTrianguloRetanguloCorreto() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertEquals(Triangulo.Tipo.RETANGULO, t.getTipo());
    }

    @Test // triangulo Retangulo Deve Ter Hipotenusa Correta
    void triRetanguloHipotenusaCorreta() {
        Triangulo t = Triangulo.retangulo(3, 4);
        assertEquals(5.0, t.getC(), 1e-9);
    }

    @Test // deve Lancar Erro Quando Lado For Zero No Equilatero
    void ErroLadoZeroNoEquilatero() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.equilatero(0));
    }

    @Test // deve Lancar Erro Quando Cateto For Negativo No Retangulo
    void ErroCatetoNegativoNoRetangulo() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.retangulo(-3, 4));
    }

    @Test // deve Lancar Erro Quando Lados Nao Formam Triangulo
    void ErroLadosNaoFormamTriangulo() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.isosceles(1, 99));
    }

    @Test // deve Calcular Perimetro Corretamente No Equilatero
    void CalcularPerimetroCorretoNoEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals(9.0, t.perimetro(), 1e-9);
    }

    @Test // deve Retornar Nome Correto No Equilatero
    void RetornarNomeCorretoNoEquilatero() {
        Triangulo t = Triangulo.equilatero(3);
        assertEquals("Triângulo Equilátero", t.nome());
    }
}
