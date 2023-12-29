package com.example.actividad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.pojo.nba.Equipo;

public class NbaBD {

    private String nbaBD = "bbdd nba";

    public NbaBD() {

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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        return listaEquipos;
    }

}
