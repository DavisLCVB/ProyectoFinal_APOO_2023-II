package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.gestion.GestorTrabajador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * @author Nallely Paredes
 */
public class Carpintero extends Trabajador implements Tareas {

    private int nCarpinteros;
    private ArrayList<AccionPrincipal> accionesCarpintero;
    public static JTextArea mostrarAcciones;

    public Carpintero() {
        accionesCarpintero = new ArrayList<>();
    }

    public Carpintero(int nPintores) {
        this.nCarpinteros = nPintores;
        accionesCarpintero = new ArrayList<>();
        llenarTareas();
    }

    public static JTextArea getMostrarAcciones() {
        return mostrarAcciones;
    }

    public static void setMostrarAcciones(JTextArea mostrarAcciones) {
        Carpintero.mostrarAcciones = mostrarAcciones;
    }
    
    @Override
    public void llenarTareas() {
        accionesCarpintero = GestorTrabajador.llenarTareas("Carpintero");
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesCarpintero;
    }

}
