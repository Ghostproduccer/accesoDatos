package com.example.actividad5;

import java.util.Scanner;

public class Actividad5Test {

    private static NBASelectPrepared bbdd = new NBASelectPrepared();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(bbdd.consultarEquipos());
                    break;
                case 2:
                    System.out.println(bbdd.consultarJugadores());
                    break;
                case 3:
                    System.out.println(bbdd.consultarPartidos());
                    break;
                case 4:
                    System.out.println(bbdd.consultarEstadisticas());
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Consultar tabla Equipos");
        System.out.println("2. Consultar tabla Jugadores");
        System.out.println("3. Consultar tabla Partidos");
        System.out.println("4. Consultar tabla Estadísticas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: \n");
    }
}
