package com.grupo8.finalproject.userinterface.apartamentos;

import com.grupo8.finalproject.domain.obras.ConstruccionEdificioApartamentos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDate;
import javax.swing.border.LineBorder;

public class PanelIngresoDatos extends JPanel {

    protected JLabel etiqueta_Numpisos;
    protected JLabel etiqueta_Numhabitaciones;
    protected JLabel etiqueta_areaTerreno;
    protected JLabel etiqueta_direccionObra;
    protected JLabel etiqueta_distritos;

    protected JComboBox available_Distritos;

    protected JTextField campo_Numpisos;
    protected JTextField campo_Numhabitaciones;
    protected JTextField campo_areaTerreno;
    protected JTextField campo_direccionObra;

    public JButton Aceptar;
    public JButton Cancelar;

    public PanelIngresoDatos() {
        IniciarComponent();
    }

    public void IniciarComponent() {

        Font mifuentepanel = new Font("Arial Narrow", Font.PLAIN, 16);
        try {
            mifuentepanel = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        this.setLayout(null);
        Color Micolorpanel = new Color(25, 23, 27);
        this.setBackground(Micolorpanel);
        mifuentepanel = mifuentepanel.deriveFont(Font.PLAIN, 16);

        etiqueta_Numpisos = new JLabel("Numero de Pisos:                         pisos");
        etiqueta_Numpisos.setBounds(25, 20, 300, 20);
        etiqueta_Numpisos.setForeground(Color.WHITE);
        etiqueta_Numpisos.setFont(mifuentepanel);
        campo_Numpisos = new JTextField();
        campo_Numpisos.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_Numpisos.setBounds(170, 20, 65, 20);
        campo_Numpisos.setBorder(new LineBorder(Color.WHITE, 5, false));

        etiqueta_Numhabitaciones = new JLabel("Nro Habitaciones:                      habitaciones por piso ");
        etiqueta_Numhabitaciones.setBounds(25, 50, 500, 20);
        etiqueta_Numhabitaciones.setForeground(Color.WHITE);
        etiqueta_Numhabitaciones.setFont(mifuentepanel);
        campo_Numhabitaciones = new JTextField();
        campo_Numhabitaciones.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_Numhabitaciones.setBounds(160, 50, 65, 20);
        campo_Numhabitaciones.setBorder(new LineBorder(Color.WHITE, 5, false));

        etiqueta_areaTerreno = new JLabel("Área del terreno:                              m²");
        etiqueta_areaTerreno.setBounds(25, 80, 500, 20);
        etiqueta_areaTerreno.setForeground(Color.WHITE);
        etiqueta_areaTerreno.setFont(mifuentepanel);
        campo_areaTerreno = new JTextField();
        campo_areaTerreno.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_areaTerreno.setBounds(150, 80, 100, 20);
        campo_areaTerreno.setBorder(new LineBorder(Color.WHITE, 5, false));

        etiqueta_direccionObra = new JLabel("Direccion de Edificio: ");
        etiqueta_direccionObra.setBounds(25, 110, 250, 20);
        etiqueta_direccionObra.setForeground(Color.WHITE);
        etiqueta_direccionObra.setFont(mifuentepanel);
        campo_direccionObra = new JTextField();
        campo_direccionObra.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_direccionObra.setBounds(185, 110, 255, 20);
        campo_direccionObra.setBorder(new LineBorder(Color.WHITE, 5, false));

        etiqueta_distritos = new JLabel("Distrito: ");
        etiqueta_distritos.setBounds(25, 140, 250, 20);
        etiqueta_distritos.setForeground(Color.WHITE);
        etiqueta_distritos.setFont(mifuentepanel);
        String[] distritos_disponibles = {"La Molina", "San Miguel", "San Borga", "Pueblo Libre", "SJL"};
        available_Distritos = new JComboBox(distritos_disponibles);
        available_Distritos.setBounds(100, 140, 250, 30);
        available_Distritos.setBackground(Color.WHITE);
        available_Distritos.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        Color micolorBoton = new Color(110, 190, 170);
        Aceptar = new JButton("Aceptar");
        Aceptar.setBounds(45, 200, 150, 45);
        Aceptar.setBackground(micolorBoton);
        Aceptar.setForeground(Color.WHITE);
        Aceptar.setBorder(new LineBorder(micolorBoton, 3, true));
        Aceptar.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        ImageIcon aceptar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\aceptar.png");
        Aceptar.setIcon(aceptar);

        Color micolorBoton_2 = new Color(240, 30, 80);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(205, 200, 150, 45);
        Cancelar.setBackground(micolorBoton_2);
        Cancelar.setForeground(Color.WHITE);
        Cancelar.setBorder(new LineBorder(micolorBoton_2, 5, true));
        Cancelar.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        ImageIcon mostrar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\MostrarDetalles.png");
        Cancelar.setIcon(mostrar);

        this.add(etiqueta_Numpisos);
        this.add(campo_Numpisos);
        this.add(etiqueta_Numhabitaciones);
        this.add(campo_Numhabitaciones);
        this.add(etiqueta_areaTerreno);
        this.add(campo_areaTerreno);
        this.add(etiqueta_direccionObra);
        this.add(campo_direccionObra);
        this.add(etiqueta_distritos);
        this.add(available_Distritos);
        this.add(Aceptar);
        this.add(Cancelar);

    }

    public ConstruccionEdificioApartamentos LlenarDatosObra() {
        ConstruccionEdificioApartamentos a = new ConstruccionEdificioApartamentos();
        a.SetNro_pisos(Integer.parseInt(campo_Numpisos.getText()));
        a.SetNro_habitaciones(Integer.parseInt(campo_Numhabitaciones.getText()));
        a.SetArea_terreno(Double.parseDouble(campo_areaTerreno.getText()));
        a.setUbicacionObra(campo_direccionObra.getText());
        a.SetDistrito(available_Distritos.getSelectedItem().toString());

        a.setNombreObra("Construcción de Edificios de Departamento");
        int m = a.CalcularComplejidad(Integer.parseInt(campo_Numpisos.getText()), Integer.parseInt(campo_Numhabitaciones.getText()));
        a.setComplejidad(m);

        LocalDate fecha_inicio = LocalDate.now();
        a.setFechaInicio(fecha_inicio);

        LocalDate fecha_fin = a.CalcularFecha_Culminacion_Obra();
        a.setFechaFin(fecha_fin);

        a.setVelocidadObra(5); //TEJADO:2 RENOVACION:3 CONSTRUCCIONAPARTAMENTOS=5 (por defecto)
        int q = a.DefinirIDObra();
        a.setiDObra(q);
        return a;
    }

    public void LimpiarDatos() {
        campo_Numpisos.setText("");
        campo_Numhabitaciones.setText("");
        campo_areaTerreno.setText("");
        campo_direccionObra.setText("");
    }

    public boolean validarDatos() {
        boolean datosValidos = true;

        String numPisos = campo_Numpisos.getText();
        String numHabitaciones = campo_Numhabitaciones.getText();
        String areaTerreno = campo_areaTerreno.getText();
        String direccion = campo_direccionObra.getText();

        if (numPisos.isEmpty() || numHabitaciones.isEmpty() || areaTerreno.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int nroPisos = Integer.parseInt(numPisos);
            if (nroPisos <= 0) {
                JOptionPane.showMessageDialog(null, "El número de pisos debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de pisos debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        try {
            int nroHabitaciones = Integer.parseInt(numHabitaciones);
            if (nroHabitaciones <= 0) {
                JOptionPane.showMessageDialog(null, "El número de habitaciones por piso debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de habitaciones por piso debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        try {
            double area = Double.parseDouble(areaTerreno);
            if (area <= 0) {
                JOptionPane.showMessageDialog(null, "El área del terreno debe ser un número válido mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El área del terreno debe ser un número válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        return datosValidos;
    }
}
