package com.grupo8.finalproject.domain.obras;

/*
 * @author Brayan Goicochea
 */
public interface AccionObras {

    public void CalcularNroObreros();

    public void CalcularNroElectricistas();

    public void CalcularNroCarpinteros();

    public void EstimacionDeMateriales();

    public void CalcularPresupuesto();

    public int CalcularComplejidad(int a, int b);

    public int DefinirIDObra();

}
