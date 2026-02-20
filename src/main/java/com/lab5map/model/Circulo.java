package com.lab5map.model;

// Singleton aplicado ao círculo
public class Circulo {

    private static Circulo instance;

    private double raio;

    // Construtor privado
    private Circulo(double raio) {
        this.raio = raio;
    }

    // Método de acesso à instância única
    public static Circulo getInstance(double raio) {
        if (instance == null) {
            instance = new Circulo(raio);
        }
        return instance;
    }

    public double area() {
        return Math.PI * raio * raio;
    }

    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    public double getRaio() {
        return raio;
    }
}