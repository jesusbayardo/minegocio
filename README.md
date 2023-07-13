# Requerimientos

**Docker-Desktop** [enter link description here](https://www.docker.com/products/docker-desktop/)

**Postman** [enter link description here](https://www.postman.com/downloads/)

**Git**  [enter link description here](https://git-scm.com/downloads)

**NodeJS 16**  [enter link description here](https://nodejs.org/en/blog/release/v16.16.0)

**PostgreSQL 14.7** [enter link description here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

**Eclipse IDE** [enter link description here](https://www.eclipse.org/downloads/)

**jdk 11** [enter link description here](https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html)

**Maven 3.x** [enter link description here](https://maven.apache.org/download.cgi#Installation)


**Realice la configuración de las variables de entorno de MAIVEN Y JDK**

# Git Repository
- Abrir una terminal CDM en cualquier parte del escritorio deL ORDENADOR y ejecutar el siguiente comando para descargar el project.

git clone https://github.com/jesusbayardo/minegocio.git

El project esta en la branch main.


# Script base de datos PG

La base de datos es creada en Postgresql,  en el project existe la carpeta bd_script, en la cuál se encuentra el script sql.

Para crear la base de datos, se debe ejecutar PGADMIN y crear una base de datos con el nombre **prueba_png**, despliegue una consola y ejecute el script.

# mvn clean install
Para crear el jar y ejecutar el backend con docker compose ejecute el siguiente comando CMD dentro del project descargado:

 **mvn clean install**

# Ejecutar la aplicación en Docker Desktop

 1. Inicie la aplicación docker desktop **Importante**
 2. Dirigase al project descargado de GitHub e ingrese a la carpeta raiz.
 3. Abra un CMD.
 4. Ejecute el comando: **docker compose up** 

Espere que se levante el project BACK-END y la BASE DE DATOS.



# Iniciar pruebas en postman

 Obtenga el token para iniciar pruebas.
  - Ejecute una peticion POST: http://localhost:8080/oauth/token
  - Ingrese las credenciales para conectar al backend. En POSTMAN en la pestaña **Authorization** seleccione el  **Type**: Basic Auth e ingrese
  
   **UserName**: angularapp y 
   
   **Password**: 12345

  - En POSTMAN en la pestaña **Body** ingrese las KEY y sus VALUE respectivos.
    - username=bayardo
    - password=12345
    - grant_type=password
  - Luego presione en **Send** para obtener el TOKEN.



# Petición POST cliente
Para iniciar una petición **POST** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pege el token obtenido anteriormente.  Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json.
  - Curl: http://localhost:8080/api/cliente
   **BODY JSON**

{
"correocliente": "homeroluis@gmail.com",
"nombrescliente":"bayardo",
"numeroIdentificacioncliente":"0401685990001",
"tipoIdentificacioncliente":"RUC",
"ciudadsucursal":"QUITO",
"direccionsucursal":"OLIVOS",
"provinciasucursal":"IMBABURA"
}



# Petición GET cliente
Para iniciar una petición **GET** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pegué el token obtenido anteriormente.  Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json.
1. Busqueda por número de identidad: {identificacion} reemplace por el número de identidad.
  - Curl: http://localhost:8080/api/{identificacion}/numerodeidentidad
2. Busqueda por nombre: {nombreCliente} reemplace por el nombre del cliente.
  - Curl: http://localhost:8080/api/{nombreCliente}/nombre

  # Petición PUT cliente
  Para iniciar una petición **PUT** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pegué el token obtenido anteriormente.  Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json.

   - Curl: http://localhost:8080/api/cliente
  **BODY JSON**

   {
            "idCliente": 1,
            "correo": "homeroluis@gmail.com",
            "nombres": "bayardo j",
            "numeroIdentificacion": "0401685990001",
            "tipoIdentificacion": "RUC"
        }


  # Petición DELETE cliente
   Para iniciar una petición **DELETE** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pegué el token obtenido anteriormente. Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json.

Reemplace {idCliente} por el Integer clave primaria.
  - Curl: http://localhost:8080/api/cliente/{idCliente}

# Petición POST Sucursal - Cliente
 Para iniciar una petición **PUT** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pegué el token obtenido anteriormente.  Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json.

Reemplace {idCliente} por el Integer clave primaria.
 - Curl: http://localhost:8080/api/sucursal/{idCliente}

  **BODY JSON**

{
     "ciudad": "boliar",
     "direccion": "OLIVOS 12",
      "provincia": "IMBABURA"
 }


# Petición GET Sucursal por Cliente
 Para iniciar una petición **GET** dirigase en Postman a la pestaña **Authorization** y seleccione el **Type**: Bear Token y en el apartado pegué el token obtenido anteriormente. Además en la pestaña **Headers** envíe como **Key**: Content-Type y **Value**: application/json. 

 Reemplace {idCliente} por el Integer clave primaria.
 - Curl: http://localhost:8080/api/sucursal/{idCliente}
