package com.grupo8.finalproject.userinterface.tejado;

import com.grupo8.finalproject.domain.obras.ReparacionDeTejado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/*
 * @author Brayan Goicochea
 */
public class PanelIngresoDatos extends JPanel {

    protected JLabel etiqueta_Numpisos;
    protected JLabel etiqueta_Numhabitaciones;
    protected JLabel etiqueta_areaTerreno;
    protected JLabel etiqueta_sectorObra;
    protected JLabel etiqueta_distritos;
    protected JLabel etiqueta_AreaTejado;
    protected JLabel etiqueta_AreaCubierta;

    protected JLabel etiqueta_tipo_construccion;
    protected JLabel etiqueta_NumeroCasas;
    protected JLabel etiqueta_NumeroEdificios;

    protected JComboBox available_Distritos;
    public JComboBox available_Construccion;
    protected JComboBox available_SectorObra;

    protected JTextField campo_Numpisos;
    protected JTextField campo_Numhabitaciones;
    protected JTextField campo_NumeroCasas;
    protected JTextField campo_NumeroEdificios;

    protected JTextField campo_AreaTejado;
    protected JTextField campo_AreaCubierta;

    protected JTextField campo_areaTerreno;
    protected JTextField campo_sectorObra;

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

        etiqueta_tipo_construccion = new JLabel("Construccion: ");
        etiqueta_tipo_construccion.setBounds(25, 20, 300, 20);
        etiqueta_tipo_construccion.setForeground(Color.WHITE);
        etiqueta_tipo_construccion.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        String[] tipoDeConstruccion_disponibles = {"Casa", "Edificio"};
        available_Construccion = new JComboBox(tipoDeConstruccion_disponibles);
        available_Construccion.setBounds(205, 20, 80, 20);
        available_Construccion.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        etiqueta_NumeroCasas = new JLabel("Número de Casas: ");
        etiqueta_NumeroCasas.setBounds(25, 50, 500, 20);
        etiqueta_NumeroCasas.setForeground(Color.WHITE);
        etiqueta_NumeroCasas.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        etiqueta_NumeroCasas.setVisible(true);
        campo_NumeroCasas = new JTextField();
        campo_NumeroCasas.setBounds(220, 50, 65, 20);
        campo_NumeroCasas.setVisible(true);
        campo_NumeroCasas.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        etiqueta_NumeroEdificios = new JLabel("Número de Edificios: ");
        etiqueta_NumeroEdificios.setBounds(25, 50, 500, 20);
        etiqueta_NumeroEdificios.setForeground(Color.WHITE);
        etiqueta_NumeroEdificios.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        etiqueta_NumeroEdificios.setVisible(false);  // Inicia invisible
        campo_NumeroEdificios = new JTextField();
        campo_NumeroEdificios.setBounds(220, 50, 65, 20);
        campo_NumeroEdificios.setVisible(false);  // Inicia invisible
        campo_NumeroEdificios.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        etiqueta_AreaTejado = new JLabel("Área del tejado:                                          m²");
        etiqueta_AreaTejado.setBounds(25, 80, 500, 20);
        etiqueta_AreaTejado.setForeground(Color.WHITE);
        etiqueta_AreaTejado.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        etiqueta_AreaTejado.setVisible(true);
        campo_AreaTejado = new JTextField();
        campo_AreaTejado.setBounds(220, 80, 65, 20);
        campo_AreaTejado.setVisible(true);
        campo_AreaTejado.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        etiqueta_AreaCubierta = new JLabel("Área de la cubierta:                                    m²");
        etiqueta_AreaCubierta.setBounds(25, 80, 500, 20);
        etiqueta_AreaCubierta.setForeground(Color.WHITE);
        etiqueta_AreaCubierta.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        campo_AreaCubierta = new JTextField();
        etiqueta_AreaCubierta.setVisible(false);
        campo_AreaCubierta.setBounds(220, 80, 65, 20);
        campo_AreaCubierta.setVisible(false);
        campo_AreaCubierta.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        available_Construccion.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = e.getItem().toString();
                    if (selectedItem.equals("Casa")) {
                        etiqueta_NumeroCasas.setVisible(true);
                        campo_NumeroCasas.setVisible(true);
                        etiqueta_AreaTejado.setVisible(true);
                        campo_AreaTejado.setVisible(true);

                        etiqueta_NumeroEdificios.setVisible(false);
                        campo_NumeroEdificios.setVisible(false);
                        etiqueta_AreaCubierta.setVisible(false);
                        campo_AreaCubierta.setVisible(false);

                    } else if (selectedItem.equals("Edificio")) {
                        etiqueta_NumeroEdificios.setVisible(true);
                        campo_NumeroEdificios.setVisible(true);
                        etiqueta_AreaCubierta.setVisible(true);
                        campo_AreaCubierta.setVisible(true);
                        etiqueta_NumeroCasas.setVisible(false);
                        campo_NumeroCasas.setVisible(false);
                        etiqueta_AreaTejado.setVisible(false);
                        campo_AreaTejado.setVisible(false);
                    }
                    revalidate();
                    repaint();
                }
            }
        });

        etiqueta_sectorObra = new JLabel("Sector del distrito: ");
        etiqueta_sectorObra.setBounds(25, 110, 250, 20);
        etiqueta_sectorObra.setForeground(Color.WHITE);
        etiqueta_sectorObra.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        String[] sectores_disponibles = {"A", "B", "C", "D", "E"};
        available_SectorObra = new JComboBox(sectores_disponibles);
        available_SectorObra.setBounds(220, 110, 65, 20);
        available_SectorObra.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        etiqueta_distritos = new JLabel("Distrito: ");
        etiqueta_distritos.setBounds(25, 140, 250, 20);
        etiqueta_distritos.setForeground(Color.WHITE);
        etiqueta_distritos.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));
        String[] distritos_disponibles = {"La Molina", "San Miguel", "San Borga", "Pueblo Libre", "SJL"};
        available_Distritos = new JComboBox(distritos_disponibles);
        available_Distritos.setBounds(90, 140, 250, 30);
        available_Distritos.setFont(mifuentepanel.deriveFont(Font.PLAIN, 12));

        Color micolorBoton = new Color(110, 190, 170);
        Aceptar = new JButton("ACEPTAR");
        Aceptar.setBounds(45, 200, 150, 45);
        Aceptar.setBackground(micolorBoton);
        Aceptar.setForeground(Color.WHITE);
        ImageIcon aceptar = new ImageIcon("C:/Users/Usuario/Documents/TAREAS/POO/Proyecto_POO/out/production/Proyecto_POO/BrayanPart/aceptar.png");
        Aceptar.setIcon(aceptar);

        Color micolorBoton_2 = new Color(240, 30, 80);
        Cancelar = new JButton("xxxx");
        Cancelar.setBounds(205, 200, 200, 45);
        Cancelar.setBackground(micolorBoton_2);
        Cancelar.setForeground(Color.WHITE);
        ImageIcon mostrar = new ImageIcon("C:/Users/Usuario/Documents/TAREAS/POO/Proyecto_POO/out/production/Proyecto_POO/BrayanPart/MostrarDetalles.png");
        Cancelar.setIcon(mostrar);

        this.add(etiqueta_sectorObra);
        this.add(etiqueta_distritos);
        this.add(available_Distritos);
        this.add(Aceptar);
        this.add(Cancelar);

        this.add(etiqueta_tipo_construccion);
        this.add(available_Construccion);
        this.add(etiqueta_NumeroEdificios);
        this.add(etiqueta_NumeroCasas);
        this.add(campo_NumeroEdificios);
        this.add(campo_NumeroCasas);
        this.add(etiqueta_AreaTejado);
        this.add(etiqueta_AreaCubierta);
        this.add(campo_AreaTejado);
        this.add(campo_AreaCubierta);
        this.add(available_SectorObra);

    }

    public ReparacionDeTejado LlenarDatosObraCasa() {

        ReparacionDeTejado a = new ReparacionDeTejado();

        a.setNro_construcciones(Integer.parseInt(campo_NumeroCasas.getText()));
        a.setArea_Terreno(Double.parseDouble(campo_AreaTejado.getText()));
        a.setUbicacionObra(available_SectorObra.getSelectedItem().toString());
        a.SetDistrito(available_Distritos.getSelectedItem().toString());
        a.setNombreObra("Reparacion De Tejado");

        int m = a.CalcularComplejidad(Integer.parseInt(campo_NumeroCasas.getText()), 5);
        a.setComplejidad(m);

        LocalDate fecha_inicio = LocalDate.now();
        a.setFechaInicio(fecha_inicio);

        LocalDate fecha_fin = a.CalcularFecha_Culminacion_Obra();
        a.setFechaFin(fecha_fin);

        a.setVelocidadObra(2); //TEJADO:2 RENOVACION:3 CONSTRUCCIONAPARTAMENTOS=5 (por defecto)
        int q = a.DefinirIDObra();
        a.setiDObra(q);

        return a;
    }

    public ReparacionDeTejado LlenarDatosObraEdificio() {

        ReparacionDeTejado a = new ReparacionDeTejado();

        a.setNro_construcciones(Integer.parseInt(campo_NumeroEdificios.getText()));
        a.setArea_Terreno(Double.parseDouble(campo_AreaCubierta.getText()));
        a.setUbicacionObra(available_SectorObra.getSelectedItem().toString());
        a.SetDistrito(available_Distritos.getSelectedItem().toString());
        a.setNombreObra("Reparacion De Tejado");

        int m = a.CalcularComplejidad(Integer.parseInt(campo_NumeroEdificios.getText()), 2);
        a.setComplejidad(m);

        LocalDate fecha_inicio = LocalDate.now();
        a.setFechaInicio(fecha_inicio);

        LocalDate fecha_fin = a.CalcularFecha_Culminacion_Obra();
        a.setFechaFin(fecha_fin);

        a.setVelocidadObra(2); //TEJADO:2 RENOVACION:3 CONSTRUCCIONAPARTAMENTOS=5 (por defecto)
        int q = a.DefinirIDObra();
        a.setiDObra(q);

        return a;
    }

    public void LimpiarDatos() {
        campo_NumeroEdificios.setText("");
        campo_NumeroCasas.setText("");
        campo_AreaTejado.setText("");
        campo_AreaCubierta.setText("");
    }

    public boolean validarDatos() {
        boolean datosValidos = true;

        String seleccion = available_Construccion.getSelectedItem().toString();

        if (seleccion.equals("Casa")) {
            // Verifica sólo los campos relacionados con Casa
            String numCasas = campo_NumeroCasas.getText();
            String areaTejado = campo_AreaTejado.getText();
            if (numCasas.isEmpty() || areaTejado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos para Casa.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                int nroCasas = Integer.parseInt(numCasas);
                if (nroCasas <= 0) {
                    JOptionPane.showMessageDialog(null, "El número de casas debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de casas debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            try {
                double area = Double.parseDouble(areaTejado);
                if (area <= 0) {
                    JOptionPane.showMessageDialog(null, "El área del tejado debe ser un número válido mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El área del tejado debe ser un número válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

        } else if (seleccion.equals("Edificio")) {
            // Verifica sólo los campos relacionados con Edificio
            String numEdificios = campo_NumeroEdificios.getText();
            String areaCubierta = campo_AreaCubierta.getText();
            if (numEdificios.isEmpty() || areaCubierta.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos para Edificio.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            try {
                int nroEdificios = Integer.parseInt(numEdificios);
                if (nroEdificios <= 0) {
                    JOptionPane.showMessageDialog(null, "El número de edificios debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de edificios debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

            try {
                double area = Double.parseDouble(areaCubierta);
                if (area <= 0) {
                    JOptionPane.showMessageDialog(null, "El área de la cubierta debe ser un número válido mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El área de la cubierta debe ser un número válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }

        }
        return datosValidos;

    }
}
