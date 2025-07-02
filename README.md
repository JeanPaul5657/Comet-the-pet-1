# Comet-the-pet-1

*Comet-the-pet-1* es una aplicación Java modular para la gestión de usuarios y mascotas, con generación automática de informes semanales en formato PDF. Incluye persistencia en MySQL mediante DAO, una capa de conexión centralizada y reportes profesionales con iText 7.

## Características principales

- Gestión completa de *usuarios* y *mascotas* con relación uno-a-muchos  
- Persistencia en *MySQL* a través de DAO (UserDAO, PetDAO) y Conexion singleton  
- Generación de informes semanales en *PDF* con iText 7, soportando múltiples novedades en un solo documento  
- Formato visual profesional: títulos estilizados, separadores, pies de página y control de tipografía y colores  
- Compilación y ejecución con *Ant*, incluyendo creación de “fat jar” con dependencias

## Estructura del proyecto


Comet-the-pet-1/
│
├── src/
│   ├── Model/           # Clases de dominio: User, Pet, Novedades
│   ├── database/        # DAO y clase Conexion para MySQL
│   └── Reportes/        # Generación de PDFs con iText
│
├── lib/                 # JARs externos: iText 7, SLF4J, MySQL Connector
├── data/                # Carpeta de salida para reportes PDF
├── build.xml            # Script Ant para compilar, empaquetar y ejecutar
└── README.md            # Documentación del proyecto


## Requisitos

- *Java 17* o superior  
- *MySQL* (v8.x recomendado)  
- *Ant* (v1.10.x o superior)  
- Dependencias en lib/:
  - iText 7 (kernel, layout, io, forms, etc.)  
  - SLF4J (slf4j-api + slf4j-simple)  
  - MySQL Connector/J  

## Instalación

1. Clonar o descargar el repositorio.  
2. Colocar los JAR de iText, SLF4J y MySQL Connector en la carpeta lib/.  
3. Ajustar parámetros de conexión en src/database/Conexion.java (URL, usuario, contraseña).  
4. Crear la base de datos y tablas ejecutando el script SQL:
   
   CREATE DATABASE IF NOT EXISTS BaseUsuariosMascotas;
   USE BaseUsuariosMascotas;
   CREATE TABLE Usuario (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(100) NOT NULL
   );
   CREATE TABLE Mascota (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(100) NOT NULL,
     edad INT NOT NULL,
     raza VARCHAR(50),
     peso DECIMAL(5,2),
     sexo CHAR(1),
     usuario_id INT NOT NULL,
     FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
       ON DELETE CASCADE ON UPDATE CASCADE
   );
   

## Compilación y ejecución


# Compilar y ejecutar reporte de ejemplo
ant run


- El target compile limpia y compila todo en build/classes.  
- El target jar crea build/jar/Comet-the-pet-1.jar con todas las dependencias.  
- El target run genera data/reporte.pdf con ejemplos de novedades.

## Uso desde código


// Ejemplo de generación de informe con múltiples novedades
List<Novedades> lista = List.of(
  new Novedades("-  Migración completada.\n-  Pruebas unitarias OK.", LocalDate.now()),
  new Novedades("-  Integración API externa.\n-  Mejoras UI.", LocalDate.now().minusDays(7))
);
new Reporte().crearPdf(lista, "data/reporte.pdf");


## Contribución

1. Crear un fork del repositorio.  
2. Implementar nuevas funcionalidades o correcciones.  
3. Enviar pull request detallando cambios y ejemplos de uso.

## Licencia

Proyecto de código abierto para fines educativos y de aprendizaje.  
```
```
