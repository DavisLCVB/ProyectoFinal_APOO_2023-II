package com.grupo8.finalproject.userinterface.apartments;

import javax.swing.*;
import java.awt.*;

/*
 * @author Brayan Goicochea
 */

public class PanelTituloB extends JPanel {

    protected JLabel etiqueta_bienvenida_2;

    public PanelTituloB() {
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD, 80);
        Font mifuenteAesthetic_2 = new Font("Arial Narrow", Font.BOLD, 23);
        etiqueta_bienvenida_2 = new JLabel("D   E     E   D   I   F   I   C   I   O   S ");
        etiqueta_bienvenida_2.setBounds(50, 80, 300, 50);
        etiqueta_bienvenida_2.setForeground(Color.WHITE);
        etiqueta_bienvenida_2.setFont(mifuenteAesthetic_2);
        this.add(etiqueta_bienvenida_2);
        setOpaque(false);//panel transparente
    }

}
