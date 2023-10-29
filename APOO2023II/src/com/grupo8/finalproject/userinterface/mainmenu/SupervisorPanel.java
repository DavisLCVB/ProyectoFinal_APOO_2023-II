/*
 * Panel encargado de almacenar la información del supervisor
 */
package com.grupo8.finalproject.userinterface.mainmenu;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class SupervisorPanel extends JPanelRound {

    private JLabel lbSupervisor;
    public JLabel lbNombre;
    public JLabel lbApellidos;
    public JLabel lbIDSupervisor;
    private JLabel lbImagenSupervisor;

    public SupervisorPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 200, 800);
        this.setRoundBottomLeft(50);
        this.setRoundTopLeft(50);
        this.setBackground(new Color(3, 1, 6));
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

        lbSupervisor = new JLabel("Supervisor");
        lbSupervisor.setBounds(0, 450, 200, 20);
        lbSupervisor.setFont(custom);
        lbSupervisor.setHorizontalAlignment(JLabel.CENTER);
        lbSupervisor.setForeground(Color.WHITE);
        this.add(lbSupervisor);

        lbNombre = new JLabel("Nombre:");
        lbNombre.setBounds(20, 490, 180, 15);
        lbNombre.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbNombre.setForeground(Color.WHITE);
        this.add(lbNombre);

        lbApellidos = new JLabel("Apellidos:");
        lbApellidos.setBounds(20, 515, 180, 15);
        lbApellidos.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbApellidos.setForeground(Color.WHITE);
        this.add(lbApellidos);

        lbIDSupervisor = new JLabel("IDSesion:");
        lbIDSupervisor.setBounds(20, 540, 180, 15);
        lbIDSupervisor.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbIDSupervisor.setForeground(Color.WHITE);
        this.add(lbIDSupervisor);

        ImageIcon usuario = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
        Image scaled = usuario.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        usuario = new ImageIcon(scaled);

        lbImagenSupervisor = new JLabel();
        lbImagenSupervisor.setBounds(0, 580, 200, 150);
        lbImagenSupervisor.setIcon(usuario);
        lbImagenSupervisor.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbImagenSupervisor);
    }
}
