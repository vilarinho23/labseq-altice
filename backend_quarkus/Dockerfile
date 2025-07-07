# Etapa 1: build com Maven e Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package -DskipTests -Dquarkus.package.type=uber-jar

# Etapa 2: imagem final
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /usr/src/app/target/*-runner.jar app.jar
CMD ["java", "-jar", "app.jar"]
