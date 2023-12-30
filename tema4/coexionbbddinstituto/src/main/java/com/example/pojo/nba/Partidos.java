package com.example.pojo.nba;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "partidos")
@XmlAccessorType(XmlAccessType.FIELD)

public class Partidos {

    @XmlElement(name = "partido")
    private List<Partido> partidos;

    // constructor y getters setters

    public Partidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public Partidos() {
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

}
