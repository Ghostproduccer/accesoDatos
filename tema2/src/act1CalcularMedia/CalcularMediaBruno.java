package act1CalcularMedia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CalcularMediaBruno {
    public static void main(String[] args) throws Exception {

        File fileJugadores = new File("src\\calcularMedia\\jugadores.txt");
        List<String> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileJugadores))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                jugadores.add(line);
            }
         br.close();
        }

        int contador = 0;
        double sumaEdades = 0;
        double sumaAlturas = 0;

        for (String string : jugadores) {
            String[] datos = string.split(" ");
            sumaEdades += Double.parseDouble(datos[1]);
            sumaAlturas += Double.parseDouble(datos[2]);
            contador++;
        }

        double mediaEdad = calcularMediaEdad(sumaEdades, contador);
        double mediaAltura = calcularMediaAltura(sumaAlturas, contador);

        System.out.println("La media de edad de los jugadores es de " + mediaEdad + " años. Y la media de altura de "
                + mediaAltura);
    }

    public static double calcularMediaAltura(double sumaAlturas, int numeroJugadores) {
        double media = sumaAlturas / numeroJugadores;
        return media;
    }

    public static double calcularMediaEdad(double sumaEdades, int numeroJugadores) {
        double media = sumaEdades / numeroJugadores;
        return media;
    }
}
