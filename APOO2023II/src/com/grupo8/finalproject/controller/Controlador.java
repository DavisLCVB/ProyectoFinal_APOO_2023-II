/**
 * Esta clase se centrará en la recepción, comunicación y flujo de datos entre
 * el apartado visual (Interfaces gráficas) y el apartado lógico del programa
 */
package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.empleados.padres.Supervisor;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.utilities.FileManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class Controlador {

    private MainWindow userInterface;

    public Controlador(MainWindow userInterface) {
        this.userInterface = userInterface;
        this.userInterface.loginPanel.loginForms.jprLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                panelLoginEntrar(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                panelLoginSalir(evt);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                panelLoginClick(evt);
            }
        });
        this.userInterface.statusBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                statusBarArrastrado(evt);
            }
        });
        this.userInterface.statusBar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt) {
                statusBarPresionado(evt);
            }
        });
        this.userInterface.exitButtonPanel.lbExitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                salirSeleccionado(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                salirDeseleccionado(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                salirPrograma(evt);
            }
        });
    }

    public void panelLoginEntrar(MouseEvent evt) {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(91, 88, 94));
    }

    public void panelLoginSalir(MouseEvent evt) {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(37, 35, 39));
    }

    public void panelLoginClick(MouseEvent evt) {
        Supervisor supervisor = new Supervisor();
        if (!validarLogin(supervisor)) {
            this.userInterface.loginPanel.loginForms.lbErrorLogin.setText("Usuario o contraseña incorrectos");
            return;
        }

        this.userInterface.loginPanel.setVisible(false);
        asignarSupervisor(supervisor);
        this.userInterface.add(this.userInterface.mainMenuPanel);
        this.userInterface.statusBar.lbStatus.setText(">> Main Menu");
    }

    public boolean validarLogin(Supervisor sup) {
        if (this.userInterface.loginPanel.loginForms.tfUsuario.getText().isEmpty() || this.userInterface.loginPanel.loginForms.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if (String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).isEmpty() || String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).equals(("********"))) {
            return false;
        }
        boolean exists = false;
        ArrayList<String> usuarios = new ArrayList<>();
        FileManager.leerArchivo("Supervisores.txt", usuarios);
        for (int i = 0; i < usuarios.size(); i += 3) {
            if (!this.userInterface.loginPanel.loginForms.tfUsuario.getText().equals(usuarios.get(i))) {
                continue;
            }
            if (!String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).equals(usuarios.get(i + 2))) {
                continue;
            }
            sup.setNombre(usuarios.get(i));
            sup.setApellido(usuarios.get(i + 1));

            exists = true;
        }
        if (!exists) {
            return false;
        }
        return true;
    }

    public void asignarSupervisor(Supervisor supervisor) {

        this.userInterface.mainMenuPanel.supervisorPanel.lbNombre.setText("Nombre: " + supervisor.getNombre());
        this.userInterface.mainMenuPanel.supervisorPanel.lbApellidos.setText("Apellido: " + supervisor.getApellido());
        this.userInterface.mainMenuPanel.supervisorPanel.lbIDSupervisor.setText("ID Sesión: " + supervisor.getiDSupervisor());
    }

    public void statusBarPresionado(MouseEvent evt) {
        this.userInterface.coordX = evt.getX();
        this.userInterface.coordY = evt.getY();
    }

    public void statusBarArrastrado(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.userInterface.setLocation(x - this.userInterface.coordX, y - this.userInterface.coordY);
    }
    public void salirSeleccionado(MouseEvent evt){
        this.userInterface.exitButtonPanel.lbExitButton.setIcon(this.userInterface.exitButtonPanel.exitON);
    }
    public void salirDeseleccionado(MouseEvent evt){
        this.userInterface.exitButtonPanel.lbExitButton.setIcon(this.userInterface.exitButtonPanel.exitOFF);
    }
    public void salirPrograma(MouseEvent evt){
        System.exit(0);
    }
}
