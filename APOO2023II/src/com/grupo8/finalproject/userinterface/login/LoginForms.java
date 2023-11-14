/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.userinterface.login;

import components.JPanelGradient;
import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author leocv
 */
public class LoginForms extends JPanelGradient {
    
    private JLabel lbUsuario;
    private JLabel lbContrasenia;
    public JTextField tfUsuario;
    public JPasswordField pfContrasenia;
    private JSeparator sUsuario;
    private JSeparator sContrasenia;
    private JLabel lbImagenUsuario;
    public JLabel btnLogin;
    public JPanelRound jprLogin;
    public JLabel lbErrorLogin;
    
    public LoginForms() {
        this.setBounds(780, 180, 420, 620);
        this.setGradientStart(new Color(0, 129, 155));
        this.setGradientEnd(new Color(0, 51, 51));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        initComponents();
    }
    
    public void initComponents() {
        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
            custom = custom.deriveFont(Font.PLAIN, 15);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        lbUsuario = new JLabel("Ingrese su nombre de usuario:");
        lbUsuario.setBounds(20, 50, 400, 40);
        lbUsuario.setForeground(Color.white);
        lbUsuario.setFont(custom);
        this.add(lbUsuario);
        
        tfUsuario = new JTextField();
        tfUsuario.setText("Usuario");
        tfUsuario.setForeground(Color.GRAY);
        tfUsuario.setBounds(20, 100, 380, 40);
        tfUsuario.setFont(custom);
        tfUsuario.setBorder(new LineBorder(Color.WHITE, 5, false));
        tfUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                usuarioClickeado();
            }
        });
        this.add(tfUsuario);
        
        sUsuario = new JSeparator();
        sUsuario.setBounds(20, 140, 380, 3);
        sUsuario.setBackground(Color.BLACK);
        sUsuario.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sUsuario);
        
        lbContrasenia = new JLabel("Ingrese su contraseña:");
        lbContrasenia.setBounds(20, 150, 400, 40);
        lbContrasenia.setForeground(Color.WHITE);
        lbContrasenia.setFont(custom);
        this.add(lbContrasenia);
        
        pfContrasenia = new JPasswordField();
        pfContrasenia.setBounds(20, 200, 380, 40);
        pfContrasenia.setForeground(Color.GRAY);
        pfContrasenia.setBorder(new LineBorder(Color.WHITE, 5, false));
        pfContrasenia.setText("********");
        pfContrasenia.setFont(custom);
        pfContrasenia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                passwordClickeado();
            }
        });
        this.add(pfContrasenia);
        
        sContrasenia = new JSeparator();
        sContrasenia.setBounds(20, 240, 380, 3);
        sContrasenia.setBackground(Color.BLACK);
        sContrasenia.setBorder(new LineBorder(Color.BLACK, 5, false));
        this.add(sContrasenia);
        
        ImageIcon imagenUsuario = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\usuario.png");
        Image scaled = imagenUsuario.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imagenUsuario = new ImageIcon(scaled);
        
        lbImagenUsuario = new JLabel();
        lbImagenUsuario.setIcon(imagenUsuario);
        lbImagenUsuario.setBounds(0, 360, 420, 200);
        lbImagenUsuario.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbImagenUsuario);
        
        int round = 25;
        jprLogin = new JPanelRound();
        jprLogin.setBounds(160, 270, 100, 40);
        jprLogin.setRoundBottomLeft(round);
        jprLogin.setRoundBottomRight(round);
        jprLogin.setRoundTopLeft(round);
        jprLogin.setRoundTopRight(round);
        jprLogin.setBackground(new Color(37, 35, 39));
        
        btnLogin = new JLabel("Entrar");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(custom.deriveFont(20.0f));
        jprLogin.add(btnLogin);
        this.add(jprLogin);
        
        lbErrorLogin = new JLabel();
        lbErrorLogin.setBounds(0, 320, 420, 20);
        lbErrorLogin.setForeground(Color.red);
        lbErrorLogin.setFont(custom.deriveFont(Font.PLAIN, 15));
        lbErrorLogin.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbErrorLogin);
    }
    
    public void usuarioClickeado() {
        lbErrorLogin.setText("");
        if (tfUsuario.getText().equals("Usuario")) {
            tfUsuario.setText("");
            tfUsuario.setForeground(Color.BLACK);
        }
        if (String.valueOf(pfContrasenia.getPassword()).isEmpty()) {
            pfContrasenia.setText("********");
            pfContrasenia.setForeground(Color.GRAY);
        }
    }
    
    public void passwordClickeado() {
        lbErrorLogin.setText("");
        if (String.valueOf(pfContrasenia.getPassword()).equals("********")) {
            pfContrasenia.setText("");
            pfContrasenia.setForeground(Color.BLACK);
        }
        if (tfUsuario.getText().isEmpty()) {
            tfUsuario.setText("Usuario");
            tfUsuario.setForeground(Color.GRAY);
        }
    }
}
