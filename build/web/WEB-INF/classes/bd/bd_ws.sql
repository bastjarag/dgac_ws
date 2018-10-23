-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2018 a las 14:40:22
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ws`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMultasByRut` (IN `p_rut` VARCHAR(15))  BEGIN
  SELECT * FROM MULTAS
  WHERE rut = p_rut;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeronaves`
--

CREATE TABLE `aeronaves` (
  `id` int(10) NOT NULL,
  `patente` varchar(25) NOT NULL,
  `fecha_aeronavegabilidad` timestamp NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aeronaves`
--

INSERT INTO `aeronaves` (`id`, `patente`, `fecha_aeronavegabilidad`) VALUES
(1, 'CC-WBS', '2018-09-25 20:34:44'),
(2, 'CC-JPG', '2018-09-25 20:37:51'),
(3, 'CC-CHU', '2018-09-25 20:37:51'),
(4, 'CC-PA', '2018-09-25 20:37:51'),
(5, 'CC-HPF', '2018-09-30 23:07:38'),
(6, 'CC-IIII', '2018-10-14 17:58:17'),
(7, 'CC-IIIA', '2018-10-14 17:58:43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencias`
--

CREATE TABLE `licencias` (
  `id` int(11) NOT NULL,
  `rut` varchar(10) NOT NULL,
  `nro_licencia` int(15) NOT NULL,
  `tipo_aeronave` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='tipo_aeronave: Avion/Helicoptero';

--
-- Volcado de datos para la tabla `licencias`
--

INSERT INTO `licencias` (`id`, `rut`, `nro_licencia`, `tipo_aeronave`) VALUES
(1, '19516416-9', 456445, 'Avion'),
(2, '16544449-3', 456654, 'Helicoptero'),
(3, '19516416-9', 666, 'Helicóptero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicinas`
--

CREATE TABLE `medicinas` (
  `id` int(10) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fecha_vcto` timestamp NOT NULL,
  `rut` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medicinas`
--

INSERT INTO `medicinas` (`id`, `descripcion`, `fecha_vcto`, `rut`) VALUES
(1, 'Paracetamol', '2018-10-22 22:36:36', '19516416-9');
INSERT INTO `medicinas` (`id`, `descripcion`, `fecha_vcto`, `rut`) VALUES
(2, 'Ibuprofeno', '2018-10-23 22:36:36', '16544449-3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multas`
--

CREATE TABLE `multas` (
  `id` int(10) NOT NULL,
  `rut` varchar(10) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `es_invalidante` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='es_invalidante: Si/No';

--
-- Volcado de datos para la tabla `multas`
--

INSERT INTO `multas` (`id`, `rut`, `descripcion`, `es_invalidante`) VALUES
(1, '19516416-9', 'Velocidad superior a la velocidad del sonido', 'No'),
(2, '16544449-3', 'Piloto intente volar bajo los efectos del Alcohol', 'Si'),
(3, '16544449-3', 'Piloto orina en las inmediaciones de la escuela', 'No'),
(4, '16544449-3', 'exceso de belleza', 'no');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aeronaves`
--
ALTER TABLE `aeronaves`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `licencias`
--
ALTER TABLE `licencias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `medicinas`
--
ALTER TABLE `medicinas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `multas`
--
ALTER TABLE `multas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aeronaves`
--
ALTER TABLE `aeronaves`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `licencias`
--
ALTER TABLE `licencias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `medicinas`
--
ALTER TABLE `medicinas`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `multas`
--
ALTER TABLE `multas`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
