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

Se requiere una base de datos en Postgresql con las siguientes tablas:

![alt text](https://github.com/paulrcam12/challengekg/blob/main/git1.png?raw=true)

Para iniciar la aplicación se necesita instalar Java 11 y Spring Boot 2.7.4.


Abra el proyecto en un compilador de Java y cambie las credenciales de Postgresql en el archivo application.properties.

Si se tiene una base de datos local, tendría que configurarse de la siguiente manera:

```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=******
```


En la clase "ChallengekgApplication.java" ejecute el comando para instalar las dependencias necesarias.

```sh
mvn clean install
```

Después de eso inicie el proyecto con el siguiente comando:

```sh
mvn spring-boot:run
```

Si todo se incició exitosamente podemos dirigirnos hasta la página:

http://localhost:8080/swagger-ui/index.html#/

Lo primero que tenemos que hacer es dirigirnos a la sección de Auth-Controller e iniciar sesión

![alt text](https://github.com/paulrcam12/challengekg/blob/main/git2.png?raw=true)

Usamos las credenciales: 
```sh
{
  "username": "admin",
  "password": "12345678"
}
```

Luego nos retornará un Token tipo Bearer como response y lo usaremos para autenticarnos en el botón "Authorize".

Una vez nos hayamos autenticado como administradores podremos registrar un empleado con la función:
![alt text](https://github.com/paulrcam12/challengekg/blob/main/git3.png?raw=true)

Automáticamente se creará un usuario tipo empleado con el ROL: USER, las credenciales serán:

usuario: El correo electrónico que se registró.
password: 12345678

Ahora podemos desconectárnos o "desautorizarnos" con ese token y volveremos a inicial sesión con la función:
![alt text](https://github.com/paulrcam12/challengekg/blob/main/git2.png?raw=true)

Usaremos las credenciales del usuario que acabamos de crear y generamos un nuevo token para autorizarnos con el rol de "USER" o de empleado.

Logeados como empleados podemos actualizar nuestros datos con la siguiente función:

![alt text](https://github.com/paulrcam12/challengekg/blob/main/git4.png?raw=true)

Y para finalizar podemos usar algunos filtros predeterminados que solo se tiene acceso si nos registramos como administradores.

![alt text](https://github.com/paulrcam12/challengekg/blob/main/git5.png?raw=true)



