package com.transportesBruno.mainBruno;

import java.util.Scanner;

public class TransportesBrunoTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TransportesBruno gestionTransportes = new TransportesBruno();

        char opcion;
        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.println("Empleados: ");
                    System.out.println(gestionTransportes.listarEmpleados());
                    break;
                case 'b':
                    System.out.println("TRANSPORTES BRUNO");
                    System.out.println();
                    System.out.println("Empleados:\n"+gestionTransportes.listarEmpleados());
                    System.out.println("Localidades:\n"+gestionTransportes.listarLocalidades());
                    System.out.println("Provincias:\n"+gestionTransportes.listarProvincias());
                    System.out.println("Regiones:\n"+gestionTransportes.listarRegiones());
                    break;
                case 'c':
                    
                    break;
                case 'd':
                    gestionTransportes.insertarNuevaLocalidad();
                    break;
                case 'e':
                    gestionTransportes.borrarEmpleado();
                    break;
                case 'f':
                    gestionTransportes.mostrarEmpleadoMasAntiguo();
                    break;
                case 'g':
                    gestionTransportes.mostrarEmpleadoMayorSalario();
                    break;
                case 'h':
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 'h');
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("a. Listar todos los empleados");
        System.out.println("b. Listar todo (muestra la información de todos los xmls)");
        System.out.println("c. Insertar nuevo empleado");
        System.out.println("d. Insertar nueva localidad");
        System.out.println("e. Borrar empleado");
        System.out.println("f. Mostrar empleado más antiguo");
        System.out.println("g. Mostrar empleado que más dinero gana");
        System.out.println("h. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
