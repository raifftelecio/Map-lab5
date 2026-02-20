package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.model.Triangulo;

public class TrianguloTest {

    @BeforeEach
    void resetSingletons() throws Exception {
        Field f1 = Triangulo.class.getDeclaredField("isoscelesInstance");
        Field f2 = Triangulo.class.getDeclaredField("equilateroInstance");
        Field f3 = Triangulo.class.getDeclaredField("retanguloInstance");

        f1.setAccessible(true);
        f2.setAccessible(true);
        f3.setAccessible(true);

        f1.set(null, null);
        f2.set(null, null);
        f3.set(null, null);
    }

    @Test
    void equilateroDeveSerSingleton() {
        Triangulo t1 = Triangulo.equilatero(6);
        Triangulo t2 = Triangulo.equilatero(10);
        assertSame(t1, t2);
    }

    @Test
    void isoscelesDeveSerSingleton() {
        Triangulo t1 = Triangulo.isosceles(5, 5, 6);
        Triangulo t2 = Triangulo.isosceles(10, 10, 12);
        assertSame(t1, t2);
    }

    @Test
    void retanguloDeveSerSingleton() {
        Triangulo t1 = Triangulo.retangulo(3, 4, 5);
        Triangulo t2 = Triangulo.retangulo(6, 8, 10);
        assertSame(t1, t2);
    }

    @Test
    void tiposDiferentesNaoSaoOMesmoObjeto() {
        Triangulo eq = Triangulo.equilatero(6);
        Triangulo iso = Triangulo.isosceles(5, 5, 6);
        Triangulo ret = Triangulo.retangulo(3, 4, 5);

        assertNotSame(eq, iso);
        assertNotSame(eq, ret);
        assertNotSame(iso, ret);
    }
}