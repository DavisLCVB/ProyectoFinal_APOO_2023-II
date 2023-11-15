package com.grupo8.finalproject.userinterface.actionworkers;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class PanelTitulo extends JPanel {

    private JLabel lbTitulo;

    public PanelTitulo() {
        this.setBounds(0, 50, 790, 100);
        this.setLayout(null);
        this.setBackground(new Color(0, 129, 155));
        initComponents();
    }

    private void initComponents() {

        Font myFont = new Font("Arial Narrow", Font.PLAIN, 30);
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-SemiBold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        myFont = myFont.deriveFont(Font.PLAIN, 30);

        lbTitulo = new JLabel("Cantidad de tareas");
        lbTitulo.setBounds(0, 0, 790, 100);
        lbTitulo.setFont(myFont);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setVerticalAlignment(JLabel.CENTER);
        this.add(lbTitulo);
    }

}
