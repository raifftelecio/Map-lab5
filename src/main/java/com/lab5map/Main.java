package com.lab5map;

import com.lab5map.factory.FabricaFiguras;
import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

public class Main {
    public static void main(String[] args) {

        //CÍRCULO (singleton) 
        Circulo c1 = (Circulo) FabricaFiguras.criarCirculo(5);
        Circulo c2 = (Circulo) FabricaFiguras.criarCirculo(5);

        System.out.println("c1 == c2 ? " + (c1 == c2)); // true

        try {
            FabricaFiguras.criarCirculo(10);
        } catch (Exception e) {
            System.out.println("Tentou criar outro círculo: " + e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // QUADRADO (infinitos)
        Quadrado q1 = (Quadrado) FabricaFiguras.criarQuadrado(4);
        Quadrado q2 = (Quadrado) FabricaFiguras.criarQuadrado(4);

        System.out.println("q1 == q2 ? " + (q1 == q2)); // false

        System.out.println("\n------------------------------\n");

        //TRIÂNGULO EQUILÁTERO (singleton do tipo) 
        Triangulo te1 = (Triangulo) FabricaFiguras.criarTrianguloEquilatero(6);
        Triangulo te2 = (Triangulo) FabricaFiguras.criarTrianguloEquilatero(6);

        System.out.println("te1 == te2 ? " + (te1 == te2)); // true

        try {
            FabricaFiguras.criarTrianguloEquilatero(7);
        } catch (Exception e) {
            System.out.println("Tentou criar outro equilátero: " + e.getMessage());
        }
    }
}