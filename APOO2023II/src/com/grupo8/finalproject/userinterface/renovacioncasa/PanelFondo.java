package com.grupo8.finalproject.userinterface.renovacioncasa;

import components.JPanelRound;
import javax.swing.JPanel;//Librería para PANEL
import java.awt.Color;//Librería para COLORES

public class PanelFondo extends JPanelRound {

    protected Color micolorAesthetic;

    public PanelFondo(){
        this.setLayout(null);//Para colocar los componentes manualmente
        micolorAesthetic=new Color(0,0,0);
        this.setBackground(micolorAesthetic);
        this.setRoundBottomLeft(50);
        this.setRoundBottomRight(50);
        this.setRoundTopLeft(50);
        this.setRoundTopRight(50);
    }
}
