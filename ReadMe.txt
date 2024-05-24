# Proyecto JDBC

Este es un proyecto simple que utiliza JDBC para interactuar con una base de datos MySQL.

## Estructura del Proyecto

El proyecto consta de las siguientes clases:

- `DbConnection`: Esta clase se encarga de establecer la conexión con la base de datos.
- `EstudianteDao` y `MateriaDao`: Estas clases son los Data Access Objects (DAO) para los estudiantes y las materias, respectivamente. Proporcionan los métodos CRUD (Create, Read, Update, Delete) para interactuar con la base de datos.
- `Estudiante` y `Materia`: Estas clases son los modelos de los objetos Estudiante y Materia.
- `EjercicioJDBC`: Esta es la clase principal que ejecuta el programa.

## Configuración

Para configurar este proyecto en tu máquina local, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Asegúrate de tener instalado MySQL en tu máquina.
3. En la clase `DbConnection`, actualiza las constantes `URL`, `USER` y `PASSWORD` con tus propios detalles de conexión a la base de datos.
4. Ejecuta el script SQL para crear la base de datos y las tablas necesarias.
5. Asegúrate de tener instalado Maven para manejar las dependencias del proyecto.

## Ejecución

Para ejecutar este proyecto, navega hasta el directorio raíz del proyecto en tu terminal y ejecuta el siguiente comando:

```bash
mvn exec:java -Dexec.mainClass="Principal.EjercicioJDBC"

Dependencias

Este proyecto utiliza las siguientes dependencias:

mysql-connector-java: Esta es la librería de MySQL que permite a Java comunicarse con la base de datos MySQL.

Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue o realiza un pull request con tus cambios.