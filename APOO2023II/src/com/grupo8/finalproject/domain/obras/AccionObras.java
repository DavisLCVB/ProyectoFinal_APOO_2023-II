package com.grupo8.finalproject.domain.obras;

/*
 * @author Brayan Goicochea
 */
public interface AccionObras {

    public void CalcularNro_obreros();

    public void CalcularNro_electricistas();

    public void CalcularNro_plomeros();

    public void CalcularNro_carpinteros();

    public void EstimacionDeMateriales();

    public void CalcularPresupuesto();

    public int CalcularComplejidad(int a, int b);

    public int DefinirIDObra();

}
