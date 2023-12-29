package com.example.actividad2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoObjectListantiguo<T> {

    private File xmlFile;
    private List<T> objectList = new ArrayList<>();

    public XMLtoObjectListantiguo(String pathName, Class<T> type) {
        this.xmlFile = new File(pathName);
        this.objectList = getObjectsFromXML(type);
    }

    public List<T> getObjectList() {
        return objectList;
    }

    private List<T> getObjectsFromXML(Class<T> type) {
        List<T> objects = new ArrayList<>();

        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Object rootObject = jaxbUnmarshaller.unmarshal(xmlFile);

            if (rootObject instanceof List) {
                objects = (List<T>) rootObject;
            } else {
                objects.add((T) rootObject);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return objects;
    }
}
