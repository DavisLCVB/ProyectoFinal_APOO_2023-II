/**
 * Esta clase se centrará en la recepción, comunicación y flujo de datos entre
 * el apartado visual (Interfaces gráficas) y el apartado lógico del programa
 */
package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.empleados.padres.Supervisor;
import com.grupo8.finalproject.domain.empleados.trabajadores.*;
import com.grupo8.finalproject.domain.obras.ConstruccionEdificioApartamentos;
import com.grupo8.finalproject.domain.obras.Obra;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.userinterface.confirmlogin.FrameOscuro;
import com.grupo8.finalproject.userinterface.confirmlogin.VentanaConfirmacion;
import com.grupo8.finalproject.utilities.FileManager;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * @author Davis Cartagena
 */
public class Controlador {

    private MainWindow userInterface;
    private VentanaConfirmacion ventanaConfirmacion;
    private ControladorDatosObras coObras;
    private Electricista electricista;
    private Pintor pintor;
    private Obrero obrero;

    public Controlador() {
    }

    public Controlador(MainWindow userInterface, VentanaConfirmacion ventanaConfirmacion, ControladorDatosObras coObras) {
        this.ventanaConfirmacion = ventanaConfirmacion;
        this.userInterface = userInterface;
        this.coObras = coObras;
        this.userInterface.loginPanel.loginForms.jprLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                panelLoginEntrar();
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                panelLoginSalir();
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                panelLoginClick();
            }
        });
        this.userInterface.statusBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                statusBarArrastrado(evt);
            }
        });
        this.userInterface.statusBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                statusBarPresionado(evt);
            }
        });
        this.userInterface.exitButtonPanel.lbExitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                salirSeleccionado(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                salirDeseleccionado(evt);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                salirPrograma(evt);
            }
        });
        this.userInterface.loginPanel.loginForms.tfUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    panelLoginClick();
                }
            }
        });
        this.userInterface.loginPanel.loginForms.tfUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                userInterface.loginPanel.loginForms.usuarioClickeado();
            }
        });
        this.userInterface.loginPanel.loginForms.pfContrasenia.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                userInterface.loginPanel.loginForms.passwordClickeado();
            }
        });
        this.userInterface.loginPanel.loginForms.pfContrasenia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    panelLoginClick();
                }
            }
        });
        this.userInterface.loginPanel.loginForms.jprLogin.setFocusable(true);
        this.userInterface.loginPanel.loginForms.jprLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    panelLoginClick();
                }
            }
        });
        this.userInterface.loginPanel.loginForms.jprLogin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                panelLoginEntrar();
            }
        });
        this.userInterface.loginPanel.loginForms.jprLogin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evt) {
                panelLoginSalir();
            }
        });
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.setFocusable(true);
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                entrarSeleccionarObra();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                salirSeleccionarObra();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarObra();
            }
        });
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                entrarSeleccionarObra();
            }

            @Override
            public void focusLost(FocusEvent e) {
                salirSeleccionarObra();
            }
        });
        this.userInterface.mainMenuPanel.workPanel.noObra.lbSeleccionar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionarObra();
            }
        });
        this.coObras.fo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                coObras.ventanaActiva().requestFocus();
            }
        });
        this.userInterface.mainMenuPanel.workPanel.noObra.prIniciarObra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                iniciarObra(coObras.obraEnCurso);
            }
        });
        this.userInterface.mainMenuPanel.workPanel.noObra.lbIniciarObra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                iniciarObra(coObras.obraEnCurso);
            }
        });

        this.userInterface.loginPanel.loginForms.usuarioClickeado();
    }

    public Controlador(MainWindow mainW, VentanaConfirmacion ventanaConfirmacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void panelLoginEntrar() {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(91, 88, 94));
    }

    public void panelLoginSalir() {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(37, 35, 39));
    }

    public void panelLoginClick() {
        Supervisor supervisor = new Supervisor();
        if (!validarLogin(supervisor)) {
            this.userInterface.loginPanel.loginForms.lbErrorLogin.setText("Usuario o contraseña incorrectos");
            return;
        }
        FrameOscuro fo = new FrameOscuro();
        fo.setLocationRelativeTo(this.userInterface);
        fo.setVisible(true);
        fo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventanaConfirmacion.requestFocus();
            }
        });
        this.ventanaConfirmacion.setLocationRelativeTo(fo);
        this.ventanaConfirmacion.setVisible(true);
        Timer timer = new Timer(3000, actionEvent -> {
            fo.dispose();
            this.ventanaConfirmacion.dispose();
            this.userInterface.loginPanel.setVisible(false);
            asignarSupervisor(supervisor);
            this.userInterface.add(this.userInterface.mainMenuPanel);
            this.userInterface.statusBar.lbStatus.setText(">> Main Menu");
            this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.requestFocus();
        });
        timer.setRepeats(false);
        timer.start();
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

    public void salirSeleccionado(MouseEvent evt) {
        this.userInterface.exitButtonPanel.lbExitButton.setIcon(this.userInterface.exitButtonPanel.exitON);
    }

    public void salirDeseleccionado(MouseEvent evt) {
        this.userInterface.exitButtonPanel.lbExitButton.setIcon(this.userInterface.exitButtonPanel.exitOFF);
    }

    public void salirPrograma(MouseEvent evt) {
        this.coObras.apartmentsGUI.dispose();
        this.coObras.fo.dispose();
        System.exit(0);
    }

    public void entrarSeleccionarObra() {
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.setBackground(new Color(21, 20, 23));
    }

    public void salirSeleccionarObra() {
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.setBackground(new Color(3, 1, 6));
    }

    public void seleccionarObra() {
        this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.requestFocus();
        String opcion = this.userInterface.mainMenuPanel.workPanel.noObra.cbMenuObras.getSelectedItem().toString();
        if (opcion.equals("Construcción de Apartamentos")) {
            visibleVentanaApartamentos();
        }
    }

    public void visibleVentanaApartamentos() {
        this.coObras.fo.setLocationRelativeTo(userInterface);
        this.coObras.fo.setVisible(true);
        this.coObras.apartmentsGUI.setVisible(true);
        this.coObras.apartmentSelected = true;
    }

    public void iniciarObra(Obra obra) {
        this.userInterface.mainMenuPanel.workersPanel.wInactive.setVisible(false);
        this.userInterface.mainMenuPanel.workersPanel.wActive.setVisible(true);
        this.userInterface.setComponentZOrder(this.userInterface.statusBar, 0);
        llenarTrabajadores();
        iniciarTrabajadores();
    }

    public void iniciarTrabajadores() {
        TrabajadorEjecutable ejecutableElectricista = new TrabajadorEjecutable(
                electricista.getArrayTareas(), this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaPElectricista,
                this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaSElectricista
        );
        TrabajadorEjecutable ejecutablePintor = new TrabajadorEjecutable(
                pintor.getArrayTareas(), this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaPPintor,
                this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaSPintor
        );
        TrabajadorEjecutable ejecutableObrero = new TrabajadorEjecutable(
                obrero.getArrayTareas(), this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaPObrero,
                this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaSObrero
        );
//        TrabajadorEjecutable ejecutablePlomero = new TrabajadorEjecutable(
//                electricista.getArrayTareas(), this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaPPlomero,
//                this.userInterface.mainMenuPanel.workersPanel.wActive.lbTareaSPlomero
//        );
        Thread hiloElectricista = new Thread(ejecutableElectricista);
        Thread hiloObrero = new Thread(ejecutableObrero);
        Thread hiloPintor = new Thread(ejecutablePintor);
//        Thread hiloPlomero = new Thread(ejecutablePlomero);

        hiloElectricista.start();
        hiloObrero.start();
        hiloPintor.start();
//           hiloPlomero.start();
        try {
            hiloElectricista.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            hiloObrero.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            hiloPintor.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarTrabajadores() {
        electricista = new Electricista(this.coObras.obraEnCurso.getNroElectricistas());
        pintor = new Pintor(this.coObras.obraEnCurso.getNroPintores());
        obrero = new Obrero(this.coObras.obraEnCurso.getNroObreros());
        //Plomero plomero = new Plomero(this.coObras.obraEnCurso.getNroPlomeros());
    }
}
