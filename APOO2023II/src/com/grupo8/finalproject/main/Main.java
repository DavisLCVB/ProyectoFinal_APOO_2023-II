package com.grupo8.finalproject.main;

import com.grupo8.finalproject.controller.*;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.userinterface.confirmlogin.VentanaConfirmacion;

public class Main {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        VentanaConfirmacion ventanaConfirmacion = new VentanaConfirmacion();
        ControladorDatosObras controladorDatosObras = new ControladorDatosObras(mainWindow);
        Controlador mainControlador = new Controlador(mainWindow, ventanaConfirmacion, controladorDatosObras);

        mainWindow.setVisible(true);
    }
}
