package com.example.actividad3;

import java.util.List;
import java.util.Scanner;

public class MainAlumno {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        AlumnoBD bbdd = new AlumnoBD("consultaAluDAM1mnos");

        System.out.println("Introduzca el curso:");
        String curso = sc.nextLine();

        List resultado = bbdd.consultarAlumnos(curso);

        for (Object object : resultado) {

            System.out.println(object.toString());

        }

    }
}
