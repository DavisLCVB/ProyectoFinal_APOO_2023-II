/**
 * Panel encargado de contener el titulo del login del panel login
 */
package com.grupo8.finalproject.userinterface.login;

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
public class LoginTitle extends JPanelRound {

    private JLabel lbLogin;

    public LoginTitle() {
        this.setLayout(null);
        this.setBounds(780, 0, 420, 180);
        this.setRoundTopRight(50);
        this.setBackground(new Color(0, 129, 155));
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 10);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 30);

        lbLogin = new JLabel("LOGIN");
        lbLogin.setBounds(0, 145, 420, 40);
        lbLogin.setFont(custom);
        lbLogin.setForeground(Color.WHITE);
        lbLogin.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbLogin);
    }
}
