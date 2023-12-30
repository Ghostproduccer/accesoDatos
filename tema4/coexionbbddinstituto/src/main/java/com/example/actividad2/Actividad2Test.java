package com.example.actividad2;

import java.util.List;

import com.example.pojo.nba.*;

public class Actividad2Test {
    
    private static XMLtoList xmltolist = new XMLtoList();
    private static NbaDBInsert bbdd = new NbaDBInsert();

    // define las rutas a los xml
    private static String equiposPath = "coexionbbddinstituto\\src\\main\\resources\\xml\\nba\\equipos.xml";
    private static String jugadoresPath = "coexionbbddinstituto\\src\\main\\resources\\xml\\nba\\jugadores.xml";
    private static String partidosPath = "coexionbbddinstituto\\src\\main\\resources\\xml\\nba\\partidos.xml";
    private static String estadisticas_jugadoresPath = "coexionbbddinstituto\\src\\main\\resources\\xml\\nba\\estadisticas_jugadores.xml";


    public static void main(String[] args) {
        
        //leemos los xml
        List <Equipo> listaEquipos = xmltolist.getEquiposfromXML(equiposPath);
        List <Jugador> listaJugadores = xmltolist.getJugadoresfromXML(jugadoresPath);
        List <Partido> listaPartidos = xmltolist.getPartidosfromXML(partidosPath);
        List <Estadistica> listaEstadisticas =xmltolist.getEstadisticasfromXML(estadisticas_jugadoresPath);

        //recorremos las listas e insertamos los datos
        for (Equipo equipo : listaEquipos) {
            System.out.println(equipo);
            bbdd.insertarEquipo(equipo);
        }

        for (Jugador jugador : listaJugadores) {
            System.out.println(jugador);
            bbdd.insertarJugador(jugador);
        }

        for (Partido partido : listaPartidos) {
            System.out.println(partido);
            bbdd.insertarPartido(partido);
        }

        for (Estadistica estadistica : listaEstadisticas) {
            System.out.println(estadistica);
            bbdd.insertarEstadistica(estadistica);
        }
        
    }
    
}
