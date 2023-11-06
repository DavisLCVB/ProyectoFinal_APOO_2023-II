/**
 * Clase encargada de trabajar con archivos
 */
package com.grupo8.finalproject.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Davis Cartagena
 */
public abstract class FileManager {

    private static final String ruta = "src\\com\\grupo8\\finalproject\\files\\";

    public static void crearArchivo(String nombreArchivo) {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String mensaje, boolean aniadir) {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, aniadir));
            salida.println(mensaje);
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo, ArrayList<String> almacen) {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        String entrada;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            do {
                entrada = buffer.readLine();
                if (entrada != null) {
                    almacen.add(entrada);
                }
            } while (entrada != null);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo, ArrayList<String> almacen, int lineas) {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        String entrada;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            for (int i = 0; i < lineas; i++) {
                entrada = buffer.readLine();
                if (entrada == null) {
                    break;
                } else {
                    almacen.add(entrada);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
