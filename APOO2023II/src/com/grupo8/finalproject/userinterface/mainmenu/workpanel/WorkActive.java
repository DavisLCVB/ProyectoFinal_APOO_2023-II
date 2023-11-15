package com.grupo8.finalproject.userinterface.mainmenu.workpanel;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class WorkActive extends JPanel {

    public JLabel lbTituloObra;
    public JTextArea taInformacionObra;
    public JPanelRound prResetObra;
    public JLabel lbResetObra;

    public WorkActive() {
        this.setBounds(0, 0, 500, 799);
        this.setBackground(new Color(37, 35, 39));
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 18);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 18);

        lbTituloObra = new JLabel("Titulo Obra");
        lbTituloObra.setBounds(0, 100, 500, 20);
        lbTituloObra.setFont(custom);
        lbTituloObra.setHorizontalAlignment(JLabel.CENTER);
        lbTituloObra.setForeground(Color.WHITE);
        this.add(lbTituloObra);

        Font custom2 = new Font("Arial", Font.PLAIN, 15);
        try {
            custom2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom2 = custom2.deriveFont(Font.PLAIN, 15);
        
        JPanelRound jprInformacionObra = new JPanelRound();
        jprInformacionObra.setBounds(50, 200, 400, 400);
        jprInformacionObra.setBackground(Color.BLACK);
        jprInformacionObra.setRoundBottomLeft(25);
        jprInformacionObra.setRoundBottomRight(25);
        jprInformacionObra.setRoundTopLeft(25);
        jprInformacionObra.setRoundTopRight(25);
        
        taInformacionObra = new JTextArea();
        taInformacionObra.setBounds(0, 0, 400, 400);
        taInformacionObra.setFont(custom2);
        taInformacionObra.setBackground(Color.BLACK);
        taInformacionObra.setForeground(Color.WHITE);
        taInformacionObra.setEditable(false);
        taInformacionObra.setBorder(new LineBorder(Color.BLACK, 10, true));
        jprInformacionObra.add(taInformacionObra);
        this.add(jprInformacionObra);  

        int round = 25;
        prResetObra = new JPanelRound();
        prResetObra.setLayout(null);
        prResetObra.setBounds(150, 680, 200, 30);
        prResetObra.setRoundBottomLeft(round);
        prResetObra.setRoundBottomRight(round);
        prResetObra.setRoundTopLeft(round);
        prResetObra.setRoundTopRight(round);
        prResetObra.setBackground(Color.BLACK);

        lbResetObra = new JLabel("Reset");
        lbResetObra.setBounds(0, 0, 200, 30);
        lbResetObra.setFont(custom2.deriveFont(Font.PLAIN, 15));
        lbResetObra.setForeground(Color.WHITE);
        lbResetObra.setHorizontalAlignment(JLabel.CENTER);
        lbResetObra.setVerticalAlignment(JLabel.CENTER);
        prResetObra.add(lbResetObra);
        this.add(prResetObra);
    }
}
