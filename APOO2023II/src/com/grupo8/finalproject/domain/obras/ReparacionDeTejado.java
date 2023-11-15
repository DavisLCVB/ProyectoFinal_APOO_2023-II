package com.grupo8.finalproject.domain.obras;

import com.grupo8.finalproject.utilities.Aleatoriedad;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class ReparacionDeTejado extends Obra implements AccionObras {

    /*Atributos que se llenarán por ventana*/
    protected int Nro_construcciones;
    protected String Distrito;
    protected double Area_Terreno;

    /*Atributos que se calcularan (en función a los llenados)*/
    protected LocalDate Fecha_Culminacion_Obra;
    protected double Presupuesto_materiales;
    protected double Presupuesto_personal;
    protected int totalDiasObra;

    //Materiales para un tejado o cubierta de una construccion
    protected int NroTejas;
    protected int NroSelladoresBasicos;
    protected int NroMembranasAsfálticas;
    protected int NroClavos;
    protected int NroTornillos;
    protected int NroSoporteParaTejas;
    protected int NroMaderas;

    public ReparacionDeTejado() {
    }

    public LocalDate CalcularFecha_Culminacion_Obra() {

        LocalDate fecha_hoy = LocalDate.now();

        if (Nro_construcciones > 0 && Nro_construcciones <= 5) {
            totalDiasObra = 3;
        } else {
            if (Nro_construcciones > 5 && Nro_construcciones <= 10) {
                totalDiasObra = 8;
            } else {
                if (Nro_construcciones > 10) {
                    totalDiasObra = 12;
                }
            }
        }
        fecha_hoy = fecha_hoy.plusDays(totalDiasObra);
        Fecha_Culminacion_Obra = fecha_hoy;
        return Fecha_Culminacion_Obra;
    }

    @Override
    public void CalcularNroObreros() {
        /*Se considera que el numero de obreros dependerá del area del tejado o cubierta*/

        if (Area_Terreno > 0 && Area_Terreno <= 40) {
            NroObreros = 4;
        } else {
            if (Area_Terreno > 40 && Area_Terreno <= 100) {
                NroObreros = 8;
            } else {
                if (Area_Terreno > 100) {
                    NroObreros = 10;
                }
            }
        }
    }

    @Override
    public void CalcularNroElectricistas() {
        /*Se considera que el numero de electricistas dependerá del area del tejado o cubierta*/
        if (Area_Terreno > 0 && Area_Terreno <= 40.0) {
            NroElectricistas = 1;
        } else {
            if (Area_Terreno > 40.0 && Area_Terreno <= 100.0) {
                NroElectricistas = 2;
            } else {
                if (Area_Terreno > 100.0) {
                    NroElectricistas = 3;
                }
            }
        }
    }

    public void CalcularNroCarpinteros() {
        if (Area_Terreno > 0 && Area_Terreno <= 40.0) {
            NroCarpinteros = 2;
        } else {
            if (Area_Terreno > 40.0 && Area_Terreno <= 100.0) {
                NroCarpinteros = 3;
            } else {
                if (Area_Terreno > 100.0) {
                    NroCarpinteros = 5;
                }
            }
        }

    }

    public void CalcularNro_plomeros() {
    }

    @Override
    public void EstimacionDeMateriales() {

        Random num_random = new Random();
        //SE CALCULA LOS MATERIALES EN FUNCION DEL TERRENO
        if (Area_Terreno > 0 && Area_Terreno <= 40.0) {

            NroTejas = num_random.nextInt(1000 - 600 + 1) + 200;//MIN:200 MAX=600
            NroSelladoresBasicos = num_random.nextInt(10 - 6 + 1) + 4;//MIN:4 MAX=8        
            NroMembranasAsfálticas = 4;
            NroClavos = num_random.nextInt(1000 - 600 + 1) + 800;//MIN:800 MAX=1200
            NroTornillos = num_random.nextInt(1000 - 600 + 1) + 800;//MIN:800 MAX=1200
            NroSoporteParaTejas = num_random.nextInt(150 - 120 + 1) + 120; // MIN: 120, MAX: 150
            NroMaderas = num_random.nextInt(5 - 2 + 1) + 2; // MIN: 2, MAX: 5     

        } else {
            if (Area_Terreno > 40 && Area_Terreno <= 100) {
                NroTejas = num_random.nextInt(1500 - 800 + 1) + 800; // MIN: 800, MAX: 1500
                NroSelladoresBasicos = num_random.nextInt(15 - 10 + 1) + 10; // MIN: 10, MAX: 15
                NroMembranasAsfálticas = num_random.nextInt(10 - 6 + 1) + 6; // MIN: 6, MAX: 10
                NroClavos = num_random.nextInt(2500 - 1500 + 1) + 1500; // MIN: 1500, MAX: 2500
                NroTornillos = num_random.nextInt(2500 - 1500 + 1) + 1500; // MIN: 1500, MAX: 2500
                NroSoporteParaTejas = num_random.nextInt(500 - 300 + 1) + 300; // MIN: 300, MAX: 500
                NroMaderas = num_random.nextInt(15 - 10 + 1) + 10; // MIN: 10, MAX: 15
            } else {
                if (Area_Terreno > 100) {
                    NroTejas = num_random.nextInt(3000 - 2000 + 1) + 2000; // MIN: 2000, MAX: 3000
                    NroSelladoresBasicos = num_random.nextInt(25 - 20 + 1) + 20; // MIN: 20, MAX: 25
                    NroMembranasAsfálticas = num_random.nextInt(20 - 15 + 1) + 15; // MIN: 15, MAX: 20
                    NroClavos = num_random.nextInt(5000 - 3000 + 1) + 3000; // MIN: 3000, MAX: 5000
                    NroTornillos = num_random.nextInt(5000 - 3000 + 1) + 3000; // MIN: 3000, MAX: 5000
                    NroSoporteParaTejas = num_random.nextInt(1000 - 700 + 1) + 700; // MIN: 700, MAX: 1000
                    NroMaderas = num_random.nextInt(30 - 20 + 1) + 20; // MIN: 20, MAX: 30
                }

            }
        }

    }

    @Override
    public int CalcularComplejidad(int a, int b) {//a=num pisos b=num habitaciones por piso
        int comp = 1;
        if (a > 15) {
            comp = 5;
        } else {
            if (a > 10) {
                comp = 4;
            } else {
                if (a >= 5 && b >= 8) {
                    comp = 3;
                } else {
                    if (a >= 3 && b >= 5) {
                        comp = 2;
                    }
                }
            }
        }
        return comp;
    }

    @Override
    public void CalcularPresupuesto() {
        CalcularNroObreros();
        CalcularNroElectricistas();
        EstimacionDeMateriales();

        Presupuesto_materiales = (NroTejas * 4.50) + (NroSelladoresBasicos * 9.70) + (NroMembranasAsfálticas * 130.00) + (NroClavos * 0.06)
                + (NroTornillos * 0.15) + (NroSoporteParaTejas * 6.90) + (NroMaderas * 36.00);
        Presupuesto_personal = totalDiasObra * NroObreros * 83.2 + totalDiasObra * NroElectricistas * 79.85 + totalDiasObra * NroCarpinteros * 47.75;
        presupuesto = Presupuesto_materiales + Presupuesto_personal;
    }

    @Override
    public int DefinirIDObra() {
        /*LOD ID de obra serán de la forma 2200MN donde MN son 2 numeros agregados aleatoriamente*/
        int num = 2200;
        num = num + Aleatoriedad.retornarNumeroAleatorio(99, 10);
        return num;
    }

    /*SETTERS*/

    public void SetArea_terreno(double a) {
        Area_Terreno = a;
    }

    public void SetDistrito(String a) {
        Distrito = a;
    }

    public double getArea_terreno() {
        return Area_Terreno;
    }

    public String getDistrito() {
        return Distrito;
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

    @Override
    public int getNroObreros() {
        return NroObreros;
    }

    @Override
    public int getNroElectricistas() {
        return NroElectricistas;
    }

    public double getArea_Tejado() {
        return Area_Terreno;
    }

    public void setArea_Tejado(double Area_Tejado) {
        this.Area_Terreno = Area_Tejado;
    }

    @Override
    public int getNroCarpinteros() {
        return NroCarpinteros;
    }

    public void setNroCarpinteros(int NroCarpinteros) {
        this.NroCarpinteros = NroCarpinteros;
    }

    public int getNroTejas() {
        return NroTejas;
    }

    public void setNroTejas(int NroTejas) {
        this.NroTejas = NroTejas;
    }

    public int getNroSelladoresBasicos() {
        return NroSelladoresBasicos;
    }

    public void setNroSelladoresBasicos(int NroSelladoresBasicos) {
        this.NroSelladoresBasicos = NroSelladoresBasicos;
    }

    public int getNroMembranasAsfálticas() {
        return NroMembranasAsfálticas;
    }

    public void setNroMembranasAsfálticas(int NroMembranasAsfálticas) {
        this.NroMembranasAsfálticas = NroMembranasAsfálticas;
    }

    public int getNroClavos() {
        return NroClavos;
    }

    public void setNroClavos(int NroClavos) {
        this.NroClavos = NroClavos;
    }

    public int getNroTornillos() {
        return NroTornillos;
    }

    public void setNroTornillos(int NroTornillos) {
        this.NroTornillos = NroTornillos;
    }

    public int getNroSoporteParaTejas() {
        return NroSoporteParaTejas;
    }

    public void setNroSoporteParaTejas(int NroSoporteParaTejas) {
        this.NroSoporteParaTejas = NroSoporteParaTejas;
    }

    public int getNroMaderas() {
        return NroMaderas;
    }

    public void setNroMaderas(int NroMaderas) {
        this.NroMaderas = NroMaderas;
    }

    public int getNro_construcciones() {
        return Nro_construcciones;
    }

    public void setNro_construcciones(int Nro_construcciones) {
        this.Nro_construcciones = Nro_construcciones;
    }

    public double getArea_Terreno() {
        return Area_Terreno;
    }

    public void setArea_Terreno(double Area_Terreno) {
        this.Area_Terreno = Area_Terreno;
    }




}
