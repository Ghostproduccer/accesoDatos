package com.example.insertSelectInstituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInstituto {
    public static void main(String[] args) {

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/instituto";

        try {
            con = DriverManager.getConnection(url, "alumno", "0123456789");
            sentencia = con.createStatement();

            /* datos a insertar */
            String sNombreAlumno = "juanita";
            String sFecha = "10-12-2000";
            double dMedia = 8;
            String sCurso = "DAM1";

            /* sentencia a insertar **cuidado con las comillas */
            StringBuffer sbCadena = new StringBuffer();
            sbCadena.append("insert into alumnos (nombre, fnac, media, curso) ");
            sbCadena.append(" VALUES ('" + sNombreAlumno + "', '" + sFecha + "', " + dMedia + ",'" + sCurso + "')");
            System.out.println("Sentencia a ejecutar: " + sbCadena);

            /* Ejecutamos el Insert */
            sentencia.executeUpdate(sbCadena.toString());
            System.out.println("Se ha insertado el nuevo alumno en la base de datos");
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