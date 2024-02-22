package com.example.actividad7.main;

import com.example.actividad7.dao.AlumnoDAO;
import com.example.actividad7.dao.AlumnoDAOImplementation;
import com.example.actividad7.model.Alumno;

public class AlumnoTest {
    public static void main(String[] args) {
        // Creamos instancia de DAO
        AlumnoDAO alumnoDAO = new AlumnoDAOImplementation();

        // Creamos un nuevo alumno
        Alumno nuevoAlumno = new Alumno(1, "Juan", "2002-01-01", 7.6f, "DAM1");

        // Insertamos el nuevo alumno
        alumnoDAO.insertarAlumno(nuevoAlumno);

        // Obtenemos el alumno recién insertado
        Alumno alumnoObtenido = alumnoDAO.obtenerAlumno(5);
        System.out.println("Alumno obtenido (recién insertado): " + alumnoObtenido.getNombre());

        // Actualizamos el nombre del alumno
        alumnoObtenido.setNombre("Pedro");
        alumnoDAO.actualizarAlumno(alumnoObtenido);

        // Obtenemos el alumno actualizado
        Alumno alumnoActualizado = alumnoDAO.obtenerAlumno(5);
        System.out.println("Nombre actualizado: " + alumnoActualizado.getNombre());

        // Eliminamos al alumno
        alumnoDAO.eliminarAlumno(9);
        System.out.println("Alumno eliminado");

        // Intentamos obtener al alumno eliminado (debería devolver null)
        Alumno alumnoEliminado = alumnoDAO.obtenerAlumno(9);
        if (alumnoEliminado == null) {
            System.out.println("Alumno eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el alumno.");
        }
    }
}

