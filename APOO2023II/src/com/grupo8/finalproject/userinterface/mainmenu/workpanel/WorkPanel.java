/*
 * Panel Encargado de obtener la información de la obra
 */
package com.grupo8.finalproject.userinterface.mainmenu.workpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class WorkPanel extends JPanel {

    public WorkInactive noObra;
    public WorkActive yepObra;

    public WorkPanel() {
        this.setBounds(200, 0, 500, 800);
        this.setBackground(new Color(37, 35, 39, 0));
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {
        noObra = new WorkInactive();
        this.add(noObra);

        yepObra = new WorkActive();
        this.add(yepObra);
        yepObra.setVisible(false);
    }

}
