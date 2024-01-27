package com.example;

import java.sql.Connection;
import java.util.List;

public class TiendaBrunoBBDD {
    
    // Configura la conexión a tu base de datos MySQL
    private String url = "jdbc:mysql://localhost:3306/tienda_bruno";
    private String username = "alumno";
    private String password = "0123456789";
    private Connection con = null;
    
    public TiendaBrunoBBDD() {
    }

    public List<Object> consultarTabla(String tabla) {
        //TODO: IMPLEMENT
        return null;
    }
    
}
