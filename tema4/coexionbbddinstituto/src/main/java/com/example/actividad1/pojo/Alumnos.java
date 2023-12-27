package com.example.actividad1.pojo;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "alumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumnos {

    @XmlElement(name = "alumno")
    private List<Alumno> alumnos;

    // Constructor y getters/setters

    public Alumnos() {
    }

    public Alumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}

