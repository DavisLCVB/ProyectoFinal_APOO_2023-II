package com.grupo8.finalproject.domain.obras;

import com.grupo8.finalproject.utilities.Aleatoriedad;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class ConstruccionEdificioApartamentos extends Obra implements AccionObras, Serializable {

    /*Atributos que se llenarán por ventana*/
    protected int Nro_pisos;
    protected int Nro_habitaciones;
    protected double Area_terreno;
    protected String Distrito;


    /*Atributos que se calcularan (en función a los llenados)*/
    protected LocalDate Fecha_Culminacion_Obra;
    protected double Presupuesto_materiales;
    protected double Presupuesto_personal;
    protected int totalDiasObra;
    protected int NroLadrillos;
    protected int Nrofierros;
    protected int NroBolsascemento;
    protected int NroKgpiedra;
    protected int NroKgarena;
    protected int Nrotubos_agua;
    protected int Nrotubos_luz;
    protected int NroPalos_madera;

    public ConstruccionEdificioApartamentos() {

    }

    public LocalDate CalcularFecha_Culminacion_Obra() {

        /*1 piso con menos de 5 habitaciones se construirá en 5 días
        1 piso con mas de 5 habitaciones y menos de 10 se construirá en 10 días
        1 piso con mas de 10 habitaciones se construirá en 15 días;*/
        LocalDate fecha_hoy = LocalDate.now();

        int diasPorPiso = 0;

        if (Nro_habitaciones > 0 && Nro_habitaciones <= 5) {
            diasPorPiso = 8;
        } else {
            if (Nro_habitaciones > 5 && Nro_habitaciones <= 10) {
                diasPorPiso = 10;
            } else {
                if (Nro_habitaciones > 10) {
                    diasPorPiso = 15;
                }
            }
        }
        totalDiasObra = diasPorPiso * Nro_pisos;
        fecha_hoy = fecha_hoy.plusDays(totalDiasObra);
        Fecha_Culminacion_Obra = fecha_hoy;
        return Fecha_Culminacion_Obra;
    }

    @Override
    public void CalcularNroObreros() {
        /*Se considera que el numero de obreros dependerá del area del terreno
        * ya que no se les puede distribuir por cantidad de pisos */
        if (Area_terreno > 0 && Area_terreno <= 90.0) {
            NroObreros = 5;
        } else {
            if (Area_terreno > 90 && Area_terreno <= 150) {
                NroObreros = 8;
            } else {
                if (Area_terreno > 150 && Area_terreno < 200) {
                    NroObreros = 10;
                }
            }
        }
    }

    @Override
    public void CalcularNroElectricistas() {
        if (Area_terreno > 0 && Area_terreno <= 90.0) {
            NroElectricistas = 1;
        } else {
            if (Area_terreno > 90 && Area_terreno <= 150) {
                NroElectricistas = 2;
            } else {
                if (Area_terreno > 150 && Area_terreno < 200) {
                    NroElectricistas = 2;
                }
            }
        }
    }

    @Override
    public void CalcularNroCarpinteros() {
        if (Area_terreno > 0 && Area_terreno <= 90.0) {
            NroCarpinteros = 1;
        } else {
            if (Area_terreno > 90 && Area_terreno <= 150) {
                NroCarpinteros = 2;
            } else {
                if (Area_terreno > 150 && Area_terreno < 200) {
                    NroCarpinteros = 2;
                }
            }
        }
    }

    @Override
    public void EstimacionDeMateriales() {

        Random num_random = new Random();
        if (Area_terreno > 0 && Area_terreno <= 90.0) {
            NroLadrillos = num_random.nextInt(5000 - 4500 + 1) + 4500;//MIN:4500 MAX=5000
            Nrofierros = 6 * 15;
            NroBolsascemento = num_random.nextInt(250 - 200 + 1) + 200;//MIN:200 MAX=250
            NroKgpiedra = num_random.nextInt(5000 - 4500 + 1) + 5000;//MIN:4500 MAX=5000
            NroKgarena = num_random.nextInt(5000 - 4500 + 1) + 5000;//MIN:4500 MAX=5000
            Nrotubos_agua = num_random.nextInt(100 - 50 + 1) + 50;//MIN:50 MAX=100
            Nrotubos_luz = num_random.nextInt(100 - 50 + 1) + 50;//MIN:50 MAX=100
            NroPalos_madera = num_random.nextInt(200 - 150 + 1) + 150;//MIN:150 MAX=200
        } else {
            if (Area_terreno > 90 && Area_terreno <= 150) {
                NroLadrillos = num_random.nextInt(6000 - 5000 + 1) + 5000;//MIN:5000 MAX=6000
                Nrofierros = 6 * 20;
                NroBolsascemento = num_random.nextInt(350 - 250 + 1) + 250;//MIN:250 MAX=350
                NroKgpiedra = num_random.nextInt(6000 - 5000 + 1) + 5000;//MIN:5000 MAX=6000
                NroKgarena = num_random.nextInt(6000 - 5000 + 1) + 5000;//MIN:5000 MAX=6000
                Nrotubos_agua = num_random.nextInt(200 - 100 + 1) + 100;//MIN:100 MAX=200
                Nrotubos_luz = num_random.nextInt(200 - 100 + 1) + 100;//MIN:100 MAX=200
                NroPalos_madera = num_random.nextInt(300 - 200 + 1) + 200;//MIN:200 MAX=300

            } else {
                if (Area_terreno > 150 && Area_terreno < 200) {
                    NroLadrillos = num_random.nextInt(8000 - 6000 + 1) + 6000;//MIN:6000 MAX=8000
                    Nrofierros = 6 * 25;
                    NroBolsascemento = num_random.nextInt(450 - 350 + 1) + 350;//MIN:350 MAX=450
                    NroKgpiedra = num_random.nextInt(7000 - 6000 + 1) + 6000;//MIN:6000 MAX=7000
                    NroKgarena = num_random.nextInt(7000 - 6000 + 1) + 6000;//MIN:6000 MAX=7000
                    Nrotubos_agua = num_random.nextInt(250 - 200 + 1) + 200;//MIN:200 MAX=250
                    Nrotubos_luz = num_random.nextInt(250 - 200 + 1) + 200;//MIN:200 MAX=250
                    NroPalos_madera = num_random.nextInt(400 - 300 + 1) + 300;//MIN:300 MAX=400

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
        CalcularNroCarpinteros();
        EstimacionDeMateriales();

        Presupuesto_materiales = NroLadrillos * 1.0 + Nrofierros * 45.0 + NroBolsascemento * 30.0 + NroKgpiedra * 6.0 + NroKgarena + 6.0 + Nrotubos_agua * 20.0 + Nrotubos_luz * 15.0 + NroPalos_madera * 5.0;
        Presupuesto_personal = totalDiasObra * NroObreros * 83.2 + totalDiasObra * NroElectricistas * 79.85 + totalDiasObra * NroPlomeros * 47.75;
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
    public void SetNro_pisos(int a) {
        Nro_pisos = a;
    }

    public void SetNro_habitaciones(int a) {
        Nro_habitaciones = a;
    }

    public void SetArea_terreno(double a) {
        Area_terreno = a;
    }

    public void SetDistrito(String a) {
        Distrito = a;
    }

    /*GETTERS*/
    public int getNro_pisos() {
        return Nro_pisos;
    }

    public int getNro_habitaciones() {
        return Nro_habitaciones;
    }

    public double getArea_terreno() {
        return Area_terreno;
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

    public int getNroLadrillos() {
        return NroLadrillos;
    }

    public int getNrofierros() {
        return Nrofierros;
    }

    public int getNroBolsascemento() {
        return NroBolsascemento;
    }

    public int getNroKgpiedra() {
        return NroKgpiedra;
    }

    public int getNroKgarena() {
        return NroKgarena;
    }

    public int getNrotubos_agua() {
        return Nrotubos_agua;
    }

    public int getNrotubos_luz() {
        return Nrotubos_luz;
    }

    public int getNroPalos_madera() {
        return NroPalos_madera;
    }

    @Override
    public String toString() {
        String CEAstr = super.toString();
        CEAstr += "Nro de Pisos:\t\t" + this.Nro_pisos + "\n";
        CEAstr += "Nro de Habitaciones:\t" + this.Nro_habitaciones + "\n";
        CEAstr += "Área del Terreno:\t" + this.Area_terreno + "\n";
        CEAstr += "Distrito:\t\t" + this.Distrito + "\n";
        return CEAstr;
    }
}
