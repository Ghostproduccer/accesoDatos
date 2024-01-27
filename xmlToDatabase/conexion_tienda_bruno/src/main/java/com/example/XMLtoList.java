package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.pojo.*;


public class XMLtoList {

    
    public List<User> getUsersfromXML(String usersPath) {
        File xmlFile = new File(usersPath);
        List<User> listaUsers = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Users users = (Users) jaxbUnmarshaller.unmarshal(xmlFile);
            listaUsers = users.getUsers();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaUsers;
    }

    public List<Vinilo> getVinilosfromXML(String vinilosPath) {
        File xmlFile = new File(vinilosPath);
        List<Vinilo> listaVinilos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Vinilos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Vinilos vinilos = (Vinilos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaVinilos = vinilos.getVinilos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaVinilos;
    }

    public List<Pedido> getPedidosfromXML(String pedidosPath) {
        File xmlFile = new File(pedidosPath);
        List<Pedido> listaPedidos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            Pedidos pedidos = (Pedidos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaPedidos = pedidos.getPedidos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaPedidos;
    }

    public List<DetallePedido> getDetallesPedidosfromXML(String detallesPedidosPath) {
        File xmlFile = new File(detallesPedidosPath);
        List<DetallePedido> listaDetallesPedidos = new ArrayList<>();
        try {
            // Crear un contexto JAXB y un unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DetallesPedidos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar el XML a objetos Java
            DetallesPedidos detallesPedidos = (DetallesPedidos) jaxbUnmarshaller.unmarshal(xmlFile);
            listaDetallesPedidos = detallesPedidos.getDetallesPedidos();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return listaDetallesPedidos;
    }
}
