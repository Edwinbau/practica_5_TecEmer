# practica_5_TecEmer-- 

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `bd_almacen`

-- Estructura de tabla para la tabla `productos`
--
CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `descrip` varchar(250) NOT NULL,
  `stock` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `descrip`, `stock`) VALUES
(1, 'Celular Samsung J7', 105),
(2, 'Celular Huawe Mate 20', 73),
(3, 'Lapto i5 Sony', 55),
(4, 'Lapto i7 HP', 49),
(5, 'No hay', 0),
(6, 'Celular iPhone 11 Pro', 47);

--
-- Índices para tablas volcadas
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);
-- AUTO_INCREMENT de las tablas volcadas

-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;
