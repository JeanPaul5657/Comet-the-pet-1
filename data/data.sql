-- 1) Crear la base de datos y seleccionarla
CREATE DATABASE IF NOT EXISTS BaseUsuariosMascotas;
USE BaseUsuariosMascotas;

-- 2) Tabla Usuario (equivale a la clase User)
CREATE TABLE Usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL
);

-- 3) Tabla Mascota (equivale a la clase Pet)
CREATE TABLE Mascota (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         edad INT NOT NULL,
                         raza VARCHAR(50),
                         peso DECIMAL(5,2),
                         sexo CHAR(1),
                         usuario_id INT NOT NULL,
                         CONSTRAINT fk_mascota_usuario
                             FOREIGN KEY (usuario_id)
                                 REFERENCES Usuario(id)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE
);
