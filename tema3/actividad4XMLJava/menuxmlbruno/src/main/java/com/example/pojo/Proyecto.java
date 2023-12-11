package com.example.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {
    
    @XmlAttribute(required = true)
    private Integer id;
    
    @XmlElement(name = "nombre")
    private String nombre;
    
    @XmlElement(name = "descripcion")
    private String descripcion;
    
    @XmlElement(name = "fecha_inicio")
    private String fechaInicio;
    
    @XmlElement(name = "fecha_fin")
    private String fechaFin;
    
    @XmlElement(name = "cliente")
    private String cliente;

    // Constructores
    
    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String descripcion, String fechaInicio, String fechaFin, String cliente) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    // toString

    @Override
    public String toString() {
        return "\nProyecto: " + nombre + " {\n ID=" + id + "\n Descripción=" + descripcion + "\n Fecha de inicio=" + fechaInicio
                + "\n Fecha de fin=" + fechaFin + "\n Cliente=" + cliente + "\n}";
    }
}

