/*
 * La clase supervisor es la encargada de controlar a los obreros, así como de
 * generar informe sobre las obras en un archivo externo. Esta clase no tendrá 
 * clases derivadas
 */
package com.grupo8.finalproject.domain.empleados.padres;

import com.grupo8.finalproject.domain.empleados.padres.Trabajador;
import com.grupo8.finalproject.domain.obras.*;
import java.util.ArrayList;

/**
 * @author Davis Cartagena
 */
public class Supervisor extends Empleado {

    private int iDSupervisor; 
    private static int indSupervisor;
    private ArrayList<Trabajador> trabajadores;
    private Obra obra;

    public Supervisor() {
        this.iDSupervisor = ++Supervisor.indSupervisor;
    }

    public Supervisor(String nombre, String apellidos) {
        this.iDSupervisor = ++Supervisor.indSupervisor;
        this.nombre = nombre;
        this.apellido = apellidos;
    }

    public void asignarTrabajo(Trabajador trabajador) {
        // TODO
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.iDSupervisor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supervisor other = (Supervisor) obj;
        if (this.iDSupervisor != other.iDSupervisor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String supervisor = "";
        supervisor += "\t.:Supervisor:.\n";
        supervisor += "ID supervisor: " + this.iDSupervisor + "\n";
        supervisor += "Nombres: " + this.nombre + "\n";
        supervisor += "Apellidos: " + this.apellido + "\n";
        return supervisor;
    }

}
