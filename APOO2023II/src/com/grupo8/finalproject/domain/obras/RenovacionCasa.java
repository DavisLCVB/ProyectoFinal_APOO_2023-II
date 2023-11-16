package com.grupo8.finalproject.domain.obras;

import com.grupo8.finalproject.utilities.Aleatoriedad;

import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class RenovacionCasa extends Obra implements AccionObras {

    private int Nro_ambientes;
    protected String Distrito;
    protected String SectoresCasa;
    protected String EstadoLugar;
    protected String Optimiza;
    protected double Area_Total;

    // Atributos que se calcularán 
    protected LocalDate Fecha_Culminacion_Obra;
    protected double Presupuesto_materiales;
    protected double Presupuesto_personal;
    protected int totalDiasObra;

    protected int Nro_electricistas;
    protected int Nro_obreros;
    protected int Nro_carpinteros;

    // Materiales y elementos para la renovación de casa
    protected int NroPintura;
    protected int NroAzulejos;
    protected int NroParquet;
    protected int NroPapelTapiz;
    protected int NroMuebles;

    public RenovacionCasa() {
    }

    public LocalDate CalcularFecha_Culminacion_Obra() {
        LocalDate fecha_hoy = LocalDate.now();

        if (Nro_ambientes > 0 && Nro_ambientes <= 2) {
            totalDiasObra = 2;
        } else if (Nro_ambientes > 2 && Nro_ambientes <= 8) {
            totalDiasObra = 5;
        } else if (Nro_ambientes > 8) {
            totalDiasObra = 6;
        }

        fecha_hoy = fecha_hoy.plusDays(totalDiasObra);
        Fecha_Culminacion_Obra = fecha_hoy;
        return Fecha_Culminacion_Obra;
    }

    public void CalcularNro_obreros() {
        // Se considera que el número de obreros dependerá del área o áreas del ambiente
        if (Area_Total > 0 && Area_Total <= 50) {
            Nro_obreros = 3;
        } else if (Area_Total > 50 && Area_Total <= 90) {
            Nro_obreros = 4;
        } else if (Area_Total > 90) {
            Nro_obreros = 6;
        }
    }

    public void CalcularNro_electricistas() {
        if (Area_Total > 0 && Area_Total <= 50) {
            Nro_electricistas = 3;
        } else if (Area_Total > 50 && Area_Total <= 90) {
            Nro_electricistas = 4;
        } else if (Area_Total > 90) {
            Nro_electricistas = 6;
        }
    }

    public void CalcularNro_carpinteros() {
        if (Area_Total > 0 && Area_Total <= 50) {
            Nro_carpinteros = 3;
        } else if (Area_Total > 50 && Area_Total <= 90) {
            Nro_carpinteros = 4;
        } else if (Area_Total > 90) {
            Nro_carpinteros = 6;
        }
    }

    @Override
    public void EstimacionDeMateriales() {
        Random num_random = new Random();

        // Se calculan los materiales en función del terreno
        if (Area_Total > 0 && Area_Total <= 60) {
            NroPintura = num_random.nextInt(10 - 5 + 1) + 5;
            NroAzulejos = num_random.nextInt(100 - 50 + 1) + 50;
            NroParquet = num_random.nextInt(50 - 30 + 1) + 30;
            NroPapelTapiz = num_random.nextInt(20 - 10 + 1) + 10;
            NroMuebles = num_random.nextInt(15 - 10 + 1) + 10;
        } else if (Area_Total > 60 && Area_Total <= 120) {
            NroPintura = num_random.nextInt(20 - 10 + 1) + 10;
            NroAzulejos = num_random.nextInt(200 - 100 + 1) + 100;
            NroParquet = num_random.nextInt(100 - 50 + 1) + 50;
            NroPapelTapiz = num_random.nextInt(40 - 20 + 1) + 20;
            NroMuebles = num_random.nextInt(30 - 15 + 1) + 15;
        } else if (Area_Total > 120) {
            NroPintura = num_random.nextInt(30 - 20 + 1) + 20;
            NroAzulejos = num_random.nextInt(300 - 150 + 1) + 150;
            NroParquet = num_random.nextInt(150 - 100 + 1) + 100;
            NroPapelTapiz = num_random.nextInt(60 - 40 + 1) + 40;
            NroMuebles = num_random.nextInt(40 - 30 + 1) + 30;
        }
    }

    public int CalculoComplejidad(int a, int b) {
        int comp = 1;
        if (a > 15) {
            comp = 5;
        } else if (a > 10) {
            comp = 4;
        } else if (a >= 5 && b >= 8) {
            comp = 3;
        } else if (a >= 3 && b >= 5) {
            comp = 2;
        }
        return comp;
    }

    @Override
    public void CalcularPresupuesto() {
        CalcularNro_obreros();
        CalcularNro_electricistas();
        CalcularNro_carpinteros();
        EstimacionDeMateriales();

        Presupuesto_materiales = (NroPintura * 25.0) + (NroAzulejos * 15.0) + (NroParquet * 30.0) + (NroPapelTapiz * 10.0)
                + (NroMuebles * 200.0);
        Presupuesto_personal = totalDiasObra * Nro_obreros * 83.2 + totalDiasObra * Nro_electricistas * 92.5
                + totalDiasObra * Nro_carpinteros * 75.0;
        presupuesto = Presupuesto_materiales + Presupuesto_personal;
    }

    @Override
    public int DefinirIDObra() {
        /*LOD ID de obra serán de la forma 2200MN donde MN son 2 numeros agregados aleatoriamente*/
        int num = 2200;
        num = num + Aleatoriedad.retornarNumeroAleatorio(99, 10);
        return num;
    }

    public void setArea_Total(double a) {
        Area_Total = a;
    }

    public void setDistrito(String a) {
        Distrito = a;
    }

    public double getArea_Total() {
        return Area_Total;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setSectoresCasa(String a) {
        SectoresCasa = a;
    }

    public String getSectoresCasa() {
        return SectoresCasa;
    }

    public void setEstadoLugar(String a) {
        EstadoLugar = a;
    }

    public String getEstadoLugar() {
        return EstadoLugar;
    }

    public int getTotalDiasObra() {
        return totalDiasObra;
    }

    public LocalDate getFecha_Culminacion_Obra() {
        return Fecha_Culminacion_Obra;
    }

    public double getPresupuesto_materiales() {
        return Presupuesto_materiales;
    }

    public double getPresupuesto_personal() {
        return Presupuesto_personal;
    }

    public int getNro_electricistas() {
        return Nro_electricistas;
    }

    public int getNro_obreros() {
        return Nro_obreros;
    }

    public int getNro_carpinteros() {
        return Nro_carpinteros;
    }

    public int getNroPintura() {
        return NroPintura;
    }

    public int getNroAzulejos() {
        return NroAzulejos;
    }

    public int getNroParquet() {
        return NroParquet;
    }

    public int getNroPapelTapiz() {
        return NroPapelTapiz;
    }

    public int getNroMuebles() {
        return NroMuebles;
    }

    public void setNro_ambientes(int Nro_ambientes) {
        this.Nro_ambientes = Nro_ambientes;
    }

    public int getNro_ambientes() {
        return Nro_ambientes;
    }

    @Override
    public void CalcularNroObreros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CalcularNroElectricistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CalcularNroCarpinteros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CalcularComplejidad(int a, int b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
