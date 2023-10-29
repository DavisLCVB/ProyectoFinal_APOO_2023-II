/*
 * Esta es el panel que permite mover la ventana y salir de la aplicación;
 */
package com.grupo8.finalproject.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class StatusBar extends JPanel {

    public JLabel lbStatus;

    public StatusBar() {
        this.setBounds(0, 0, 1160, 40);
        this.setLayout(null);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 15);

        lbStatus = new JLabel(">> Login");
        lbStatus.setForeground(Color.WHITE);
        lbStatus.setBounds(10, 10, 200, 15);
        lbStatus.setFont(custom);
        this.add(lbStatus);
    }
}
