package com.example;

import java.util.Scanner;

public class Main {

    private static TiendaBrunoBBDD bbdd = new TiendaBrunoBBDD();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nombre de la tabla:");
                    String tabla = sc.nextLine();
                    System.out.println(bbdd.consultarTabla(tabla));
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Listar tabla");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
