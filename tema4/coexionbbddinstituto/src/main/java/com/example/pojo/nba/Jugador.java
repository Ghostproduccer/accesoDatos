package com.example.pojo.nba;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "equipo")
@XmlAccessorType(XmlAccessType.FIELD)

public class Jugador {

    @XmlElement(required = true)
    private Integer codigo;

    @XmlElement(name = "nombre_jugador")
    private String nombre;

    @XmlElement(name = "procedencia")
    private String procedencia;

    @XmlElement(name = "altura")
    private Double altura;

    @XmlElement(name = "peso")
    private Double peso;

    @XmlElement(name = "posicion")
    private String posicion;

    @XmlElement(name = "nombre_equipo")
    private String nombreEquipo;

    public Jugador() {
    }

    public Jugador(Integer codigo, String nombre, String procedencia, Double altura, Double peso, String posicion,
            String nombreEquipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.altura = altura;
        this.peso = peso;
        this.posicion = posicion;
        this.nombreEquipo = nombreEquipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public String toString() {
        return "Jugador [codigo=" + codigo + ", nombre=" + nombre + ", procedencia=" + procedencia + ", altura="
                + altura + ", peso=" + peso + ", posicion=" + posicion + ", nombreEquipo=" + nombreEquipo + "]";
    }

}
