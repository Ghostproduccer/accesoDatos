package com.example;

import java.util.Scanner;

public class Main {

    private static TiendaBrunoBBDD bbdd = new TiendaBrunoBBDD();
    private static Scanner sc = new Scanner(System.in);
    private static final String XML_PATH = XMLConversion.getXmlPath();

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("Introduzca el nombre de la tabla:");
                    String tabla = sc.nextLine();
                    System.out.println(tabla);
                    bbdd.consultarTabla(tabla);
                    break;
                case 2:
                    System.out.println("Introduzca el id del cliente");
                    Integer id = sc.nextInt();
                    bbdd.consultarPedidos(id);
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Introduzca el nombre del archivo XML a volcar:");
                    String fileName = sc.nextLine();
                    bbdd.insertarVinilosdesdeXML(XML_PATH + fileName);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("¿Desea hacer un backup de los vinilos? s/n");
                    String siono = sc.nextLine();
                    if (siono.equals("s")) {
                        bbdd.volcarVinilosXML();
                    }
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
        System.out.println("2. Historial de pedidos por cliente");
        System.out.println("3. Modificar precio vinilo");
        System.out.println("4. Insertar vinilos desde XML");
        System.out.println("5. Backup de vinilos a XML");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
