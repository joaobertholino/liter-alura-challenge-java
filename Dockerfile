FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY src /liter-alura-build/src
COPY pom.xml /liter-alura-build
WORKDIR /liter-alura-build
RUN mvn clean package

FROM openjdk:21
COPY --from=build /liter-alura-build/target/*.jar /liter-alura-image/app.jar
WORKDIR /liter-alura-image
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]