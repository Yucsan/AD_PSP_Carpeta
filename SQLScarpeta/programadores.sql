-- DROP DATABASE IF EXISTS programadores;

CREATE DATABASE programadores;
USE programadores;

CREATE TABLE programador (
  codpro VARCHAR(10) PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  telefono VARCHAR(12),
  direccion VARCHAR(50),
  ciudad VARCHAR(50),
  cp INT
);

CREATE TABLE proyecto (
  codproye INT(5) NOT NULL PRIMARY KEY,
  nombre VARCHAR(32) NOT NULL UNIQUE,
  tecnologia VARCHAR(30),
  pais VARCHAR(20)
);

CREATE TABLE empresa (
  codempre VARCHAR(6) PRIMARY KEY,
  titulo VARCHAR(80) NOT NULL,
  cif VARCHAR(12),
  codproye_FK INT(5), -- Debe coincidir con el tipo de proyecto.codproye
  codpro_FK VARCHAR(10), -- Debe coincidir con el tipo de programador.codpro
  FOREIGN KEY (codproye_FK) REFERENCES proyecto(codproye),
  FOREIGN KEY (codpro_FK) REFERENCES programador(codpro)
);

INSERT INTO programador (codpro, nombre, telefono, direccion, ciudad, cp)
VALUES
  ('P001', 'Juan Pérez', '1234567890', 'Calle Falsa 123', 'Madrid', 28001),
  ('P002', 'Ana López', '1234567891', 'Calle Sol 456', 'Barcelona', 08001),
  ('P003', 'Luis Martínez', '1234567892', 'Avenida Luna 789', 'Valencia', 46001),
  ('P004', 'María García', '1234567893', 'Plaza Mayor 101', 'Sevilla', 41001),
  ('P005', 'Pedro Sánchez', '1234567894', 'Calle Estrella 202', 'Bilbao', 48001);

INSERT INTO proyecto (codproye, nombre, tecnologia, pais)
VALUES
  (1, 'Proyecto Alpha', 'Java', 'España'),
  (2, 'Proyecto Beta', 'Python', 'España'),
  (3, 'Proyecto Gamma', 'ReactJS', 'Portugal');

INSERT INTO empresa (codempre, titulo, cif, codproye_FK, codpro_FK)
VALUES
  ('E001', 'Tech Solutions', 'CIF123456', 1, 'P001'), -- Relación inicial con proyecto 1 y programador 1
  ('E002', 'Innovatech', 'CIF654321', 3, 'P003');    -- Relación inicial con proyecto 3 y programador 3

INSERT INTO empresa (codempre, titulo, cif, codproye_FK, codpro_FK)
VALUES
  ('E001', 'Tech Solutions', 'CIF123456', 1, 'P002'), -- Programador 2
  ('E001', 'Tech Solutions', 'CIF123456', 1, 'P003'); -- Programador 3

INSERT INTO empresa (codempre, titulo, cif, codproye_FK, codpro_FK)
VALUES
  ('E001', 'Tech Solutions', 'CIF123456', 2, 'P004'), -- Programador 4
  ('E001', 'Tech Solutions', 'CIF123456', 2, 'P005'); -- Programador 5



