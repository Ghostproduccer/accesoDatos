-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS tienda_bruno;
USE tienda_bruno;

-- Tabla de Usuarios
CREATE TABLE users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo_electronico VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    contrasena VARCHAR(255)
);

-- Tabla de Vinilos
CREATE TABLE vinilos (
    id_vinilo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    artista VARCHAR(100),
    genero VARCHAR(50),
    ano_lanzamiento INT,
    precio DECIMAL(10, 2),
    stock INT
);

-- Tabla de Pedidos
CREATE TABLE pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    fecha_pedido DATE,
    estado VARCHAR(20),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- Tabla de Detalles del Pedido
CREATE TABLE detalles_pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_vinilo INT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_vinilo) REFERENCES vinilos(id_vinilo)
);
