package com.example.pojo.nba;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "estadisticas_jugadores")
@XmlAccessorType(XmlAccessType.FIELD)

public class EstadisticasJugadores {

    @XmlElement(name = "estadistica")
    private List<Estadistica> estadisticas_jugadores;

    // costructor y getters setters

    public EstadisticasJugadores(List<Estadistica> estadisticas_jugadores) {
        this.estadisticas_jugadores = estadisticas_jugadores;
    }

    public List<Estadistica> getEstadisticas_jugadores() {
        return estadisticas_jugadores;
    }

    public void setEstadisticas_jugadores(List<Estadistica> estadisticas_jugadores) {
        this.estadisticas_jugadores = estadisticas_jugadores;
    }

}
