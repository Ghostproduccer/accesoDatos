package act6Banco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import act3RegistroTemperaturas.RegistroTemperatura;

public class BancoBruno {
    
    private static List<Cliente> listaClientes = new ArrayList<>();
    
    public static void main(String[] args) {
        
        //creamos 20 clientes de ejemplo
        for(int i = 0; i < 20; i++) {
            Date fechaNacimiento = new Date(20010101);
            listaClientes.add(new Cliente("2968773"+i+"T", "Cliente"+i, fechaNacimiento, 1000));
        }

        //guardamos los clientes en clientes.txt
        guardarRegistrosEnArchivo("src\\act4Banco\\clientes.txt", listaClientes);

        //recuperamos la lista de clientes desde el archivo y los mostramos por pantalla
        List<Cliente> listaCLientesRecuperados = cargarRegistrosDesdeArchivo("src\\act4Banco\\clientes.txt");

        for (Cliente cliente : listaCLientesRecuperados) {
            System.out.println(cliente);
        }
    }

    private static void guardarRegistrosEnArchivo(String archivo, List<Cliente> listaClientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listaClientes);
        } catch (IOException e) {
            System.err.println("Error al guardar registros en el archivo.");
        }
    }

    private static List<Cliente> cargarRegistrosDesdeArchivo(String archivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            clientes = (List<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            // El archivo aún no existe, se creará cuando se guarden registros
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar registros desde el archivo.");
        }
        return clientes;
    }
}
