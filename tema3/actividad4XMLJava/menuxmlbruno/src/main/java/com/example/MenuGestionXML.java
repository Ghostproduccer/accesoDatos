package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.basex.api.client.ClientSession;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.XQuery;
import org.basex.io.serial.Serializer;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.iter.Iter;
import org.basex.query.value.Value;
import org.basex.query.value.item.Item;



public class MenuGestionXML {

    static Context context = new Context();
    static Scanner scanner = new Scanner(System.in);
    static String query;

    public static void main(String[] args) throws IOException, QueryException {

        boolean exit = false;

        while (!exit) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Buscar Proyectos por Cliente");
            System.out.println("2. Buscar Empleados por Departamento");
            System.out.println("3. Buscar Proyectos sin Fecha de Fin Definida");
            System.out.println("4. Añadir Nuevo Proyecto");
            System.out.println("5. Generar Documento JSON");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    buscaProyectoCliente();
                    break;
                case 2:
                    buscaEmpleadoDepartamento();
                    break;
                case 3:
                    buscaProyectoSinFechaFin();
                    break;
                case 4:
                    agregarNuevoProyecto();
                    break;
                case 5:
                    // Lógica para generar un documento JSON basado en el documento XML
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private static void buscaProyectoSinFechaFin() throws BaseXException, QueryException, IOException {
        System.out.println("Los proyectos sin fecha de fin definida son: ");

        query = "for $proyecto in doc('menuxmlbruno\\src\\main\\resources\\xml\\Proyectos.xml')//proyecto[fecha_fin = 'Indefinida'] return $proyecto";

        String result = ejecutarQuery(query);
        System.out.println(result);

    }

    private static void buscaEmpleadoDepartamento() throws BaseXException, QueryException, IOException {
        scanner.nextLine();
        System.out.println("Introduzca el nombre del departamento");
        String departamentoBuscar = scanner.nextLine();
        query = String.format(
                "for $empleado in doc('menuxmlbruno\\src\\main\\resources\\xml\\Empleados.xml')//empleado[departamento = '%s'] "
                        +
                        "return $empleado",
                departamentoBuscar);
        String result = ejecutarQuery(query);
        System.out.println(result);
    }

    private static void buscaProyectoCliente() throws BaseXException, QueryException, IOException {
        scanner.nextLine();
        System.out.println("Introduzca el nombre del cliente");
        String clienteBuscar = scanner.nextLine();
        query = String.format(
                "for $proyecto in doc('menuxmlbruno\\src\\main\\resources\\xml\\Proyectos.xml')//proyecto[cliente = '%s'] "
                        +
                        "return data($proyecto/nombre)",
                clienteBuscar);
        String result = ejecutarQuery(query);
        System.out.println(result);
    }

    private static void agregarNuevoProyecto() throws BaseXException, IOException, QueryException {
        scanner.nextLine();

        System.out.print("Introduzca el nombre del nuevo proyecto: ");
        String nombreProyecto = scanner.nextLine();

        System.out.print("Introduzca la descripción del nuevo proyecto: ");
        String descripcionProyecto = scanner.nextLine();

        System.out.print("Introduzca la fecha de inicio del nuevo proyecto: ");
        String fechaInicioProyecto = scanner.nextLine();

        System.out.print("Introduzca la fecha de fin del nuevo proyecto (o 'Indefinida' si no hay fecha de fin): ");
        String fechaFinProyecto = scanner.nextLine();

        System.out.print("Introduzca el cliente del nuevo proyecto: ");
        String clienteProyecto = scanner.nextLine();

        System.out.print("Introduzca el ID del nuevo proyecto: ");
        int nuevoIdProyecto = scanner.nextInt();

        // Crear el nuevo elemento proyecto
        String nuevoProyectoXml = String.format(
                "<proyecto id=\"%d\"><nombre>%s</nombre><descripcion>%s</descripcion><fecha_inicio>%s</fecha_inicio><fecha_fin>%s</fecha_fin><cliente>%s</cliente></proyecto>",
                nuevoIdProyecto, nombreProyecto, descripcionProyecto, fechaInicioProyecto, fechaFinProyecto,
                clienteProyecto);

        // Añadir el nuevo proyecto al documento XML
        agregarProyectoAXml(nuevoProyectoXml);

        System.out.println("Nuevo proyecto añadido correctamente.");
    }

    private static void agregarProyectoAXml(String nuevoProyectoXml)
            throws BaseXException, QueryException, IOException {

        // Construir la consulta para insertar el nuevo proyecto
        String query = String.format(
                "insert node %s into /proyectos",
                nuevoProyectoXml);

        // Ejecutar la consulta para agregar el nuevo proyecto al documento XML
        ejecutarQuery(query);

        System.out.println("Nuevo proyecto agregado al documento XML correctamente.");

    }

    private static void generarDocumentoJSON() throws BaseXException, IOException {
        System.out.println("Generando documento JSON...");

        // Obtener datos de empleados y proyectos en formato JSON
        JSONArray empleadosArray = obtenerDatosJSON("menuxmlbruno\\src\\main\\resources\\xml\\Empleados.xml", "empleado");
        JSONArray proyectosArray = obtenerDatosJSON("menuxmlbruno\\src\\main\\resources\\xml\\Proyectos.xml", "proyecto");

        // Crear el objeto JSON principal
        JSONObject jsonPrincipal = new JSONObject();
        jsonPrincipal.put("empleados", empleadosArray);
        jsonPrincipal.put("proyectos", proyectosArray);

        // Escribir el JSON en un archivo
        try (FileWriter file = new FileWriter("resultado.json")) {
            file.write(jsonPrincipal.toJSONString());
        }

        System.out.println("Documento JSON generado correctamente. Se ha guardado en resultado.json.");
    }

    private static JSONArray obtenerDatosJSON(String archivoXml, String nombreElemento)
            throws BaseXException, QueryException, IOException {
        query = String.format("for $item in doc('%s')//%s return $item", archivoXml, nombreElemento);
        String result = ejecutarQuery(query);

        // Convertir el resultado de la consulta a un JSONArray
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(result);

        return jsonArray;
    }

    static String ejecutarQuery(String query) throws BaseXException, QueryException, IOException {
        String result = new XQuery(query).execute(context);
        return result;
    }

    static void process(final String query) throws QueryException {
        // Create a query processor
        try (QueryProcessor proc = new QueryProcessor(query, context)) {
            // Execute the query
            Value result = proc.value();

            // Print result as string.
            System.out.println(result);
        }
    }

    static void iterate(final String query) throws QueryException {
        // Create a query processor
        try (QueryProcessor proc = new QueryProcessor(query, context)) {
            // Store the pointer to the result in an iterator:
            Iter iter = proc.iter();

            // Iterate through all items and serialize
            for (Item item; (item = iter.next()) != null;) {
                System.out.println(item.toJava());
            }
        }
    }

    static void serialize(final String query) throws QueryException, IOException {
        // Create a query processor
        try (QueryProcessor proc = new QueryProcessor(query, context)) {

            // Store the pointer to the result in an iterator:
            Iter iter = proc.iter();

            // Create a serializer instance
            try (Serializer ser = proc.serializer(System.out)) {
                // Iterate through all items and serialize contents
                for (Item item; (item = iter.next()) != null;) {
                    ser.serialize(item);
                }
            }
            System.out.println();
        }
    }

}
