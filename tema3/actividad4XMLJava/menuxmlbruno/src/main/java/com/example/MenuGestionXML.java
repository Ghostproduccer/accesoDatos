package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class MenuGestionXML {

    static Context context = new Context();
    static Scanner scanner = new Scanner(System.in);
    static String query;

    public static void main(String[] args) throws IOException, QueryException, TransformerException {

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

    private static void agregarNuevoProyecto() throws TransformerException {
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
        String nuevoIdProyecto = scanner.nextLine();

        // Cargar el documento XML existente
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("menuxmlbruno\\src\\main\\resources\\xml\\Proyectos.xml");

        // Obtener el elemento raíz
        Element rootElement = doc.getDocumentElement();

        // Crear un nuevo elemento proyecto
        Element nuevoProyecto = doc.createElement("proyecto");
        nuevoProyecto.setAttribute("id", nuevoIdProyecto);

        // Crear elementos hijos para el nuevo proyecto
        Element nombre = doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode(nombreProyecto));
        nuevoProyecto.appendChild(nombre);

        Element descripcion = doc.createElement("descripcion");
        descripcion.appendChild(doc.createTextNode(descripcionProyecto));
        nuevoProyecto.appendChild(descripcion);

        Element fechaInicio = doc.createElement("fecha_inicio");
        fechaInicio.appendChild(doc.createTextNode(fechaInicioProyecto));
        nuevoProyecto.appendChild(fechaInicio);

        Element fechaFin = doc.createElement("fecha_fin");
        fechaFin.appendChild(doc.createTextNode(fechaFinProyecto));
        nuevoProyecto.appendChild(fechaFin);

        Element cliente = doc.createElement("cliente");
        cliente.appendChild(doc.createTextNode(clienteProyecto));
        nuevoProyecto.appendChild(cliente);

        // Agregar el nuevo producto al elemento raíz
        rootElement.appendChild(nuevoProyecto);

        // Guardar los cambios en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;

        transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("menuxmlbruno\\src\\main\\resources\\xml\\Proyectos.xml"));
        transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Nuevo proyecto añadido correctamente.");
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
