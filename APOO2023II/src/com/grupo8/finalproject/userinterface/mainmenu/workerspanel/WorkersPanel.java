package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import components.JPanelRound;
import java.awt.Color;

public class WorkersPanel extends JPanelRound {

    public WorkersActive wActive;
    public WorkersInactive wInactive;

    public WorkersPanel() {
        this.setBounds(700, 0, 500, 800);
        this.setBackground(new Color(0, 129, 155));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
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
