package com.grupo8.finalproject.domain.empleados.gestion;

import java.io.Serializable;
import java.util.ArrayList;

public class AccionPrincipal implements Serializable{

    private String nombre;
    
    private ArrayList<String> subprocesos = new ArrayList<>();

    public AccionPrincipal(String nombre) {
        this.nombre = nombre;
    }

    public void setSubprocesos(ArrayList<String> subprocesos) {
        this.subprocesos = subprocesos;
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
