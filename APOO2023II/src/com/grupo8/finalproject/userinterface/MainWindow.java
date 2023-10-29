/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.userinterface;

import com.grupo8.finalproject.userinterface.login.*;
import com.grupo8.finalproject.userinterface.mainmenu.MainMenuPanel;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author leocv
 */
public class MainWindow extends JFrame {

    public LoginPanel loginPanel;
    public MainMenuPanel mainMenuPanel;
    public StatusBar statusBar;
    public ExitButtonPanel exitButtonPanel;
    public int coordX;
    public int coordY;

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
        statusBar = new StatusBar();
        this.add(statusBar);
        
        exitButtonPanel = new ExitButtonPanel();
        this.add(exitButtonPanel);
        
        loginPanel = new LoginPanel();
        this.add(loginPanel);

        mainMenuPanel = new MainMenuPanel();
    }
}
