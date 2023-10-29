/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.userinterface;

import com.grupo8.finalproject.userinterface.login.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author leocv
 */
public class MainWindow extends JFrame {

    public LoginPanel loginPanel;
    public JPanel panel;

    public MainWindow() {
        this.setSize(1200, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
    }

    public void initComponents() {
        loginPanel = new LoginPanel();
        this.add(loginPanel);
        
        panel = new JPanel();
        panel.setBounds(0,0,1200,800);
        panel.setBackground(Color.BLUE);
    }
}
