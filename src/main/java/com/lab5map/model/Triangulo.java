package com.lab5map.model;

// Singleton aplicado por tipo de triângulo
public class Triangulo {

    private static Triangulo isoscelesInstance;
    private static Triangulo equilateroInstance;
    private static Triangulo retanguloInstance;

    private double a;
    private double b;
    private double c;

    // Construtor privado
    private Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Singleton Isósceles
    public static Triangulo isosceles(double a, double b, double c) {
        if (isoscelesInstance == null) {
            isoscelesInstance = new Triangulo(a, b, c);
        }
        return isoscelesInstance;
    }

    // Singleton Equilátero
    public static Triangulo equilatero(double lado) {
        if (equilateroInstance == null) {
            equilateroInstance = new Triangulo(lado, lado, lado);
        }
        return equilateroInstance;
    }

    // Singleton Retângulo
    public static Triangulo retangulo(double a, double b, double c) {
        if (retanguloInstance == null) {
            retanguloInstance = new Triangulo(a, b, c);
        }
        return retanguloInstance;
    }

    public double perimetro() {
        return a + b + c;
    }

    public double area() {
        double s = perimetro() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}