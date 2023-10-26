package act3RegistroTemperaturas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionMeteoBruno {
    public static void main(String[] args) {

        List<RegistroTemperatura> registros = cargarRegistrosDesdeArchivo("src\\act3RegistroTemperaturas\\meteo.txt");
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Menú:");
            System.out.println("1- Registrar nueva temperatura");
            System.out.println("2- Mostrar historial de registros");
            System.out.println("3- Mostrar media de temperatura");
            System.out.println("4- Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Registro de nueva temperatura
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Temperatura máxima: ");
                    int tempMaxima = scanner.nextInt();
                    System.out.print("Temperatura mínima: ");
                    int tempMinima = scanner.nextInt();
                    scanner.nextLine();

                    RegistroTemperatura nuevoRegistro = new RegistroTemperatura(ciudad, fecha, tempMaxima, tempMinima);
                    registros.add(nuevoRegistro);

                    guardarRegistrosEnArchivo("src\\act3RegistroTemperaturas\\meteo.txt", registros);
                    break;

                case 2:
                    // Mostrar historial de registros para una ciudad específica
                    System.out.print("Ciudad: ");
                    String ciudadConsulta = scanner.nextLine();
                    mostrarHistorialRegistros(registros, ciudadConsulta);
                    break;

                case 3:
                    // Calcular y mostrar la media de temperaturas para una ciudad
                    System.out.print("Ciudad: ");
                    String ciudadMedia = scanner.nextLine();
                    mostrarMediaTemperatura(registros, ciudadMedia);
                    break;

                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static List<RegistroTemperatura> cargarRegistrosDesdeArchivo(String archivo) {
        List<RegistroTemperatura> registros = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            registros = (List<RegistroTemperatura>) ois.readObject();
        } catch (FileNotFoundException e) {
            // El archivo aún no existe, se creará cuando se guarden registros
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar registros desde el archivo.");
        }
        return registros;
    }

    private static void guardarRegistrosEnArchivo(String archivo, List<RegistroTemperatura> registros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(registros);
        } catch (IOException e) {
            System.err.println("Error al guardar registros en el archivo.");
        }
    }

    // Método para mostrar el historial de registros para una ciudad
    private static void mostrarHistorialRegistros(List<RegistroTemperatura> registros, String ciudad) {
        for (RegistroTemperatura registro : registros) {
            if (registro.getCiudad().equals(ciudad)) {
                System.out.println(registro);
            }
        }
    }

    // Método para calcular y mostrar la media de temperaturas para una ciudad
    private static void mostrarMediaTemperatura(List<RegistroTemperatura> registros, String ciudad) {
        int tempMaximaTotal = 0;
        int tempMinimaTotal = 0;
        int contador = 0;

        for (RegistroTemperatura registro : registros) {
            if (registro.getCiudad().equals(ciudad)) {
                tempMaximaTotal += registro.getTempMaxima();
                tempMinimaTotal += registro.getTempMinima();
                contador++;
            }
        }

        if (contador > 0) {
            double tempMaximaMedia = (double) tempMaximaTotal / contador;
            double tempMinimaMedia = (double) tempMinimaTotal / contador;
            System.out.println("Media de temperatura en " + ciudad + ":");
            System.out.println("Temperatura máxima: " + tempMaximaMedia);
            System.out.println("Temperatura mínima: " + tempMinimaMedia);
        } else {
            System.out.println("No se encontraron registros para la ciudad especificada.");
        }
    }
}
