package com.grupo8.finalproject.domain.empleados.padres;

import com.grupo8.finalproject.domain.empleados.trabajadores.*;

/**
 * @author Jose Sernaque
 */
public class GestorTrabajador {

    public static void ingresoTrabajadores(int nElectricistas, int nObreros, int nPlomeros, int nPintores) {
        Electricista electricista = new Electricista(nElectricistas);
        Pintor pintor = new Pintor(nPintores);
        Obrero obrero = new Obrero(nObreros);
        
    }
}
