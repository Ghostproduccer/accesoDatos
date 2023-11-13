package com.transportesBruno.mainBruno;

import java.util.List;
import java.util.Scanner;

import com.transportesBruno.pojoBruno.ListaEmpleados;
import com.transportesBruno.pojoBruno.ListaLocalidades;
import com.transportesBruno.pojoBruno.Localidad;
import com.transportesBruno.pojoBruno.Empleado;

public class TransportesBrunoTest {
    private static Scanner scanner = new Scanner(System.in);
    private static TransportesBruno gestionTransportes = new TransportesBruno();

    public static void main(String[] args) {

        char opcion;
        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case 'a':
                    mostrarEmpleados();
                    break;
                case 'b':
                    mostrarTodo();
                    break;
                case 'c':
                    insertarNuevoEmpleado();
                    break;
                case 'd':
                    insertarNuevaLocalidad();
                    break;
                case 'e':
                    borrarEmpleado();
                    break;
                case 'f':
                    mostrarEmpleadoMasAntiguo();
                    break;
                case 'g':
                    mostrarEmpleadoMayorSalario();
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

    private static void mostrarEmpleados() {
        System.out.println("Empleados: ");
        System.out.println(gestionTransportes.listarEmpleados());
    }

    private static void mostrarTodo() {
        System.out.println("TRANSPORTES BRUNO");
        System.out.println();
        System.out.println("Empleados:\n" + gestionTransportes.listarEmpleados());
        System.out.println("Localidades:\n" + gestionTransportes.listarLocalidades());
        System.out.println("Provincias:\n" + gestionTransportes.listarProvincias());
        System.out.println("Regiones:\n" + gestionTransportes.listarRegiones());
    }

    private static void insertarNuevoEmpleado() {
        // comprobamos el id mas alto de mis empleados
        List<Empleado> empleados = gestionTransportes.listarEmpleados().getEmpleados();
        int idMasAlto = 0;
        for (Empleado empleado : empleados) {
            if (empleado.getId() > idMasAlto) {
                idMasAlto = empleado.getId();
            }
        }
        // generamos un nuevo id
        int nuevoID = idMasAlto + 1;
        scanner.nextLine();
        System.out.println("Introduzca el dni del empleado:");
        String dni = scanner.nextLine();
        System.out.println("Introduzca el nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("introduzca la fecha de nacimiento");
        String fechaNac = scanner.nextLine();
        System.out.println("Introduzca teléfono");
        String tlf = scanner.nextLine();
        System.out.println("Introduzca el salario");
        double salario = scanner.nextDouble();

        // creamos el nuevo empleado y lo añadimos al XML
        Empleado nuevoEmpleado = new Empleado(nuevoID, dni, nombre, fechaNac, tlf, salario);
        empleados.add(nuevoEmpleado);
        ListaEmpleados listaActualizada = new ListaEmpleados();
        listaActualizada.setEmpleados(empleados);
        gestionTransportes.insertarNuevoEmpleado(listaActualizada);

        System.out.println("Nuevo empleado añadido");
    }

    private static void insertarNuevaLocalidad() {
        scanner.nextLine();
        System.out.println("Introduzca el nombre de la localidad:");
        String nomLocalidad = scanner.nextLine();
        System.out.println("Introduzca el código de la localidad:");
        String codLocalidad = scanner.nextLine();
        Localidad newLocalidad = new Localidad(nomLocalidad, codLocalidad);
        List<Localidad> localidades = gestionTransportes.listarLocalidades().getListaLocalidades();
        localidades.add(newLocalidad);
        ListaLocalidades listaLocalidadesUpdate = new ListaLocalidades();
        listaLocalidadesUpdate.setListaLocalidades(localidades);
        gestionTransportes.insertarNuevaLocalidad(listaLocalidadesUpdate);

        System.out.println("Nueva localidad añadida");
    }

    private static void borrarEmpleado() {
        List<Empleado> empleados = gestionTransportes.listarEmpleados().getEmpleados();
        System.out.println("introduzca el id del empleado a borrar");
        int idDelete = scanner.nextInt();
        for (int i = empleados.size() - 1; i >= 0; i--) {
            Empleado empleado = empleados.get(i);
            if (empleado.getId().equals(idDelete)) {
                empleados.remove(i);
                break;
            }
        }
        ListaEmpleados listaActualizada = new ListaEmpleados();
        listaActualizada.setEmpleados(empleados);
        gestionTransportes.insertarNuevoEmpleado(listaActualizada);
    }

    private static void mostrarEmpleadoMasAntiguo() {
        List<Empleado> empleados = gestionTransportes.listarEmpleados().getEmpleados();
        Empleado empleadoMasAntiguo = empleados.get(0);

        for (Empleado empleado : empleados) {
            if (empleado.getId() < empleadoMasAntiguo.getId()) {
                empleadoMasAntiguo = empleado;
            }
        }
        System.out.println("El empleado mas antiguo es: " + empleadoMasAntiguo.toString());
    }

    private static void mostrarEmpleadoMayorSalario() {
        List<Empleado> empleados = gestionTransportes.listarEmpleados().getEmpleados();
        Empleado empleadoMayorSalario = empleados.get(0);

        for (Empleado empleado : empleados) {
            if (empleado.getSalarioEmpleado() > empleadoMayorSalario.getSalarioEmpleado()) {
                empleadoMayorSalario = empleado;
            }
        }
        System.out.println("El empleado con mayor salario es: " + empleadoMayorSalario.toString());
    }

}
