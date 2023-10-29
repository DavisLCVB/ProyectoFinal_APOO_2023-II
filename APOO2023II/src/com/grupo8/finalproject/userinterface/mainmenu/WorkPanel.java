/*
 * Panel Encargado de obtener la información de la obra
 */
package com.grupo8.finalproject.userinterface.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class WorkPanel extends JPanel {

    private JLabel lbObra;
    public JLabel lbNombreObra;
    public JLabel lbProgreso;
    public JProgressBar pbProgreso;
    private JLabel lbToDo;

    public WorkPanel() {
        this.setBounds(200, 0, 500, 800);
        this.setBackground(new Color(37, 35, 39));
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 20);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 20);

        lbObra = new JLabel("Obra");
        lbObra.setBounds(0, 100, 500, 20);
        lbObra.setFont(custom);
        lbObra.setForeground(Color.WHITE);
        lbObra.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbObra);

        lbNombreObra = new JLabel("Nombre: ");
        lbNombreObra.setBounds(100, 120, 400, 15);
        lbNombreObra.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbNombreObra.setForeground(Color.WHITE);
        this.add(lbNombreObra);

        lbProgreso = new JLabel("Progreso: ");
        lbProgreso.setBounds(100, 160, 400, 20);
        lbProgreso.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbProgreso.setForeground(Color.WHITE);
        this.add(lbProgreso);

        pbProgreso = new JProgressBar();
        pbProgreso.setBounds(100, 200, 300, 20);
        pbProgreso.setMaximum(100);
        pbProgreso.setFont(custom);
        this.add(pbProgreso);

        lbToDo = new JLabel("En implementación...");
        lbToDo.setBounds(0, 380, 500, 40);
        lbToDo.setFont(custom.deriveFont(Font.PLAIN, 40));
        lbToDo.setForeground(Color.WHITE);
        lbToDo.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbToDo);
    }

}
