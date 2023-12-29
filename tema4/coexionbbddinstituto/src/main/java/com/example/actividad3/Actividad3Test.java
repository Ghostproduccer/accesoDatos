package com.example.actividad3;

import com.example.pojo.instituto.Alumnos;

public class Actividad3Test {

    public static void main(String[] args) {

        AlumnoBD bbdd = new AlumnoBD("consultaAluDAM1mnos");

        String curso = "DAM2";

        // Realizar consulta
        Alumnos alumnos = new Alumnos(bbdd.consultarAlumnos(curso));

        // volcar alumnos a xml
        bbdd.volcaraXML(alumnos);

    }
}
