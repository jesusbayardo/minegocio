# Requirements

**Docker-Desktop** [enter link description here](https://www.docker.com/products/docker-desktop/)
**Git**  [enter link description here](https://git-scm.com/downloads)
**NodeJS 16**  [enter link description here](https://nodejs.org/en/blog/release/v16.16.0)
**PostgreSQL 14.7** [enter link description here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
**Eclipse IDE** [enter link description here](https://www.eclipse.org/downloads/)
**jdk 11** [enter link description here](https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html)
**Maven 3.x** [enter link description here](https://maven.apache.org/download.cgi#Installation)

**IMPORTANT** Perform the configuration of the jdk and maiven environment variables.


# Git Repository
Run in terminal CMD to  download the project.

git clone https://gitlab.com/28abril2023consulti/bayardo-chandi.git -b bchandi_netflixV2  --single-branch

open the project in the BACKEND folder.


# Running the application locally-dev

 1. Run eclipseIDE.

 2. Import the project.(FILE-> Open projects from file system ->Directoty)

 3. Search the project and press on Finish.

 4. Create the database connection

 5. Run pgADMIN

 6. Create a database named: prueba_ar

 7. Run the database script SQL in the console, it is in the  folder: bd

 8. create a new connection between the project and the database

 8. Right click on top of the project and run AS -> SPRING BOOT APP

 9. Open http://localhost:8080
 




# Running the application docker

 1. Start docker desktop **Important**
 2. Open the terminal and go to the root directory where docker-compose.yml is located and run the following command.
 3. Execute: **mvn clean install**
 4. Execute: **docker-compose up** 

After running the above steps without any errors and docker containers are up and running, url: http://localhost:8080

"# minegocio" 
