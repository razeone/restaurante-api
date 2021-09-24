DROP TABLE IF EXISTS platillo;

CREATE TABLE platillo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) UNIQUE NOT NULL,
    descripcion VARCHAR(350),
    vegetariano BOOLEAN,
    disponible BOOLEAN,
    precio FLOAT
);

DROP TABLE IF EXISTS orden;

CREATE TABLE orden (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreCliente VARCHAR(250) NOT NULL,
    notasDeOrden VARCHAR(450),
    fechaHoraCreacion DATETIME,
    estado VARCHAR(50),
    totalOrden FLOAT,
    totalMasImpuesto FLOAT
);