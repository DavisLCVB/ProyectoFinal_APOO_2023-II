package com.grupo8.finalproject.userinterface.mainmenu.workpanel;

import components.JPanelRound;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * @author Davis Cartagena
 */
public class WorkInactive extends JPanel {

    private JLabel lbNoObra;
    private JLabel lbImagenNoObra;
    public JPanelRound prSeleccionarObra;
    public JLabel lbSeleccionar;
    public JComboBox<String> cbMenuObras;
    public JPanelRound prIniciarObra;
    public JLabel lbIniciarObra;

    public WorkInactive() {
        this.setBounds(0, 0, 500, 799);
        this.setBackground(new Color(37, 35, 39));
        this.setLayout(null);
        initComponents();
    }

    public void initComponents() {

        Font custom = new Font("Arial", Font.PLAIN, 20);
        try {
            custom = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\JosefinSans\\JosefinSans-Bold.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom = custom.deriveFont(Font.PLAIN, 20);

        Font custom2 = new Font("Arial", Font.PLAIN, 20);
        try {
            custom2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        custom2 = custom2.deriveFont(Font.PLAIN, 20);

        ImageIcon iconNoObra = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\images\\noObra.png");
        Image scaled = iconNoObra.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        iconNoObra = new ImageIcon(scaled);

        int inicio = 250;

        lbImagenNoObra = new JLabel();
        lbImagenNoObra.setBounds(0, inicio, 500, 100);
        lbImagenNoObra.setIcon(iconNoObra);
        lbImagenNoObra.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbImagenNoObra);

        lbNoObra = new JLabel("¡No hay obras en curso!");
        lbNoObra.setBounds(0, inicio + 100, 500, 30);
        lbNoObra.setFont(custom);
        lbNoObra.setForeground(Color.WHITE);
        lbNoObra.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbNoObra);

        String[] opciones = {"Construcción de Apartamentos", "Reparación de Tejados", "Renovación de Casa"};

        UIManager.put("ComboBox.selectionBackground", new Color(0, 129, 155));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);

        cbMenuObras = new JComboBox<>(opciones);
        cbMenuObras.setBounds(50, inicio + 150, 400, 30);
        cbMenuObras.setFont(custom2.deriveFont(Font.PLAIN, 15));
        cbMenuObras.setBackground(new Color(21, 20, 23));
        cbMenuObras.setBorder(new LineBorder(Color.BLACK, 1, false));
        cbMenuObras.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    renderer.setBackground(new Color(0, 129, 155));
                    renderer.setForeground(Color.WHITE);
                } else {
                    renderer.setBackground(Color.BLACK);
                    renderer.setForeground(Color.WHITE);
                }
                return renderer;
            }
        });
        cbMenuObras.setForeground(Color.WHITE);
        this.add(cbMenuObras);

        int round = 25;
        prSeleccionarObra = new JPanelRound();
        prSeleccionarObra.setLayout(null);
        prSeleccionarObra.setBounds(150, inicio + 200, 200, 30);
        prSeleccionarObra.setRoundBottomLeft(round);
        prSeleccionarObra.setRoundBottomRight(round);
        prSeleccionarObra.setRoundTopLeft(round);
        prSeleccionarObra.setRoundTopRight(round);
        prSeleccionarObra.setBackground(new Color(3, 1, 6));

        lbSeleccionar = new JLabel("Seleccionar");
        lbSeleccionar.setBounds(0, 0, 200, 30);
        lbSeleccionar.setFont(custom2.deriveFont(Font.PLAIN, 15));
        lbSeleccionar.setForeground(Color.WHITE);
        lbSeleccionar.setHorizontalAlignment(JLabel.CENTER);
        lbSeleccionar.setVerticalAlignment(JLabel.CENTER);
        prSeleccionarObra.add(lbSeleccionar);
        this.add(prSeleccionarObra);

        prIniciarObra = new JPanelRound();
        prIniciarObra.setLayout(null);
        prIniciarObra.setBounds(150, inicio + 300, 200, 30);
        prIniciarObra.setRoundBottomLeft(round);
        prIniciarObra.setRoundBottomRight(round);
        prIniciarObra.setRoundTopLeft(round);
        prIniciarObra.setRoundTopRight(round);
        prIniciarObra.setBackground(new Color(3, 1, 6));

        lbIniciarObra = new JLabel("Iniciar");
        lbIniciarObra.setBounds(0, 0, 200, 30);
        lbIniciarObra.setFont(custom2.deriveFont(Font.PLAIN, 15));
        lbIniciarObra.setForeground(Color.WHITE);
        lbIniciarObra.setHorizontalAlignment(JLabel.CENTER);
        lbIniciarObra.setVerticalAlignment(JLabel.CENTER);
        prIniciarObra.add(lbIniciarObra);
        this.add(prIniciarObra);
        this.prIniciarObra.setVisible(false);
    }
}
