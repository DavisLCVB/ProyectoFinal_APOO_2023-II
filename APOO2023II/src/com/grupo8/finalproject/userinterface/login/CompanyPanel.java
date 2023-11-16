package com.grupo8.finalproject.userinterface.login;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class CompanyPanel extends JPanelRound {

    private JLabel lbEmpresa;
    public JLabel lbGifEmpresa;

    public CompanyPanel() {
        this.setLayout(null);
        this.setBounds(0, 0, 780, 800);
        this.setRoundTopLeft(50);
        this.setRoundBottomLeft(50);
        this.setBackground(new Color(3, 1, 6));
        initComponents();
    }

    public void initComponents() {
        Font fuenteCustom = new Font("Arial", Font.PLAIN, 100);
        try {
            fuenteCustom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        fuenteCustom = fuenteCustom.deriveFont(Font.PLAIN, 100);

        lbEmpresa = new JLabel("BuildSphere");
        lbEmpresa.setBounds(0, 50, 780, 100);
        lbEmpresa.setHorizontalAlignment(JLabel.CENTER);
        lbEmpresa.setFont(fuenteCustom);
        lbEmpresa.setForeground(Color.WHITE);
        this.add(lbEmpresa);

        lbGifEmpresa = new JLabel();
        lbGifEmpresa.setBounds(0, 200, 780, 500);
        lbGifEmpresa.setIcon(new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\Construccion.gif"));
        lbGifEmpresa.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbGifEmpresa);
    }
}
