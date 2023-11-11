package com.transportesBruno.mainBruno;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.transportesBruno.pojoBruno.Empleado;
import com.transportesBruno.pojoBruno.ListaEmpleados;
import com.transportesBruno.pojoBruno.ListaLocalidades;
import com.transportesBruno.pojoBruno.ListaProvincias;
import com.transportesBruno.pojoBruno.ListaRegiones;
import com.transportesBruno.pojoBruno.Localidad;
import com.transportesBruno.pojoBruno.Provincia;
import com.transportesBruno.pojoBruno.Region;

public class TransportesBruno {

    private void listarElementos(String nombre, String rutaArchivo, Class<?> clase) {
        try {
            // Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(clase);

            // Objeto Unmarshaller para leer
            Unmarshaller um = context.createUnmarshaller();

            // Leemos el XML, obtenemos sus elementos y los agregamos a la lista
            Object listaElementos = um.unmarshal(new File(rutaArchivo));

            System.out.println(nombre + ":");
            System.out.println(listaElementos);
            System.out.println();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void listarEmpleados() {

        listarElementos("Empleados",
                "tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\empleado.xml", ListaEmpleados.class);

    }

    public void listarTodo() {

        System.out.println("Transportes Bruno:");
        System.out.println();

        listarElementos("Empleados",
                "tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\empleado.xml",
                ListaEmpleados.class);

        listarElementos("Localidades",
                "tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\localidad.xml",
                ListaLocalidades.class);

        listarElementos("Provincias",
                "tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\provincia.xml",
                ListaProvincias.class);

        listarElementos("Regiones",
                "tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\region.xml",
                ListaRegiones.class);

    }

    public void insertarNuevoEmpleado() {
        // Implementa la lógica para insertar un nuevo empleado
    }

    public void insertarNuevaLocalidad() {
        // Implementa la lógica para insertar una nueva localidad
    }

    public void borrarEmpleado() {
        // Implementa la lógica para borrar un empleado por DNI
    }

    public void mostrarEmpleadoMasAntiguo() {
        // Implementa la lógica para mostrar al empleado más antiguo
    }

    public void mostrarEmpleadoMayorSalario() {
        // Implementa la lógica para mostrar al empleado que más dinero gana
    }
}
