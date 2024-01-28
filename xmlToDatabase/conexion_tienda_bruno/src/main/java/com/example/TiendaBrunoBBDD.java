package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.example.pojo.*;

public class TiendaBrunoBBDD {

    // Configura la conexión a tu base de datos MySQL
    private String url = "jdbc:mysql://localhost:3306/tienda_bruno";
    private String username = "alumno";
    private String password = "0123456789";
    private Connection con = null;
    private XMLConversion xmLtoList = new XMLConversion();

    public TiendaBrunoBBDD() {
    }

    public void consultarTabla(String tabla) {

        if (tabla.equals("users")) {

            System.out.println(listarUsuarios());

        }
        if (tabla.equals("vinilos")) {

            System.out.println(listarVinilos().getVinilos());

        }
        if (tabla.equals("pedidos")) {

            System.out.println(listarPedidos());

        }
        if (tabla.equals("detalles_pedido")) {

            System.out.println(listarDetallesPedido());

        }
    }

    public void consultarPedidos(Integer idCliente) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT " +
                    "users.nombre AS nombre_usuario, " +
                    "users.apellido, " +
                    "pedidos.id_pedido, " +
                    "pedidos.fecha_pedido, " +
                    "vinilos.id_vinilo, " +
                    "vinilos.nombre AS nombre_vinilo, " +
                    "vinilos.artista, " +
                    "detalles_pedido.cantidad, " +
                    "detalles_pedido.precio_unitario " +
                    "FROM " +
                    "pedidos " +
                    "JOIN users ON pedidos.id_user = users.id_user " +
                    "JOIN detalles_pedido ON pedidos.id_pedido = detalles_pedido.id_pedido " +
                    "JOIN vinilos ON detalles_pedido.id_vinilo = vinilos.id_vinilo " +
                    "WHERE " +
                    "pedidos.id_user = "+idCliente+";";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                String nombreUsuario = rs.getString("nombre_usuario");
                String apellido = rs.getString("apellido");
                int idPedido = rs.getInt("id_pedido");
                String fechaPedido = rs.getString("fecha_pedido");
                int idVinilo = rs.getInt("id_vinilo");
                String nombreVinilo = rs.getString("nombre_vinilo");
                String artista = rs.getString("artista");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");

                System.out.println("Usuario: " + nombreUsuario + " " + apellido);
                System.out.println("Pedido ID: " + idPedido);
                System.out.println("Fecha de Pedido: " + fechaPedido);
                System.out.println("Detalle del Vinilo:");
                System.out.println("   - ID del Vinilo: " + idVinilo);
                System.out.println("   - Nombre del Vinilo: " + nombreVinilo);
                System.out.println("   - Artista: " + artista);
                System.out.println("   - Cantidad: " + cantidad);
                System.out.println("   - Precio Unitario: " + precioUnitario);
                System.out.println("---------------------------------------");
            }

            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private Vinilos listarVinilos() {

        List<Vinilo> vinilos = new ArrayList<>();
        Vinilos result = new Vinilos();

        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM vinilos;";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            Integer idVinilo;
            String nombre;
            String artista;
            String genero;
            Integer anoLanzamiento;
            Double precio;
            Integer stock;

            while (rs.next()) {
                idVinilo = rs.getInt("id_vinilo");
                nombre = rs.getString("nombre");
                artista = rs.getString("artista");
                genero = rs.getString("genero");
                anoLanzamiento = rs.getInt("ano_lanzamiento");
                precio = rs.getDouble("precio");
                stock = rs.getInt("stock");

                Vinilo vinilo = new Vinilo(idVinilo, nombre, artista, genero, anoLanzamiento, precio, stock);

                vinilos.add(vinilo);
            }
            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result.setVinilos(vinilos);
        return result;
    }

    private List<User> listarUsuarios() {

        List<User> usuarios = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users;";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            Integer idUser;
            String nombre;
            String apellido;
            String email;
            String direccion;
            String telefono;
            String contrasena;

            while (rs.next()) {
                idUser = rs.getInt("id_user");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                email = rs.getString("email");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                contrasena = rs.getString("contrasena");

                User user = new User(idUser, nombre, apellido, email, direccion, telefono, contrasena);

                usuarios.add(user);
            }
            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usuarios;
    }

    private List<Pedido> listarPedidos() {

        List<Pedido> pedidos = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM pedidos;";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            Integer idPedido;
            Integer idUser;
            String fechaPedido;
            String estado;

            while (rs.next()) {
                idPedido = rs.getInt("id_pedido");
                idUser = rs.getInt("id_user");
                fechaPedido = rs.getString("fecha_pedido");
                estado = rs.getString("estado");

                Pedido pedido = new Pedido(idPedido, idUser, fechaPedido, estado);

                pedidos.add(pedido);
            }
            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pedidos;
    }

    private List<DetallePedido> listarDetallesPedido() {

        List<DetallePedido> detallesPedidos = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM detalles_pedido;";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            Integer idDetalle;
            Integer idPedido;
            Integer idVinilo;
            Integer cantidad;
            Double precioUnitario;

            while (rs.next()) {
                idDetalle = rs.getInt("id_detalle");
                idPedido = rs.getInt("id_pedido");
                idVinilo = rs.getInt("id_vinilo");
                cantidad = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio_unitario");

                DetallePedido detallepedido = new DetallePedido(idDetalle, idPedido, idVinilo, cantidad,
                        precioUnitario);

                detallesPedidos.add(detallepedido);
            }
            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return detallesPedidos;
    }

    public void insertarVinilosdesdeXML(String vinilosPath) {

        List <Vinilo> vinilosInsert = xmLtoList.getVinilosfromXML(vinilosPath);

        try {
            con = DriverManager.getConnection(url, username, password);
            Statement sentencia = con.createStatement();
            
            for (Vinilo vinilo : vinilosInsert) {
            /* datos a insertar */
            String nombre = vinilo.getNombre();
            String artista = vinilo.getArtista();
            String genero = vinilo.getGenero();
            Integer anoLanzamiento = vinilo.getAnoLanzamiento();
            Double precio = vinilo.getPrecio();
            Integer stock = vinilo.getStock();


            /* sentencia a insertar **cuidado con las comillas */
            StringBuffer sbCadena = new StringBuffer();
            sbCadena.append("insert into vinilos (nombre, artista, genero, ano_lanzamiento, precio, stock) ");
            sbCadena.append(" VALUES ('" + nombre + "', '" + artista + "', '" + genero + "' , " + anoLanzamiento +", " + precio + ", " + stock +")");
            System.out.println("Sentencia a ejecutar: " + sbCadena);

            /* Ejecutamos el Insert */
            sentencia.executeUpdate(sbCadena.toString());
            System.out.println("Se han insertado los vinilos en la base de datos\n");
            }
            
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    public void volcarVinilosXML() {
        Vinilos vinilos = listarVinilos();
        LocalDate fechaActual = LocalDate.now();
        String xmlPath = xmLtoList.getXmlPath()+"backup_vinilos_"+fechaActual.toString()+".xml";

        xmLtoList.setVinilosToXML(xmlPath, vinilos);
    }

}
