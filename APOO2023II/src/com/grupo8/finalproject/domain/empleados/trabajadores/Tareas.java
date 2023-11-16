package com.grupo8.finalproject.domain.empleados.trabajadores;

import com.grupo8.finalproject.domain.empleados.gestion.AccionPrincipal;
import java.util.ArrayList;

public interface Tareas {

    void llenarTareas(int subtareas);

    ArrayList<AccionPrincipal> getArrayTareas();
}
