package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.padres.AccionPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Nallely Paredes
 */
public class Obrero implements Tareas {
    private int nObreros;
    private ArrayList<AccionPrincipal> accionesObrero;

    public Obrero() {
        accionesObrero = new ArrayList<>();
        llenarTareas();
    }

    public Obrero(int nObreros) {
        this.nObreros = nObreros;
        accionesObrero = new ArrayList<>();
        llenarTareas();
    }

    @Override
    public void llenarTareas() {
        int cantidadAccionesPrincipales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tareas"));
        for (int i = 0; i < cantidadAccionesPrincipales; i++) {
            
            String nombreAccionPrincipal = JOptionPane.showInputDialog("Nombre de la Tarea N°: " + (i + 1));
            
            AccionPrincipal accion = new AccionPrincipal(nombreAccionPrincipal);
            
            int cantidadSubprocesos = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de subprocesos"));

            for (int j = 0; j < cantidadSubprocesos; j++) {
                String subproc = JOptionPane.showInputDialog("Subproceso N°: " + (j + 1));
                accion.agregarSubproceso(subproc);
            }
            accionesObrero.add(accion);
        }
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesObrero;
    }
    
}
