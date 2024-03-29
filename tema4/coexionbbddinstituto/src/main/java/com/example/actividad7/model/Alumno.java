package com.example.actividad7.model;


public class Alumno {

    private Integer num;

    private String nombre;

    private String fnac;

    private Float media;

    private String curso;

    // Constructores y getters/setters

    public Alumno() {
    }

    public Alumno(Integer num, String nombre, String fnac, Float media, String curso) {
        this.num = num;
        this.nombre = nombre;
        this.fnac = fnac;
        this.media = media;
        this.curso = curso;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "----------\nnum=" + num + "\n Nombre=" + nombre + "\n Fecha de Nacimiento=" + fnac + "\n Media=" + media
                + "\n Curso=" + curso
                + "\n----------\n";
    }

}
