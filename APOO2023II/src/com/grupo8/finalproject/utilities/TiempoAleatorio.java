package com.grupo8.finalproject.utilities;


import java.time.LocalDateTime;

public abstract class TiempoAleatorio {

    private static LocalDateTime ahora;
    private static int rango;

    public static int getRango() {
        return rango;
    }

    public static void setRango(int rango) {
        TiempoAleatorio.rango = rango;
    }

    public static LocalDateTime retornarHoraAleatoria() {
        ahora = LocalDateTime.now();//primero inicializamos la varibale ahora con el tiempo actual
        int limiteAns = Aleatoriedad.getLimite();//Luego guardamos momentaneamente el límite anterior de Aleatoriedad
        Aleatoriedad.setLimite(rango);//colocamos un nuevo límite
        int numero = Aleatoriedad.retornarNumeroAleatorio() + 5;//Aquí nos generará un númeor entre 0 y rango -1, pero
        //al sumarle 20, nos aseguramos que sea mayor a 20 segundos
        Aleatoriedad.setLimite(limiteAns); //Aquí regresamos el límite anterior a Aleatoriedad
        return ahora.plusSeconds(numero); //Aquí retornamos la hora actual más os segundos aleatorios que definimos
    }
}
