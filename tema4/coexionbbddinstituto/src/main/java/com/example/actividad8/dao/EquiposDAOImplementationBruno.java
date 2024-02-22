package com.example.actividad8.dao;

// package com.example.actividad8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.actividad8.model.Equipo;
import com.example.actividad8.util.DatabaseConnection;

public class EquiposDAOImplementationBruno implements EquiposDAOBruno {

    @Override
    public void insertarEquipo(Equipo equipo) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO equipos (nombre, ciudad, conferencia, division) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getCiudad());
            statement.setString(3, equipo.getConferencia());
            statement.setString(4, equipo.getDivision());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEquipo(Equipo equipo) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE equipos SET ciudad = ?, conferencia = ?, division = ? WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, equipo.getCiudad());
            statement.setString(2, equipo.getConferencia());
            statement.setString(3, equipo.getDivision());
            statement.setString(4, equipo.getNombreEquipo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEquipo(String nombre) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM equipos WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo obtenerEquipo(String nombre) {
        Equipo equipo = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM equipos WHERE nombre = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                equipo = new Equipo(resultSet.getString("nombre"),
                                            resultSet.getString("ciudad"),
                                            resultSet.getString("conferencia"),
                                            resultSet.getString("division"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }

    @Override
    public List<Equipo> obtenerTodosEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM equipos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Equipo equipo = new Equipo(resultSet.getString("nombre"),
                                            resultSet.getString("ciudad"),
                                            resultSet.getString("conferencia"),
                                            resultSet.getString("division"));
                equipos.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }
}
