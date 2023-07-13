



FROM openjdk:17-jdk-alpine
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/src/myapp/
COPY uploads /usr/src/myapp/uploads

WORKDIR /usr/src/myapp

EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]