package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.gestion.GestorTrabajador;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * @author Jose Sernaque
 */
public class Electricista extends Trabajador implements Tareas{
    private int nElectricistas;
    private ArrayList<AccionPrincipal> accionesElectricista;
    public static JTextArea mostrarAcciones;

    public Electricista() {
        accionesElectricista = new ArrayList<>();
    }

    public Electricista(int nElectricistas) {
        accionesElectricista = new ArrayList<>();
        this.nElectricistas = nElectricistas;
        llenarTareas();
    }

    public static JTextArea getMostrarAcciones() {
        return mostrarAcciones;
    }

    public static void setMostrarAcciones(JTextArea mostrarAcciones) {
        Electricista.mostrarAcciones = mostrarAcciones;
    }
    
    @Override
    public void llenarTareas() {
        accionesElectricista = GestorTrabajador.llenarTareas("Electricista");
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesElectricista;
    }

    public int getnElectricistas() {
        return nElectricistas;
    }
    
    
}
