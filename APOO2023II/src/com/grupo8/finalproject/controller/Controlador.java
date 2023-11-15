/**
 * Esta clase se centrará en la recepción, comunicación y flujo de datos entre
 * el apartado visual (Interfaces gráficas) y el apartado lógico del programa
 */
package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import com.grupo8.finalproject.domain.empleados.gestion.GestorSupervisor;
import com.grupo8.finalproject.domain.empleados.gestion.Supervisor;
import com.grupo8.finalproject.domain.empleados.trabajadores.*;
import com.grupo8.finalproject.domain.obras.Obra;
import com.grupo8.finalproject.userinterface.MainWindow;
import com.grupo8.finalproject.userinterface.OptionSalida;
import com.grupo8.finalproject.userinterface.actionworkers.VentanaObreros;
import com.grupo8.finalproject.userinterface.confirmlogin.FrameOscuro;
import com.grupo8.finalproject.userinterface.confirmlogin.VentanaConfirmacion;
import com.grupo8.finalproject.userinterface.mainmenu.workerspanel.WorkersActive;
import com.grupo8.finalproject.utilities.FileManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Davis Cartagena
 */
public class Controlador {

    private MainWindow userInterface;
    private VentanaConfirmacion ventanaConfirmacion;
    private VentanaObreros tareaObreros;
    private ControladorDatosObras coObras;
    private Electricista electricista = new Electricista();
    private Carpintero carpintero = new Carpintero();
    private Obrero obrero = new Obrero();
    public static ArrayList<Boolean> terminado = new ArrayList<>();
    private TrabajadorEjecutable ejecElectricista;
    private TrabajadorEjecutable ejecObrero;
    private TrabajadorEjecutable ejecCarpintero;
    private OptionSalida salir;

    public Controlador() {
    }

