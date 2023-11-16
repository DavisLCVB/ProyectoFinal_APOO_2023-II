package com.grupo8.finalproject.userinterface.confirmlogin;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class VentanaConfirmacion extends JFrame {

    private JPanelRound panelConfirmacion;
    private JLabel jlConfirmacion;
    private JLabel jlGifConfirmacion;

    public VentanaConfirmacion() {
        this.setSize(400, 400);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    public void initComponents() {

        Font fuenteCustom = new Font("Arial", Font.PLAIN, 20);
        try {
            fuenteCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        fuenteCustom = fuenteCustom.deriveFont(Font.PLAIN, 20);

        panelConfirmacion = new JPanelRound();
        panelConfirmacion.setBounds(0, 0, 400, 400);
        panelConfirmacion.setBackground(new Color(41, 39, 43));
        panelConfirmacion.setRoundBottomLeft(50);
        panelConfirmacion.setRoundBottomRight(50);
        panelConfirmacion.setRoundTopLeft(50);
        panelConfirmacion.setRoundTopRight(50);
        panelConfirmacion.setLayout(null);
        this.add(panelConfirmacion);

        jlConfirmacion = new JLabel("¡Inicio de sesión exitoso!");
        jlConfirmacion.setBounds(0, 270, 400, 30);
        jlConfirmacion.setFont(fuenteCustom);
        jlConfirmacion.setForeground(Color.WHITE);
        jlConfirmacion.setHorizontalAlignment(JLabel.CENTER);
        panelConfirmacion.add(jlConfirmacion);

        ImageIcon gifCheck = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario_check.png");
        Image scaled = gifCheck.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        gifCheck = new ImageIcon(scaled);

        jlGifConfirmacion = new JLabel();
        jlGifConfirmacion.setBounds(130, 70, 300, 200);
        jlGifConfirmacion.setIcon(gifCheck);
        jlGifConfirmacion.setVerticalAlignment(JLabel.CENTER);
        panelConfirmacion.add(jlGifConfirmacion);
    }
}
