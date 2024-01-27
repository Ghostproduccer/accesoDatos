package com.example.actividad1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.pojo.instituto.*;

public class XMLtoAlumnos {

    private static String pathName = "coexionbbddinstituto\\src\\main\\resources\\xml\\instituto\\alumnos.xml";
    private static File xmlFile = new File(pathName);
    private static List<Alumno> listalumnos = new ArrayList<>();

    public static void main(String[] args) {
    
    listalumnos = getAlumnosfromXML();
    
    System.out.println(listalumnos);

    }

    public static List<Alumno> getAlumnosfromXML() {
        
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Alumnos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Alumnos alumnos = (Alumnos) jaxbUnmarshaller.unmarshal(xmlFile);
            listalumnos = alumnos.getAlumnos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listalumnos;
    }
}
