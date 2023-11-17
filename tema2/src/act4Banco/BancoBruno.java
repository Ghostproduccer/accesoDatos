package act4Banco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BancoBruno {

    private static final String file = "tema2\\src\\act4Banco\\clientes.txt";
    private static List<ClienteBruno> listaClientes = cargarRegistrosDesdeArchivo(file);
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
        System.out.print("DNI:");
        String dni = sc.nextLine();
        System.out.print("Fecha de nacimiento:");
        String fechaNac = sc.nextLine();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();
        ClienteBruno cliente = new ClienteBruno(dni, nombre, fechaNac, saldo);
        listaClientes.add(cliente);
        guardarRegistrosEnArchivo(listaClientes, file);
        System.out.println("Cliente añadido correctamente.");
    }

    private static void bajaCliente() {
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        ClienteBruno cliente = buscarClientePorNombre(nombre);
        if (cliente != null) {
            listaClientes.remove(cliente);
            guardarRegistrosEnArchivo(listaClientes, file);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {
        Collections.sort(listaClientes, new Comparator<ClienteBruno>() {
            @Override
            public int compare(ClienteBruno c1, ClienteBruno c2) {
                return Double.compare(c2.getSaldo(), c1.getSaldo());
            }
        });

        System.out.println("\nListado de clientes:");
        for (ClienteBruno cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    private static void saldoMedioClientes() {
        double saldoTotal = 0;
        for (ClienteBruno cliente : listaClientes) {
            saldoTotal += cliente.getSaldo();
        }
        double saldoMedio = saldoTotal / listaClientes.size();
        System.out.println("El saldo medio de los clientes es: " + saldoMedio);
    }

    private static ClienteBruno buscarClientePorNombre(String nombre) {
        for (ClienteBruno cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    private static List<ClienteBruno> cargarRegistrosDesdeArchivo(String archivo) {
        List<ClienteBruno> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String dni = datos[0];
                String nombre = datos[1];
                String fechaNac = datos[2];
                double saldo = Double.parseDouble(datos[3]);
                ClienteBruno cliente = new ClienteBruno(dni, nombre, fechaNac, saldo);
                lista.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        return lista;
    }

    private static void guardarRegistrosEnArchivo(List<ClienteBruno> lista, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (ClienteBruno cliente : lista) {
                bw.write(cliente.getDni() + "," + cliente.getNombre() + "," + cliente.getFechaNacimiento() + "," + cliente.getSaldo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
    }
}
