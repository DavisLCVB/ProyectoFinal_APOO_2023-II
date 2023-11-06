/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.domain.empleados.padres;

import java.util.ArrayList;

/**
 * @author Jose Sernaque
 */
public class AccionPrincipal {

    private String nombre;
    
    private ArrayList<String> subprocesos = new ArrayList<>();

    public AccionPrincipal(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getSubprocesos() {
        return subprocesos;
    }

    public void agregarSubproceso(String subproceso) {
        subprocesos.add(subproceso);
    }
}
