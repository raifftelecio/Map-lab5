package com.lab5map.model;

public final class Circulo implements FiguraGeometrica {

    private final double raio;
    private static Circulo instance;

    private Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser > 0.");
        }
        this.raio = raio;
    }

    // Singleton: cria só uma vez. Se tentarem criar com outro raio, dá erro.
    public static Circulo getInstance(double raio) {
        if (instance == null) {
            instance = new Circulo(raio);
        } else if (Double.compare(instance.raio, raio) != 0) {
            throw new IllegalStateException(
                    "Círculo já foi criado com raio " + instance.raio + ". Não é permitido criar outro."
            );
        }
        return instance;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double calculaArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calculaPerimetro() {
        return 2 * Math.PI * raio;
    }
}