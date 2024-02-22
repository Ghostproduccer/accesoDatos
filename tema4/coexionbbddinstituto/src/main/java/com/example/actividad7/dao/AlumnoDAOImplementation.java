package com.example.actividad7.dao;

import com.example.actividad7.model.Alumno;
import com.example.actividad7.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDAOImplementation implements AlumnoDAO {

    @Override
    public void insertarAlumno(Alumno alumno) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Alumnos (nombre, fnac, media, curso) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getFnac());
            statement.setFloat(3, alumno.getMedia());
            statement.setString(4, alumno.getCurso());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Alumnos SET nombre = ?, fnac = ?, media = ?, curso = ? WHERE num = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getFnac());
            statement.setFloat(3, alumno.getMedia());
            statement.setString(4, alumno.getCurso());
            statement.setInt(5, alumno.getNum());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarAlumno(int num) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM Alumnos WHERE num = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, num);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Alumno obtenerAlumno(int num) {
        Alumno alumno = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Alumnos WHERE num = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, num);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                alumno = new Alumno(resultSet.getInt("num"), resultSet.getString("nombre"),
                        resultSet.getString("fnac"), resultSet.getFloat("media"), resultSet.getString("curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;
    }
}
