package com.example.actividad7.dao;

import com.example.actividad7.model.Alumno;
import com.example.actividad7.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Alumno> obtenerTodosAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Alumnos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Alumno alumno = new Alumno(resultSet.getInt("num"), resultSet.getString("nombre"),
                        resultSet.getString("fnac"), resultSet.getFloat("media"), resultSet.getString("curso"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public List<Alumno> obtenerAlumnosPorClase(String clase) {
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Alumnos WHERE curso = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clase);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Alumno alumno = new Alumno(resultSet.getInt("num"), resultSet.getString("nombre"),
                        resultSet.getString("fnac"), resultSet.getFloat("media"), resultSet.getString("curso"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public float obtenerNotaMediaClase(String clase) {
        List<Alumno> alumnos = obtenerAlumnosPorClase(clase);
        float totalMedia = 0;
        for (Alumno alumno : alumnos) {
            totalMedia += alumno.getMedia();
        }
        return totalMedia / alumnos.size();
    }

    public List<Alumno> obtenerAlumnosSuspensosClase(String clase) {
        List<Alumno> alumnosSuspensos = new ArrayList<>();
        List<Alumno> alumnos = obtenerAlumnosPorClase(clase);
        for (Alumno alumno : alumnos) {
            if (alumno.getMedia() < 5.0f) {
                alumnosSuspensos.add(alumno);
            }
        }
        return alumnosSuspensos;
    }
}
