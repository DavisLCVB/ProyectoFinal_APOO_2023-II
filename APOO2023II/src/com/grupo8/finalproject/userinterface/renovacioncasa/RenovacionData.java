package com.grupo8.finalproject.userinterface.renovacioncasa;

import javax.swing.*; //Librería para VENTANA
import java.awt.*;


public class RenovacionData extends JFrame {
    public PanelFondo fondo_ventana;
    public PanelTituloA Letras_iniciales;
    public PanelTituloB Letras_iniciales_2;
    public PanelIngresoDatos panel_ingresoDatos;
    public ImageIcon imagen;



    public RenovacionData(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IniciarComp();
    }

    public void IniciarComp() {


        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Renovación de casa");

        fondo_ventana = new PanelFondo();
        fondo_ventana.setBounds(5,5,775,529);//width=ancho height=largo
        this.add(fondo_ventana);

        Letras_iniciales = new PanelTituloA();
        Letras_iniciales.setBounds(60, 30, 700, 110);
        fondo_ventana.add(Letras_iniciales);

        Letras_iniciales_2= new PanelTituloB();
        Letras_iniciales_2.setBounds(55,130,700,40);
        fondo_ventana.add(Letras_iniciales_2);

        Color color_estilo =new Color(0,120,145);
        JPanel panel_estilo = new JPanel();
        panel_estilo.setBackground(color_estilo);
        panel_estilo.setBounds(0,190,1500,60);
        fondo_ventana.add(panel_estilo);


        panel_ingresoDatos = new PanelIngresoDatos();
        panel_ingresoDatos.setBounds(20,270,450,275);
        fondo_ventana.add(panel_ingresoDatos);

        imagen=new ImageIcon("C:/Users/ftriv/Documents/NetBeansProjects/TrabajoPOO/production/TrabajoPOO/RenovacionCasa/edificio.gif");
        JLabel panel_imagen = new JLabel();
        panel_imagen.setIcon(imagen);
        panel_imagen.setBounds(500,260,300,300);
        fondo_ventana.add(panel_imagen);

    }

}
