package com.grupo8.finalproject.controller;

import com.grupo8.finalproject.domain.empleados.padres.AccionPrincipal;
import com.grupo8.finalproject.utilities.Aleatoriedad;
import com.grupo8.finalproject.utilities.TiempoAleatorio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author Jose Sernaque
 */
public class TrabajadorEjecutable implements Runnable {

    private ArrayList<AccionPrincipal> acciones;
    JLabel lbaccionPrincipal;
    JLabel lbsubproceso;

    public TrabajadorEjecutable(ArrayList<AccionPrincipal> acciones, JLabel accionPrincipal, JLabel subproceso) {
        this.acciones = acciones;
        this.lbaccionPrincipal = accionPrincipal;
        this.lbsubproceso = subproceso;
    }

    @Override
    public void run() {
    Random numR = new Random();
    for (AccionPrincipal a : acciones) {
        ArrayList<String> subprocesos = a.getSubprocesos();
        final String accionPrincipalNombre = a.getNombre();

        SwingUtilities.invokeLater(() -> lbaccionPrincipal.setText(accionPrincipalNombre));

        int numeroSub = a.getSubprocesos().size();
        for (int i = 0; i < numeroSub; i++) {
            LocalDateTime aleatorio = LocalDateTime.now().plusSeconds(numR.nextInt(5) + 5);
            while (true) {
                if (!subprocesos.isEmpty()) {
                    LocalDateTime ahora = LocalDateTime.now();
                    int indiceAleatorio = numR.nextInt(subprocesos.size());

                    if (ahora.equals(aleatorio) || ahora.isAfter(aleatorio)) {
                        final String subprocesoTexto = subprocesos.get(indiceAleatorio);

                        SwingUtilities.invokeLater(() -> lbsubproceso.setText(subprocesoTexto));
                        subprocesos.remove(indiceAleatorio);
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
        try {
            Thread.sleep(1000); // Agregar un pequeño retraso entre acciones
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    SwingUtilities.invokeLater(() -> {
        lbaccionPrincipal.setText("Finalizado");
        lbsubproceso.setText("Finalizados");
    });
}

}
