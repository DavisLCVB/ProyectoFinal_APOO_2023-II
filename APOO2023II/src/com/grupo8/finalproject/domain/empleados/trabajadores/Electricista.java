/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.padres.AccionPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Jose Sernaque
 */
public class Electricista implements Tareas{
    private int nElectricistas;
    private ArrayList<AccionPrincipal> accionesElectricista;

    public Electricista() {
        accionesElectricista = new ArrayList<>();
        llenarTareas();
    }

    public Electricista(int nElectricistas) {
        accionesElectricista = new ArrayList<>();
        this.nElectricistas = nElectricistas;
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
            accionesElectricista.add(accion);
        }
    }

    @Override
    public ArrayList<AccionPrincipal> getArrayTareas() {
        return accionesElectricista;
    }

    public int getnElectricistas() {
        return nElectricistas;
    }
    
    
}
