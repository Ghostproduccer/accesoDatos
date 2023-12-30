-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS nba_database;

-- Usar la base de datos recién creada
USE nba_database;

-- Crear la tabla para equipos
CREATE TABLE IF NOT EXISTS equipos (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_equipo VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    conferencia VARCHAR(50),
    division VARCHAR(50)
);

-- Crear la tabla para jugadores
CREATE TABLE IF NOT EXISTS jugadores (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre_jugador VARCHAR(255) NOT NULL,
    posicion VARCHAR(50),
    fecha_nacimiento DATE,
    id_equipo INT,
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo)
);

-- Crear la tabla para partidos
CREATE TABLE IF NOT EXISTS partidos (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    equipo_local_id INT,
    equipo_visitante_id INT,
    puntos_local INT,
    puntos_visitante INT,
    FOREIGN KEY (equipo_local_id) REFERENCES equipos(id_equipo),
    FOREIGN KEY (equipo_visitante_id) REFERENCES equipos(id_equipo)
);

-- Crear la tabla para estadísticas de jugadores en partidos
CREATE TABLE IF NOT EXISTS estadisticas_jugadores (
    id_estadistica INT AUTO_INCREMENT PRIMARY KEY,
    id_partido INT,
    id_jugador INT,
    puntos INT,
    rebotes INT,
    asistencias INT,
    FOREIGN KEY (id_partido) REFERENCES partidos(id_partido),
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador)
);
