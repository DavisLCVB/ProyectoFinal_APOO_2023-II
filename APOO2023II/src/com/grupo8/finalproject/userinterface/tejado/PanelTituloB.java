package com.grupo8.finalproject.userinterface.tejado;

import com.grupo8.finalproject.userinterface.apartamentos.*;
import javax.swing.*;
import java.awt.*;

public class PanelTituloB extends JPanel {

    protected JLabel etiqueta_bienvenida_2;

    public PanelTituloB() {
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD, 80);
        Font mifuenteAesthetic_2 = new Font("Arial Narrow", Font.BOLD, 23);
        etiqueta_bienvenida_2 = new JLabel("D   E     T   E   J   A   D   O");
        etiqueta_bienvenida_2.setBounds(0, 80, 600, 50);
        etiqueta_bienvenida_2.setForeground(Color.WHITE);
        etiqueta_bienvenida_2.setHorizontalAlignment(JLabel.CENTER);
        etiqueta_bienvenida_2.setFont(mifuenteAesthetic_2);
        this.add(etiqueta_bienvenida_2);
        setOpaque(false);
    }

}
