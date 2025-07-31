FROM eclipse-temurin:17-jre
LABEL authors="dp"

WORKDIR /app
COPY target/*.jar app.jar
COPY src/main/resources/application.properties /app/application.properties

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=/app/application.properties"]