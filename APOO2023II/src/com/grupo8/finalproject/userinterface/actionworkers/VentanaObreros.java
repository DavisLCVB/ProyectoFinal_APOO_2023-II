package com.grupo8.finalproject.userinterface.actionworkers;

import com.grupo8.finalproject.userinterface.apartamentos.PanelBorde;
import java.awt.Color;
import javax.swing.*;

public class VentanaObreros extends JFrame {

    public PanelFondo panFondo;
    public PanelBorde pb;

    public VentanaObreros() {
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setSize(790, 540);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Datos Obreros");
        initComponents();
    }

    public void initComponents() {
        panFondo = new PanelFondo();
        this.add(panFondo);
        panFondo.setBounds(5, 5, 780, 530);
        pb = new PanelBorde();
        pb.setBounds(0, 0, 790, 540);
        this.add(pb);
    }
}
