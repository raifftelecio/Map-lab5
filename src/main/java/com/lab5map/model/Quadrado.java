package com.lab5map.model;

// Quadrado não é Singleton (instâncias ilimitadas)
public class Quadrado {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double area() {
        return lado * lado;
    }

    public double perimetro() {
        return 4 * lado;
    }
}