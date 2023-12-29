package com.example.pojo.instituto;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "alumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumnos {

    @XmlElement(name = "alumno")
    private List<Alumno> alumnos;

    // Constructor y getters/setters

    public Alumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Alumnos() {
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
