package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.gestion.GestorTrabajador;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * @author Nallely Paredes
 */
public class Obrero extends Trabajador implements Tareas {
    private int nObreros;
    private ArrayList<AccionPrincipal> accionesObrero;
    public static JTextArea mostrarAcciones;

    public Obrero() {
        accionesObrero = new ArrayList<>();
    }

    public Obrero(int nObreros) {
        this.nObreros = nObreros;
        accionesObrero = new ArrayList<>();
        llenarTareas();
    }

    public static JTextArea getMostrarAcciones() {
        return mostrarAcciones;
    }

    public static void setMostrarAcciones(JTextArea mostrarAcciones) {
        Obrero.mostrarAcciones = mostrarAcciones;
    }
    
    @Override
    public void llenarTareas() {
        accionesObrero = GestorTrabajador.llenarTareas("Obrero");
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesObrero;
    }
    
}
