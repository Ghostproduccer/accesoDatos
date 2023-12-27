package com.example.actividad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.actividad1.pojo.Alumno;

public class AlumnoBD {

    private String alumnoBD = "";

    public AlumnoBD(String alumnoBD) {
        this.alumnoBD = alumnoBD;
    }

    public boolean insertarAlumnos(List<Alumno> listaAlumnos) {
        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/instituto";
    
        try {
            con = DriverManager.getConnection(url, "alumno", "0123456789");
            sentencia = con.createStatement();
    
            for (Alumno alumno : listaAlumnos) {
                String sNombreAlumno = alumno.getNombre();
                String sFecha = alumno.getFnac();
                double dMedia = alumno.getMedia();
                String sCurso = alumno.getCurso();
    
                StringBuilder sbCadena = new StringBuilder();
                sbCadena.append("insert into alumnos (nombre, fnac, media, curso) ");
                sbCadena.append(" VALUES ('" + sNombreAlumno + "', '" + sFecha + "', " + dMedia + ",'" + sCurso + "')");
                System.out.println("Sentencia a ejecutar: " + sbCadena);
    
                int filasAfectadas = sentencia.executeUpdate(sbCadena.toString());
    
                if (filasAfectadas > 0) {
                    System.out.println("Se ha insertado el nuevo alumno en la base de datos");
                } else {
                    System.out.println("Error al insertar el alumno en la base de datos");
                }
            }
    
            return true; // Indicar que la inserción fue exitosa
    
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
    
        return false; // Indicar que la inserción falló
    }
}
