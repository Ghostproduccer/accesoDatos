package com.transportesBruno.pojoBruno;

import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "localidad")
@XmlType(propOrder = { "nombreLocalidad", "codLocalidad" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Localidad {
    @XmlElement(name = "nombre")
    private String nombreLocalidad;
    @XmlElement(name = "codLocalidad")
    private String codLocalidad;

    public Localidad() {
    }

    public Localidad(String nombreLocalidad, String codLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.codLocalidad = codLocalidad;
    }

    // getters y setters
    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(String codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    // toString
    @Override
    public String toString() {
        return "\nLocalidad " + nombreLocalidad + " { Código= " + codLocalidad + " }";
    }

}
