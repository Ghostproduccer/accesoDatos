package com.actividad7Bruno;

import com.actividad7Bruno.BrunoCV.Idioma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrunoCVTest {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader fileReader = new FileReader("tema2Maven\\bruno\\src\\main\\resources\\brunoCV.json")) {
            // Leer el archivo JSON y convertirlo a la clase MinombreCV
            BrunoCV miCV = gson.fromJson(fileReader, BrunoCV.class);

            // Mostrar el contenido actual del CV
            System.out.println("CV original:");
            System.out.println(gson.toJson(miCV));

            // Cambiar el nivel de inglés de B1 a B2
            List idiomas = new ArrayList<BrunoCV.Idioma>();

            for (BrunoCV.Idioma idioma : miCV.getIdiomas()) {
                if (idioma.getIdioma().equals("English")) {
                    idioma.setNivel("B2");
                }
            }

            // Guardar el CV actualizado en el mismo archivo JSON
            try (FileWriter fileWriter = new FileWriter("tema2Maven\\bruno\\src\\main\\resources\\brunoCV.json")) {
                gson.toJson(miCV, fileWriter);
            }

            // Mostrar el CV actualizado
            System.out.println("\nCV actualizado:");
            System.out.println(gson.toJson(miCV));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
