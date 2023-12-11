package com.example.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "proyectos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyectos {

    @XmlElement(name = "proyecto")
    private List<Proyecto> proyectos;

    // Getter y setter para la lista de proyectos

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
