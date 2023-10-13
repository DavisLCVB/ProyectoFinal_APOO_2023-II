/**
 * La clase "Trabajador" es la clase base que representa a los trabajadores
 * involucrados en una obra de construcción. Esta clase contiene atributos y
 * métodos comunes que son aplicables a todos los trabajadores de la obra, como
 * nombre, identificación, y otras características relevantes. Las
 * clases hijas se derivarán de esta clase para definir roles y funciones
 * específicos de los trabajadores, como albañiles, electricistas, plomeros,
 * supervisores, etc. La clase "Trabajador" se utiliza para crear un arreglo de
 * trabajadores que participarán en la obra y proporciona una estructura
 * unificada para gestionar la información y las acciones relacionadas con el
 * personal de la construcción.
 */
package com.grupo8.finalproject.domain.trabajadores;

import java.util.Objects;

/**
 * Desarrollado por Davis Cartagena
 */
public class Trabajador {

    protected String nombres;
    protected String apellidos;
    protected int iDTrabajador;
    protected double salario;
    protected boolean estado;
    protected String accion;
    private static int indTrabajador;

    public Trabajador() {
        this.iDTrabajador = ++Trabajador.indTrabajador;
    }

    public Trabajador(String nombres, String apellidos, int iDTrabajador, double salario, boolean estado) {
        this.iDTrabajador = ++Trabajador.indTrabajador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.salario = salario;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombres);
        hash = 97 * hash + Objects.hashCode(this.apellidos);
        hash = 97 * hash + this.iDTrabajador;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 97 * hash + (this.estado ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.accion);
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
        final Trabajador other = (Trabajador) obj;
        if (this.iDTrabajador != other.iDTrabajador) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.accion, other.accion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String trabajador = "";
        trabajador += "\t.:Trabajador:.\n";
        trabajador += "ID del trabajador: " + this.iDTrabajador + "\n";
        trabajador += "Nombres: " + this.nombres + "\n";
        trabajador += "Apellidos: " + this.apellidos + "\n";
        trabajador += "Estado: " + (this.estado ? "Trabajando" : "Descansando") + "\n";
        trabajador += "Acción: " + this.accion + "\n";
        return trabajador;
    }
}
