package com.example.actividad3;

public class Alumno {

    private int num;
    private String nombre;
    private String fNac;
    private double media;
    private String curso;

    public Alumno(int num, String nombre, String fNac, double media, String curso) {
        this.num = num;
        this.nombre = nombre;
        this.fNac = fNac;
        this.media = media;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "----------\nnum=" + num + "\n Nombre=" + nombre + "\n Fecha de Nacimiento=" + fNac + "\n Media=" + media
                + "\n Curso=" + curso
                + "\n----------\n";
    }

}
