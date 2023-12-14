# Prueba Técnica BackEnd - Sintad

Sistema Back-End desarrollado en Spring Boot 3.1.4 con JDK 17.

## Pasos previos
- Realizar en `mvn clean install` para la instalación de las librerías necesarias.
- Usado para el sistema de [Back-End](https://github.com/Enzoest26/prueba-tecnica-backend-sintad) levantado para el uso correcto del Front-End.
- Inicializar con el comando de `ng serve` para el despliegue, opcional agregar el agumento `-o` para abrirlo en una pestaña automaticamente.

## Sistema
El sistema es usado para el [Front-End](https://github.com/Enzoest26/prueba-tecnica-frontend-sintad). Para su uso utilizar este postman.

## Paquetes
Se uso los siguientes paquetes para el desarrollo del Back:
- JWT : Creación y validación de un token de seguridad.
- Spring Security: Encagado de manejar el acceso al sistema con filtros.
- JPA: Creación de clases persitente de realizar mantenimiento de los recursos en la BD.
- Spring Web: Encargado de manejar las peticiones por HTTP.

## Test - Pruebas Unitarias
### Paso Previo
Para la ultilización de las pruebas unitarias se tiene que cambiar el [application.propierties](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/blob/main/src/main/resources/application.properties), descomentar los que tienen `#` y comentar los anteriores. Se uso una base de datos basado en memoria como `H2`.
Pruebas unitaririas. [Click](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/tree/main/src/test/java/com/tecnica/prueba)
