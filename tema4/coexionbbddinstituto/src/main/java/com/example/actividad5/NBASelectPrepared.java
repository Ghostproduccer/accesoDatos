package com.example.actividad5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.example.pojo.nba.*;

public class NBASelectPrepared {

    private static final String URL = "jdbc:mysql://localhost:3306/nba3";
    private static final String USERNAME = "alumno";
    private static final String PASSWORD = "0123456789";

    public NBASelectPrepared() {}

    public List<Equipo> consultarEquipos() {
        return consultarEquipos("equipos");
    }

    public List<Jugador> consultarJugadores() {
        return consultarJugadores("jugadores");
    }

    public List<Partido> consultarPartidos() {
        return consultarPartidos("partidos");
    }

    public List<Estadistica> consultarEstadisticas() {
        return consultarEstadisticas("estadisticas");
    }

    private List<Equipo> consultarEquipos(String tabla) {
        return consultarEquipoJugador(tabla, Equipo.class);
    }

    private List<Jugador> consultarJugadores(String tabla) {
        return consultarEquipoJugador(tabla, Jugador.class);
    }

    private <T> List<T> consultarEquipoJugador(String tabla, Class<T> type) {
        List<T> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + tabla;

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                if (type == Equipo.class) {
                    String nombre = rs.getString("nombre");
                    String ciudad = rs.getString("ciudad");
                    String conferencia = rs.getString("conferencia");
                    String division = rs.getString("division");
                    lista.add(type.cast(new Equipo(nombre, ciudad, conferencia, division)));
                } else if (type == Jugador.class) {
                    Integer codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String procedencia = rs.getString("procedencia");
                    String altura = rs.getString("altura");
                    int peso = rs.getInt("peso");
                    String posicion = rs.getString("posicion");
                    String nombreEquipo = rs.getString("nombre_equipo");
                    lista.add(type.cast(new Jugador(codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo)));
                }
            }

            if (lista.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    private List<Partido> consultarPartidos(String tabla) {
        List<Partido> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + tabla;

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Integer codigo = rs.getInt("codigo");
                String equipoLocal = rs.getString("equipo_local");
                String equipoVisitante = rs.getString("equipo_visitante");
                int puntosLocal = rs.getInt("puntos_local");
                int puntosVisitante = rs.getInt("puntos_visitante");
                String temporada = rs.getString("temporada");
                lista.add(new Partido(codigo, equipoLocal, equipoVisitante, puntosLocal, puntosVisitante, temporada));
            }

            if (lista.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    private List<Estadistica> consultarEstadisticas(String tabla) {
        List<Estadistica> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + tabla;

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                String temporada = rs.getString("temporada");
                Integer jugador = rs.getInt("jugador");
                int puntosPartido = rs.getInt("puntos_por_partido");
                int asistenciasPartido = rs.getInt("asistencias_por_partido");
                int taponesPartido = rs.getInt("tapones_por_partido");
                int rebotesPartido = rs.getInt("rebotes_por_partido");
                lista.add(new Estadistica(temporada, jugador, puntosPartido, asistenciasPartido, taponesPartido, rebotesPartido));
            }

            if (lista.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
