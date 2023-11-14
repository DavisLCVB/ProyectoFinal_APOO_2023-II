package com.grupo8.finalproject.userinterface.tejado;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTituloA extends JPanel {

    protected JLabel etiqueta_bienvenida;

    public PanelTituloA() {
        Font mifuenteAesthetic = new Font("Sarala", Font.BOLD, 80);

        etiqueta_bienvenida = new JLabel("REPARACIÓN");
        etiqueta_bienvenida.setBounds(8, 70, 400, 70);
        etiqueta_bienvenida.setForeground(Color.WHITE);
        etiqueta_bienvenida.setFont(mifuenteAesthetic);

        setOpaque(false);//panel transparente
        this.add(etiqueta_bienvenida);

    }

}
