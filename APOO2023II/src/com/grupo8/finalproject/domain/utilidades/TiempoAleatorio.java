/*
 * Esta clase usa a la clase de Aleatoriedad y nos permite generar un tiempo
 * aleatorio según convenga
 */
package com.grupo8.finalproject.domain.utilidades;

/**
 * @author Davis Cartagena
 */
import java.time.LocalDateTime;

//Clase abstracta para evitar generar objetos
public abstract class TiempoAleatorio {

    //LocalDateTime es un tipo de variable que almacena fecha y hora exacta
    //la usaremos para crear la hora futura en la que "terminará" la acción
    private static LocalDateTime ahora;
    //El rango nos ayuda a definir cuantos segundos despues de los 20 deseamos obtener
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
        int numero = Aleatoriedad.retornarNumeroAleatorio() + 20;//Aquí nos generará un númeor entre 0 y rango -1, pero
        //al sumarle 20, nos aseguramos que sea mayor a 20 segundos
        Aleatoriedad.setLimite(limiteAns); //Aquí regresamos el límite anterior a Aleatoriedad
        return ahora.plusSeconds(numero); //Aquí retornamos la hora actual más os segundos aleatorios que definimos
    }
}
