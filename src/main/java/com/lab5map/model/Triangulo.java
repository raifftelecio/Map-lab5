package com.lab5map.model;

public final class Triangulo implements FiguraGeometrica {

    public enum Tipo {
        ISOSCELES,
        EQUILATERO,
        RETANGULO
    }

    private final Tipo tipo;
    private final double a;
    private final double b;
    private final double c;

    private Triangulo(Tipo tipo, double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Lados devem ser > 0");
        if (!formaTriangulo(a, b, c)) throw new IllegalArgumentException("Lados não formam triângulo válido");

        this.tipo = tipo;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // --- Fábricas (criação por tipo) ---
    public static Triangulo equilatero(double lado) {
        return new Triangulo(Tipo.EQUILATERO, lado, lado, lado);
    }

    public static Triangulo isosceles(double ladoIgual, double base) {
        return new Triangulo(Tipo.ISOSCELES, ladoIgual, ladoIgual, base);
    }

    public static Triangulo retangulo(double catetoA, double catetoB) {
        double hipotenusa = Math.sqrt(catetoA * catetoA + catetoB * catetoB);
        return new Triangulo(Tipo.RETANGULO, catetoA, catetoB, hipotenusa);
    }

    private static boolean formaTriangulo(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    @Override
    public String nome() {
        return switch (tipo) {
            case ISOSCELES -> "Triângulo Isósceles";
            case EQUILATERO -> "Triângulo Equilátero";
            case RETANGULO -> "Triângulo Retângulo";
        };
    }

    @Override
    public double perimetro() {
        return a + b + c;
    }

    @Override
    public double area() {
        // Fórmula de Heron (vale para qualquer triângulo válido)
        double s = perimetro() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
