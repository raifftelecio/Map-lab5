package com.lab5map;

import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

public class Main {

    public static void main(String[] args) {

        double perimetro;
        double area;

        System.out.println("DADOS PRÉ-INSERIDOS 1:\n");

        // CÍRCULO
        Circulo circulo = Circulo.getInstance(25);

        perimetro = circulo.perimetro();
        System.out.println("O perímetro do círculo é: " + perimetro);

        area = circulo.area();
        System.out.println("A área do círculo é: " + area);

        System.out.println("\n-------------------------------------------------------------\n");

        // QUADRADO
        Quadrado quadrado = new Quadrado(7);

        perimetro = quadrado.perimetro();
        System.out.println("O perímetro do quadrado é: " + perimetro);

        area = quadrado.area();
        System.out.println("A área do quadrado é: " + area);

        System.out.println("\n-------------------------------------------------------------\n");

        // TRIÂNGULO EQUILÁTERO
        Triangulo tEqui = Triangulo.equilatero(7);

        perimetro = tEqui.perimetro();
        System.out.println("O perímetro do triângulo equilátero é: " + perimetro);

        area = tEqui.area();
        System.out.println("A área do triângulo equilátero é: " + area);

        System.out.println("\n-------------------------------------------------------------\n");

        // TRIÂNGULO ISÓSCELES
        Triangulo tIso = Triangulo.isosceles(6, 6, 4);

        perimetro = tIso.perimetro();
        System.out.println("O perímetro do triângulo isósceles é: " + perimetro);

        area = tIso.area();
        System.out.println("A área do triângulo isósceles é: " + area);

        System.out.println("\n-------------------------------------------------------------\n");

        // TRIÂNGULO RETÂNGULO
        Triangulo tRet = Triangulo.retangulo(3, 4, 5);

        perimetro = tRet.perimetro();
        System.out.println("O perímetro do triângulo retângulo é: " + perimetro);

        area = tRet.area();
        System.out.println("A área do triângulo retângulo é: " + area);

        System.out.println("\n-------------------------------------------------------------\n");

        // DEMONSTRAÇÃO DO SINGLETON
        System.out.println("DEMONSTRAÇÃO DO PADRÃO:\n");

        Circulo c1 = Circulo.getInstance(25);
        Circulo c2 = Circulo.getInstance(30);
        System.out.println("Círculo é único? " + (c1 == c2));

        Triangulo eq1 = Triangulo.equilatero(7);
        Triangulo eq2 = Triangulo.equilatero(10);
        System.out.println("Equilátero é único? " + (eq1 == eq2));

        Quadrado q1 = new Quadrado(2);
        Quadrado q2 = new Quadrado(2);
        System.out.println("Quadrados são diferentes? " + (q1 != q2));
    }
}