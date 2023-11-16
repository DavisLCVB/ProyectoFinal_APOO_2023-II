/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo8.finalproject.userinterface;

import com.grupo8.finalproject.userinterface.login.*;
import com.grupo8.finalproject.userinterface.mainmenu.MainMenuPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class MainWindow extends JFrame {

    public LoginPanel loginPanel;
    public MainMenuPanel mainMenuPanel;
    public StatusBar statusBar;
    public ExitButtonPanel exitButtonPanel;
    public int coordX;
    public int coordY;

    public MainWindow() {
        this.setTitle("BuildSphere App");
        this.setSize(1200, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setIconImage((new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\mainIcon\\mainIcon.png")).getImage());
        initComponents();

        Font customFnt = new Font("Arial Narrow", Font.PLAIN, 15);
        try {
            customFnt = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        customFnt = customFnt.deriveFont(Font.PLAIN, 15);

        UIManager.put("OptionPane.background", new Color(37, 35, 39));
        UIManager.put("OptionPane.messageFont", customFnt);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", new Color(37, 35, 39));
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
