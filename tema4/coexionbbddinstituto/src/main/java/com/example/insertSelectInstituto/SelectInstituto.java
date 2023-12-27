package com.example.insertSelectInstituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectInstituto {
    public static void main(String[] args) {

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/instituto";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * FROM alumnos";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                System.out.println("----------");
                // Columna num
                System.out.println("Número de alumno: " + rs.getInt("num"));
                // Columna nombre
                System.out.println("Nombre del alumno: " + rs.getString("nombre"));
                // Columna fnac
                System.out.println("Fecha nacimiento del alumno: " + rs.getString("fnac"));
                // Columna media
                System.out.println("Media del alumno: " + rs.getDouble("media"));
                // Columna curso
                System.out.println("Curso del alumno: " + rs.getString("curso"));
                System.out.println("----------");
                System.out.println();
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}