package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Triangulo;

public class TrianguloTest {

    @BeforeEach
    void resetMultitons() throws Exception {
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

    // EQUILATERO
    @Test
    void equilateroDeveCalcularAreaCorretamente() {
        Triangulo t = Triangulo.getEquilatero(6);
        double esperado = (Math.sqrt(3) / 4.0) * 6 * 6; // 9*sqrt(3)
        assertEquals(esperado, t.calculaArea(), 1e-9);
    }

    @Test
    void equilateroDeveCalcularPerimetroCorretamente() {
        Triangulo t = Triangulo.getEquilatero(6);
        assertEquals(18.0, t.calculaPerimetro(), 1e-9);
    }

    @Test
    void equilateroDeveRetornarMesmaInstancia() {
        Triangulo t1 = Triangulo.getEquilatero(6);
        Triangulo t2 = Triangulo.getEquilatero(6);
        assertSame(t1, t2);
    }

    @Test
    void equilateroDeveLancarErroSeTentarRecriarComOutroLado() {
        Triangulo.getEquilatero(6);
        assertThrows(IllegalStateException.class, () -> Triangulo.getEquilatero(7));
    }

    // ISOCELES (5,5,6)
    @Test
    void isocelesDeveCalcularAreaCorretamente() {
        Triangulo t = Triangulo.getIsoceles(5, 6);
        // Heron: s=8 => area = sqrt(8*3*3*2)=sqrt(144)=12
        assertEquals(12.0, t.calculaArea(), 1e-9);
    }

    @Test
    void isocelesDeveCalcularPerimetroCorretamente() {
        Triangulo t = Triangulo.getIsoceles(5, 6);
        assertEquals(16.0, t.calculaPerimetro(), 1e-9);
    }

    @Test
    void isocelesDeveRetornarMesmaInstancia() {
        Triangulo t1 = Triangulo.getIsoceles(5, 6);
        Triangulo t2 = Triangulo.getIsoceles(5, 6);
        assertSame(t1, t2);
    }

    @Test
    void isocelesDeveLancarErroSeTentarRecriarComOutrosLados() {
        Triangulo.getIsoceles(5, 6);
        assertThrows(IllegalStateException.class, () -> Triangulo.getIsoceles(5, 7));
    }

    @Test
    void isocelesDeveLancarErroSeBaseIgualAoLado() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.getIsoceles(5, 5));
    }

    // RETANGULO (3,4,5)
    @Test
    void retanguloDeveCalcularAreaCorretamente() {
        Triangulo t = Triangulo.getRetangulo(3, 4, 5);
        assertEquals(6.0, t.calculaArea(), 1e-9);
    }

    @Test
    void retanguloDeveCalcularPerimetroCorretamente() {
        Triangulo t = Triangulo.getRetangulo(3, 4, 5);
        assertEquals(12.0, t.calculaPerimetro(), 1e-9);
    }

    @Test
    void retanguloDeveRetornarMesmaInstancia() {
        Triangulo t1 = Triangulo.getRetangulo(3, 4, 5);
        Triangulo t2 = Triangulo.getRetangulo(3, 4, 5);
        assertSame(t1, t2);
    }

    @Test
    void retanguloDeveLancarErroSeTentarRecriarComOutrosLados() {
        Triangulo.getRetangulo(3, 4, 5);
        assertThrows(IllegalStateException.class, () -> Triangulo.getRetangulo(6, 8, 10));
    }

    @Test
    void retanguloDeveLancarErroSeNaoForRetangulo() {
        assertThrows(IllegalArgumentException.class, () -> Triangulo.getRetangulo(2, 3, 4));
    }
}