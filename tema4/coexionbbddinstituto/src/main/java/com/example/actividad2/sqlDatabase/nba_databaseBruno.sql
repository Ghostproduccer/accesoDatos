drop database if exists nba3;
CREATE DATABASE nba3;

use nba3;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
CREATE TABLE IF NOT EXISTS `equipos` (
  `Nombre` varchar(20) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `Conferencia` varchar(4) DEFAULT NULL,
  `Division` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=LATIN1;

CREATE TABLE IF NOT EXISTS `estadisticas` (
  `temporada` varchar(5) NOT NULL,
  `jugador` int(11) NOT NULL,
  `Puntos_por_partido` float DEFAULT NULL,
  `Asistencias_por_partido` float DEFAULT NULL,
  `Tapones_por_partido` float DEFAULT NULL,
  `Rebotes_por_partido` float DEFAULT NULL,
  PRIMARY KEY (`temporada`,`jugador`),
  KEY `jugador` (`jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `jugadores` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) DEFAULT NULL,
  `Procedencia` varchar(20) DEFAULT NULL,
  `Altura` varchar(4) DEFAULT NULL,
  `Peso` int(11) DEFAULT NULL,
  `Posicion` varchar(5) DEFAULT NULL,
  `Nombre_equipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `Nombre_equipo` (`Nombre_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `partidos` (
  `codigo` int(11) NOT NULL,
  `equipo_local` varchar(20) DEFAULT NULL,
  `equipo_visitante` varchar(20) DEFAULT NULL,
  `puntos_local` int(11) DEFAULT NULL,
  `puntos_visitante` int(11) DEFAULT NULL,
  `temporada` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `equipo_local` (`equipo_local`),
  KEY `equipo_visitante` (`equipo_visitante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- Filtros para la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD CONSTRAINT `estadisticas_ibfk_1` FOREIGN KEY (`jugador`) REFERENCES `jugadores` (`codigo`);

--
-- Filtros para la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`Nombre_equipo`) REFERENCES `equipos` (`Nombre`);

--
-- Filtros para la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`equipo_local`) REFERENCES `equipos` (`Nombre`),
  ADD CONSTRAINT `partidos_ibfk_2` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipos` (`Nombre`);
  
  
  
/*Borramos usuario si ya existe y lo volvemos a crear*/
DROP USER if EXISTS 'alumno'@'localhost';
SELECT user FROM mysql.user;
CREATE USER 'alumno'@'localhost' IDENTIFIED BY '0123456789';
/*Le damos permisos*/
GRANT ALL PRIVILEGES ON nba3.* TO 'alumno'@'localhost';
SELECT user FROM mysql.user;