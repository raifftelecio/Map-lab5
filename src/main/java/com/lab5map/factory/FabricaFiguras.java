package com.lab5map.factory;

import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

public final class FabricaFiguras {

    private static volatile FabricaFiguras instance;

    private Circulo circuloUnico;

    private Triangulo triIsosceles;
    private Triangulo triEquilatero;
    private Triangulo triRetangulo;

    private FabricaFiguras() {}

    // Singleton thread-safe 
    public static FabricaFiguras getInstance() {
        if (instance == null) {
            synchronized (FabricaFiguras.class) {
                if (instance == null) {
                    instance = new FabricaFiguras();
                }
            }
        }
        return instance;
    }

    public synchronized Circulo getCirculo(double raio) {
        if (circuloUnico == null) {
            circuloUnico = new Circulo(raio);
            return circuloUnico;
        }

        if (Double.compare(circuloUnico.getRaio(), raio) != 0) {
            throw new IllegalStateException(
                    "Já existe um círculo criado com raio=" + circuloUnico.getRaio()
            );
        }
        return circuloUnico;
    }

    // 1 triângulo isósceles
    public synchronized Triangulo getTrianguloIsosceles(double ladoIgual, double base) {
        if (triIsosceles == null) {
            triIsosceles = Triangulo.isosceles(ladoIgual, base);
            return triIsosceles;
        }
        throw new IllegalStateException("Já existe um triângulo isósceles criado.");
    }

    // 1 triângulo equilátero
    public synchronized Triangulo getTrianguloEquilatero(double lado) {
        if (triEquilatero == null) {
            triEquilatero = Triangulo.equilatero(lado);
            return triEquilatero;
        }
        throw new IllegalStateException("Já existe um triângulo equilátero criado.");
    }

    // 1 triângulo retângulo
    public synchronized Triangulo getTrianguloRetangulo(double catetoA, double catetoB) {
        if (triRetangulo == null) {
            triRetangulo = Triangulo.retangulo(catetoA, catetoB);
            return triRetangulo;
        }
        throw new IllegalStateException("Já existe um triângulo retângulo criado.");
    }

    // Quadrados ilimitados
    public Quadrado createQuadrado(double lado) {
        return new Quadrado(lado);
    }

    // Auxiliar 
    public int quantidadeTriangulosCriados() {
        int count = 0;
        if (triIsosceles != null) count++;
        if (triEquilatero != null) count++;
        if (triRetangulo != null) count++;
        return count;
    }
}
