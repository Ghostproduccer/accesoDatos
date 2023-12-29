package com.example.pojo.nba;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "estadistica")
@XmlAccessorType(XmlAccessType.FIELD)

public class Estadistica {

    @XmlElement(name = "temporada")
    private String temporada;

    @XmlElement(name = "jugador")
    private Integer jugador;

    @XmlElement(name = "puntos_por_partido")
    private int puntosPartido;

    @XmlElement(name = "asistencias_por_partido")
    private int asistenciasPartido;

    @XmlElement(name = "tapones_por_partido")
    private int taponesPartido;

    @XmlElement(name = "rebotes_por_partido")
    private int rebotesPartido;

    public Estadistica() {
    }

    public Estadistica(String temporada, Integer jugador, int puntosPartido, int asistenciasPartido, int taponesPartido,
            int rebotesPartido) {
        this.temporada = temporada;
        this.jugador = jugador;
        this.puntosPartido = puntosPartido;
        this.asistenciasPartido = asistenciasPartido;
        this.taponesPartido = taponesPartido;
        this.rebotesPartido = rebotesPartido;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Integer getJugador() {
        return jugador;
    }

    public void setJugador(Integer jugador) {
        this.jugador = jugador;
    }

    public int getPuntosPartido() {
        return puntosPartido;
    }

    public void setPuntosPartido(int puntosPartido) {
        this.puntosPartido = puntosPartido;
    }

    public int getAsistenciasPartido() {
        return asistenciasPartido;
    }

    public void setAsistenciasPartido(int asistenciasPartido) {
        this.asistenciasPartido = asistenciasPartido;
    }

    public int getTaponesPartido() {
        return taponesPartido;
    }

    public void setTaponesPartido(int taponesPartido) {
        this.taponesPartido = taponesPartido;
    }

    public int getRebotesPartido() {
        return rebotesPartido;
    }

    public void setRebotesPartido(int rebotesPartido) {
        this.rebotesPartido = rebotesPartido;
    }

    @Override
    public String toString() {
        return "Estadistica [temporada=" + temporada + ", jugador=" + jugador + ", puntosPartido=" + puntosPartido
                + ", asistenciasPartido=" + asistenciasPartido + ", taponesPartido=" + taponesPartido
                + ", rebotesPartido=" + rebotesPartido + "]";
    }

}
