package com.grupo8.finalproject.userinterface.confirmlogin;

import java.awt.Color;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class FrameOscuro extends JFrame{
    private PanelOscuro panelOscuro;

    public FrameOscuro(){
        this.setSize(1200,800);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
    }
    public void initComponents(){
        panelOscuro = new PanelOscuro();
        this.add(panelOscuro);
    }
}
