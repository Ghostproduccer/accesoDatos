package com.example.pojo.nba;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "equipos")
@XmlAccessorType(XmlAccessType.FIELD)

public class Equipos {

    @XmlElement(name = "equipo")
    private List<Equipo> equipos;

    public Equipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
