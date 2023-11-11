package com.transportesBruno.pojoBruno;

import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "provincia")
@XmlType(propOrder = { "nombre", "codProvincia" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Provincia {
    @XmlElement(name = "nombre")
    private String nombreProvincia;
    @XmlElement(name = "codigo")
    private String codProvincia;

    // getters y setters
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    // toString
    @Override
    public String toString() {
        return "Provincia [nombreProvincia=" + nombreProvincia + ", codProvincia=" + codProvincia + "]";
    }

}