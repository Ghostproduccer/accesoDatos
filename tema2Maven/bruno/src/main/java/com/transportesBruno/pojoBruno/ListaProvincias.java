package com.transportesBruno.pojoBruno;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

//anotaciones
@XmlRootElement(name = "provincias")
@XmlAccessorType(XmlAccessType.FIELD)

public class ListaProvincias {
    // atributos
    @XmlElement(name = "provincia")
    private List<Provincia> listaProvincias;

    // getters setters
    public List<Provincia> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    // toString
    @Override
    public String toString() {
        return "ListaProvincias [listaProvincias=" + listaProvincias + "]";
    }

}
