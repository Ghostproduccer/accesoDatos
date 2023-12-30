package com.example.pojo.nba;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "jugadores")
@XmlAccessorType(XmlAccessType.FIELD)

public class Jugadores {

    @XmlElement(name = "jugador")
    private List<Jugador> jugadores;

    // constructor y getters setters

    public Jugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugadores() {
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
