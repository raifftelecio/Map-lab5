package com.lab5map.model;

public final class Triangulo implements FiguraGeometrica {

    private final int lado1;
    private final int lado2;
    private final int lado3;

    private static Triangulo retangulo = null;
    private static Triangulo equilatero = null;
    private static Triangulo isoceles = null;

    // Equilátero
    private Triangulo(int lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Lado deve ser > 0.");
        }
        this.lado1 = lado;
        this.lado2 = lado;
        this.lado3 = lado;
    }

    // Isósceles 
    private Triangulo(int lado, int base) {
        if (lado <= 0 || base <= 0) {
            throw new IllegalArgumentException("Lados devem ser > 0.");
        }

        if (base == lado) {
            throw new IllegalArgumentException("Triângulo isósceles precisa ter base diferente do lado igual.");
        }

        // desigualdade triangular: lado + lado > base  =>  2*lado > base
        if ((2 * lado) <= base) {
            throw new IllegalArgumentException("Não forma triângulo isósceles (2*lados iguais deve ser > base).");
        }

        this.lado1 = lado;
        this.lado2 = lado;
        this.lado3 = base;
    }

    // Retângulo (cateto1, cateto2, hipotenusa)
    private Triangulo(int cateto1, int cateto2, int hipotenusa, boolean flagRetangulo) {
        if (cateto1 <= 0 || cateto2 <= 0 || hipotenusa <= 0) {
            throw new IllegalArgumentException("Lados devem ser > 0.");
        }

        // desigualdade triangular (necessária)
        if ((cateto1 + cateto2) <= hipotenusa) {
            throw new IllegalArgumentException("Não forma triângulo (desigualdade triangular).");
        }

        // Pitágoras: c1² + c2² = h²
        int lhs = cateto1 * cateto1 + cateto2 * cateto2;
        int rhs = hipotenusa * hipotenusa;

        if (lhs != rhs) {
            throw new IllegalArgumentException("Não é triângulo retângulo (Pitágoras não fecha).");
        }

        this.lado1 = cateto1;
        this.lado2 = cateto2;
        this.lado3 = hipotenusa;
    }

    // Singleton Equilátero
    public static Triangulo getEquilatero(int lado) {
        if (equilatero == null) {
            equilatero = new Triangulo(lado);
        } else if (equilatero.lado1 != lado) {
            throw new IllegalStateException(
                    "Equilátero já foi criado com lado " + equilatero.lado1 + ". Não é permitido criar outro."
            );
        }
        return equilatero;
    }

    // Singleton Isósceles
    public static Triangulo getIsoceles(int lado, int base) {
        if (isoceles == null) {
            isoceles = new Triangulo(lado, base);
        } else if (!(isoceles.lado1 == lado && isoceles.lado2 == lado && isoceles.lado3 == base)) {
            throw new IllegalStateException(
                    "Isósceles já foi criado com lados (" + isoceles.lado1 + ", " + isoceles.lado2 + ", " + isoceles.lado3 + "). " +
                    "Não é permitido criar outro."
            );
        }
        return isoceles;
    }

    // Singleton Retângulo
    public static Triangulo getRetangulo(int cateto1, int cateto2, int hipotenusa) {
        if (retangulo == null) {
            retangulo = new Triangulo(cateto1, cateto2, hipotenusa, true);
        } else if (!(retangulo.lado1 == cateto1 && retangulo.lado2 == cateto2 && retangulo.lado3 == hipotenusa)) {
            throw new IllegalStateException(
                    "Retângulo já foi criado com lados (" + retangulo.lado1 + ", " + retangulo.lado2 + ", " + retangulo.lado3 + "). " +
                    "Não é permitido criar outro."
            );
        }
        return retangulo;
    }

    @Override
    public double calculaArea() {
        // Fórmula de Heron
        double s = calculaPerimetro() / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calculaPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // úteis para testes
    public int getLado1() { return lado1; }
    public int getLado2() { return lado2; }
    public int getLado3() { return lado3; }
}