/*
 * Panel contenedor del boton de salida
 */
package com.grupo8.finalproject.userinterface;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Davis Cartagena
 */
public class ExitButtonPanel extends JPanel {

    public JLabel lbExitButton;
    public ImageIcon exitOFF;
    public ImageIcon exitON;

    public ExitButtonPanel() {
        this.setBounds(1160, 0, 40, 40);
        this.setLayout(null);
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    public void initComponents() {

        exitOFF = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\salirNormal.png");
        Image scaled1 = exitOFF.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        exitOFF = new ImageIcon(scaled1);

        exitON = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\salirAlternativo.png");
        Image scaled2 = exitON.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        exitON = new ImageIcon(scaled2);

        lbExitButton = new JLabel();
        lbExitButton.setBounds(0, 0, 40, 40);
        lbExitButton.setIcon(exitOFF);
        this.add(lbExitButton);
    }
}
