package com.grupo8.finalproject.userinterface.mainmenu.workerspanel;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 * @author Davis Cartagena
 */
public class WorkersActive extends JPanelRound {

    private JLabel lbElectricista;
    private JLabel lbObrero;
    private JLabel lbCarpintero;
    public JScrollPane spElectricista;
    public JScrollPane spObrero;
    public JScrollPane spCarpintero;
    public static JTextArea areaElectricista = new JTextArea();
    public static JTextArea areaObrero = new JTextArea();
    public static JTextArea areaCarpintero = new JTextArea();

    public WorkersActive() {
        this.setBounds(0, 0, 500, 800);
        this.setBackground(new Color(0, 129, 155, 0));
        this.setLayout(null);
        this.setRoundBottomRight(50);
        this.setRoundTopRight(50);
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 15);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
            custom = custom.deriveFont(Font.PLAIN, 15);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        lbElectricista = new JLabel("Electricista");
        lbElectricista.setFont(custom);
        lbElectricista.setBounds(20, 100, 480, 15);
        lbElectricista.setVerticalAlignment(JLabel.CENTER);
        lbElectricista.setForeground(Color.WHITE);
        this.add(lbElectricista);

        lbObrero = new JLabel("Obrero");
        lbObrero.setFont(custom);
        lbObrero.setBounds(20, 300, 480, 15);
        lbObrero.setVerticalAlignment(JLabel.CENTER);
        lbObrero.setForeground(Color.WHITE);
        this.add(lbObrero);

        lbCarpintero = new JLabel("Carpintero");
        lbCarpintero.setFont(custom);
        lbCarpintero.setBounds(20, 500, 480, 15);
        lbCarpintero.setVerticalAlignment(JLabel.CENTER);
        lbCarpintero.setForeground(Color.WHITE);
        this.add(lbCarpintero);
        
        areaElectricista = new JTextArea();
        areaElectricista.setEditable(false);
        areaElectricista.setRows(8);
        areaElectricista.setBounds(0, 0, 250, 175);
        areaElectricista.setFont(custom.deriveFont(Font.PLAIN, 13));
        areaElectricista.setForeground(Color.WHITE);
        areaElectricista.setBackground(new Color(2, 64, 77));
        this.add(areaElectricista);

        areaObrero = new JTextArea();
        areaObrero.setEditable(false);
        areaObrero.setRows(8);
        areaObrero.setBounds(0, 0, 300, 185);
        areaObrero.setFont(custom.deriveFont(Font.PLAIN, 13));
        areaObrero.setForeground(Color.WHITE);
        areaObrero.setBackground(new Color(2, 64, 77));
        this.add(areaObrero);

        areaCarpintero = new JTextArea();
        areaCarpintero.setEditable(false);
        areaCarpintero.setRows(8);
        areaCarpintero.setBounds(0, 0, 300, 185);
        areaCarpintero.setFont(custom.deriveFont(Font.PLAIN, 13));
        areaCarpintero.setForeground(Color.WHITE);
        areaCarpintero.setBackground(new Color(2, 64, 77));
        this.add(areaCarpintero);

        ScrollBarCustom elecScrollH = new ScrollBarCustom();
        ScrollBarCustom elecScrollV = new ScrollBarCustom();
        
        ScrollBarCustom obreScrollH = new ScrollBarCustom();
        ScrollBarCustom obreScrollV = new ScrollBarCustom();
        
        ScrollBarCustom carpScrollH = new ScrollBarCustom();
        ScrollBarCustom carpScrollV = new ScrollBarCustom();
        
        JScrollPane scroll = new JScrollPane(areaElectricista);
        scroll.setBounds(20, 115, 460, 180);
        scroll.setBorder(new LineBorder(new Color(2, 64, 77), 5, true));
        scroll.setBackground(new Color(0, 0, 0, 0));
        scroll.getVerticalScrollBar().setUI(elecScrollV);
        scroll.getHorizontalScrollBar().setUI(elecScrollH);

        JScrollPane scroll2 = new JScrollPane(areaObrero);
        scroll2.setBounds(20, 315, 460, 180);
        scroll2.setBorder(new LineBorder(new Color(2, 64, 77), 5, true));
        scroll2.setBackground(new Color(0, 0, 0, 0));
        scroll2.getVerticalScrollBar().setUI(obreScrollV);
        scroll2.getHorizontalScrollBar().setUI(obreScrollH);

        JScrollPane scroll3 = new JScrollPane(areaCarpintero);
        scroll3.setBounds(20, 515, 460, 180);
        scroll3.setBorder(new LineBorder(new Color(2, 64, 77), 5, true));
        scroll3.setBackground(new Color(0, 0, 0, 0));
        scroll3.getVerticalScrollBar().setUI(carpScrollV);
        scroll3.getHorizontalScrollBar().setUI(carpScrollH);
        this.add(scroll);
        this.add(scroll2);
        this.add(scroll3);
    }
}
