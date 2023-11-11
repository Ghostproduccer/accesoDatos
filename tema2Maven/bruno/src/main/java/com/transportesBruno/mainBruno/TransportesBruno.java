package com.transportesBruno.mainBruno;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.transportesBruno.pojoBruno.Empleado2;
import com.transportesBruno.pojoBruno.ListaEmpleados;

public class TransportesBruno {

    public void listarEmpleados() {
        
        try {
            //Objeto JAXBContext
            JAXBContext context = JAXBContext.newInstance(ListaEmpleados.class);

            //Objeto Unmarshmaller para leer
            Unmarshaller um = context.createUnmarshaller();

            //leemos el xml, obtenemos sus elementos y los gregamos a la listaEmpleados
            ListaEmpleados listaEmpleados = (ListaEmpleados) um.unmarshal(new File("tema2Maven\\bruno\\src\\main\\java\\com\\transportesBruno\\xmlBruno\\empleado.xml"));

            System.out.println(listaEmpleados);

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        

    }

    public void listarTodo() {
        // Implementa la lógica para listar toda la información de todos los XMLs
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

