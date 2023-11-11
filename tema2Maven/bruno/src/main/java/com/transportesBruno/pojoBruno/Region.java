package com.transportesBruno.pojoBruno;

import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "region")
@XmlType(propOrder = { "nombre", "codRegion" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Region {
    @XmlElement(name = "nombre")
    private String nombreRegion;
    @XmlElement(name = "codigo")
    private String codRegion;

    // getters y setters
    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    // toString
    @Override
    public String toString() {
        return "Region [nombreRegion=" + nombreRegion + ", codRegion=" + codRegion + "]";
    }

}
