package com.grupo8.finalproject.userinterface.tejado;

import com.grupo8.finalproject.userinterface.apartamentos.*;
import components.JPanelRound;
import java.awt.Color;//Librería para COLORES
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelFondo extends JPanelRound {

    protected Color micolorAesthetic;
    private ImageIcon imagen;

    public PanelFondo() {
        this.setBounds(0, 0, 800, 600);
        this.setLayout(null);//Para colocar los componentes manualmente
        micolorAesthetic = new Color(0, 0, 0);
        this.setBackground(micolorAesthetic);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    public void initComponents() {
        imagen = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\edificio.gif");
        Image scaled = imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel panel_imagen = new JLabel();
        panel_imagen.setIcon(imagen);
        panel_imagen.setBounds(500, 250, 300, 300);
        this.add(panel_imagen);
    }
}
