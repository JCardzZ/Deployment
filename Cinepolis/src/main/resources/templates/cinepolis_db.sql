-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2020 a las 01:44:18
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinepolis_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banner`
--

CREATE TABLE `banner` (
  `id` bigint(20) NOT NULL,
  `archivo` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `apellido_cliente` varchar(255) DEFAULT NULL,
  `tel_cel` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_tiket` date DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `apellido_cliente`, `tel_cel`, `ciudad`, `departamento`, `direccion`, `email`, `fecha_tiket`, `nombre_cliente`) VALUES
(1, 'Alvarenga', '000001', 'Santa Rita', 'Chalatenango', 'ESPIAS', 'cardozamanuel96@gmail.com', '2020-11-22', 'NOMBRE'),
(2, 'Cardoza Cardoza', '7920-2061', 'Santa Rita', 'Chalatenango', 'El Salvador, Chalatenango, Santa Rita', 'note9dozamanuel96@gmail.com', '2020-11-22', 'NOMBRE'),
(3, 'Guevara', '7920-2061', 'Santa Rita', 'Chalatenango', 'El Salvador, Chalatenango, Santa Rita', 'cardozamanuel96@gmail.com', '2020-11-22', 'll'),
(4, 'TEST', '11111111', 'Santa Rita', 'Chalatenango', 'El Salvador, Chalatenango, Santa Rita', 'w@gmail.com', '2020-11-22', 'TEST'),
(5, 'TEST', '11111111', 'Santa Rita', 'Chalatenango', 'El Salvador, Chalatenango, Santa Rita', 'w@gmail.com', '2020-11-30', 'PRUEBA DE FECHA'),
(6, 'Cardoza Cardoza', '7920-2061', 'Santa Rita', 'Chalatenango', 'El Salvador, Chalatenango, Santa Rita', 'cardozamanuel96@gmail.com', '2020-11-23', 'Épicas, Western y otros contextos'),
(7, 'Martinez Reina', '7930-6624', 'San Rafael', 'Chalatenango', 'El Salvador, Chalatenango, Ojos de agua', 'medardo@gmail.com', NULL, 'Medardo Antonio editado'),
(8, 'axs', '23', 'sac', 'sxa', 'd', 'sxasxa@gmail.com', '2020-11-23', 'qsxawd'),
(9, 'Mejia Mejia', '0000000', 'Chalatenango', 'Chalatenango', 'Chalatenango', 'miguel@gmail.com', '2020-11-23', 'Juan Miguel'),
(10, 'Mejia Mejia', '0000000', 'Chalatenango', 'Chalatenango', 'Chalatenango', 'miguel@gmail.com', '2020-12-31', 'FECHA NEW '),
(11, 'Mejia Mejia', '0000000', 'Chalatenango', 'Chalatenango', 'Chalatenango', 'miguel@gmail.com', '2020-11-30', 'PRUEBA DE FECHA dxdd'),
(12, 'Mejia Mejia', '0000000', 'Chalatenango', 'Chalatenango', 'Chalatenango', 'miguel@gmail.com', '2020-12-31', 'PRUEBA DE FECHA PERSONALIZADA'),
(13, 'Mejia Mejia', '0000000', 'Chalatenango', 'Chalatenango', 'Chalatenango', 'miguel@gmail.com', '2020-11-29', 'PRUEBA DE INSERT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id` bigint(20) NOT NULL,
  `cantidad_items` int(11) DEFAULT NULL,
  `id_productofk` bigint(20) DEFAULT NULL,
  `id_comprafk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` bigint(20) NOT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `sinopsis` varchar(255) DEFAULT NULL,
  `trailer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funciones`
--

CREATE TABLE `funciones` (
  `id` bigint(20) NOT NULL,
  `hora` datetime DEFAULT NULL,
  `id_horario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id` int(11) NOT NULL,
  `descripcion_genero` varchar(255) DEFAULT NULL,
  `tipo_genero` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id`, `descripcion_genero`, `tipo_genero`) VALUES
(1, 'Este tipo de película son de alta tensión y contienen persecuciones y muchas peleas, además de una dirección que pone énfasis en el movimiento. Incluyen rescates, batallas, escapadas, explosiones… Su ritmo es espectacular, donde el bueno o los buenos suel', 'De acción'),
(2, 'Son películas serias, con personajes y situaciones muy realistas, parecidas a la vida cotidiana, que incluyen situaciones tensas y dramáticas, y que pueden acabar mal o no.', 'Dramáticas'),
(3, 'Las películas de terror pretenden despertar nuestro miedo con escenas chocantes, tensas y terroríficas, o bien mediante una ambientación y una dirección que producen angustia. Las películas de terror pueden incluir personajes poco realistas, como muertos ', 'De terror'),
(4, 'Las películas musicales se caracterizan por tener escenas donde los actores bailan coreografías y cantan. La historia se explica en la combinación de momentos musicales y momentos no musicales. Por ejemplo, Mary Poppins.', 'Musicales'),
(5, 'Giran en torno a situaciones fantásticas y, en muchos casos, futurísticas que pueden incluir o no viajes en el tiempo o tridimensionales. Los personajes de este género no necesariamente son humanos, sino que pueden ser robots, androides o extraterrestres.', 'Ciencia ficción'),
(6, 'Como su nombre indica, las películas de guerra incluyen historias que giran en torno a la guerra. Puesto que muchas de las películas son americanas, los soldados son, en muchos casos, de esa nacionalidad. Es posible ver operaciones militares, el entrenami', 'De guerra o bélicas'),
(7, 'Las películas del oeste se ambientan oeste americano. Es uno de los géneros cinematográficos más antiguos, y la trama suele ser casi siempre la misma. Pistoleros, caballos, mujeres hermosas, whisky, bares de la época y mucha acción. Sin embargo, sus conte', 'Películas del Oeste'),
(8, 'Estas películas contienen un contenido relacionado con asesinatos o con el crimen organizado. La trama suele incluir un homicidio o un acto criminal que, a lo largo de la película, se va esclareciendo. También reciben el nombre de películas de suspense o ', 'Crimen (Suspense)'),
(9, 'Son películas para niños. Suelen incluir personajes mágicos y no no necesariamente son personas. Algunas películas son dibujos animados y contienen animales como personajes. Aunque sean para niños, algunos adultos también disfrutan de ellas. Algunos ejemp', 'Infantiles'),
(10, 'Las películas para adultos son largometrajes con escenas de contenido adulto, ya sea por su violencia o por las escenas íntimas que se ven.', 'Adultos'),
(11, 'Las películas actuales son aquellos largometrajes que hace más o menos corto tiempo que se estrenaron y que por lo tanto se sirven de los últimos avances técnicos y tecnológicos. No son películas que estén en el cine necesariamente, pero son películas rec', 'Películas actuales'),
(12, 'Las películas antiguas son aquellas que se estrenaron hace muchos años y que al verlas nos damos cuenta de cómo avanza la tecnología, especialmente cuando son en blanco y negro y con efectos especiales que nada tienen que ver con los de las películas actu', 'Películas antiguas'),
(13, 'Los estrenos son películas muy recientes. Se engloban dentro de las películas actuales, pero hace poco que salieron a la luz. Son las más recientes y despiertan un gran interés.', 'Estrenos'),
(14, 'Los clásicos son películas que pasaron a la historia por distintos motivos, entre ellos, por sus efectos especiales innovadores o por lo mucho que han gustado. “Lo que el viento se llevó”, “Titanic” o “Rambo” son algunos ejemplos. Los clásicos son obras d', 'Clásicos'),
(15, 'Las primeras películas eran mudas, por lo que los actores no hablaban. Eran películas muy expresivas en las que se podía interpretar lo que ocurría solo con ver a los actores y leer algún texto que aparecía entre escena y escena. La mayoría de peliculas e', 'Mudas'),
(16, 'A partir del año 1927, las películas comenzaron a tener sonido. Es, entonces, cuando dieron un salto de calidad. El primer largometraje comercial que no era cine mudo fue “El cantor de jazz”.', 'Sonoras'),
(17, 'Las películas en blanco y negro son películas antiguas. Tenían este formato porque, al basarse en fotografía, no había posibilidad de filmarlas en color en esa época. Muchas películas en color han sido reestrenadas en color al cabo de unos años.', 'Películas en blanco y negro'),
(18, 'Con el avance de la tecnología las películas también fueron sofisticándose y aparecieron las películas en color.', 'Películas en color'),
(19, 'Si alguna vez has visto “Las Aventuras de Indiana Jones” sabrás de lo que hablo con este género. Estas películas cuentan historias interesantes y excitantes en contextos normalmente exóticos, y con un contenido similar al de las películas de acción. Suele', 'De aventuras ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` bigint(20) NOT NULL,
  `fecha_pelicula` datetime DEFAULT NULL,
  `hora_pelicula` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `sala` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id` bigint(20) NOT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `clasificacion` varchar(255) DEFAULT NULL,
  `destacada` int(11) DEFAULT NULL,
  `directores` varchar(255) DEFAULT NULL,
  `duracion` varchar(255) DEFAULT NULL,
  `estatus` varchar(255) DEFAULT NULL,
  `fechaestreno` datetime DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `imagen_trailer` varchar(255) DEFAULT NULL,
  `precio_entrada` double DEFAULT NULL,
  `sinopsis` varchar(255) DEFAULT NULL,
  `subtitulos` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url_trailer` varchar(255) DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `actores`, `clasificacion`, `destacada`, `directores`, `duracion`, `estatus`, `fechaestreno`, `idioma`, `imagen`, `imagen_trailer`, `precio_entrada`, `sinopsis`, `subtitulos`, `titulo`, `url_trailer`, `id_genero`) VALUES
(1, NULL, 'A', 1, NULL, '140 minutos', 'Aprobada', '2020-11-29 00:00:00', 'Español', '9DYODC54849e52e6fcb2cd14482db6016f4a3a04.jpg', NULL, 5.75, NULL, 'Si', 'calabera', NULL, 1),
(2, NULL, 'A', 1, NULL, '140 minutos', 'Creada', '2020-11-18 00:00:00', 'Español', 'default.png', NULL, 1.5, NULL, 'Si', 'TESTSTTSTS', NULL, 1),
(3, NULL, 'A', 1, NULL, '140 minutos', 'Creada', '2020-11-18 00:00:00', 'Español', 'default.png', NULL, 1.5, 'sqwdefrgb', 'Si', 'TESTSTTSTS', NULL, 1),
(4, 'XXXX', 'A', 1, 'XXXXXX', '140 minutos', 'Aprobada', '2020-11-16 00:00:00', 'Español', 'DPACZM5Tsuperman.jpg', NULL, 5.75, '<p style=\"text-align: center;\"><strong><span style=\"color: #ff0000;\">Superman:</span></strong></p>\r\n<p>The Movie o simplemente Superman es una pel&iacute;cula del g&eacute;nero de superh&eacute;roes estrenada en 1978 y dirigida por Richard Donner, basada ', 'Si', 'SUPERMAN PRUEBA', 'https://www.youtube.com/watch?v=pBbsvavno8I', 13),
(5, NULL, 'B', 1, NULL, '140 minutos', 'Aprobada', '2020-11-16 00:00:00', 'Aleman', '79N2EI8Tfondo.jpg', NULL, 4.5, '<div class=\"DI6Ufb\" style=\"-webkit-box-flex: 10; flex: 1 10 0%; min-width: 0px; color: #202124; font-family: arial, sans-serif;\">\r\n<div class=\"EfDVh mod NFQFxe viOShc LKPcQc\" lang=\"es-SV\" style=\"clear: none; padding-top: 0px; border-radius: 8px; border-to', 'No', 'FONDO DE PRUEBA', NULL, 3),
(6, 'shagy', 'A', 1, 'shagy', '140 minutos', 'Aprobada', '2020-11-14 00:00:00', 'Español', '8S12I38Uel-tiempo-contigo.jpg', NULL, 1.5, '<p>shagy</p>', 'Si', 'shagy', 'https://www.youtube.com/embed/4-Mhrh3M0co', 1),
(7, 'Kathryn Newton, Uriah Shelton, Celeste O\'Connor, Vince Vaughn', 'B', 1, 'Christopher Landon', '190 minutos', 'Aprobada', '2020-12-31 00:00:00', 'Español', '32DJV1TJEste-Cuerpo-Está-Para-Matar.jpg', NULL, 4.5, '<div class=\"info\" style=\"box-sizing: border-box; padding: 30px 0px 0px; margin: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 14.44px; line-height: inherit; font-family: Montserrat, He', 'Si', 'Freaky: Este Cuerpo Está Para Matar', 'https://static.cinepolis.com/videos/35282/1/2/35282.webm', 3),
(8, 'Cameron Diaz como la Princesa Fiona.', 'A', 1, 'Mike Mitchell', '140 minutos', 'Aprobada', '2010-11-03 00:00:00', 'Español', '2PV02K15Shreck.jpg', 'default.png', 4.5, '<div class=\"mod\" lang=\"es-SV\" style=\"clear: none; padding-top: 16px; border-radius: 8px; padding-left: 16px; padding-right: 16px; color: #202124; font-family: arial, sans-serif;\" data-md=\"61\">\r\n<div class=\"LGOjhe\" style=\"overflow: hidden; padding-bottom: ', 'Si', ' Shrek para siempre ', 'https://www.youtube.com/embed/mux5z5Yn_vo', 1),
(9, 'Kathryn Newton, Uriah Shelton, Celeste O\'Connor, Vince Vaughn', 'A', 1, 'Christopher Landon', '140 minutos', 'Aprobada', '2020-11-03 00:00:00', 'Español', 'PAVZN43WIt_Eso_Banner_Latino_JPosters.jpg', 'default.png', 1.5, '<p>e3dwrf</p>', 'Si', 'marios', 'https://www.youtube.com/embed/4-Mhrh3M0co', 1),
(10, 'Octavia Spencer, Codie-Lei Eastick, Anne Hathaway, Stanley Tucci', 'A', 1, 'Robert Zemeckis', '190 minutos', 'Aprobada', '2020-11-28 00:00:00', 'Español', 'PJ3KF0RVbrujas.jpg', 'default.png', 1.5, '<div class=\"info\" style=\"box-sizing: border-box; padding: 30px 0px 0px; margin: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 14.44px; line-height: inherit; font-family: Montserrat, He', 'Si', 'Las Brujas', 'https://www.youtube.com/embed/Z6i6MHFqRr0', 1),
(11, 'fdv', 'A', 0, '112', '140 minutos', 'Creada', '2020-11-10 00:00:00', 'Español', 'default.png', 'default.png', 333, '<p>sdfv</p>', 'No', 'wsdcvf', 'https://www.youtube.com/embed/dcfv', 6),
(12, 'fdv', 'A', 0, '112', '140 minutos', 'Creada', '2020-11-10 00:00:00', 'Español', 'default.png', 'default.png', 333, '<p>sdfv</p>', 'No', 'wsdcvf', 'https://www.youtube.com/embed/dcfv', 6),
(13, 'Kang Dong Won, Lee Jung Hyun, Lee Raeas Joon Yi, Kwon Hae Hyo', 'B', 1, 'Sang-ho Yeon', '190 minutos', 'Aprobada', '2020-11-21 00:00:00', 'Español', '6Q6QTUEJzombie.jpg', 'default.png', 10.5, '<div class=\"info\" style=\"box-sizing: border-box; padding: 30px 0px 0px; margin: 0px; border: 0px; font-variant-numeric: inherit; font-variant-east-asian: inherit; font-stretch: inherit; font-size: 14.44px; line-height: inherit; font-family: Montserrat, He', 'Si', 'Estación Zombie 2: Península', 'https://www.youtube.com/embed/3pnLbDq_1bw', 3),
(14, 'Hans Zimmer y Steve Mazzaro', 'B', 1, 'Tim Hill', '190 minutos', 'Aprobada', '2020-11-21 00:00:00', 'Español', 'SUTY3H2Wesponja.jpg', 'default.png', 3.75, '<div class=\"DI6Ufb\" style=\"-webkit-box-flex: 10; flex: 1 10 0%; min-width: 0px; color: #202124; font-family: arial, sans-serif;\">\r\n<div class=\"EfDVh mod NFQFxe viOShc LKPcQc\" lang=\"es-SV\" style=\"clear: none; padding-top: 0px; border-radius: 8px; border-to', 'Si', 'Bob Esponja al rescate', 'https://www.youtube.com/embed/4-Mhrh3M0co', 1),
(15, 'Kathryn Newton, Uriah Shelton, Celeste O\'Connor, Vince Vaughn', 'A', 1, 'Genndy Tartakovsky', '140 minutos', 'Aprobada', '2020-11-27 00:00:00', 'Español', 'S2GSUUNRtransilvania.jpg', 'default.png', 9.75, '<p>&nbsp;</p>\r\n<div class=\"mod\" lang=\"es-SV\" style=\"clear: none; padding-left: 15px; padding-right: 15px; color: #202124; font-family: arial, sans-serif; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-', 'Si', 'Hotel Transylvania 2  ', 'https://www.youtube.com/embed/dPyLt_8VBX0', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, 'ROLE_ADMIN', 'ADMIN'),
(2, 'ROLE_ADMIN', 'USER'),
(3, 'ROLE_SUPERVISOR', 'SUPERVISOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tikets`
--

CREATE TABLE `tikets` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES
(1, 'cardoza@gmail.com', 'manuel', 'cardoza', '$2a$04$pNP7Sa6P1b5VnikIszsYnePSxMv4RBYk/afphtGPswPASsjj5w8U6', 'ok'),
(32, 'cardozamanuel@gmail.com', 'Manuel', 'Cardoza', '$2a$04$pNP7Sa6P1b5VnikIszsYnePSxMv4RBYk/afphtGPswPASsjj5w8U6', 'admin'),
(34, 'Usuario@gmail.com', 'Usuario', 'Usuario', '$2a$04$pNP7Sa6P1b5VnikIszsYnePSxMv4RBYk/afphtGPswPASsjj5w8U6', 'user'),
(47, 'sadc@gmail.com', 'wsxdecfr', 'swdef', '$2a$04$7oZRmXBUCScBx3s5jD.lleqB0fCT5OAv71my/VTlooL7Y/r4pKlRa', 'asd'),
(48, 'test@gmail.com', 'test', 'test', '$2a$04$Bqb2bEtLQDOFHa7.TCbwHeK3bmTOyQRBf12ff8SBORxpzgd.Hu8VW', 'test'),
(49, 'test@gmail.com', 'ok', 'ok', '$2a$04$WBlHnPcsOZdNZuaXmJfJfeFx7F49sQYBX2qKI/pJHBxruXlfeFtLe', 'ok'),
(50, 'juan@gmail.com', 'Juan', 'Perez', '$2a$04$xpzx268mO2QrvMX.cp/kDeBH5mtlrvjOWxAjRwXNDHDZ3Dyco4iPe', 'juan'),
(51, 'test@gmail.com', 'test', 'test', '$2a$04$sZRifJjJ2jLjdqU4Goeyve.DWEcmqoL0ZuX5dnaLTfx9uGX6zLq6m', 'test@gmail.com'),
(52, 'ana@gmail.com', 'ana', 'cardoza', '$2a$04$uMXv3MUIExBgm1Cuk/GjheExWq88SOIR6RAL.qH8CmV9LfWDAaoIG', 'ana'),
(53, 'chele@gmail.com', 'chele', 'chele', '$2a$04$2wug/itqgV75nrjcLhSzK.mU0DzjDzu4EMvekraPhEt0BrBppi3Mu', 'chele');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 2),
(32, 1),
(34, 2),
(47, 2),
(48, 1),
(49, 2),
(50, 1),
(51, 2),
(52, 2),
(53, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfutnrukcy5b4vead164urrxu6` (`id_productofk`),
  ADD KEY `FK6qev9n1bqqil31lihywvri845` (`id_comprafk`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `funciones`
--
ALTER TABLE `funciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtbbaoyeuo8l7qqcu2bf4rk69d` (`id_horario`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkmp5bgqii3j0y90q99y6xav0x` (`id_genero`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tikets`
--
ALTER TABLE `tikets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK61pd9s1ge1eqjc4sty2qrt37p` (`cliente_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banner`
--
ALTER TABLE `banner`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `funciones`
--
ALTER TABLE `funciones`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `noticias`
--
ALTER TABLE `noticias`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tikets`
--
ALTER TABLE `tikets`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `FK6qev9n1bqqil31lihywvri845` FOREIGN KEY (`id_comprafk`) REFERENCES `tikets` (`id`),
  ADD CONSTRAINT `FKfutnrukcy5b4vead164urrxu6` FOREIGN KEY (`id_productofk`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `funciones`
--
ALTER TABLE `funciones`
  ADD CONSTRAINT `FKtbbaoyeuo8l7qqcu2bf4rk69d` FOREIGN KEY (`id_horario`) REFERENCES `horarios` (`id`);

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `FKkmp5bgqii3j0y90q99y6xav0x` FOREIGN KEY (`id_genero`) REFERENCES `generos` (`id`);

--
-- Filtros para la tabla `tikets`
--
ALTER TABLE `tikets`
  ADD CONSTRAINT `FK61pd9s1ge1eqjc4sty2qrt37p` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
