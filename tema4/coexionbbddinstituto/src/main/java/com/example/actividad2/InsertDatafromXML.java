package com.example.actividad2;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.example.pojo.nba.*;

public class InsertDatafromXML {

    // define las rutas a los xml
    private static String equiposPath = "coexionbbddinstituto\\src\\main\\resources\\xml\\nba\\equipos.xml";
    private static String jugadoresPath = "src\\main\\resources\\xml\\nba\\jugadores.xml";
    private static String partidosPath = "src\\main\\resources\\xml\\nba\\partidos.xml";
    private static String estadisticas_jugadoresPath = "src\\main\\resources\\xml\\nba\\estadisticas_jugadores.xml";

    // Configura la conexión a tu base de datos MySQL
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/nba_database";
    private static String username = "alumno";
    private static String password = "0123456789";
    private static Connection con = null;

    // declara las listas
    private static List<Equipo> equipos;
    private static List<Estadistica> estadisticas;
    private static List<Jugador> jugadores;
    private static List<Partido> partidos;

    public static void main(String[] args) throws FileNotFoundException, JAXBException, SQLException {

        // cargamos las listas desde xml
        XMLtoObject<Equipo> xmlToObjectList;
        xmlToObjectList = new XMLtoObject<>(equiposPath);

        xmlToObjectList.deserializeXml(Equipo.class);

        equipos = xmlToObjectList.getObjectList();

        System.out.println(equipos);

        //con = DriverManager.getConnection(jdbcUrl, username, password);

    }

    private static void insertData(Connection connection, String filePath, String tableName) throws SQLException {
        // Prepara la consulta SQL para insertar desde XML
        String insertQuery = "LOAD XML LOCAL INFILE ? INTO TABLE " + tableName + " ROWS IDENTIFIED BY '<"
                + tableName.substring(0, tableName.length() - 1) + ">';";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Establece el parámetro con la ruta del archivo XML
            preparedStatement.setString(1, filePath);

            // Ejecuta la consulta
            preparedStatement.executeUpdate();
        }
    }
}
