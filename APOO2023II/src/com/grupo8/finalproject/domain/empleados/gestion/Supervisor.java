package com.grupo8.finalproject.domain.empleados.gestion;

import com.grupo8.finalproject.utilities.Aleatoriedad;
import javax.swing.ImageIcon;

public class Supervisor {

    private int iDSesion;
    private static int indSupervisor;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private ImageIcon icono;

    public Supervisor() {
        this.iDSesion = Aleatoriedad.retornarNumeroAleatorio(9999, 1000);
        this.iDSesion *= 10;
        this.iDSesion += ++Supervisor.indSupervisor;
    }

    public Supervisor(String nombre, String apellidos) {
        this.iDSesion = Aleatoriedad.retornarNumeroAleatorio(9999, 1000);
        this.iDSesion *= 10;
        this.iDSesion += ++Supervisor.indSupervisor;
        this.nombre = nombre;
        this.apellido = apellidos;
    }

    public int getiDSesion() {
        return iDSesion;
    }

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }
    
}
