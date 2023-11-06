package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class WorkersActive extends JPanelRound {

    private JLabel lbElectricista;
    private JLabel lbPintor;
    private JLabel lbObrero;
    private JLabel lbPlomero;
    public JLabel lbTareaPElectricista;
    public JLabel lbTareaPPintor;
    public JLabel lbTareaPObrero;
    public JLabel lbTareaPPlomero;
    public JLabel lbTareaSPintor;
    public JLabel lbTareaSObrero;
    public JLabel lbTareaSPlomero;
    public JLabel lbTareaSElectricista;

    public WorkersActive() {
        this.setBounds(0, 0, 500, 800);
        this.setBackground(new Color(0, 129, 155));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 20);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
            custom = custom.deriveFont(Font.PLAIN, 20);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        int esp = 30;
        int init = 50;
        lbElectricista = new JLabel("Electricista");
        lbElectricista.setFont(custom);
        lbElectricista.setBounds(20, init, 680, 30);
        lbElectricista.setVerticalAlignment(JLabel.CENTER);
        lbElectricista.setForeground(Color.WHITE);
        this.add(lbElectricista);

        lbPintor = new JLabel("Pintor");
        lbPintor.setFont(custom);
        lbPintor.setBounds(20, init + 3 * esp, 680, 30);
        lbPintor.setVerticalAlignment(JLabel.CENTER);
        lbPintor.setForeground(Color.WHITE);
        this.add(lbPintor);

        lbObrero = new JLabel("Obrero");
        lbObrero.setFont(custom);
        lbObrero.setBounds(20, init + 6 * esp, 680, 30);
        lbObrero.setVerticalAlignment(JLabel.CENTER);
        lbObrero.setForeground(Color.WHITE);
        this.add(lbObrero);

        lbPlomero = new JLabel("Plomero");
        lbPlomero.setFont(custom);
        lbPlomero.setBounds(20, init + 9 * esp, 680, 30);
        lbPlomero.setVerticalAlignment(JLabel.CENTER);
        lbPlomero.setForeground(Color.WHITE);
        this.add(lbPlomero);

        lbTareaPElectricista = new JLabel();
        lbTareaPElectricista.setFont(custom);
        lbTareaPElectricista.setBounds(20, init + esp, 680, 30);
        lbTareaPElectricista.setVerticalAlignment(JLabel.CENTER);
        lbTareaPElectricista.setForeground(Color.WHITE);
        this.add(lbTareaPElectricista);

        lbTareaPPintor = new JLabel();
        lbTareaPPintor.setFont(custom);
        lbTareaPPintor.setBounds(20, init + 4 * esp, 680, 30);
        lbTareaPPintor.setVerticalAlignment(JLabel.CENTER);
        lbTareaPPintor.setForeground(Color.WHITE);
        this.add(lbTareaPPintor);

        lbTareaPObrero = new JLabel();
        lbTareaPObrero.setFont(custom);
        lbTareaPObrero.setBounds(20, init + 7 * esp, 680, 30);
        lbTareaPObrero.setVerticalAlignment(JLabel.CENTER);
        lbTareaPObrero.setForeground(Color.WHITE);
        this.add(lbTareaPObrero);

        lbTareaPPlomero = new JLabel();
        lbTareaPPlomero.setFont(custom);
        lbTareaPPlomero.setBounds(20, init + 10 * esp, 680, 30);
        lbTareaPPlomero.setVerticalAlignment(JLabel.CENTER);
        lbTareaPPlomero.setForeground(Color.WHITE);
        this.add(lbTareaPPlomero);

        lbTareaSElectricista = new JLabel();
        lbTareaSElectricista.setFont(custom);
        lbTareaSElectricista.setBounds(20, init + 2 * esp, 680, 30);
        lbTareaSElectricista.setVerticalAlignment(JLabel.CENTER);
        lbTareaSElectricista.setForeground(Color.WHITE);
        this.add(lbTareaSElectricista);

        lbTareaSPintor = new JLabel();
        lbTareaSPintor.setFont(custom);
        lbTareaSPintor.setBounds(20, init + 5 * esp, 680, 30);
        lbTareaSPintor.setVerticalAlignment(JLabel.CENTER);
        lbTareaSPintor.setForeground(Color.WHITE);
        this.add(lbTareaSPintor);

        lbTareaSObrero = new JLabel();
        lbTareaSObrero.setFont(custom);
        lbTareaSObrero.setBounds(20, init + 8 * esp, 680, 30);
        lbTareaSObrero.setVerticalAlignment(JLabel.CENTER);
        lbTareaSObrero.setForeground(Color.WHITE);
        this.add(lbTareaSObrero);

        lbTareaSPlomero = new JLabel();
        lbTareaSPlomero.setFont(custom);
        lbTareaSPlomero.setBounds(20, init + 11 * esp, 680, 30);
        lbTareaSPlomero.setVerticalAlignment(JLabel.CENTER);
        lbTareaSPlomero.setForeground(Color.WHITE);
        this.add(lbTareaSPlomero);
    }
}
