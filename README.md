# Prueba Técnica BackEnd - Sintad

Sistema Back-End desarrollado en Spring Boot 3.1.4 con JDK 17.

## Pasos previos
- Realizar en `mvn clean install` para la instalación de las librerías necesarias.
- Se necesita el motor de base de datos `MySql` levantada con el `schema`, se adjunta el script [script.sql](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/blob/main/script_prueba_tecnica.sql).
- Usado para el sistema de [Back-End](https://github.com/Enzoest26/prueba-tecnica-backend-sintad) levantado para el uso correcto del Front-End.

## Sistema
El sistema es usado para el [Front-End](https://github.com/Enzoest26/prueba-tecnica-frontend-sintad). Para su uso utilizar este collection de [Postman](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/blob/main/Prueba%20Técnica%20-%20Sintad.postman_collection.json).

## Recomendaciones
- Si retorna un código de estatus `403`, significa que el token ha expirado o no lo tiene.
- Se necesita el `schema` Mysql, en caso de utilizar otro, adjustar el [application.propierties](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/blob/main/src/main/resources/application.properties).

## Paquetes
Se uso los siguientes paquetes para el desarrollo del Back:
- JWT : Creación y validación de un token de seguridad.
- Spring Security: Encagado de manejar el acceso al sistema con filtros.
- JPA: Creación de clases persitente de realizar mantenimiento de los recursos en la BD.
- Spring Web: Encargado de manejar las peticiones por HTTP.

## Test - Pruebas Unitarias
### Paso Previo
Para la ultilización de las pruebas unitarias se tiene que cambiar el [application.propierties](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/blob/main/src/main/resources/application.properties), descomentar los que tienen `#` y comentar los anteriores. Se uso una base de datos basado en memoria como `H2`.

### Pruebas unitaririas. [Click](https://github.com/Enzoest26/prueba-tecnica-backend-sintad/tree/main/src/test/java/com/tecnica/prueba)
