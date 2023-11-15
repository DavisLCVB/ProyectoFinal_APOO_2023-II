package com.grupo8.finalproject.userinterface.actionworkers;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

public class PanelFondo extends JPanelRound {

    private PanelTitulo panTitulo;
    public PanelDatos panDatos;
    private JLabel lbImagen;

    public PanelFondo() {
        this.setBounds(0, 0, 790, 540);
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(null);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    private void initComponents() {
        panTitulo = new PanelTitulo();
        this.add(panTitulo);

        panDatos = new PanelDatos();
        this.add(panDatos);

        ImageIcon imagen = new ImageIcon(new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\tareas.png").getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH));
        lbImagen = new JLabel(imagen);
        lbImagen.setBounds(560, 235, 230, 230);
        lbImagen.setIcon(imagen);
        lbImagen.setHorizontalAlignment(JLabel.CENTER);
        lbImagen.setVerticalAlignment(JLabel.CENTER);
        this.add(lbImagen);
    }
}
