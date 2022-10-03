# Inventario de vacunación de empleados
## _Kruger Corp Challenge_

Kruger Corporation requiere una aplicación para llevar un registro del inventario del estado de
vacunación de los empleados.
La aplicación contará con 2 roles: Administrador y Empleado.


## Features

- APIs documentadas en OpenAPI 3/Swagger.
- Seguridad en todos los end points.
- Ejemplos de estructuras de JSON.


## Tech

Recursos usados en el proyecto

- Spring Boot 2.7.4
- Java 11
- Open API 3.0.3
- JWT Authentication
- Postgresql 14
- Spring Data JPA


## Installation

Requiere instalar Java 11 y Spring Boot 2.7.4.

Abra el proyecto en un compilador de Java y en la clase "ChallengekgApplication.java" ejecute el comando para instalar las dependencias necesarias.

```sh
mvn clean install
```
Después de eso ejecute el proyecto con el siguiente comando:

```sh
mvn spring-boot:run
```

Se requiere una base de datos en postgre con las siguientes tablas:

