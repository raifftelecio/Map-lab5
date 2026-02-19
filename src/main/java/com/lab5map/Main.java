package com.lab5map;

import com.lab5map.factory.FabricaFiguras;
import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

public class Main {
    public static void main(String[] args) {

        double perimetro;
        double area;

        FabricaFiguras fabrica = FabricaFiguras.getInstance();

        System.out.println("DADOS PRÉ-INSERIDOS 1:\n");

        // Círculo 
        try {
            Circulo circulo = fabrica.getCirculo(25);

            perimetro = circulo.perimetro();
            System.out.println("O perímetro do círculo é: " + perimetro);

            area = circulo.area();
            System.out.println("A área do círculo é: " + area);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n----------------------------------------------------------------\n");

        // Quadrado
        try {
            Quadrado quadrado = fabrica.createQuadrado(7);

            perimetro = quadrado.perimetro();
            System.out.println("O perímetro do quadrado é: " + perimetro);

            area = quadrado.area();
            System.out.println("A área do quadrado é: " + area);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n----------------------------------------------------------------\n");

        // Triângulo Equilátero 
        try {
            Triangulo tEqui = fabrica.getTrianguloEquilatero(7);

            perimetro = tEqui.perimetro();
            System.out.println("O perímetro do triângulo equilátero é: " + perimetro);

            area = tEqui.area();
            System.out.println("A área do triângulo equilátero é: " + area);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n----------------------------------------------------------------\n");

        // Triângulo Isósceles 
        try {
            Triangulo tIso = fabrica.getTrianguloIsosceles(6, 4);

            perimetro = tIso.perimetro();
            System.out.println("O perímetro do triângulo isósceles é: " + perimetro);

            area = tIso.area();
            System.out.println("A área do triângulo isósceles é: " + area);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n----------------------------------------------------------------\n");

        // Triângulo Retângulo 
        try {
            Triangulo tRet = fabrica.getTrianguloRetangulo(3, 4);

            perimetro = tRet.perimetro();
            System.out.println("O perímetro do triângulo retângulo é: " + perimetro);

            area = tRet.area();
            System.out.println("A área do triângulo retângulo é: " + area);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n----------------------------------------------------------------\n");

        // Demonstrações do comportamento do Singleton / regras da fábrica
        System.out.println("DEMONSTRAÇÕES DO PADRÃO:\n");
        try {
            Circulo c1 = fabrica.getCirculo(25);
            Circulo c2 = fabrica.getCirculo(25);
            System.out.println("Círculo é único? " + (c1 == c2));

            Quadrado q1 = fabrica.createQuadrado(2);
            Quadrado q2 = fabrica.createQuadrado(2);
            System.out.println("Quadrados são ilimitados? (objetos diferentes) " + (q1 != q2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}