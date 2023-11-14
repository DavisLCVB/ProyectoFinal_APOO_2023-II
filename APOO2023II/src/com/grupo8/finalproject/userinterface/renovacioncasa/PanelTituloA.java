package com.grupo8.finalproject.userinterface.renovacioncasa;

import javax.swing.*;
import java.awt.*;

public class PanelTituloA extends JPanel {

    protected JLabel etiqueta_bienvenida;

    public PanelTituloA(){
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD,80);


        etiqueta_bienvenida=new JLabel("RENOVACION ");
        etiqueta_bienvenida.setBounds(8,70,400,70);
        etiqueta_bienvenida.setForeground(Color.WHITE);
        etiqueta_bienvenida.setFont(mifuenteAesthetic);

        setOpaque(false);//panel transparente
        this.add(etiqueta_bienvenida);


    }

}
