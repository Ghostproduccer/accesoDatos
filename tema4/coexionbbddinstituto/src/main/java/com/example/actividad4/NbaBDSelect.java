package com.example.actividad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.example.pojo.nba.*;

public class NbaBDSelect {

    private String nbaBD = "bbdd nba";

    public NbaBDSelect() {

    }

    public List<Equipo> consultarEquipos() {

        List listaEquipos = new ArrayList<Equipo>();

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/nba3";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * " +
                    "FROM equipos;";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                String nombreEquipo = rs.getString("nombre");

                String ciudad = rs.getString("ciudad");

                String conferencia = rs.getString("conferencia");

                String division = rs.getString("division");

                listaEquipos.add(new Equipo(nombreEquipo, ciudad, conferencia, division));

            }
            if (listaEquipos.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return listaEquipos;
    }

    public List<Jugador> consultarJugadores() {

        List<Jugador> listaJugadores = new ArrayList<Jugador>();

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/nba3";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * " +
                    "FROM jugadores;";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");

                String nombre = rs.getString("nombre");

                String procedencia = rs.getString("procedencia");

                String altura = rs.getString("altura");

                int peso = rs.getInt("peso");

                String posicion = rs.getString("posicion");

                String nombreEquipo = rs.getString("nombre_equipo");

                listaJugadores.add(new Jugador(codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo));

            }
            if (listaJugadores.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return listaJugadores;
    }

    public List<Partido> consultarPartidos() {

        List<Partido> listaPartidos = new ArrayList<Partido>();

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/nba3";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * " +
                    "FROM partidos;";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                Integer codigo = rs.getInt("codigo");

                String equipoLocal = rs.getString("equipo_local");

                String equipoVisitante = rs.getString("equipo_visitante");

                int puntosLocal = rs.getInt("puntos_local");

                int puntosVisitante = rs.getInt("puntos_visitante");

                String temporada = rs.getString("temporada");

                listaPartidos.add(
                        new Partido(codigo, equipoLocal, equipoVisitante, puntosLocal, puntosVisitante, temporada));

            }
            if (listaPartidos.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return listaPartidos;
    }

    public List<Estadistica> consultarEstadisticas() {

        List<Estadistica> listaEstadisticas = new ArrayList<Estadistica>();

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/nba3";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * " +
                    "FROM estadisticas;";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                String temporada = rs.getString("temporada");

                Integer jugador = rs.getInt("jugador");

                int puntosPartido = rs.getInt("puntos_por_partido");

                int asistenciasPartido = rs.getInt("asistencias_por_partido");

                int taponesPartido = rs.getInt("tapones_por_partido");

                int rebotesPartido = rs.getInt("rebotes_por_partido");

                listaEstadisticas.add(
                        new Estadistica(temporada, jugador, puntosPartido, asistenciasPartido, taponesPartido,
                                rebotesPartido));

            }
            if (listaEstadisticas.isEmpty()) {
                System.out.println("La consulta no ha devuelto ningún resultado.");
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return listaEstadisticas;
    }

}
