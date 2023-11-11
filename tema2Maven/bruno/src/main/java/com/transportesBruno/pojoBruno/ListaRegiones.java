package com.transportesBruno.pojoBruno;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "regiones")
@XmlAccessorType(XmlAccessType.FIELD)

public class ListaRegiones {
    // atributos
    @XmlElement(name = "region")
    private List<Region> listaRegiones;

    // getters y setters
    public List<Region> getListaRegiones() {
        return listaRegiones;
    }

    public void setListaRegiones(List<Region> listaRegiones) {
        this.listaRegiones = listaRegiones;
    }

    // toString
    @Override
    public String toString() {
        return "ListaRegiones [listaRegiones=" + listaRegiones + "]";
    }

}
