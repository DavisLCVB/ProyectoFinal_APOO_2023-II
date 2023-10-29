/**
 * Esta clase se centrará en la recepción, comunicación y flujo de datos entre
 * el apartado visual (Interfaces gráficas) y el apartado lógico del programa
 */
package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.userinterface.MainWindow;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    }

    public void panelLoginEntrar(MouseEvent evt) {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(91, 88, 94));
    }

    public void panelLoginSalir(MouseEvent evt) {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(37, 35, 39));
    }

    public void panelLoginClick(MouseEvent evt) {
        if (!validarLogin()) {
            this.userInterface.loginPanel.loginForms.lbErrorLogin.setText("Usuario o contraseña incorrectos");
            return;
        }
        String info = "Usuario: ";
        info += this.userInterface.loginPanel.loginForms.tfUsuario.getText() + "\n";
        info += "Contraseña: ";
        info += String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()) + "\n";

        JOptionPane.showMessageDialog(null, info, "Login", JOptionPane.INFORMATION_MESSAGE);
        this.userInterface.loginPanel.setVisible(false);
        this.userInterface.add(this.userInterface.panel);
    }

    public boolean validarLogin() {
        if (this.userInterface.loginPanel.loginForms.tfUsuario.getText().isEmpty() || this.userInterface.loginPanel.loginForms.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if (String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).isEmpty() || String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).equals(("********"))) {
            return false;
        }
        return true;
    }
}
