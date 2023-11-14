package com.grupo8.finalproject.userinterface.renovacioncasa;

import javax.swing.JPanel;//Librería para PANEL
import java.awt.Color;//Librería para COLORES

public class PanelFondo extends JPanel {

    protected Color micolorAesthetic;

    public PanelFondo(){
        this.setLayout(null);//Para colocar los componentes manualmente
        micolorAesthetic=new Color(0,0,0);
        this.setBackground(micolorAesthetic);
    }
}
