package com.grupo8.finalproject.userinterface.actionworkers;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PanelDatos extends JPanelRound {

    private JLabel lbElect;
    private JLabel lbCarp;
    private JLabel lbObre;
    public JSpinner cantElect;
    public JSpinner cantCarp;
    public JSpinner cantObre;
    public JPanelRound prAceptar;
    public JLabel lbAceptar;

    public PanelDatos() {
        this.setBounds(50, 225, 500, 250);
        this.setBackground(new Color(37, 35, 39));
        this.setRoundBottomLeft(25);
        this.setRoundBottomRight(25);
        this.setRoundTopLeft(25);
        this.setRoundTopRight(25);
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {

        Font fnCustom = new Font("Arial Narrow", Font.PLAIN, 18);
        try {
            fnCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        fnCustom = fnCustom.deriveFont(Font.PLAIN, 18);

        lbElect = new JLabel("Cantidad de tareas para electricista:");
        lbElect.setBounds(10, 12, 300, 20);
        lbElect.setFont(fnCustom);
        lbElect.setForeground(Color.WHITE);
        this.add(lbElect);

        lbCarp = new JLabel("Cantidad de tareas para carpintero:");
        lbCarp.setBounds(10, 69, 300, 20);
        lbCarp.setFont(fnCustom);
        lbCarp.setForeground(Color.WHITE);
        this.add(lbCarp);

        lbObre = new JLabel("Cantidad de tareas para obrero:");
        lbObre.setBounds(10, 126, 300, 20);
        lbObre.setFont(fnCustom);
        lbObre.setForeground(Color.WHITE);
        this.add(lbObre);

        SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);

        cantElect = new JSpinner(spinnerModel1);
        cantElect.setBounds(400, 12, 50, 30);
        cantElect.setBorder(new LineBorder(Color.WHITE, 5, true));
        cantElect.setBounds(400, 12, 50, 30);
        cantElect.setFont(fnCustom);
        this.add(cantElect);

        cantCarp = new JSpinner(spinnerModel2);
        cantCarp.setBounds(400, 69, 50, 30);
        cantCarp.setBorder(new LineBorder(Color.WHITE, 5, true));
        cantCarp.setFont(fnCustom);
        this.add(cantCarp);

        cantObre = new JSpinner(spinnerModel3);
        cantObre.setBounds(400, 126, 50, 30);
        cantObre.setBorder(new LineBorder(Color.WHITE, 5, true));
        cantObre.setFont(fnCustom);
        this.add(cantObre);

        prAceptar = new JPanelRound();
        prAceptar.setBackground(Color.BLACK);
        prAceptar.setRoundBottomLeft(25);
        prAceptar.setRoundBottomRight(25);
        prAceptar.setRoundTopLeft(25);
        prAceptar.setRoundTopRight(25);
        prAceptar.setBounds(150, 180, 200, 40);
        this.add(prAceptar);

        lbAceptar = new JLabel("Aceptar");
        lbAceptar.setBounds(0, 0, 200, 30);
        lbAceptar.setHorizontalAlignment(JLabel.CENTER);
        lbAceptar.setForeground(Color.WHITE);
        lbAceptar.setFont(fnCustom);
        prAceptar.add(lbAceptar);
    }

    public boolean validadDatos() {
        int num1 = 0, num2 = 0, num3 = 0;
        try {
            num1 = Integer.parseInt(cantElect.getValue().toString());
            num2 = Integer.parseInt(cantCarp.getValue().toString());
            num3 = Integer.parseInt(cantObre.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar números", "Ingreso de Datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
            JOptionPane.showMessageDialog(null, "Error: Los números deben ser mayores a 0", "Ingreso de Datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (num1 > 99 || num2 > 99 || num3 > 99) {
            JOptionPane.showMessageDialog(null, "Error: Los números son demasiado gran", "Ingreso de Datos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
