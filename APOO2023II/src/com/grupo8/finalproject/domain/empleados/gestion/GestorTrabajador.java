package com.grupo8.finalproject.domain.empleados.gestion;

import com.grupo8.finalproject.utilities.Aleatoriedad;
import com.grupo8.finalproject.utilities.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestorTrabajador {

    public static ArrayList<AccionPrincipal> llenarTareas(String tipo) {

        ArrayList<AccionPrincipal> tareas = new ArrayList<>();
        ArrayList<String> archivos = new ArrayList<>();
        ArrayList<String> fases = new ArrayList<>();

        if (tipo.equalsIgnoreCase("Electricista")) {
            fases.add("Fase 1 - Planificación y Diseño");
            fases.add("Fase 2 - Instalación y Cableado");
            fases.add("Fase 3 - Pruebas y Puesta en Marcha");

            archivos.add("tareas\\Fase1-Electricista.txt");
            archivos.add("tareas\\Fase2-Electricista.txt");
            archivos.add("tareas\\Fase3-Electricista.txt");
        } else if (tipo.equalsIgnoreCase("Carpintero")) {
            fases.add("Fase 1 - Preparación y materiales");
            fases.add("Fase 2 - Cortes y ensamblaje");
            fases.add("Fase 3 - Entrega de obra");

            archivos.add("tareas\\Fase1-Carpintero.txt");
            archivos.add("tareas\\Fase2-Carpintero.txt");
            archivos.add("tareas\\Fase3-Carpintero.txt");
        } else if (tipo.equalsIgnoreCase("Obrero")) {
            fases.add("Fase 1 - Inicio de Obra");
            fases.add("Fase 2 - Estructuración y Edificación");
            fases.add("Fase 3 - Cierre de Obra");

            archivos.add("tareas\\Fase1-Obrero.txt");
            archivos.add("tareas\\Fase2-Obrero.txt");
            archivos.add("tareas\\Fase3-Obrero.txt");
        }

        for (int i = 0; i < 3; i++) {
            tareas.add(new AccionPrincipal(fases.get(i)));
        }

        for (int i = 0; i < 3; i++) {
            int cantidadSubtareas = -1;
            boolean pass;
            do {
                pass = false;
                cantidadSubtareas = -1;
                String respuesta = JOptionPane.showInputDialog(null, "Ingrese la cantidad de subtareas para " + fases.get(i), "Ingreso Datos", JOptionPane.INFORMATION_MESSAGE);
                try {
                    cantidadSubtareas = Integer.parseInt(respuesta);
                    pass = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número no válido", "Ingreso Datos", JOptionPane.ERROR_MESSAGE);
                }
            } while (!pass);

            ArrayList<String> contenedor = new ArrayList<>();
            try {
                FileManager.leerArchivo(archivos.get(i), contenedor);
                if (contenedor.size() < 2) {
                    throw new Exception("Error, archivo vacio");
                }
            } catch (Exception e) {
                try {
                    FileManager.crearArchivo(archivos.get(i));
                    FileManager.escribirArchivo(archivos.get(i), "empty", false);
                    System.out.println("Creando Archivo " + archivos.get(i));
                    FileManager.escribirArchivo(archivos.get(i), "Fin-Archivo", true);
                    FileManager.leerArchivo(archivos.get(i), contenedor);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                } catch (IOException ex) {
                    Logger.getLogger(GestorTrabajador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            ArrayList<String> subtareas = new ArrayList<>();
            ArrayList<String> copias = new ArrayList<>();

            for (int j = 0; j < cantidadSubtareas; j++) {
                String temp = "";
                do {
                    int indiceAleatorio = Aleatoriedad.retornarNumeroAleatorio(contenedor.size() - 1);
                    try {
                        temp = contenedor.get(indiceAleatorio);
                    } catch (Exception e) {
                        System.out.println("Indice fuera de límites: " + indiceAleatorio);
                    }
                } while (copias.contains(temp) && copias.size() < contenedor.size() - 1);

                copias.add(temp);
                subtareas.add(temp);
            }
            tareas.get(i).setSubprocesos(subtareas);
        }

        return tareas;
    }
}
