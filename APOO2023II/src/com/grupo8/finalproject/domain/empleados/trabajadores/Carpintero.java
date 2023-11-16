package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.gestion.GestorTrabajador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Carpintero extends Trabajador implements Tareas {

    private int nCarpinteros;
    private ArrayList<AccionPrincipal> accionesCarpintero;
    public static JTextArea mostrarAcciones;

    public Carpintero() {
        accionesCarpintero = new ArrayList<>();
    }

    public Carpintero(int nPintores, int subtareas) {
        this.nCarpinteros = nPintores;
        accionesCarpintero = new ArrayList<>();
        llenarTareas(subtareas);
    }

    public static JTextArea getMostrarAcciones() {
        return mostrarAcciones;
    }

    public static void setMostrarAcciones(JTextArea mostrarAcciones) {
        Carpintero.mostrarAcciones = mostrarAcciones;
    }
    
    @Override
    public void llenarTareas(int subtareas) {
        accionesCarpintero = GestorTrabajador.llenarTareas("Carpintero", subtareas);
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesCarpintero;
    }

}
