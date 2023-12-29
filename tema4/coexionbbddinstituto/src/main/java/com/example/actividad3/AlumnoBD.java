package com.example.actividad3;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.pojo.instituto.Alumno;
import com.example.pojo.instituto.Alumnos;

public class AlumnoBD {

    private String alumnoBD = "";
    private String xmlPath = "coexionbbddinstituto\\src\\main\\java\\com\\example\\actividad3\\alumnos.xml";

    public AlumnoBD(String alumnoBD) {
        this.alumnoBD = alumnoBD;
    }

    public List<Alumno> consultarAlumnos(String curso) {

        List listaAlumnos = new ArrayList<Alumno>();

        Connection con = null;
        Statement sentencia;
        String url = "jdbc:mysql://localhost:3306/instituto";

        try {

            con = DriverManager.getConnection(url, "alumno", "0123456789");

            String sql = "SELECT * " +
                    "FROM alumnos " +
                    "WHERE curso = '" + curso + "';";
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                // Columna num
                Integer num = rs.getInt("num");
                // Columna nombre
                String nombre = rs.getString("nombre");
                // Columna fnac
                String fNac = rs.getString("fnac");
                // Columna media
                float media = rs.getFloat("media");
                // Columna curso
                String clase = rs.getString("curso");

                listaAlumnos.add(new Alumno(num, nombre, fNac, media, clase));

            }
            if (listaAlumnos.isEmpty()) {
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

        return listaAlumnos;
    }

    public void volcaraXML(Alumnos listaAlumnos) {
        try {
            JAXBContext context = JAXBContext.newInstance(Alumnos.class);
            // objeto Marshaller para escribir
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // escribimos al xml
            jaxbMarshaller.marshal(listaAlumnos, new File(xmlPath));
            System.out.println("Alumnos volcados a xml");
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
