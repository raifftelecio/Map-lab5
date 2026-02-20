package com.lab5map;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab5map.factory.FabricaFiguras;
import com.lab5map.model.Circulo;
import com.lab5map.model.Quadrado;
import com.lab5map.model.Triangulo;

class FabricaFigurasTest {

    @BeforeEach // resetar singleton para nao vazar estado entre testes
    void resetarSingleton() throws Exception {
        FabricaFiguras f = FabricaFiguras.getInstance();

        // Zera os campos internos (circulo e triângulos) para cada teste começar do zero.
        Field circulo = FabricaFiguras.class.getDeclaredField("circuloUnico");
        circulo.setAccessible(true);
        circulo.set(f, null);

        Field iso = FabricaFiguras.class.getDeclaredField("triIsosceles");
        iso.setAccessible(true);
        iso.set(f, null);

        Field equi = FabricaFiguras.class.getDeclaredField("triEquilatero");
        equi.setAccessible(true);
        equi.set(f, null);

        Field ret = FabricaFiguras.class.getDeclaredField("triRetangulo");
        ret.setAccessible(true);
        ret.set(f, null);
    }

    @Test // get Instance Deve Retornar Mesma Instancia
    void getInstanceRetornaMesmaInstancia() {
        FabricaFiguras a = FabricaFiguras.getInstance();
        FabricaFiguras b = FabricaFiguras.getInstance();
        assertSame(a, b);
    }

    @Test // get Circulo Deve Retornar Mesmo Objeto Na Segunda Chamada
    void getCirculoRetornaMesmoObjSegChamada() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Circulo c1 = f.getCirculo(2.0);
        Circulo c2 = f.getCirculo(2.0);
        assertSame(c1, c2);
    }

    @Test // get Circulo Deve Lancar Erro Se Tentar Outro Raio Depois De Criado
    void getCirculoErroTentarOutroRaioAposCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getCirculo(2.0);
        assertThrows(IllegalStateException.class, () -> f.getCirculo(3.0));
    }

    @Test // get Triangulo Equilatero Deve Retornar Objeto Criado
    void getTrianguloEquilateroRetornaObjCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloEquilatero(3.0);
        assertNotNull(t);
    }

    @Test // get Triangulo Equilatero Deve Lancar Erro Ao Criar Segundo
    void getTrianguloEquilateroErroSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloEquilatero(3.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloEquilatero(10.0));
    }

    @Test // get Triangulo Isosceles Deve Retornar Objeto Criado
    void getTrianguloIsoscelesRetornaObjCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloIsosceles(4.0, 6.0);
        assertNotNull(t);
    }

    @Test // get Triangulo Isosceles Deve Lancar Erro Ao Criar Segundo
    void getTrianguloIsoscelesErroSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloIsosceles(4.0, 6.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloIsosceles(10.0, 10.0));
    }

    @Test // get Triangulo Retangulo Deve Retornar Objeto criado
    void getTrianguloRetanguloRetornaObjCriado() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Triangulo t = f.getTrianguloRetangulo(3.0, 4.0);
        assertNotNull(t);
    }
 
    @Test // get Triangulo Retangulo Deve Lancar Erro Ao Criar Segundo
    void getTrianguloRetanguloErroCriarSegundo() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloRetangulo(3.0, 4.0);
        assertThrows(IllegalStateException.class, () -> f.getTrianguloRetangulo(5.0, 12.0));
    }

    @Test // create Quadrado Deve criar Novas Instancias Sempre
    void createQuadradoCriarNovasInstancias() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        Quadrado q1 = f.createQuadrado(2.0);
        Quadrado q2 = f.createQuadrado(2.0);
        assertNotSame(q1, q2);
    }

    @Test // quantidade Triangulos Criados Deve Ser Zero No Inicio
    void ZeroTriangulosCriadosInicio() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        assertEquals(0, f.quantidadeTriangulosCriados());
    }

    @Test // quantidade Triangulos Criados Deve Ser Tres Depois De Criar Todos
    void TresTriangulosCriados() {
        FabricaFiguras f = FabricaFiguras.getInstance();
        f.getTrianguloEquilatero(3.0);
        f.getTrianguloIsosceles(4.0, 6.0);
        f.getTrianguloRetangulo(3.0, 4.0);
        assertEquals(3, f.quantidadeTriangulosCriados());
    }
}