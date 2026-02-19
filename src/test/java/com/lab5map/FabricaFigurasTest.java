package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.factory.FabricaFiguras;
import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

class FabricaFigurasTest {

    @BeforeEach
    void resetarSingletonParaNaoVazarEstadoEntreTestes() throws Exception {
        FabricaFiguras f = FabricaFiguras.getInstance();

        // Zera os campos internos (circulo e triângulos) para cada teste começar do zero.
        Field circulo = FabricaFiguras.class.getDeclaredField("circuloUnico");
        circulo.setAccessible(true);
        circulo.set(f, null);

        Field iso = FabricaFiguras.class.getDeclaredField("triIsosceles");
        iso.setAccessible(true);
        iso.set(f, null);

        Field equi = FabricaFiguras.class.getDeclaredField("triEquilatero");
        equi.setAccessible(true);
        equi.set(f, null);

        Field ret = FabricaFiguras.class.getDeclaredField("triRetangulo");
        ret.setAccessible(true);
        ret.set(f, null);
    }

    @Test
    void getInstanceDeveRetornarMesmaInstancia() {
        FabricaFiguras a = FabricaFiguras.getInstance();
        FabricaFiguras b = FabricaFiguras.getInstance();
        assertSame(a, b);
    }

    @Test
    void getCirculoDeveRetornarMesmoObjetoNaSegundaChamada() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Circulo c1 = f.getCirculo(2.0);
        Circulo c2 = f.getCirculo(2.0);
        assertSame(c1, c2);
    }

    @Test
    void getCirculoDeveLancarErroSeTentarOutroRaioDepoisDeCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getCirculo(2.0);
        assertThrows(IllegalStateException.class, () -> f.getCirculo(3.0));
    }

    @Test
    void getTrianguloEquilateroDeveRetornarObjetoCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloEquilatero(3.0);
        assertNotNull(t);
    }

    @Test
    void getTrianguloEquilateroDeveLancarErroAoCriarSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloEquilatero(3.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloEquilatero(10.0));
    }

    @Test
    void getTrianguloIsoscelesDeveRetornarObjetoCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloIsosceles(4.0, 6.0);
        assertNotNull(t);
    }

    @Test
    void getTrianguloIsoscelesDeveLancarErroAoCriarSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloIsosceles(4.0, 6.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloIsosceles(10.0, 10.0));
    }

    @Test
    void getTrianguloRetanguloDeveRetornarObjetoCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloRetangulo(3.0, 4.0);
        assertNotNull(t);
    }

    @Test
    void getTrianguloRetanguloDeveLancarErroAoCriarSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloRetangulo(3.0, 4.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloRetangulo(5.0, 12.0));
    }

    @Test
    void createQuadradoDeveCriarNovasInstanciasSempre() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Quadrado q1 = f.createQuadrado(2.0);
        Quadrado q2 = f.createQuadrado(2.0);
        assertNotSame(q1, q2);
    }

    @Test
    void quantidadeTriangulosCriadosDeveSerZeroNoInicio() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        assertEquals(0, f.quantidadeTriangulosCriados());
    }

    @Test
    void quantidadeTriangulosCriadosDeveSerTresDepoisDeCriarTodos() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloEquilatero(3.0);
        f.getTrianguloIsosceles(4.0, 6.0);
        f.getTrianguloRetangulo(3.0, 4.0);
        assertEquals(3, f.quantidadeTriangulosCriados());
    }
}