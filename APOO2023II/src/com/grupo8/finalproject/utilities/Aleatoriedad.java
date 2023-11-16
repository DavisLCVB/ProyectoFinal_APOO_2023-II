package com.grupo8.finalproject.utilities;

import java.util.Random;

public abstract class Aleatoriedad {

    private static Random random = new Random();

    private static int limite;
    private static int limite_inf;

    public static int getLimite() {
        return limite;
    }

    public static void setLimite(int limite) {
        Aleatoriedad.limite = limite;
    }

    public static int getLimite_inf() {
        return limite_inf;
    }

    public static void setLimite_inf(int limite_inf) {
        Aleatoriedad.limite_inf = limite_inf;
    }

    public static int retornarNumeroAleatorio() {
        return random.nextInt(limite);
    }

    public static int retornarNumeroAleatorio(int limite) {
        setLimite(limite);
        return retornarNumeroAleatorio();
    }

    public static int retornarNumeroAleatorio(int limite_sup, int limite_inf) {
        setLimite(limite_sup - limite_inf);
        setLimite_inf(limite_inf);
        return retornarNumeroAleatorio() + limite_inf;
    }
}
