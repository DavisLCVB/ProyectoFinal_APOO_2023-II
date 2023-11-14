package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.obras.ConstruccionEdificioApartamentos;
import com.grupo8.finalproject.domain.obras.Obra;
import com.grupo8.finalproject.domain.obras.RenovacionCasa;
import com.grupo8.finalproject.domain.obras.ReparacionDeTejado;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.userinterface.apartamentos.ApartmentsData;
import com.grupo8.finalproject.userinterface.confirmlogin.FrameOscuro;
import com.grupo8.finalproject.userinterface.renovacioncasa.RenovacionData;
import com.grupo8.finalproject.userinterface.tejado.TejadoData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Davis Cartagena
 */
public class ControladorDatosObras implements ActionListener {

    public ApartmentsData apartmentsGUI;
    public TejadoData tejadoGUI;
    public RenovacionData renovacionGUI;
    public boolean apartmentSelected;
    public boolean renovSelected;
    public boolean roofSelected;
    public FrameOscuro fo;
    public Obra obraEnCurso;
    public MainWindow main;
    public boolean obraInconclusa;

    public ControladorDatosObras(MainWindow main) {
        obraInconclusa = false;
        this.main = main;
        this.apartmentsGUI = new ApartmentsData();
        this.tejadoGUI = new TejadoData();
        this.renovacionGUI = new RenovacionData();
        fo = new FrameOscuro();
        this.apartmentsGUI.setVisible(false);
        this.tejadoGUI.setVisible(false);
        fo.setVisible(false);
        this.apartmentsGUI.panel_ingresoDatos.Aceptar.addActionListener(this);
        this.apartmentsGUI.panel_ingresoDatos.Cancelar.addActionListener(this);
        this.tejadoGUI.panel_ingresoDatos.Aceptar.addActionListener(this);
        this.tejadoGUI.panel_ingresoDatos.Cancelar.addActionListener(this);
        this.renovacionGUI.panel_ingresoDatos.Aceptar.addActionListener(this);
        this.renovacionGUI.panel_ingresoDatos.Cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.apartmentsGUI.panel_ingresoDatos.Aceptar) {
            if (this.apartmentsGUI.panel_ingresoDatos.validarDatos() == true) {
                ConstruccionEdificioApartamentos apart;
                apart = this.apartmentsGUI.panel_ingresoDatos.LlenarDatosObra();
                apart.CalcularPresupuesto();
                this.apartmentsGUI.panel_ingresoDatos.LimpiarDatos();
                JOptionPane.showMessageDialog(null, "Datos registrados con éxito!");
                obraEnCurso = apart;
                this.apartmentsGUI.setVisible(false);
                this.fo.setVisible(false);
                this.main.mainMenuPanel.workPanel.noObra.prIniciarObra.setVisible(true);
                this.apartmentSelected = false;
                this.roofSelected = false;
            }

        }
        if (e.getSource() == this.apartmentsGUI.panel_ingresoDatos.Cancelar) {
            this.apartmentsGUI.panel_ingresoDatos.LimpiarDatos();
            this.apartmentsGUI.setVisible(false);
            this.fo.setVisible(false);
            this.apartmentSelected = false;
            this.roofSelected = false;
            this.renovSelected = false;

        }
        if (e.getSource() == this.tejadoGUI.panel_ingresoDatos.Aceptar) {
            if (this.tejadoGUI.panel_ingresoDatos.validarDatos()) {
                ReparacionDeTejado tej;
                if (this.tejadoGUI.panel_ingresoDatos.available_Construccion.getSelectedItem().toString().equals("Casa")) {
                    tej = this.tejadoGUI.panel_ingresoDatos.LlenarDatosObraCasa();
                } else {
                    tej = this.tejadoGUI.panel_ingresoDatos.LlenarDatosObraEdificio();

                }
                tej.CalcularPresupuesto();
                this.tejadoGUI.panel_ingresoDatos.LimpiarDatos();
                JOptionPane.showMessageDialog(null, "Datos registrados con éxito!");
                obraEnCurso = tej;
                this.tejadoGUI.setVisible(false);
                this.fo.setVisible(false);
                this.main.mainMenuPanel.workPanel.noObra.prIniciarObra.setVisible(true);
                this.roofSelected = false;
                this.apartmentSelected = false;
            }
        }
        if (e.getSource() == this.tejadoGUI.panel_ingresoDatos.Cancelar) {
            this.tejadoGUI.panel_ingresoDatos.LimpiarDatos();
            this.tejadoGUI.setVisible(false);
            this.fo.setVisible(false);
            this.roofSelected = false;
            this.apartmentSelected = false;
            this.renovSelected = false;
        }
        if (e.getSource() == this.renovacionGUI.panel_ingresoDatos.Aceptar) {
            if (this.renovacionGUI.panel_ingresoDatos.validarDatos()) {
                RenovacionCasa ren;
                ren = this.renovacionGUI.panel_ingresoDatos.LlenarDatosObra();
                ren.CalcularPresupuesto();
                ren.setUbicacionObra("La casa de alguien");
                this.renovacionGUI.panel_ingresoDatos.LimpiarDatos();
                JOptionPane.showMessageDialog(null, "Datos registrados con éxito!");
                obraEnCurso = ren;
                this.renovacionGUI.setVisible(false);
                this.fo.setVisible(false);
                this.main.mainMenuPanel.workPanel.noObra.prIniciarObra.setVisible(true);
                this.roofSelected = false;
                this.apartmentSelected = false;
                this.renovSelected = false;
            }
        }
        if (e.getSource() == this.renovacionGUI.panel_ingresoDatos.Cancelar) {
            this.renovacionGUI.panel_ingresoDatos.LimpiarDatos();
            this.renovacionGUI.setVisible(false);
            this.fo.setVisible(false);
            this.roofSelected = false;
            this.apartmentSelected = false;
            this.renovSelected = false;
        }
    }

    public JFrame ventanaActiva() {
        if (apartmentSelected) {
            return apartmentsGUI;
        } else if (roofSelected) {
            return tejadoGUI;
        }
        return null;
    }
}
