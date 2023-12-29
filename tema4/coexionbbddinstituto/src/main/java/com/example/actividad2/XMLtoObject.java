package com.example.actividad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoObject<T> {

    private File xmlFile;
    private List<T> objectList;

    public XMLtoObject(String pathName) throws FileNotFoundException, JAXBException {
        this.xmlFile = new File(pathName);

        if (!xmlFile.exists()) {
            throw new FileNotFoundException("El archivo XML no existe: " + pathName);
        }

        this.objectList = new ArrayList<>();
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void deserializeXml(Class<T> type) throws JAXBException {
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(type);

            // Utilizar try-with-resources para cerrar automáticamente el Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                // Deserializar el XML a objetos Java
                Object rootObject = jaxbUnmarshaller.unmarshal(xmlFile);

                if (rootObject instanceof List) {
                    objectList = (List<T>) rootObject;
                } else {
                    objectList.add((T) rootObject);
                }
                
            
        } catch (JAXBException e) {
            // Puedes lanzar una excepción personalizada o manejarla de manera específica según tus necesidades
            e.printStackTrace();
            throw e;
        }
    }
}
