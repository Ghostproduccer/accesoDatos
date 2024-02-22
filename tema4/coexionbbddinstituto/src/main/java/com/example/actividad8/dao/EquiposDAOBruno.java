package com.example.actividad8.dao;

import java.util.List;
import com.example.actividad8.model.Equipo;

public interface EquiposDAOBruno {
    void insertarEquipo(Equipo equipo);
    void actualizarEquipo(Equipo equipo);
    void eliminarEquipo(String nombre);
    Equipo obtenerEquipo(String nombre);
    List<Equipo> obtenerTodosEquipos();
}
