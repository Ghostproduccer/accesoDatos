package com.example.pojo.nba;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "partido")
@XmlAccessorType(XmlAccessType.FIELD)

public class Partido {

    @XmlElement(required = true)
    private Integer codigo;

    @XmlElement(name = "equipo_local")
    private String equipoLocal;

    @XmlElement(name = "equipo_visitante")
    private String equipoVisitante;

    @XmlElement(name = "puntos_local")
    private int puntosLocal;

    @XmlElement(name = "puntos_visitante")
    private int puntosVisitante;

    @XmlElement(name = "temporada")
    private String temporada;

    // constructor getters setters
    
    public Partido(Integer codigo, String equipoLocal, String equipoVisitante, int puntosLocal, int puntosVisitante,
            String temporada) {
        this.codigo = codigo;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.temporada = temporada;
    }

    public Partido() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Partido [codigo=" + codigo + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
                + ", puntosLocal=" + puntosLocal + ", puntosVisitante=" + puntosVisitante + ", temporada=" + temporada
                + "]";
    }

}
