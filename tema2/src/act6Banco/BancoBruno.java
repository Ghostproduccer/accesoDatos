package act6Banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import act6Banco.ClienteSer;

public class BancoBruno {

    private static final String file = "tema2\\src\\act6Banco\\clientes.dat";
    private static List<ClienteSer> listaClientes = cargarRegistrosDesdeArchivo(file);
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Baja cliente");
            System.out.println("3. Listar clientes (por saldo de mayor a menor)");
            System.out.println("4. Saldo medio de clientes");
            System.out.println("5. Salir");

            System.out.println("Seleccione una opción:");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    bajaCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    saldoMedioClientes();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);

    }

    private static void altaCliente() {

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("dni:");
        String dni = sc.nextLine();
        System.out.print("fecha de nacimiento");
        String fechaNac = sc.nextLine();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();
        ClienteSer cliente = new ClienteSer(dni, nombre, fechaNac, saldo);
        listaClientes.add(cliente);
        guardarRegistrosEnArchivo(listaClientes, file);
        System.out.println("Cliente añadido correctamente.");
    }

    private static void bajaCliente() {

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        ClienteSer cliente = buscarClientePorNombre(nombre);
        if (cliente != null) {
            listaClientes.remove(cliente);
            guardarRegistrosEnArchivo(listaClientes, file);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {

        Collections.sort(listaClientes, new Comparator<ClienteSer>() {
            @Override
            public int compare(ClienteSer c1, ClienteSer c2) {
                return Double.compare(c2.getSaldo(), c1.getSaldo());
            }
        });

        System.out.println("\nListado de clientes:");
        for (ClienteSer cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    private static void saldoMedioClientes() {

        double saldoTotal = 0;
        for (ClienteSer cliente : listaClientes) {
            saldoTotal += cliente.getSaldo();
        }
        double saldoMedio = saldoTotal / listaClientes.size();
        System.out.println("El saldo medio de los clientes es: " + saldoMedio);
    }

    private static ClienteSer buscarClientePorNombre(String nombre) {

        for (ClienteSer cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    private static List<ClienteSer> cargarRegistrosDesdeArchivo(String archivo) {

        List<ClienteSer> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (List<ClienteSer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Se creará uno nuevo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el archivo.");
        }
        return lista;
    }

    private static void guardarRegistrosEnArchivo(List<ClienteSer> lista, String archivo) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
}
