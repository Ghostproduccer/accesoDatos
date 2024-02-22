package com.example.actividad8.main;

import java.util.List;
import com.example.actividad8.dao.EquiposDAOBruno;
import com.example.actividad8.dao.EquiposDAOImplementationBruno;
import com.example.actividad8.model.Equipo;

public class EquiposTestBruno {
    public static void main(String[] args) {
        EquiposDAOBruno dao = new EquiposDAOImplementationBruno();

        // Ejemplo de uso: insertar un equipo
        Equipo equipo1 = new Equipo("amarillos", "Los Angeles", "east", "Pacífico");
        dao.insertarEquipo(equipo1);

        // Ejemplo de uso: obtener todos los equipos
        List<Equipo> equipos = dao.obtenerTodosEquipos();
        System.out.println("\nEquipos:\n");
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }

        // Ejemplo de uso: obtener un equipo por nombre
        Equipo equipoObtenido = dao.obtenerEquipo("amarillos");
        System.out.println("\nEquipo obtenido: \n" + equipoObtenido);

        // Ejemplo de uso: actualizar un equipo
        if (equipoObtenido != null) {
            equipoObtenido.setCiudad("San Francisco");
            dao.actualizarEquipo(equipoObtenido);
            System.out.println("\nEquipo actualizado: \n" + dao.obtenerEquipo("amarillos"));
        }

        // Ejemplo de uso: eliminar un equipo
        dao.eliminarEquipo("amarillos");
        System.out.println("\nEquipo eliminado. Lista de equipos:\n");
        equipos = dao.obtenerTodosEquipos();
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }
}
