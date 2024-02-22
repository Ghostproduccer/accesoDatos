package com.example.actividad6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NbaEquiposCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/nba3";
    private static final String USERNAME = "alumno";
    private static final String PASSWORD = "0123456789";

    private  final String nombre;
    private String ciudad;
    private String conferencia;
    private String division;

    public NbaEquiposCRUD(String nombre, String ciudad, String conferencia, String division) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
    }

    public String create() throws SQLException {
        String sql = "INSERT INTO equipos (nombre, ciudad, conferencia, division) VALUES (?, ?, ?, ?)";
    
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, ciudad);
            statement.setString(3, conferencia);
            statement.setString(4, division);
    
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating team failed, no rows affected.");
            }
        }
    
        return nombre;
    }
    

    public static NbaEquiposCRUD read(String nombre) throws SQLException {
        String sql = "SELECT ciudad, conferencia, division FROM equipos WHERE nombre = ?";
        NbaEquiposCRUD equipo = null;

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nombre);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    equipo = new NbaEquiposCRUD(nombre, rs.getString("ciudad"),
                            rs.getString("conferencia"), rs.getString("division"));
                }
            }
        }

        return equipo;
    }

    public void update() throws SQLException {
        String sql = "UPDATE equipos SET ciudad = ?, conferencia = ?, division = ? WHERE nombre = ?";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, this.ciudad);
            statement.setString(2, this.conferencia);
            statement.setString(3, this.division);
            statement.setString(4, this.nombre);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating team failed, no rows affected.");
            }
        }
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM equipos WHERE nombre = ?";

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nombre);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting team failed, no rows affected.");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String toString() {
        return "Equipo: {" +
                "Nombre='" + nombre + '\'' +
                ", Ciudad='" + ciudad + '\'' +
                ", Conferencia='" + conferencia + '\'' +
                ", División='" + division + '\'' +
                '}';
    }
}
