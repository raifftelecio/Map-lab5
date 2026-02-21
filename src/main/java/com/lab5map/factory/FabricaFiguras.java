package com.lab5map.factory;

import com.lab5map.model.Circulo;
import com.lab5map.model.FiguraGeometrica;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

public final class FabricaFiguras {

    private FabricaFiguras() {
        // fábrica utilitária: não instancia
    }

    // 1 único círculo
    public static FiguraGeometrica criarCirculo(double raio) {
        return Circulo.getInstance(raio);
    }

    // 3 triângulos no total (um de cada tipo)
    public static FiguraGeometrica criarTrianguloEquilatero(int lado) {
        return Triangulo.getEquilatero(lado);
    }

    public static FiguraGeometrica criarTrianguloIsoceles(int lado, int base) {
        return Triangulo.getIsoceles(lado, base);
    }

    public static FiguraGeometrica criarTrianguloRetangulo(int cateto1, int cateto2, int hipotenusa) {
        return Triangulo.getRetangulo(cateto1, cateto2, hipotenusa);
    }

    // infinitos quadrados
    public static FiguraGeometrica criarQuadrado(double lado) {
        return new Quadrado(lado);
    }
}
