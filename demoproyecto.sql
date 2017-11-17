-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2017 a las 03:34:59
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `demoproyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `codCurso` int(11) NOT NULL,
  `nombCurso` varchar(45) DEFAULT NULL,
  `codDoc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codCurso`, `nombCurso`, `codDoc`) VALUES
(1, 'PHP', 1),
(2, 'JAVA', 2),
(3, 'Base de datos', 6),
(4, 'Ingles', 7),
(5, 'Administracion de Empresas', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `codDoc` int(11) NOT NULL,
  `nombDoc` varchar(45) DEFAULT NULL,
  `codCur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`codDoc`, `nombDoc`, `codCur`) VALUES
(1, 'Ernesto', 1),
(2, 'Jonatan', 2),
(5, 'Marvin', 5),
(6, 'Sergio', 3),
(7, 'Mauricio', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `codEst` int(11) NOT NULL,
  `nomEst` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`codEst`, `nomEst`) VALUES
(10, 'Diana'),
(11, 'Jaimito'),
(12, 'Daniel'),
(13, 'Jonatan'),
(14, 'Shirley'),
(15, 'Alejandro'),
(16, 'Sebastian'),
(17, 'Nikol '),
(18, 'Khata'),
(19, 'Dinas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

CREATE TABLE `matriculas` (
  `codEst` int(11) NOT NULL,
  `codCurso` int(11) NOT NULL,
  `nota` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `matriculas`
--

INSERT INTO `matriculas` (`codEst`, `codCurso`, `nota`) VALUES
(10, 1, 2.6),
(11, 2, 4.7),
(12, 3, 3.6),
(15, 4, 4.9),
(16, 5, 4),
(17, 1, 4.2),
(18, 2, 4.6),
(13, 2, 5),
(13, 1, 5),
(14, 4, 4.9),
(14, 1, 3.8);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codCurso`);

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`codDoc`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`codEst`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
