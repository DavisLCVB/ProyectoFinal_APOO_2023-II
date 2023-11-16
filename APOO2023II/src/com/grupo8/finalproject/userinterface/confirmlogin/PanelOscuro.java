package com.grupo8.finalproject.userinterface.confirmlogin;

import components.JPanelRound;
import java.awt.Color;

public class PanelOscuro extends JPanelRound {

    public PanelOscuro() {
        this.setBounds(0, 0, 1200, 800);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
    }
}
