package com.example.actividad7.main;

import com.example.actividad7.dao.AlumnoDAO;
import com.example.actividad7.dao.AlumnoDAOImplementation;
import com.example.actividad7.model.Alumno;

import java.util.List;

public class AlumnoTest {
    public static void main(String[] args) {
        // Creamos instancia de DAO
        AlumnoDAOImplementation alumnoDAO = new AlumnoDAOImplementation();

        // Método 1: Obtener todos los alumnos de la base de datos
        System.out.println("Método 1: Obtener todos los alumnos de la base de datos");
        List<Alumno> todosAlumnos = alumnoDAO.obtenerTodosAlumnos();
        for (Alumno alumno : todosAlumnos) {
            System.out.println(alumno);
        }

        // Método 2: Obtener los alumnos de una clase específica
        System.out.println("\nMétodo 2: Obtener los alumnos de una clase específica");
        List<Alumno> alumnosClase = alumnoDAO.obtenerAlumnosPorClase("DAM1");
        for (Alumno alumno : alumnosClase) {
            System.out.println(alumno);
        }

        // Método 3: Obtener la nota media de una clase
        System.out.println("\nMétodo 3: Obtener la nota media de una clase");
        float notaMediaClase = alumnoDAO.obtenerNotaMediaClase("DAM1");
        System.out.println("Nota media de la clase CONTA1: " + notaMediaClase);

        // Método 4: Obtener los alumnos suspensos de una clase
        System.out.println("\nMétodo 4: Obtener los alumnos suspensos de una clase");
        List<Alumno> alumnosSuspensos = alumnoDAO.obtenerAlumnosSuspensosClase("DAM1");
        for (Alumno alumno : alumnosSuspensos) {
            System.out.println(alumno);
        }
    }
}


