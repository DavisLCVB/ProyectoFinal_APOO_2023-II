/*
 * Clase encargada de almacenar y mostrar la información de los trabajadores
 */
package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import components.JPanelRound;
import java.awt.Color;

/**
 * @author Davis Cartagena
 */
public class WorkersPanel extends JPanelRound {

    public WorkersActive wActive;
    public WorkersInactive wInactive;

    public WorkersPanel() {
        this.setBounds(700, 0, 500, 800);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {
        wActive = new WorkersActive();
        this.add(wActive);
        wInactive = new WorkersInactive();
        this.add(wInactive);
        this.wActive.setVisible(false);
    }
}