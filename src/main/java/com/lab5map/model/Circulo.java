package com.lab5map.model;

public final class Circulo implements FiguraGeometrica {
    private final double raio;

    public Circulo(double raio) {
        if (raio <= 0) throw new IllegalArgumentException("Raio deve ser > 0");
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public String nome() {
        return "Círculo";
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}
