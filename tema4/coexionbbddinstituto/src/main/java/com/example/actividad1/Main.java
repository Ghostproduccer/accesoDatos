package com.example.actividad1;

import java.util.List;

import com.example.actividad1.pojo.Alumno;

public class Main {
    public static void main(String[] args) {
        AlumnoBD alumnobd = new AlumnoBD("insertarxml");
        List<Alumno> alumnos = XMLtoAlumnos.getAlumnosfromXML();
        alumnobd.insertarAlumnos(alumnos);
    }
    
}
