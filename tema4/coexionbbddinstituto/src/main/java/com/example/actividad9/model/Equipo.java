package com.example.actividad9.model;

public class Equipo {

    private String nombreEquipo;

    private String ciudad;

    private String conferencia;

    private String division;

    // Constructores, getters y setters

    public Equipo(String nombreEquipo, String ciudad, String conferencia, String division) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
    }

    public Equipo() {
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    // toString()

    @Override
    public String toString() {
        return "Equipo [nombreEquipo=" + nombreEquipo + ", ciudad=" + ciudad
                + ", conferencia=" + conferencia + ", division=" + division + "]";
    }

}

