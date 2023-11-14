package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import java.util.ArrayList;

/**
 * @author Jose Sernaque
 */
public interface Tareas {

    void llenarTareas();

    ArrayList<AccionPrincipal> getArrayTareas();
}
