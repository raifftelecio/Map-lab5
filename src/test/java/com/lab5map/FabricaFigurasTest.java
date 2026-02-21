package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.factory.FabricaFiguras;
import com.lab5map.model.Circulo;
import com.lab5map.model.FiguraGeometrica;
import com.lab5map.model.Triangulo;

public class FabricaFigurasTest {

    @BeforeEach
    void resetSingletons() throws Exception {
        // Reset do Circulo.instance
        Field fCirculo = Circulo.class.getDeclaredField("instance");
        fCirculo.setAccessible(true);
        fCirculo.set(null, null);

        // Reset dos "multitons" de Triangulo
        Field fEq = Triangulo.class.getDeclaredField("equilatero");
        Field fIso = Triangulo.class.getDeclaredField("isoceles");
        Field fRet = Triangulo.class.getDeclaredField("retangulo");

        fEq.setAccessible(true);
        fIso.setAccessible(true);
        fRet.setAccessible(true);

        fEq.set(null, null);
        fIso.set(null, null);
        fRet.set(null, null);
    }

    // criarCirculo
    @Test
    void criarCirculo_deveRetornarMesmaInstancia() {
        FiguraGeometrica c1 = FabricaFiguras.criarCirculo(10);
        FiguraGeometrica c2 = FabricaFiguras.criarCirculo(10);

        assertSame(c1, c2);
    }

    @Test
    void criarCirculo_deveLancarErroSeTentarCriarComRaioDiferente() {
        FabricaFiguras.criarCirculo(10);

        assertThrows(IllegalStateException.class, () -> FabricaFiguras.criarCirculo(12));
    }

    // criarQuadrado
    @Test
    void criarQuadrado_deveCriarNovasInstancias() {
        FiguraGeometrica q1 = FabricaFiguras.criarQuadrado(4);
        FiguraGeometrica q2 = FabricaFiguras.criarQuadrado(4);

        assertNotSame(q1, q2);
    }

    // criarTrianguloEquilatero
    @Test
    void criarTrianguloEquilatero_deveRetornarMesmaInstancia() {
        FiguraGeometrica t1 = FabricaFiguras.criarTrianguloEquilatero(6);
        FiguraGeometrica t2 = FabricaFiguras.criarTrianguloEquilatero(6);

        assertSame(t1, t2);
    }

    @Test
    void criarTrianguloEquilatero_deveLancarErroSeTentarCriarComOutroLado() {
        FabricaFiguras.criarTrianguloEquilatero(6);

        assertThrows(IllegalStateException.class, () -> FabricaFiguras.criarTrianguloEquilatero(7));
    }

    // criarTrianguloIsoceles
    @Test
    void criarTrianguloIsoceles_deveRetornarMesmaInstancia() {
        FiguraGeometrica t1 = FabricaFiguras.criarTrianguloIsoceles(5, 6);
        FiguraGeometrica t2 = FabricaFiguras.criarTrianguloIsoceles(5, 6);

        assertSame(t1, t2);
    }

    @Test
    void criarTrianguloIsoceles_deveLancarErroSeTentarCriarComOutrosLados() {
        FabricaFiguras.criarTrianguloIsoceles(5, 6);

        assertThrows(IllegalStateException.class, () -> FabricaFiguras.criarTrianguloIsoceles(5, 7));
    }

    // criarTrianguloRetangulo
    @Test
    void criarTrianguloRetangulo() {
        FiguraGeometrica t1 = FabricaFiguras.criarTrianguloRetangulo(3, 4, 5);
        FiguraGeometrica t2 = FabricaFiguras.criarTrianguloRetangulo(3, 4, 5);

        assertSame(t1, t2);
    }

    @Test
    void criarTrianguloRetangulo_deveLancarErroSeTentarCriarComOutrosLados() {
        FabricaFiguras.criarTrianguloRetangulo(3, 4, 5);

        assertThrows(IllegalStateException.class, () -> FabricaFiguras.criarTrianguloRetangulo(6, 8, 10));
    }
}
