/*
 * Clase abstracta del cual derivarán los diferentes tipos de trabajadores y 
 * la clase de Supervisor. Esta contiene los elementos básicos: Nombre y 
 * apellido.
 */
package com.grupo8.finalproject.domain.empleados;

/**
 * @author Davis Cartagena
 */
public abstract class Empleado {

    protected String nombre;
    protected String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
