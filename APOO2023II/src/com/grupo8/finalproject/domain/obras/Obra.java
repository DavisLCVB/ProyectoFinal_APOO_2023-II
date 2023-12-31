package com.grupo8.finalproject.domain.obras;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Obra implements Serializable{

    protected String nombreObra;
    protected String ubicacionObra;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected double presupuesto;
    protected int complejidad;
    protected int velocidadObra;
    protected int iDObra;
    private static int indObra;
    protected int NroObreros = 0;
    protected int NroElectricistas = 0;
    protected int NroCarpinteros = 0;
    protected int NroPlomeros = 0;

    public Obra() {
        this.iDObra = ++Obra.indObra;
    }

    public Obra(String nombreObra, String ubicacionObra, LocalDate fechaInicio, LocalDate fechaFin, double presupuesto, int complejidad, int velocidadObra) {
        this.nombreObra = nombreObra;
        this.ubicacionObra = ubicacionObra;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.presupuesto = presupuesto;
        this.complejidad = complejidad;
        this.velocidadObra = velocidadObra;
        this.iDObra = ++Obra.indObra;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public String getUbicacionObra() {
        return ubicacionObra;
    }

    public void setUbicacionObra(String ubicacionObra) {
        this.ubicacionObra = ubicacionObra;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getVelocidadObra() {
        return velocidadObra;
    }

    public void setVelocidadObra(int velocidadObra) {
        this.velocidadObra = velocidadObra;
    }

    public int getiDObra() {
        return iDObra;
    }

    public void setiDObra(int iDObra) {
        this.iDObra = iDObra;
    }

    public int getNroObreros() {
        return NroObreros;
    }

    public int getNroElectricistas() {
        return NroElectricistas;
    }

    public int getNroCarpinteros() {
        return NroCarpinteros;
    }

    public int getNroPlomeros() {
        return NroPlomeros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombreObra);
        hash = 97 * hash + Objects.hashCode(this.ubicacionObra);
        hash = 97 * hash + Objects.hashCode(this.fechaInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaFin);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.presupuesto) ^ (Double.doubleToLongBits(this.presupuesto) >>> 32));
        hash = 97 * hash + this.complejidad;
        hash = 97 * hash + this.velocidadObra;
        hash = 97 * hash + this.iDObra;
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
        final Obra other = (Obra) obj;
        if (Double.doubleToLongBits(this.presupuesto) != Double.doubleToLongBits(other.presupuesto)) {
            return false;
        }
        if (this.complejidad != other.complejidad) {
            return false;
        }
        if (this.velocidadObra != other.velocidadObra) {
            return false;
        }
        if (this.iDObra != other.iDObra) {
            return false;
        }
        if (!Objects.equals(this.nombreObra, other.nombreObra)) {
            return false;
        }
        if (!Objects.equals(this.ubicacionObra, other.ubicacionObra)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String obra = "";
        obra += "Ubicación de la obra:\t" + this.ubicacionObra + "\n";
        obra += "Fecha de Inicio:\t\t" + this.fechaInicio.format(formato) + "\n";
        obra += "Fecha de Fin prevista:\t" + this.fechaFin.format(formato) + "\n";
        obra += "ID de Obra:\t\t" + this.iDObra + "\n";
        obra += "Presupuesto:\t\t" + this.presupuesto + "\n";
        obra += "Velocidad de la obra:\t" + this.velocidadObra + "\n";
        obra += "Complejidad:\t\t";
        switch (this.complejidad) {
            case 0:
                obra += "Baja\n";
                break;
            case 1:
                obra += "Media\n";
                break;
            case 2:
                obra += "Alta\n";
                break;
            default:
                obra += "Desconocida\n";
                break;
        }
        return obra;
    }
}
