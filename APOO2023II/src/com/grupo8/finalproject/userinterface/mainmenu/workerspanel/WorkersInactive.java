package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author leocv
 */
public class WorkersInactive extends JPanelRound {

    private JLabel lbTrabajador;
    private JLabel lbImagenTrabajador;
    private JPanelRound prTrabajador;

    public WorkersInactive() {
        this.setBounds(0, 0, 500, 800);
        this.setBackground(new Color(0, 129, 155, 0));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 20);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 20);

        lbTrabajador = new JLabel("Trabajadores en Descanso");
        lbTrabajador.setBounds(0, 420, 500, 20);
        lbTrabajador.setFont(custom);
        lbTrabajador.setForeground(Color.WHITE);
        lbTrabajador.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbTrabajador);

        prTrabajador = new JPanelRound();
        int round = 25;
        prTrabajador.setRoundBottomLeft(round);
        prTrabajador.setRoundBottomRight(round);
        prTrabajador.setRoundTopLeft(round);
        prTrabajador.setRoundTopRight(round);
        prTrabajador.setBackground(new Color(3, 1, 6));
        prTrabajador.setBounds(175, 280, 120,120);
        prTrabajador.setLayout(null);
        this.add(prTrabajador);

        ImageIcon imagenTrabajador = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\trabajador.png");
        Image scaled = imagenTrabajador.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagenTrabajador = new ImageIcon(scaled);

        lbImagenTrabajador = new JLabel();
        lbImagenTrabajador.setBounds(10, 10, 100, 100);
        lbImagenTrabajador.setIcon(imagenTrabajador);
        prTrabajador.add(lbImagenTrabajador);
    }
}
