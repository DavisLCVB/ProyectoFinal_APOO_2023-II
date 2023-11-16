package com.grupo8.finalproject.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class FileManager {

    private static final String ruta = "src\\com\\grupo8\\finalproject\\files\\";

    public static void crearArchivo(String nombreArchivo) throws FileNotFoundException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        PrintWriter salida = new PrintWriter(archivo);
        salida.close();
    }

    public static void escribirArchivo(String nombreArchivo, String mensaje, boolean aniadir) throws IOException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        PrintWriter salida = new PrintWriter(new FileWriter(archivo, aniadir));
        salida.println(mensaje);
        salida.close();
    }

    public static void leerArchivo(String nombreArchivo, ArrayList<String> almacen) throws FileNotFoundException, IOException {
        String nombreFullArchivo = ruta + nombreArchivo;
        File archivo = new File(nombreFullArchivo);
        String entrada;
        BufferedReader buffer = new BufferedReader(new FileReader(archivo));
        do {
            entrada = buffer.readLine();
            if (entrada != null) {
                almacen.add(entrada);
            }
        } while (entrada != null);
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

    public static void escribirArchivo(String nombre, Object obj) throws FileNotFoundException, IOException {
        FileOutputStream ostream = new FileOutputStream(ruta + nombre);
        ObjectOutputStream p = new ObjectOutputStream(ostream);
        p.writeObject(obj);
        p.flush();
        ostream.close();
    }

    public static Object leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream istream = new FileInputStream(ruta + nombreArchivo);
        ObjectInputStream p = new ObjectInputStream(istream);
        Object obj = p.readObject();
        istream.close();
        return obj;
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(ruta + nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se elimino" + ruta + nombreArchivo);
        }
    }
}
