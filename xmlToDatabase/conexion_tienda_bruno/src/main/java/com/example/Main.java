package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.pojo.*;

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
                    System.out
                            .println("\nIntroduzca el nombre de la tabla (vinilos, pedidos, users, detalles_pedido):");
                    String tabla = sc.nextLine();
                    bbdd.consultarTabla(tabla);
                    break;
                case 2:
                    // implement realizar pedido
                    // para pruebas
                    List<Vinilo> lista = new ArrayList<>();
                    Vinilo vinilo1 = bbdd.consultarVinilo(1);
                    Vinilo vinilo2 = bbdd.consultarVinilo(1);
                    lista.add(vinilo1);
                    lista.add(vinilo2);
                    Vinilos vinilos = new Vinilos(lista);

                    User cliente = bbdd.listarUsuarios().get(2);

                    bbdd.realizarPedido(vinilos, cliente);
                    break;
                case 3:
                    System.out.println("Introduzca el id del vinilo");
                    Integer idVinilo = sc.nextInt();
                    Vinilo vinilo = bbdd.consultarVinilo(idVinilo);
                    System.out.println(vinilo);
                    sc.nextLine();
                    System.out.println("¿Desea modificar el precio del vinilo? s/n");
                    String answer = sc.nextLine();
                    if (answer.equals("s")) {
                        bbdd.modificarPrecioVinilo(vinilo, sc);
                    }
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
        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Consultar tabla");
        System.out.println("2. Realizar pedido");
        System.out.println("3. Modificar precio vinilo");
        System.out.println("4. Insertar vinilos desde XML");
        System.out.println("5. Backup de vinilos a XML");
        System.out.println("6. Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }
}
