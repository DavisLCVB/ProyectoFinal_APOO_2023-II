package com.grupo8.finalproject.userinterface.renovacioncasa;

import com.grupo8.finalproject.domain.obras.RenovacionCasa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDate;
import javax.swing.border.LineBorder;

public class PanelIngresoDatos extends JPanel implements ActionListener {

    protected JLabel etiquetaNumAmbientes;
    protected JLabel etiquetaSectorCasa;
    protected JLabel etiquetaEstado;
    protected JLabel etiquetaArea_Sector;
    protected JLabel etiquetaReestructurada;
    protected JLabel etiquetaDistritos;

    protected JComboBox<String> availableDistritos;
    protected JComboBox<String> availableLugares;
    protected JComboBox<String> availableOptimiza;

    protected JTextField campoAmbientes;
    protected JTextField campoSectorCasa;

    protected JTextField campoArea_Sector;
    protected JTextField campoReestructurada;

    public JButton Aceptar;
    public JButton Cancelar;

    public PanelIngresoDatos() {
        IniciarComponentes();
    }

    public void IniciarComponentes() {

        Font mifuentePanel = new Font("Arial Narrow", Font.PLAIN, 16);
        try {
            mifuentePanel = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\grupo8\\finalproject\\resources\\fonts\\Sarala\\Sarala-Regular.ttf"));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        this.setLayout(null);
        Color micolorPanel = new Color(25, 23, 27);
        this.setBackground(micolorPanel);
        mifuentePanel = mifuentePanel.deriveFont(Font.PLAIN, 16);

        etiquetaSectorCasa = new JLabel("Sector a mejorar:");
        etiquetaSectorCasa.setBounds(25, 55, 300, 20);
        etiquetaSectorCasa.setForeground(Color.WHITE);
        etiquetaSectorCasa.setFont(mifuentePanel);
        String[] LugaresDisponibles = {"Cocina", "Dormitorio", "Sala", "Baño"};
        availableLugares = new JComboBox<>(LugaresDisponibles);
        availableLugares.setBounds(200, 55, 200, 20);
        availableLugares.setFont(mifuentePanel.deriveFont(Font.PLAIN, 12));

        etiquetaNumAmbientes = new JLabel("Número de ambientes:");
        etiquetaNumAmbientes.setBounds(25, 20, 300, 20);
        etiquetaNumAmbientes.setForeground(Color.WHITE);
        etiquetaNumAmbientes.setFont(mifuentePanel);
        campoAmbientes = new JTextField();
        campoAmbientes.setBounds(200, 20, 65, 20);

        etiquetaArea_Sector = new JLabel("Area del sector total:");
        etiquetaArea_Sector.setBounds(25, 125, 300, 20);
        etiquetaArea_Sector.setForeground(Color.WHITE);
        etiquetaArea_Sector.setFont(mifuentePanel);
        campoArea_Sector = new JTextField();
        campoArea_Sector.setBounds(200, 125, 200, 20);

        etiquetaEstado = new JLabel("Optimizar/mejorar:");
        etiquetaEstado.setBounds(25, 90, 300, 20);
        etiquetaEstado.setForeground(Color.WHITE);
        etiquetaEstado.setFont(mifuentePanel);
        String[] OptimizaDisponibles = {"Iluminación", "Fluido electrico", "Paredes dañadas"};
        availableOptimiza = new JComboBox<>(OptimizaDisponibles);
        availableOptimiza.setFont(mifuentePanel.deriveFont(Font.PLAIN, 12));
        availableOptimiza.setBounds(200, 90, 200, 20);

        etiquetaDistritos = new JLabel("Distrito:");
        etiquetaDistritos.setBounds(25, 160, 250, 20);
        etiquetaDistritos.setForeground(Color.WHITE);
        etiquetaDistritos.setFont(mifuentePanel);
        String[] distritosDisponibles = {"La Molina", "San Miguel", "San Borja", "Pueblo Libre", "SJL"};
        availableDistritos = new JComboBox<>(distritosDisponibles);
        availableDistritos.setFont(mifuentePanel.deriveFont(Font.PLAIN, 12));
        availableDistritos.setBounds(200, 160, 200, 20);

        Color micolorBoton = new Color(110, 190, 170);
        Aceptar = new JButton("Aceptar");
        Aceptar.setBounds(45, 195, 150, 45);
        Aceptar.setBackground(micolorBoton);
        Aceptar.setForeground(Color.WHITE);
        Aceptar.setBorder(new LineBorder(micolorBoton, 3, true));
        Aceptar.setFont(mifuentePanel.deriveFont(Font.PLAIN, 12));
        ImageIcon aceptar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\aceptar.png");
        Aceptar.setIcon(aceptar);

        Color micolorBoton_2 = new Color(240, 30, 80);
        Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(205, 195, 150, 45);
        Cancelar.setBackground(micolorBoton_2);
        Cancelar.setForeground(Color.WHITE);
        Cancelar.setBorder(new LineBorder(micolorBoton_2, 5, true));
        Cancelar.setFont(mifuentePanel.deriveFont(Font.PLAIN, 12));
        ImageIcon mostrar = new ImageIcon("src\\com\\grupo8\\finalproject\\resources\\media\\gif\\MostrarDetalles.png");
        Cancelar.setIcon(mostrar);

        this.add(etiquetaNumAmbientes);
        this.add(campoAmbientes);

        this.add(etiquetaSectorCasa);
        this.add(availableLugares);

        this.add(etiquetaEstado);

        this.add(etiquetaArea_Sector);
        this.add(campoArea_Sector);

        //this.add(etiquetaReestructurada);
        //this.add(campoReestructurada);
        this.add(etiquetaDistritos);
        this.add(availableDistritos);

        this.add(availableOptimiza);

        this.add(Aceptar);
        this.add(Cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Aceptar) {
            if (validarDatos()) {
                LlenarDatosObra();
                LimpiarDatos();
                JOptionPane.showMessageDialog(null, "Datos registrados con éxito!");
            }
        }
        if (e.getSource() == Cancelar) {

        }
    }

    public RenovacionCasa LlenarDatosObra() {
        RenovacionCasa obra = new RenovacionCasa();

        obra.setSectoresCasa(availableLugares.getSelectedItem().toString());
        obra.setNro_ambientes(Integer.parseInt(campoAmbientes.getText()));
        obra.setEstadoLugar(availableOptimiza.getSelectedItem().toString());
        obra.setArea_Total(Double.parseDouble(campoArea_Sector.getText()));
        obra.setDistrito(availableDistritos.getSelectedItem().toString());
        obra.setNombreObra("Renovación de casa");

        int m = obra.CalculoComplejidad(Integer.parseInt(campoAmbientes.getText()), 2);
        obra.setComplejidad(m);

        LocalDate fecha_inicio = LocalDate.now();
        obra.setFechaInicio(fecha_inicio);

        LocalDate fecha_fin = obra.CalcularFecha_Culminacion_Obra();
        obra.setFechaFin(fecha_fin);

        obra.setVelocidadObra(2);
        int q = obra.DefinirIDObra();
        obra.setiDObra(q);

        return obra;
    }

    public void LimpiarDatos() {
        campoAmbientes.setText("");
        campoArea_Sector.setText("");

    }

    public boolean validarDatos() {
        boolean datosValidos = true;

        String numHabitaciones = campoAmbientes.getText();
        String amueblada = campoArea_Sector.getText();

        if (numHabitaciones.isEmpty() || amueblada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        try {
            int nroHabitaciones = Integer.parseInt(numHabitaciones);
            if (nroHabitaciones <= 0) {
                JOptionPane.showMessageDialog(null, "El número de habitaciones debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de habitaciones debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        try {
            int nroMuebles = Integer.parseInt(amueblada);
            if (nroMuebles <= 0) {
                JOptionPane.showMessageDialog(null, "El número de muebles debe ser un entero mayor que cero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                datosValidos = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de muebles debe ser un entero válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            datosValidos = false;
        }

        return datosValidos;
    }
}
