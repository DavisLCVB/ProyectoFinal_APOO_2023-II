/*
 * Esta clase es la que ayuda a poder generar números aleatorios sin necesidad
 * de crear este tipo de objetos constantemente
 */
package com.grupo8.finalproject.domain.utilidades;

/**
 * @author Davis Cartagena
*/
import java.util.Random;

//La clase es abstracta ya que así nos evitamos crear objetos cada que querramos crear un número aleatorio
public abstract class Aleatoriedad {
    //Creamos un objeto de tipo Random, este es el que nos generará los números aleatorios
    //no se olviden de importar la librería java.util.Random
    //Lo declaramos estático para que esté asociada a la clase y tengamos que crear un objeto
    //de tipo "Aleatoriedad" en nuestro proyecto. Esto para facilitar la escritura.
    private static Random random = new Random();

    //Esta variable será el límite en el que deseamos crear el número. También es estática por
    //las razones del anterior, nos evitamos crear objetos de esta clase
    private static int limite;

    //La clase no tiene constructor debido a que no habrán objetos de su tipo en nuestor programa
    //el único método al que accederemos será a los set, get, y el retornarNumeroAleatorio
    public static int getLimite() {
        return limite;
    }

    public static void setLimite(int limite) {
        Aleatoriedad.limite = limite;
    }

    //La forma de llamar a los métodos estáticos es con el punto. En este caso, llamaremos a esta
    //función con la siguiente sintaxis: Aleatoriedad.retornarNumeroAleatorio()
    //Sin embargo asegurémonos de establecer el límite con el set antes de nada.
    public static int retornarNumeroAleatorio() {
        //nextInt es una función que retorna un entero con el rango especificado, en este caso de 0
        //a límite - 1. En notación: [0,limite)
        return random.nextInt(limite);
    }
}