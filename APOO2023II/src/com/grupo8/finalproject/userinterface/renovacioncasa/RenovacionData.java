package com.grupo8.finalproject.userinterface.renovacioncasa;

import com.grupo8.finalproject.userinterface.apartamentos.PanelBorde;
import javax.swing.*; //Librería para VENTANA
import java.awt.*;

public class RenovacionData extends JFrame {

    public PanelFondo fondo_ventana;
    public PanelTituloA Letras_iniciales;
    public PanelTituloB Letras_iniciales_2;
    public PanelIngresoDatos panel_ingresoDatos;
    public ImageIcon imagen;
    public PanelBorde pb;

    public RenovacionData() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(785, 539);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Construcción de edificios de Apartamento");
        IniciarComp();
    }

    public void IniciarComp() {
        fondo_ventana = new PanelFondo();
        fondo_ventana.setBounds(5, 5, 775, 529);//width=ancho height=largo
        this.add(fondo_ventana);

        pb = new PanelBorde();
        this.add(pb);
        
        Letras_iniciales = new PanelTituloA();
        Letras_iniciales.setBounds(60, 30, 700, 110);
        fondo_ventana.add(Letras_iniciales);

        Letras_iniciales_2 = new PanelTituloB();
        Letras_iniciales_2.setBounds(55, 130, 700, 40);
        fondo_ventana.add(Letras_iniciales_2);

        Color color_estilo = new Color(0, 120, 145);
        JPanel panel_estilo = new JPanel();
        panel_estilo.setBackground(color_estilo);
        panel_estilo.setBounds(0, 190, 1500, 60);
        fondo_ventana.add(panel_estilo);

        panel_ingresoDatos = new PanelIngresoDatos();
        panel_ingresoDatos.setBounds(20, 270, 450, 275);
        fondo_ventana.add(panel_ingresoDatos);

        imagen = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\Renovacion.gif");
        JLabel panel_imagen = new JLabel();
        panel_imagen.setIcon(imagen);
        panel_imagen.setBounds(500, 260, 300, 300);
        fondo_ventana.add(panel_imagen);

    }

}
