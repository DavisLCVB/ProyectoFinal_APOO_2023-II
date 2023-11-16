package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.trabajadores.Carpintero;
import com.grupo8.finalproject.domain.empleados.trabajadores.Electricista;
import com.grupo8.finalproject.domain.empleados.trabajadores.Obrero;
import com.grupo8.finalproject.utilities.Aleatoriedad;
import com.grupo8.finalproject.utilities.TiempoAleatorio;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TrabajadorEjecutable implements Runnable {

    private ArrayList<AccionPrincipal> acciones;
    private String tipo;
    private Font fontCustom;
    private int num;

    public TrabajadorEjecutable(ArrayList<AccionPrincipal> acciones, String tipo) {

        this.acciones = acciones;
        this.tipo = tipo;
        fontCustom = new Font("Arial", Font.PLAIN, 15);
        try {
            fontCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
            fontCustom = fontCustom.deriveFont(Font.PLAIN, 15);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public void mostrarAccionesTrabajador() {
        for (AccionPrincipal accion : acciones) {
            String texto = "Realizando " + accion.getNombre() + ":\n";
            if (tipo.equalsIgnoreCase("Electricista")) {
                Electricista.mostrarAcciones.append(texto);
            } else if (tipo.equalsIgnoreCase("Obrero")) {
                Obrero.mostrarAcciones.append(texto);
            } else if (tipo.equalsIgnoreCase("Carpintero")) {
                Carpintero.mostrarAcciones.append(texto);
            }
            mostrarSubaccionesTrabajador(accion.getSubprocesos());
        }
        String texto = "---------------------.:TAREAS FINALIZADAS:.---------------------";
        if (tipo.equalsIgnoreCase("Electricista")) {
            Electricista.mostrarAcciones.append(texto);
        } else if (tipo.equalsIgnoreCase("Obrero")) {
            Obrero.mostrarAcciones.append(texto);
        } else if (tipo.equalsIgnoreCase("Carpintero")) {
            Carpintero.mostrarAcciones.append(texto);
        }
    }

    public void mostrarSubaccionesTrabajador(ArrayList<String> subtareas) {
        int superior = subtareas.size();
        for (int i = 0; i < superior; i++) {
            TiempoAleatorio.setRango(3);
            LocalDateTime aleatorio = TiempoAleatorio.retornarHoraAleatoria();
            Aleatoriedad.setLimite(subtareas.size());
            int indiceAleatorio = Aleatoriedad.retornarNumeroAleatorio();
            String texto = ">> " + subtareas.get(indiceAleatorio);
            if (tipo.equalsIgnoreCase("Electricista")) {
                Electricista.mostrarAcciones.append(texto);
            } else if (tipo.equalsIgnoreCase("Obrero")) {
                Obrero.mostrarAcciones.append(texto);
            } else if (tipo.equalsIgnoreCase("Carpintero")) {
                Carpintero.mostrarAcciones.append(texto);
            }
            while (true) {
                LocalDateTime ahora = LocalDateTime.now();
                if (ahora.equals(aleatorio) || ahora.isAfter(aleatorio)) {
                    texto = " - FINALIZADO\n";
                    if (tipo.equalsIgnoreCase("Electricista")) {
                        Electricista.mostrarAcciones.append(texto);
                    } else if (tipo.equalsIgnoreCase("Obrero")) {
                        Obrero.mostrarAcciones.append(texto);
                    } else if (tipo.equalsIgnoreCase("Carpintero")) {
                        Carpintero.mostrarAcciones.append(texto);
                    }
                    subtareas.remove(indiceAleatorio);
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }

    @Override
    public void run() {
    }

    public ArrayList<AccionPrincipal> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<AccionPrincipal> acciones) {
        this.acciones = acciones;
    }

}
