package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.obras.ConstruccionEdificioApartamentos;
import com.grupo8.finalproject.domain.obras.Obra;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.userinterface.apartments.ApartmentsData;
import com.grupo8.finalproject.userinterface.confirmlogin.FrameOscuro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Davis Cartagena
 */
public class ControladorDatosObras implements ActionListener {

    public ApartmentsData apartmentsGUI;
    public boolean apartmentSelected;
    public FrameOscuro fo;
    public Obra obraEnCurso;
    public MainWindow main;

    public ControladorDatosObras(ApartmentsData apartmentsGUI, MainWindow main) {
        this.main = main;
        this.apartmentsGUI = apartmentsGUI;
        fo = new FrameOscuro();
        this.apartmentsGUI.panel_ingresoDatos.Aceptar.addActionListener(this);
        this.apartmentsGUI.panel_ingresoDatos.Mostrar_Detalles.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.apartmentsGUI.panel_ingresoDatos.Aceptar) {
            if (this.apartmentsGUI.panel_ingresoDatos.validarDatos() == true) {
                ConstruccionEdificioApartamentos apart = new ConstruccionEdificioApartamentos();
                apart = this.apartmentsGUI.panel_ingresoDatos.LlenarDatosObra();
                this.apartmentsGUI.panel_ingresoDatos.LimpiarDatos();
                JOptionPane.showMessageDialog(null, "Datos registrados con éxito!");
                obraEnCurso = apart;
                this.apartmentsGUI.setVisible(false);
                this.fo.setVisible(false);
                this.main.mainMenuPanel.workPanel.noObra.prIniciarObra.setVisible(true);
            }

        }
        if (e.getSource() == this.apartmentsGUI.panel_ingresoDatos.Mostrar_Detalles) {

        }
    }

    public JFrame ventanaActiva() {
        if (apartmentSelected) {
            return apartmentsGUI;
        }
        return null;
    }
}
