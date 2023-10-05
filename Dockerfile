FROM openjdk:17-alpine
COPY target/Originacion-0.0.1.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]