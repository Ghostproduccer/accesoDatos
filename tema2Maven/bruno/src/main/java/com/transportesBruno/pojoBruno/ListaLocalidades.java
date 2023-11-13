package com.transportesBruno.pojoBruno;

import java.util.List;
import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "localidades")
@XmlAccessorType(XmlAccessType.FIELD)

public class ListaLocalidades {
    // atributos
    @XmlElement(name = "localidad")
    private List<Localidad> listaLocalidades;

    // getters and setters
    public List<Localidad> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<Localidad> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    // toString
    @Override
    public String toString() {
        return "ListaLocalidades [listaLocalidades=" + listaLocalidades + "]";
    }

}
