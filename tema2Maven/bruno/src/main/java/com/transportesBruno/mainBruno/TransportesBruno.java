package com.transportesBruno.mainBruno;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.transportesBruno.pojoBruno.ListaEmpleados;
import com.transportesBruno.pojoBruno.ListaLocalidades;
import com.transportesBruno.pojoBruno.ListaProvincias;
import com.transportesBruno.pojoBruno.ListaRegiones;

public class TransportesBruno {

    public ListaEmpleados listarEmpleados() {
        try {
            // Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(ListaEmpleados.class);

            // Objeto Unmarshaller para leer
            Unmarshaller um = context.createUnmarshaller();

            // devolvemos la lista despues de Leer el XML y obtener sus elementos
            return (ListaEmpleados) um.unmarshal(
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\empleado.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ListaLocalidades listarLocalidades() {
        try {
            // Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(ListaLocalidades.class);

            // Objeto Unmarshaller para leer
            Unmarshaller um = context.createUnmarshaller();

            // devolvemos la lista despues de Leer el XML y obtener sus elementos
            return (ListaLocalidades) um.unmarshal(
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\localidad.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ListaProvincias listarProvincias() {
        try {
            // Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(ListaProvincias.class);

            // Objeto Unmarshaller para leer
            Unmarshaller um = context.createUnmarshaller();

            // devolvemos la lista despues de Leer el XML y obtener sus elementos
            return (ListaProvincias) um.unmarshal(
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\provincia.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ListaRegiones listarRegiones() {
        try {
            // Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(ListaRegiones.class);

            // Objeto Unmarshaller para leer
            Unmarshaller um = context.createUnmarshaller();

            // devolvemos la lista despues de Leer el XML y obtener sus elementos
            return (ListaRegiones) um.unmarshal(
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\region.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertarNuevoEmpleado(ListaEmpleados listaActualizada) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaEmpleados.class);
            // objeto Marshaller para escribir
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // escribimos al xml
            jaxbMarshaller.marshal(listaActualizada,
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\empleado.xml"));
            System.out.println("Obj Empleado escrito a fichero");
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertarNuevaLocalidad(ListaLocalidades listaActualizada) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaLocalidades.class);
            // objeto Marshaller para escribir
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // escribimos al xml
            jaxbMarshaller.marshal(listaActualizada,
                    new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\Localidad.xml"));
            System.out.println("Obj Localidad escrito a fichero");
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
