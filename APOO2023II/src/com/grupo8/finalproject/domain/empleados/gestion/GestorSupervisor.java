package com.grupo8.finalproject.domain.empleados.gestion;

import com.grupo8.finalproject.utilities.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class GestorSupervisor {
    
    private static ArrayList<Supervisor> supervisores = new ArrayList<>();
    private static int indexSupervisorActual;
    private Supervisor supervisorActual;
    
    public GestorSupervisor() {
    }
    
    public static void llenarSupervisores() {
        ArrayList<String> datos = new ArrayList<>();
        ArrayList<String> usuarios = new ArrayList<>();
        try {
            FileManager.leerArchivo("supervisores\\DatosSupervisores.txt", datos);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        try {
            FileManager.leerArchivo("supervisores\\ClavesSupervisores.txt", usuarios);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        for (int i = 0; i < datos.size(); i += 2) {
            Supervisor temp = new Supervisor();
            temp.setNombre(datos.get(i));
            temp.setApellido(datos.get(i + 1));
            temp.setUsuario(usuarios.get(i));
            temp.setContraseña(usuarios.get(i + 1));
            temp.setIcono(iconoSup(datos.get(i), datos.get(i + 1)));
            supervisores.add(temp);
        }
    }
    
    public static boolean buscarSupervisor(String usuario, String contraseña) {
        boolean encontrado = false;
        for (int i = 0; i < supervisores.size(); i++) {
            Supervisor sup = supervisores.get(i);
            if (!sup.getUsuario().equals(usuario)) {
                continue;
            }
            if (!sup.getContraseña().equals(contraseña)) {
                continue;
            }
            encontrado = true;
            indexSupervisorActual = i;
            break;
        }
        return encontrado;
    }
    
    public static ArrayList<Supervisor> getSupervisores() {
        return supervisores;
    }
    
    public static void setSupervisores(ArrayList<Supervisor> supervisores) {
        GestorSupervisor.supervisores = supervisores;
    }
    
    public static int getIndexSupervisorActual() {
        return indexSupervisorActual;
    }
    
    public static void setIndexSupervisorActual(int indexSupervisorActual) {
        GestorSupervisor.indexSupervisorActual = indexSupervisorActual;
    }
    
    public static Supervisor getSupervisorActual() {
        return supervisores.get(indexSupervisorActual);
    }
    
    public void setSupervisorActual(Supervisor supervisorActual) {
        this.supervisorActual = supervisorActual;
    }
    
    public static ImageIcon iconoSup(String nombre, String apellido) {
        ImageIcon sup = null;
        switch (nombre) {
            case "Davis": {
                try {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\supervisores\\DavisIcono.png");
                } catch (Exception e) {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                }
            }
            break;
            case "Nallely": {
                try {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\supervisores\\NallelyIcono.png");
                } catch (Exception e) {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                }
            }
            break;
            case "Brayan": {
                try {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\supervisores\\BrayanIcono.png");
                } catch (Exception e) {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                }
            }
            break;
            case "José": {
                try {
                    if (apellido.equals("Sernaque")) {
                        sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\supervisores\\JoseSIcono.png");
                    }
                } catch (Exception e) {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                }
            }
            break;
            case "Felipe": {
                try {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\supervisores\\FelipeIcono.png");
                } catch (Exception e) {
                    sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                }
            }
            break;
            default:
                sup = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
                break;
        }
        return sup;
    }
}
