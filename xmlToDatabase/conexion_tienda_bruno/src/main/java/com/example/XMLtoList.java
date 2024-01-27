package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.pojo.nba.*;

public class XMLtoList {

    
    public List<Equipo> getEquiposfromXML(String equiposPath) {
        File xmlFile = new File(equiposPath);
        List<Equipo> listaEquipos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Equipos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Equipos equipos = (Equipos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaEquipos = equipos.getEquipos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaEquipos;
    }

    public List<Estadistica> getEstadisticasfromXML(String estadisticas_jugadoresPath) {
        File xmlFile = new File(estadisticas_jugadoresPath);
        List<Estadistica> listaEstadisticas = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(EstadisticasJugadores.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            EstadisticasJugadores estadisticas = (EstadisticasJugadores) jaxbUnmarshaller.unmarshal(xmlFile);
            listaEstadisticas = estadisticas.getEstadisticas_jugadores();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaEstadisticas;
    }

    public List<Jugador> getJugadoresfromXML(String jugadoresPath) {
        File xmlFile = new File(jugadoresPath);
        List<Jugador> listaJugadores = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Jugadores.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Jugadores jugadores = (Jugadores) jaxbUnmarshaller.unmarshal(xmlFile);
            listaJugadores = jugadores.getJugadores();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaJugadores;
    }

    public List<Partido> getPartidosfromXML(String partidosPath) {
        File xmlFile = new File(partidosPath);
        List<Partido> listaPartidos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Partidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Partidos partidos = (Partidos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaPartidos = partidos.getPartidos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaPartidos;
    }
}
