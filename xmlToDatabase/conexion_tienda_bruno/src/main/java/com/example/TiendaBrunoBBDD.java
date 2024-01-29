package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    public void realizarPedido(Vinilos vinilos, User cliente) {
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            // primero actualizar el stock de los vinilos seleccionados y realizar el
            // seguimiento de la cantidad
            Map<Integer, Integer> cantidadPorVinilo = new HashMap<>();
            for (Vinilo vinilo : vinilos.getVinilos()) {
                int nuevoStock = vinilo.getStock() - 1;
                String sqlUpdate = "UPDATE vinilos SET stock = ? WHERE id_vinilo = ?;";
                try (PreparedStatement updateStatement = con.prepareStatement(sqlUpdate)) {
                    updateStatement.setInt(1, nuevoStock);
                    updateStatement.setInt(2, vinilo.getIdVinilo());
                    updateStatement.executeUpdate();
                    System.out.println("Stock del vinilo " + vinilo.getIdVinilo() + " Actualizado a " + nuevoStock);

                    // Realizar el seguimiento de la cantidad por vinilo
                    int cantidadActual = cantidadPorVinilo.getOrDefault(vinilo.getIdVinilo(), 0);
                    cantidadPorVinilo.put(vinilo.getIdVinilo(), cantidadActual + 1);
                }
            }

            // despues añadir un nuevo pedido
            LocalDate fechaActual = LocalDate.now();
            String sqlInsertPedido = "INSERT INTO pedidos (id_user, fecha_pedido, estado) VALUES (?, ?, 'En proceso');";
            try (PreparedStatement insertPedidoStatement = con.prepareStatement(sqlInsertPedido,
                    Statement.RETURN_GENERATED_KEYS)) {
                insertPedidoStatement.setInt(1, cliente.getIdUser());
                insertPedidoStatement.setDate(2, java.sql.Date.valueOf(fechaActual));
                insertPedidoStatement.executeUpdate();

                // Obtener el ID del pedido recién insertado
                int idPedido = -1;
                try (ResultSet generatedKeys = insertPedidoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idPedido = generatedKeys.getInt(1);

                        // Añadir detalles del pedido
                        String sqlInsertDetallePedido = "INSERT INTO detalles_pedido (id_pedido, id_vinilo, cantidad) VALUES (?, ?, ?);";
                        try (PreparedStatement insertDetallePedidoStatement = con
                                .prepareStatement(sqlInsertDetallePedido)) {
                            for (Vinilo vinilo : vinilos.getVinilos()) {
                                int cantidad = cantidadPorVinilo.get(vinilo.getIdVinilo());
                                insertDetallePedidoStatement.setInt(1, idPedido);
                                insertDetallePedidoStatement.setInt(2, vinilo.getIdVinilo());
                                insertDetallePedidoStatement.setInt(3, cantidad);
                                insertDetallePedidoStatement.executeUpdate();
                                System.out.println("Detalle de pedido añadido para el vinilo " + vinilo.getIdVinilo()
                                        + " con cantidad " + cantidad);
                            }
                        }
                    } else {
                        System.out.println("No se pudo obtener el ID del pedido recién insertado");
                    }
                }
            }

            // Confirmar la transacción
            con.commit();
            con.setAutoCommit(true);
            System.out.println("Pedido añadido correctamente.");

            con.close();

        } catch (SQLException e) {
            // Manejo de excepciones
            try {
                if (con != null) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

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

    public List<User> listarUsuarios() {

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

        List<Vinilo> vinilosInsert = xmLtoList.getVinilosfromXML(vinilosPath);

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
                sbCadena.append(" VALUES ('" + nombre + "', '" + artista + "', '" + genero + "' , " + anoLanzamiento
                        + ", " + precio + ", " + stock + ")");
                System.out.println("Sentencia a ejecutar: " + sbCadena);

                /* Ejecutamos el Insert */
                sentencia.executeUpdate(sbCadena.toString());
            }
            System.out.println("Se han insertado " + vinilosInsert.size() + " vinilos en la base de datos\n");

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
        String xmlPath = xmLtoList.getXmlPath() + "backup_vinilos_" + fechaActual.toString() + ".xml";

        xmLtoList.setVinilosToXML(xmlPath, vinilos);
    }

    public Vinilo consultarVinilo(Integer idVinilo) {
        Vinilo vinilo = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * from vinilos WHERE id_vinilo = " + idVinilo + ";";
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            String nombre;
            String artista;
            String genero;
            Integer anoLanzamiento;
            Double precio;
            Integer stock;

            while (rs.next()) {
                nombre = rs.getString("nombre");
                artista = rs.getString("artista");
                genero = rs.getString("genero");
                anoLanzamiento = rs.getInt("ano_lanzamiento");
                precio = rs.getDouble("precio");
                stock = rs.getInt("stock");

                vinilo = new Vinilo(idVinilo, nombre, artista, genero, anoLanzamiento, precio, stock);
            }

            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vinilo;
    }

    public void modificarPrecioVinilo(Vinilo vinilo, Scanner sc) {
        System.out.println("El precio actual es " + vinilo.getPrecio() + " , introduzca el nuevo importe:");
        String nuevoPrecio = sc.nextLine();
        try {
            con = DriverManager.getConnection(url, username, password);
            StringBuffer sql = new StringBuffer();
            sql.append(
                    "UPDATE vinilos SET precio = " + nuevoPrecio + " WHERE id_vinilo = '" + vinilo.getIdVinilo() + "'");
            System.out.println("Sentencia a ejecutar: " + sql);

            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql.toString());
            System.out.println("Precio Actualizado");

            sentencia.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
