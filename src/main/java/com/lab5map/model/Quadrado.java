package com.lab5map.model;

public final class Quadrado implements FiguraGeometrica {
    private final double lado;

    public Quadrado(double lado) {
        if (lado <= 0) throw new IllegalArgumentException("Lado deve ser > 0");
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public String nome() {
        return "Quadrado";
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }
}
