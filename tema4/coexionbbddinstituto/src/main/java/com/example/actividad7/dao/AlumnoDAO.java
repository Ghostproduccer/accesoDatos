package com.example.actividad7.dao;

import com.example.actividad7.model.Alumno;

public interface AlumnoDAO {
    void insertarAlumno(Alumno alumno);
    void actualizarAlumno(Alumno alumno);
    void eliminarAlumno(int num);
    Alumno obtenerAlumno(int num);
}