    public Controlador(MainWindow userInterface, VentanaConfirmacion ventanaConfirmacion, ControladorDatosObras coObras) {
        this.ventanaConfirmacion = ventanaConfirmacion;
        this.userInterface = userInterface;
        this.coObras = coObras;
        this.coObras.obraInconclusa = false;
        this.tareaObreros = new VentanaObreros();
        this.salir = new OptionSalida() {
            @Override
            public void ejecutar() {
                confirmarSalida();
            }
        };
        cargarArchivos();
        terminado.add(false);
        terminado.add(false);
        terminado.add(false);
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
        this.tareaObreros.panFondo.panDatos.prAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                entrarAceptarTareasObreros();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                salirAceptarTareasObreros();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                aceptarTareasObreros();
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
        this.tareaObreros.panFondo.panDatos.prAceptar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    aceptarTareasObreros();
                }
            }

        });
        Electricista.setMostrarAcciones(WorkersActive.areaElectricista);
        Obrero.setMostrarAcciones(WorkersActive.areaObrero);
        Carpintero.setMostrarAcciones(WorkersActive.areaCarpintero);
        this.userInterface.loginPanel.loginForms.usuarioClickeado();
    }

    public void panelLoginEntrar() {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(91, 88, 94));
    }

    public void panelLoginSalir() {
        this.userInterface.loginPanel.loginForms.jprLogin.setBackground(new Color(37, 35, 39));
    }

    public void panelLoginClick() {
        if (!validarLogin()) {
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
        Timer timer = new Timer(2500, actionEvent -> {
            fo.dispose();
            this.ventanaConfirmacion.dispose();
            this.userInterface.loginPanel.setVisible(false);
            this.userInterface.add(this.userInterface.mainMenuPanel);
            this.userInterface.statusBar.lbStatus.setText(">> Main Menu");
            this.userInterface.mainMenuPanel.workPanel.noObra.prSeleccionarObra.requestFocus();
            if (this.coObras.obraInconclusa) {
                JOptionPane.showMessageDialog(this.userInterface, "Se encontró una obra inconclusa, se procederá a culminarla", "Obra inconclusa", JOptionPane.INFORMATION_MESSAGE);
                iniciarObra(this.coObras.obraEnCurso);
            }

        });
        timer.setRepeats(false);
        timer.start();
    }

    public boolean validarLogin() {
        if (this.userInterface.loginPanel.loginForms.tfUsuario.getText().isEmpty() || this.userInterface.loginPanel.loginForms.tfUsuario.getText().equals("Usuario")) {
            return false;
        }
        if (String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).isEmpty() || String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()).equals(("********"))) {
            return false;
        }
        if (GestorSupervisor.buscarSupervisor(this.userInterface.loginPanel.loginForms.tfUsuario.getText().trim(), String.valueOf(this.userInterface.loginPanel.loginForms.pfContrasenia.getPassword()))) {
            asignarSupervisor(GestorSupervisor.getSupervisorActual());
            return true;
        }
        return false;
    }

    public void asignarSupervisor(Supervisor supervisor) {
        this.userInterface.mainMenuPanel.supervisorPanel.lbNombre.setText("Nombre: " + supervisor.getNombre());
        this.userInterface.mainMenuPanel.supervisorPanel.lbApellidos.setText("Apellido: " + supervisor.getApellido());
        this.userInterface.mainMenuPanel.supervisorPanel.lbIDSupervisor.setText("ID Sesión: " + supervisor.getiDSesion());
        this.userInterface.mainMenuPanel.supervisorPanel.lbImagenSupervisor.setIcon(new ImageIcon(supervisor.getIcono().getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
    }

    public void entrarAceptarTareasObreros() {
        this.tareaObreros.panFondo.panDatos.prAceptar.setBackground(new Color(0, 129, 155));
    }

    public void salirAceptarTareasObreros() {
        this.tareaObreros.panFondo.panDatos.prAceptar.setBackground(Color.BLACK);
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
        salir.generarOptionPane();
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
        switch (opcion) {
            case "Construcción de Apartamentos":
                visibleVentanaApartamentos();
                break;
            case "Reparación de Tejados":
                visibleVentanaTejados();
                break;
            case "Renovación de Casa":
                visibleRenovacionCasa();
                break;
            default:
                break;
        }
    }

    public void visibleVentanaApartamentos() {
        this.coObras.fo.setLocationRelativeTo(userInterface);
        this.coObras.fo.setVisible(true);
        this.coObras.apartmentsGUI.setVisible(true);
        this.coObras.apartmentSelected = true;
    }

    public void visibleVentanaTejados() {
        this.coObras.fo.setLocationRelativeTo(userInterface);
        this.coObras.fo.setVisible(true);
        this.coObras.tejadoGUI.setVisible(true);
        this.coObras.roofSelected = true;
    }

    private void visibleRenovacionCasa() {
        this.coObras.fo.setLocationRelativeTo(userInterface);
        this.coObras.fo.setVisible(true);
        this.coObras.renovacionGUI.setVisible(true);
        this.coObras.renovSelected = true;
    }

    public void iniciarObra(Obra obra) {
        if (!this.coObras.obraInconclusa) {
            this.coObras.fo.setLocationRelativeTo(userInterface);
            this.coObras.fo.setVisible(true);
            this.tareaObreros.setVisible(true);
        }else{
            cargarGUIObra();
        }
    }

    public void cargarGUIObra() {
        this.tareaObreros.setVisible(false);
        this.coObras.fo.setVisible(false);
        this.userInterface.mainMenuPanel.workersPanel.wInactive.setVisible(false);
        this.userInterface.mainMenuPanel.workersPanel.wActive.setVisible(true);
        this.userInterface.mainMenuPanel.workPanel.noObra.setVisible(false);
        this.userInterface.mainMenuPanel.workPanel.yepObra.setVisible(true);
        this.userInterface.mainMenuPanel.workPanel.yepObra.taInformacionObra.append(this.coObras.obraEnCurso.toString());
        this.userInterface.mainMenuPanel.workPanel.yepObra.lbTituloObra.setText(this.coObras.obraEnCurso.getNombreObra());
        this.userInterface.mainMenuPanel.workPanel.yepObra.prResetObra.setVisible(false);
        this.coObras.obraInconclusa = true;
        iniciarTrabajadores();
    }

    public void iniciarTrabajadores() {

        terminado.set(0, false);
        terminado.set(1, false);
        terminado.set(2, false);
        cargarEjecutables();

        Thread hiloElectricista = new Thread(ejecElectricista);
        Thread hiloObrero = new Thread(ejecObrero);
        Thread hiloCarpintero = new Thread(ejecCarpintero);

        hiloElectricista.start();
        hiloObrero.start();
        hiloCarpintero.start();

        try {
            hiloElectricista.join();
            hiloObrero.join();
            hiloCarpintero.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void llenarTrabajadores(int E, int C, int O) {
        electricista = new Electricista(this.coObras.obraEnCurso.getNroElectricistas(), E);
        carpintero = new Carpintero(this.coObras.obraEnCurso.getNroCarpinteros(), C);
        obrero = new Obrero(this.coObras.obraEnCurso.getNroObreros(), O);
    }

    private void cargarArchivos() {
        GestorSupervisor.llenarSupervisores();
        cargarObraInconclusa();
    }

    private void finObra() {
        if (terminado.get(0) && terminado.get(1) && terminado.get(2)) {
            habilitarBotonReset();
            this.coObras.obraInconclusa = false;
            eliminarResiduos();
        }
    }

    private void habilitarBotonReset() {
        System.out.println("Obra Terminada");
        this.userInterface.mainMenuPanel.workPanel.yepObra.prResetObra.setVisible(true);
        this.userInterface.mainMenuPanel.workPanel.yepObra.prResetObra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                entrarResetObra();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                salirResetObra();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                resetPaneles();
            }
        });
    }

    private void entrarResetObra() {
        this.userInterface.mainMenuPanel.workPanel.yepObra.prResetObra.setBackground(new Color(111, 112, 112));
    }

    private void salirResetObra() {
        this.userInterface.mainMenuPanel.workPanel.yepObra.prResetObra.setBackground(Color.BLACK);
    }

    private void resetPaneles() {
        this.userInterface.mainMenuPanel.workPanel.yepObra.setVisible(false);
        this.userInterface.mainMenuPanel.workPanel.yepObra.taInformacionObra.setText("");
        this.userInterface.mainMenuPanel.workPanel.noObra.prIniciarObra.setVisible(false);
        this.userInterface.mainMenuPanel.workPanel.noObra.setVisible(true);

        this.userInterface.mainMenuPanel.workersPanel.wActive.setVisible(false);
        this.userInterface.mainMenuPanel.workersPanel.wInactive.setVisible(true);
        Electricista.mostrarAcciones.setText("");
        Obrero.mostrarAcciones.setText("");
        Carpintero.mostrarAcciones.setText("");
    }

    private void guardarInstanciasObra() {
        try {
            FileManager.escribirArchivo("obrasInconclusas.dat", this.coObras.obraEnCurso);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void guardarDatosTrabajadores() {
        ArrayList<AccionPrincipal> accElectricista = this.ejecElectricista.getAcciones();
        ArrayList<AccionPrincipal> accObrero = this.ejecObrero.getAcciones();
        ArrayList<AccionPrincipal> accCarpin = this.ejecCarpintero.getAcciones();

        try {
            FileManager.escribirArchivo("electricista.dat", accElectricista);
            FileManager.escribirArchivo("Obrero.dat", accObrero);
            FileManager.escribirArchivo("carpintero.dat", accCarpin);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void cargarObraInconclusa() {
        try {
            this.coObras.obraEnCurso = (Obra) FileManager.leerArchivo("obrasInconclusas.dat");
            this.coObras.obraInconclusa = true;
            System.out.println(this.coObras.obraEnCurso);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Todo en orden");
        }
    }

    private void cargarTrabajosInconclusos() {
        try {
            ArrayList<AccionPrincipal> accElectricista = (ArrayList<AccionPrincipal>) FileManager.leerArchivo("electricista.dat");
            ArrayList<AccionPrincipal> accObrero = (ArrayList<AccionPrincipal>) FileManager.leerArchivo("obrero.dat");
            ArrayList<AccionPrincipal> accCarpintero = (ArrayList<AccionPrincipal>) FileManager.leerArchivo("carpintero.dat");
            this.ejecElectricista.setAcciones(accElectricista);
            this.ejecObrero.setAcciones(accObrero);
            this.ejecCarpintero.setAcciones(accCarpintero);
            System.out.println("Se encontraron tareas inconclusas");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No hay tareas inconclusas");
        }
    }

    private void crearEjecutables() {
        ejecElectricista = new TrabajadorEjecutable(this.electricista.getArrayTareas(), "Electricista") {
            @Override
            public void run() {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        mostrarAccionesTrabajador();
                        return null;
                    }

                    @Override
                    protected void done() {
                        Controlador.terminado.set(0, Boolean.TRUE);
                        finObra();
                    }

                };
                worker.execute();
            }
        };
        ejecObrero = new TrabajadorEjecutable(this.obrero.getArrayTareas(), "Obrero") {
            @Override
            public void run() {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        mostrarAccionesTrabajador();
                        return null;
                    }

                    @Override
                    protected void done() {
                        Controlador.terminado.set(1, Boolean.TRUE);
                        finObra();
                    }

                };
                worker.execute();
            }
        };
        ejecCarpintero = new TrabajadorEjecutable(this.carpintero.getArrayTareas(), "Carpintero") {
            @Override
            public void run() {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        mostrarAccionesTrabajador();
                        return null;
                    }

                    @Override
                    protected void done() {
                        Controlador.terminado.set(2, Boolean.TRUE);
                        finObra();
                    }

                };
                worker.execute();
            }
        };
    }

    private void cargarEjecutables() {
        crearEjecutables();
        cargarTrabajosInconclusos();
    }

    private void eliminarResiduos() {
        FileManager.eliminarArchivo("Obrero.dat");
        FileManager.eliminarArchivo("carpintero.dat");
        FileManager.eliminarArchivo("electricista.dat");
        FileManager.eliminarArchivo("obrasInconclusas.dat");
    }

    private void confirmarSalida() {
        this.coObras.apartmentsGUI.dispose();
        this.coObras.fo.dispose();
        if (this.coObras.obraInconclusa) {
            guardarInstanciasObra();
            guardarDatosTrabajadores();
        }
        System.exit(0);
    }

    public void aceptarTareasObreros() {
        if (!this.tareaObreros.panFondo.panDatos.validadDatos()) {
            return;
        }
        if (!this.coObras.obraInconclusa) {
            int elec = Integer.parseInt(this.tareaObreros.panFondo.panDatos.cantElect.getValue().toString());
            int obre = Integer.parseInt(this.tareaObreros.panFondo.panDatos.cantObre.getValue().toString());
            int carp = Integer.parseInt(this.tareaObreros.panFondo.panDatos.cantCarp.getValue().toString());
            llenarTrabajadores(elec, carp, obre);
        }
        cargarGUIObra();
    }
}
