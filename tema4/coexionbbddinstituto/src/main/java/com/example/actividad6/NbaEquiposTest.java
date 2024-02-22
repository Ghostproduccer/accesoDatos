package com.example.actividad6;

import java.sql.SQLException;

public class NbaEquiposTest {
    public static void main(String[] args) {
        try {
            // Prueba 1: Insertar nuevo equipo
            NbaEquiposCRUD miEquipo1 = new NbaEquiposCRUD("batido46", "Ciudad", "west", "Sureste");
            String equipoGenerado = miEquipo1.create();
            System.out.println("1-Create: Equipo insertado=" + equipoGenerado);

            // Prueba 2: Leer un equipo por un nombre que sabemos que existe
            NbaEquiposCRUD miEquipo2 = NbaEquiposCRUD.read("batido46");
            System.out.println("2-Read: Equipo leído: " + miEquipo2);

            // Prueba 3: Cambiar la división y actualizarlo en la base de datos
            if (miEquipo2 != null) {
                miEquipo2.setDivision("Surnorte");
                miEquipo2.update();
            } else {
                System.out.println("Equipo no encontrado para actualizar.");
            }

            // Prueba 4: Leer de nuevo y comprobar el cambio
            NbaEquiposCRUD miEquipo3 = NbaEquiposCRUD.read("batido46");
            System.out.println("3 y 4 update-read: Equipo leído tras cambio: " + miEquipo3);

            // Prueba 5: Eliminar el equipo
            if (miEquipo3 != null) {
                miEquipo3.delete();
            } else {
                System.out.println("Equipo no encontrado para eliminar.");
            }

            // Prueba 6: Intentar leer el equipo eliminado y comprobar si falla
            NbaEquiposCRUD miEquipo4 = NbaEquiposCRUD.read("batido46");
            if (miEquipo4 == null) {
                System.out.println("5 y 6 delete-read: Equipo no encontrado (eliminado correctamente)");
            } else {
                System.out.println("5 y 6 delete-read: Equipo encontrado (error)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
