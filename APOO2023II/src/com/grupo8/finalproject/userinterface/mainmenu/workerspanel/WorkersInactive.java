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
    private JLabel lbCantTrabajador;
    private JLabel lbTipoTrabajador;
    private JLabel lbToDo;
    private JLabel lbImagenTrabajador;
    private JLabel lbFaseActual;
    private JLabel lbTareaActual;
    private JPanelRound prTrabajador;

    public WorkersInactive() {
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
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 20);

        lbTrabajador = new JLabel("Trabajadores");
        lbTrabajador.setBounds(0, 100, 500, 20);
        lbTrabajador.setFont(custom);
        lbTrabajador.setForeground(Color.WHITE);
        lbTrabajador.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbTrabajador);

        lbCantTrabajador = new JLabel("Total de trabajadores: 0");
        lbCantTrabajador.setBounds(100, 150, 400, 15);
        lbCantTrabajador.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbCantTrabajador.setForeground(Color.WHITE);
        this.add(lbCantTrabajador);

        lbTipoTrabajador = new JLabel("Total de trabajadores: 0");
        lbTipoTrabajador.setBounds(100, 175, 400, 15);
        lbTipoTrabajador.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbTipoTrabajador.setForeground(Color.WHITE);
        this.add(lbTipoTrabajador);

        lbFaseActual = new JLabel("Fase Actual: ZZZ");
        lbFaseActual.setBounds(100, 200, 400, 15);
        lbFaseActual.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbFaseActual.setForeground(Color.WHITE);
        this.add(lbFaseActual);

        lbTareaActual = new JLabel("Tarea Actual: ZZZ x2");
        lbTareaActual.setBounds(100, 225, 400, 15);
        lbTareaActual.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbTareaActual.setForeground(Color.WHITE);
        this.add(lbTareaActual);

        prTrabajador = new JPanelRound();
        int round = 25;
        prTrabajador.setRoundBottomLeft(round);
        prTrabajador.setRoundBottomRight(round);
        prTrabajador.setRoundTopLeft(round);
        prTrabajador.setRoundTopRight(round);
        prTrabajador.setBackground(new Color(3, 1, 6));
        prTrabajador.setBounds(100, 265, 300, 300);
        prTrabajador.setLayout(null);
        this.add(prTrabajador);

        ImageIcon imagenTrabajador = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\trabajador.png");
        Image scaled = imagenTrabajador.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imagenTrabajador = new ImageIcon(scaled);

        lbImagenTrabajador = new JLabel();
        lbImagenTrabajador.setBounds(50, 50, 200, 200);
        lbImagenTrabajador.setIcon(imagenTrabajador);
        prTrabajador.add(lbImagenTrabajador);

        lbToDo = new JLabel("Por implementar...");
        lbToDo.setBounds(0, 585, 500, 30);
        lbToDo.setFont(custom);
        lbToDo.setForeground(Color.WHITE);
        lbToDo.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbToDo);
    }
}
