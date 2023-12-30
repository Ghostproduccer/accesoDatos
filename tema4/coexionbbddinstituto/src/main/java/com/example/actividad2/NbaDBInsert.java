package com.example.actividad2;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.example.pojo.nba.*;

public class NbaDBInsert {

    // Configura la conexión a tu base de datos MySQL
    private static String url = "jdbc:mysql://localhost:3306/nba3";
    private static String username = "alumno";
    private static String password = "0123456789";
    private static Connection con = null;

    // metodos para la insercion
    public static void insertarEquipo(Equipo equipo) {

        Statement sentencia;

        try {

            con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO equipos (Nombre, Ciudad, Conferencia, Division)\r\n" +
                    "VALUES ('" + equipo.getNombreEquipo() + "', '" + equipo.getCiudad() + "', '"
                    + equipo.getConferencia() + "', '" + equipo.getDivision() + "');";

            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha insertado el equipo en la base de datos");

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
    }

    public static void insertarJugador(Jugador jugador) {

        Statement sentencia;

        try {

            con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO jugadores (Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo)\r\n" +
                    "VALUES ('" + jugador.getNombre() + "', '" + jugador.getProcedencia() + "', '"
                    + jugador.getAltura() + "', '" + jugador.getPeso() + "', '" + jugador.getPosicion() + "', '"
                    + jugador.getNombreEquipo() + "');";

            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha insertado el jugador en la base de datos");

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
    }

    public static void insertarPartido(Partido partido) {

        Statement sentencia;

        try {

            con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO partidos (equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada)\r\n"
                    +
                    "VALUES ('" + partido.getEquipoLocal() + "', '" + partido.getEquipoVisitante() + "', '"
                    + partido.getPuntosLocal() + "', '" + partido.getPuntosVisitante() + "', '" + partido.getTemporada()
                    + "');";

            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha insertado el partido en la base de datos");

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
    }

    public static void insertarEstadistica(Estadistica estadistica) {

        Statement sentencia;

        try {

            con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO estadisticas (temporada, jugador, Puntos_por_partido, Asistencias_por_partido, Tapones_por_partido, Rebotes_por_partido)\r\n"
                    +
                    "VALUES ('" + estadistica.getTemporada() + "', '" + estadistica.getJugador() + "', '"
                    + estadistica.getPuntosPartido() + "', '" + estadistica.getAsistenciasPartido() + "', '"
                    + estadistica.getTaponesPartido()
                    + "', '" + estadistica.getRebotesPartido() + "');";

            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha insertado la estadistica en la base de datos");

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
    }

}
