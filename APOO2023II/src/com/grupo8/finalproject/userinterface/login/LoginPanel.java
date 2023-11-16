package com.grupo8.finalproject.userinterface.login;

import java.awt.Color;
import javax.swing.*;

public class LoginPanel extends JPanel {

    public CompanyPanel companyPanel;
    private LoginTitle loginTitle;
    public LoginForms loginForms;

    public LoginPanel() {
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        initComponents();
    }

    public void initComponents() {
        companyPanel = new CompanyPanel();
        this.add(companyPanel);

        loginTitle = new LoginTitle();
        this.add(loginTitle);

        loginForms = new LoginForms();
        this.add(loginForms);
    }
}
